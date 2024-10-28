<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
				<div class="contents">
					<div class="inner">
						<form name="writeFrm" method="post"
							action="Crew_WriteProcess.adcr">
							<table border="1" width="80%">
								<tr>
									<td>NAME</td>
									<td><input type="text" name="name" style="width: 90%;" /></td>
								</tr>
								<tr>
									<td>LOCATION_ID</td>
									<td><input type="text" name="location_id"
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
										<button type="button"
											onclick="location.href='/JSP/Admin/Crew/Crew_List.adcr';">목록보기
										</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>