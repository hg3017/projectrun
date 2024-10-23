package Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class FileUtils {
	
	public static Map<String, String> fileUpload(HttpServletRequest request, String fName) {
		Map<String, String> data = new HashMap<>();
		
		try {
			String saveDirectory = request.getServletContext().getRealPath("/Upload");
			System.out.println(saveDirectory);
			
			int maxPostSize = 1024 * 1024 * 5; // 5M
			String encoding = "UTF-8";
			
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
			
			String fileName = mr.getFilesystemName(fName);
			if (fileName != null) {
				String ext = fileName.substring(fileName.lastIndexOf("."));
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				
				String newFileName = now + ext;
				File oldFile = new File(saveDirectory + File.separator + fileName);
				File newFile = new File(saveDirectory + File.separator + newFileName);
				oldFile.renameTo(newFile);
				
				data.put("oFile", fileName);
				data.put("sFile", newFileName);
			}
			
			setParamData(mr, data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
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
