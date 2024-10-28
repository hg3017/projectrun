<%@page import="DTO.AdminCrewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%AdminCrewDTO crew = (AdminCrewDTO) request.getAttribute("crew"); %>
				<div class="contents">
					<div class="inner">
						<form name="writeFrm" method="post"
							action="Crew_WriteProcess.adcr">
							<table border="1" width="80%">
								<tr>
									<td width="10%">IDX</td>
									<td align="center"><%=crew.getIdx()%></td>
								</tr>
								<tr>
									<td width="10%">NAME</td>
									<td align="center"><%=crew.getName()%></td>
								</tr>
								<tr>
									<td width="10%">LOCATION_ID</td>
									<td align="center"><%=crew.getLocation_id()%></td>
								</tr>
								<tr>
									<td width="10%">DESCRIPTION</td>
									<td align="center"><%=crew.getDescription()%></td>
								</tr>
								<tr>
									<td width="10%">REGIDATE</td>
									<td align="center"><%=crew.getRegidate()%></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><a
										href="/JSP/Admin/Crew/Crew_List.adcr">[List]</a> <a
										href="/JSP/Admin/Crew/Crew_Edit.adcr?idx=<%=crew.getIdx()%>">[Edit]</a>
										<a
										href="/JSP/Admin/Crew/Crew_DeleteProcess.adcr?idx=<%=crew.getIdx()%>">[Delete]</a>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>