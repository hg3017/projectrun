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
			//String saveDirectory = request.getServletContext().getRealPath("/Upload");
			//String saveDirectory = "/Users/lhg/git/ProjectRun/src/main/webapp/JSP/Upload";
			String saveDirectory = System.getProperty("user.home") + "/git/ProjectRun/src/main/webapp/JSP/Upload";
			System.out.println(saveDirectory);
			
			int maxPostSize = 1024 * 1024 * 10; // 10M
			String encoding = "UTF-8";
			
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
			
			String fileName = mr.getFilesystemName(fName);
			if (fileName != null) {
				String ext = fileName.substring(fileName.lastIndexOf("."));
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				
				String newFileName = now + ext;
				File oldFile = new File(saveDirectory + File.separator + fileName);
				File newFile = new File(saveDirectory + File.separator + newFileName);

//				if(!newFile.exists()) {
//					newFile.mkdirs();
//				}
				
				oldFile.renameTo(newFile);
				
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
    	//String saveDirectory = request.getServletContext().getRealPath("/Upload");
    	//String saveDirectory = "/Users/lhg/git/ProjectRun/src/main/webapp/JSP/Upload";
    	String saveDirectory = System.getProperty("user.home") + "/git/ProjectRun/src/main/webapp/JSP/Upload";
    	
    	String saveFilename = request.getParameter("sFile");
    	String orginalFilename = request.getParameter("oFile");
    	
    	try {
    		File file = new File(saveDirectory, saveFilename);
    		InputStream inStream = new FileInputStream(file);
    		
    		String client = request.getHeader("User-Agent");
    		if (client.indexOf("WOW64") == -1) {
    			orginalFilename = new String(orginalFilename.getBytes("UTF-8"), "ISO-8859-1");
    		} else {
    			orginalFilename = new String(orginalFilename.getBytes("KSC5601"), "ISO-8859-1");
    		}
			
    		// 파일 헤더 설정
    		response.reset();
    		response.setContentType("application/octet-stream");
    		response.setHeader("Content-Disposition", "attachment;filename=\"" + orginalFilename + "\"");
    		response.setHeader("Content-Length", "" + file.length());
    		
    		OutputStream outStream = response.getOutputStream();
    		byte[] b = new byte[(int)file.length()];
    		int readBuffer = 0;
    		while((readBuffer = inStream.read(b)) > 0){
    			outStream.write(b, 0 , readBuffer);
    		}
    		
    		outStream.close();
    		inStream.close();

    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public static void setParamData(MultipartRequest mr, Map<String, String> map) {
		@SuppressWarnings("unchecked")
		Enumeration<String> em = mr.getParameterNames();
		while (em.hasMoreElements()) {
			String key = em.nextElement();
			String val = mr.getParameter(key);
			
			map.put(key, val);
		}
	}

}
