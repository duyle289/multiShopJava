
<%@ include file="/common/tablib.jsp"%>
<div align="center">
	<h2>Create Student</h2>
	<form action="new" method="post" modelAttribute="student">
		<table border="0" cellpadding="5">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Class:</td>
				<td><select name="class">
						<c:forEach items="${classList}" var="className" varStatus="loop">
							<option value="${loop.index}">${className.getTENLOP()}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</div>