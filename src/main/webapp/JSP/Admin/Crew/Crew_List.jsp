<%@page import="java.util.List"%>
<%@page import="DTO.AdminCrewDTO"%>
<%@page import="DAO.AdminCrewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<AdminCrewDTO> crews = (List<AdminCrewDTO>)request.getAttribute("crews"); %>
				<div class="contents">
					<div class="inner">
					<div class="board_contents">
						<div class="board_search_wrap" style="background:none;">
							<form style="padding-left: 80px;">
								<fieldset style="display: flex;gap:10px;">
									<legend>게시물 검색</legend>
									<div class="board_search">
									<div class="select_wrap" style="width: 150px;text-align: center;">
										<select>
											<option>아이디</option>
											<option>닉네임</option>
											<option>지역</option>
										</select>
									</div>
									<div class="input_wrap">
										<input type="search" placeholder="검색어를 입력해주세요"
											title="검색어를 입력해주세요">
										<button type="submit" class="search_btn">
										</button>
									</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="board_list_admin">
							<table border="1">
									<tr style="height: 50px;background: #8c5ba3;color: #fff;">
										<th width="7%">NO</th>
										<th width="10%">NAME</th>
										<th width="10%">LOCATION_ID</th>
										<th width="15%">DESCRIPTION</th>
										<th width="15%">REGIDATE</th>
									</tr>
									<%
									for (AdminCrewDTO crew : crews) {
									%>
									<tr align="center" style="height: 38px;">
										<td><a href="Crew_View.adcr?idx=<%=crew.getIdx()%>"><%=crew.getIdx()%></a></td>
										<td><%=crew.getName()%></td>
										<td><%=crew.getLocation_id()%></td>
										<td><%=crew.getDescription()%></td>
										<td><%=crew.getRegidate()%></td>
										<%
										}
										%>
									
									<tr style="height: 50px;font-size:18px;font-weight: bold;" align="center">
										<td colspan="5"><a href="/JSP/Admin/Crew/Crew_Write.adcr">회원가입</a></td>
									</tr>
								</table>
						</div>
						</div>
					</div>
				</div>