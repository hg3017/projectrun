<%@page import="DTO.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 결과 확인(웹 페이지에 출력)
MemberDTO member = (MemberDTO) request.getAttribute("member");
List<MemberDTO> members = (List<MemberDTO>) request.getAttribute("members");
%>
					<div class="contents">
						<div class="inner">
							<form name="writeFrm" method="post"
								action="Member_WriteProcess.adme">
								<table border="1" width="80%">
									<tr>
										<td>ID</td>
										<td><input type="text" name="id" style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>PASS</td>
										<td><input type="text" name="pass" style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>NAME</td>
										<td><input type="text" name="name" style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>GRADE</td>
										<td><input type="text" name="grade" style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>NICKNAME</td>
										<td><input type="text" name="nickname"
											style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>PHONE_NUMBER</td>
										<td><input type="text" name="phone_number"
											style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>LOCATION</td>
										<td><input type="text" name="location"
											style="width: 90%;" /></td>
									</tr>
									<tr>
										<td>DESCRIPTION</td>
										<td><input type="text" name="description"
											style="width: 90%;" /></td>
									</tr>
									<tr>
										<td colspan="2" align="center">
											<button type="submit">작성 완료</button>
											<button type="reset">다시 입력</button>
											<button type="button" onclick="location.href='/JSP/Admin/Member/Member_List.jsp'">
											목록 보기</button>
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>