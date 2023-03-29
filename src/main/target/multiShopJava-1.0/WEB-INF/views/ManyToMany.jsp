<%@ include file="/common/tablib.jsp"%>
<div align="center">
	<h1>Student List</h1>
	<table border="1">
		<th>Cource name</th>
		<th>Student name</th>
		<th>Date</th>
		<c:forEach var="Cource_Student" items="${listCource_Students}"
			varStatus="status">
			<tr>
				<td>${Cource_Student.getCource().getName()}</td>
				<td>${Cource_Student.getStudent().getName()}</td>
				<td>${Cource_Student.getDate()}</td>

			</tr>
		</c:forEach>
	</table>
</div>