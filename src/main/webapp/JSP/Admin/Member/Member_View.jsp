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
						<div class="mv_page">
							<form name="writeFrm" method="post"
								action="Member_WriteProcess.adme">
								<table border="1" width="80%">
									<tr>
										<td class="mv_td" width="15%" align="center">ID</td>
										<td align="center"><%=member.getId()%></td>
									</tr>
									<tr>
										<td class="mv_td" width="15%" align="center">PASS</td>
										<td align="center"><%=member.getPass()%></td>
									</tr>
									<tr>
										<td class="mv_td" width="15%" align="center">NAME</td>
										<td align="center"><%=member.getName()%></td>
									</tr>
<%-- 									<tr>
										<td width="10%">GRADE</td>
										<td align="center"><%=member.getGrade()%></td>
									</tr> --%>
									<tr>
										<td class="mv_td" width="15%" align="center">NICKNAME</td>
										<td align="center"><%=member.getNickname()%></td>
									</tr>
									<tr>
										<td class="mv_td" width="15%" align="center">LOCATION</td>
										<td align="center"><%=member.getLocation()%></td>
									</tr>
									<tr>
										<td class="mv_td" width="15%" align="center">PHONE_NUMBER</td>
										<td align="center"><%=member.getPhone_number()%></td>
									</tr>
									<tr>
										<td class="mv_td" width="15%" align="center">REGIDATE</td>
										<td align="center"><%=member.getRegidate()%></td>
									</tr>
									<tr>
										<td class="mv_td" width="15%" align="center">EDITDATE</td>
										<td align="center"><%=member.getEditdate()%></td>
									</tr>									<tr>
										<td class="mv_td" width="15%" align="center">DESCRIPTION</td>
										<td align="center"><%=member.getDescription()%></td>
									</tr>
									<tr height="70px;">
										<td colspan="2" style="font-size:18px;font-weight: bold;"align="center">
										<a
											href="/JSP/Admin/Member/Member_List.adme">List</a>
										<a
											href="/JSP/Admin/Member/Member_Edit.adme?id=<%=member.getId()%>">Edit</a>
										<a
											href="/JSP/Admin/Member/Member_DeleteProcess.adme?id=<%=member.getId()%>">Delete</a>
										</td>
									</tr>
								</table>
							</form>
							</div>
						</div>
					</div>