<%@page import="DAO.FileDAO"%>
<%@page import="DTO.FileDTO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String saveDirectory = application.getRealPath("/Uploads");
out.print(saveDirectory);
saveDirectory = "/Users/lhg/Desktop/ProjectRun/src/main/webapp/Upload";

int maxPostSize = 1024 * 1024 * 5; // 5M
String encoding = "UTF-8";

MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);

// file
String fileName = mr.getFilesystemName("attachedFile");
String ext = fileName.substring(fileName.lastIndexOf(".")); // aaa.jpg
String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
String newFileName = now + ext;
File oldFile = new File(saveDirectory + File.separator + fileName);
File newFile = new File(saveDirectory + File.separator + newFileName);
oldFile.renameTo(newFile);

// DTO
String member_id = mr.getParameter("member_id");
String title = mr.getParameter("title");
String[] content = mr.getParameterValues("content");
/* StringBuffer cateBuf = new StringBuffer();
if(content == null) {
	cateBuf.append("선택 없음");
}else{
	for(String s: cate) {
		cateBuf.append(s+",");
	}
}
 */
FileDTO dto = new FileDTO();
dto.setMember_id(member_id);
dto.setTitle(title);
//dto.setCate(cateBuf.toString());
dto.setOfile(fileName);
dto.setSfile(newFileName);

// DAO
FileDAO dao = new FileDAO();
dao.insertFile(dto);

//response.sendRedirect("/An_Write.an");


%>