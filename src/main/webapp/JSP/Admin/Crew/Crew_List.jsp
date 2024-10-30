<%@page import="java.util.List"%>
<%@page import="DTO.AdminCrewDTO"%>
<%@page import="DAO.AdminCrewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<AdminCrewDTO> crews = (List<AdminCrewDTO>)request.getAttribute("crews"); %>
				<div class="contents">
					<div class="inner">
						<div class="board_search_wrap">
							<form>
								<fieldset>
									<legend>게시물 검색</legend>
									<div class="board_search">
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
											<span class="blind">게시물 검색</span>
										</button>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="board_list_admin">
							<table border="1" width="80%">
									<tr>
										<th width="11%">IDX</th>
										<th width="11%">NAME</th>
										<th width="11%">LOCATION_ID</th>
										<th width="11%">DESCRIPTION</th>
										<th width="11%">REGIDATE</th>
									</tr>
									<%
									for (AdminCrewDTO crew : crews) {
									%>
									<tr align="center">
										<td><a href="Crew_View.adcr?idx=<%=crew.getIdx()%>"><%=crew.getIdx()%></a></td>
										<td><%=crew.getName()%></td>
										<td><%=crew.getLocation_id()%></td>
										<td><%=crew.getDescription()%></td>
										<td><%=crew.getRegidate()%></td>
										<%
										}
										%>
									
									<tr>
										<td colspan="4"><a href="/JSP/Admin/Crew/Crew_Write.adcr">[회원 가입]</a></td>
									</tr>
								</table>
						</div>
					</div>
				</div>