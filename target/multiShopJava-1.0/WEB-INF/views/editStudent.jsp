<%@ include file="/common/tablib.jsp"%>

<div align="center">
	<h2>Edit Customer</h2>
	<form:form action="edit" method="post" modelAttribute="student">
		<table border="0" cellpadding="5">
			<tr>
				<td>ID:</td>
				<td>
					<input readonly type="text" name="id" value="${student.id}">
				</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="Name" value="${student.getName()}"></td>
			</tr>
			<tr>
				<td>Class:</td>
				<td><select name="CLASS">
						 <%-- <option selected="selected">${student.getCLASS().getMALOP()}</option> --%>
						<c:forEach items="${classList}" var="className" varStatus="loop">
							<option value="${loop.index}" <c:if test="${loop.index == student.getCLASS().getMALOP()-1}"> selected </c:if>>${className.getTENLOP()}</option>
						</c:forEach>
				</select></td>
			</tr>
			<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</div>