<%@page import="java.util.List"%>
<%@page import="DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 결과 확인(웹 페이지에 출력)
// MemberDTO member = (MemberDTO)request.getAttribute("member");
List<MemberDTO> members = (List<MemberDTO>)request.getAttribute("members");
%>
					<div class="contents">
						<div class="inner">
							<div class="board_search_wrap_admin">
								<form>
									<fieldset>
										<legend>게시물 검색</legend>
										<div class="board_search_admin">
											<select>
												<option>아이디</option>
												<option>닉네임</option>
												<option>지역</option>
											</select>
										</div>
										<div class="input_wrap_admin">
											<input type="search" placeholder="검색어를 입력해주세요"
												title="검색어를 입력해주세요">
											<button type="submit" class="search_btn">
												<span class="blind">게시물 검색</span>
											</button>
										</div>
									</fieldset>
								</form>
							</div>
							<div class="board_list_admin">
								<table border="1" width="80%">
									<tr>
										<th width="11%">ID</th>
										<th width="11%">PASS</th>
										<th width="11%">NAME</th>
										<th width="11%">GRADE</th>
										<th width="11%">NICKNAME</th>
										<th width="11%">LOCATION</th>
										<th width="12%">PHONE_NUMBER</th>
										<th width="11%">REGIDATE</th>
										<th width="11%">EDITDATE</th>
									</tr>
									<%
									for (MemberDTO member : members) {
									%>
									<tr align="center">
										<td><a href="Member_View.adme?id=<%=member.getId()%>"><%=member.getId()%></a></td>
										<td><%=member.getPass()%></td>
										<td><%=member.getName()%></td>
										<td><%=member.getGrade()%></td>
										<td><%=member.getNickname()%></td>
										<td><%=member.getLocation()%></td>
										<td><%=member.getPhone_number()%></td>
										<td><%=member.getRegidate()%></td>
										<td><%=member.getEditdate()%></td>
										<%
										}
										%>
									
									<tr>
										<td colspan="4"><a href="Member_Write.jsp">[회원 가입]</a></td>
									</tr>
								</table>
							</div>
						</div>
					</div>