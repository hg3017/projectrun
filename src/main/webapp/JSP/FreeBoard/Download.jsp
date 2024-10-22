<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//String saveDirectory = application.getRealPath("/Uploads");
//out.print(saveDirectory);
String saveDirectory = "/Users/lhg/Desktop/ProjectRun/src/main/webapp/Upload";
String saveFilename = request.getParameter("sName");
String orginalFilename = request.getParameter("oName");

File file = new File(saveDirectory, saveFilename);
InputStream inStream = new FileInputStream(file);

String client = request.getHeader("User-Agent");
if(client.indexOf("WOW64") == -1) {
	orginalFilename = new String(orginalFilename.getBytes("UTF-8"), "ISO-8859-1");
}else {
	orginalFilename = new String(orginalFilename.getBytes("KSC5601"), "ISO-8859-1");
}

// file Header
response.reset();
response.setContentType("application/octet-stream");
response.setHeader("Content-Dispsition", "attachment;filename=\"" + orginalFilename + "\"");
response.setHeader("Content-Length", "" + file.length());

out.clear();

OutputStream outStream = response.getOutputStream();

byte b[] = new byte[(int)file.length()];
int readBuffer = 0;
while((readBuffer = inStream.read()) > 0){
	outStream.write(b, 0 , readBuffer);
}

inStream.close();
outStream.close();
		
%>