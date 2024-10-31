package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class FileUtils {
	
	public static Map<String, String> fileUpload(HttpServletRequest request, String fName) {
		Map<String, String> data = new HashMap<>();
		
		try {
			String saveDirectory = request.getServletContext().getRealPath("/JSP/Upload");
			System.out.println(saveDirectory);
			
			int maxPostSize = 1024 * 1024 * 10; // 10M
			String encoding = "UTF-8";
			
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
			
			String fileName = mr.getFilesystemName(fName);
			if (fileName != null) {
				String ext = fileName.substring(fileName.lastIndexOf(".")); // abc.jpg
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				// fileName이 null이 아닐 경우 파일의 확장자와 날짜를 사용하여 새로운 이름을 생성하고, 파일을 새 이름으로 변경
				String newFileName = now + ext;
				File oldFile = new File(saveDirectory + File.separator + fileName);
				File newFile = new File(saveDirectory + File.separator + newFileName);

//				if(!newFile.exists()) {
//					newFile.mkdirs();
//				}
				
				oldFile.renameTo(newFile); // 새 이름으로 파일이 저장
				// data 맵에 저장하여 반환
				data.put("ofile", fileName);
				data.put("sfile", newFileName);
			}
			
			setParamData(mr, data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
    public static void fileDownload(HttpServletRequest request, HttpServletResponse response) {
    	String saveDirectory = request.getServletContext().getRealPath("/JSP/Upload");
    	
    	String saveFilename = request.getParameter("sFile");
    	String orginalFilename = request.getParameter("oFile");
    	
    	try {
    		File file = new File(saveDirectory, saveFilename);
    		InputStream inStream = new FileInputStream(file);
    		// 한글파일이 안깨지도록..
    		String client = request.getHeader("User-Agent");
    		if (client.indexOf("WOW64") == -1) {
    			orginalFilename = new String(orginalFilename.getBytes("UTF-8"), "ISO-8859-1");
    		} else {
    			orginalFilename = new String(orginalFilename.getBytes("KSC5601"), "ISO-8859-1");
    		}
			
    		// 파일 헤더 설정. 파일이 첨부파일로 전송되도록 지정
    		response.reset();
    		response.setContentType("application/octet-stream");
    		response.setHeader("Content-Disposition", "attachment;filename=\"" + orginalFilename + "\"");
    		response.setHeader("Content-Length", "" + file.length());
    		// 입력 스트림(inStream)으로 파일을 읽어 OutputStream을 통해 클라이언트로 전송
    		OutputStream outStream = response.getOutputStream();
    		byte[] b = new byte[(int)file.length()];
    		int readBuffer = 0;
    		while((readBuffer = inStream.read(b)) > 0){
    			outStream.write(b, 0 , readBuffer);
    		}
    		// 모든데이터 전송후 닫음
    		outStream.close();
    		inStream.close();

    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
	// MultipartRequest에서 파일 이외의 파라미터들을 map에 추가
	public static void setParamData(MultipartRequest mr, Map<String, String> map) {
		// @SuppressWarnings("unchecked")
		Enumeration<String> em = mr.getParameterNames();
		while (em.hasMoreElements()) {
			String key = em.nextElement();
			String val = mr.getParameter(key);
			
			map.put(key, val);
		}
	}

}
