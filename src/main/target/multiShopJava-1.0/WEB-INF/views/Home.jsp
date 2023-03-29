<%@ include file="/common/tablib.jsp"%>


<div align="center">
	<h1>Student List</h1>
	<h3>
		<a href="Student/new">New Customer</a>
	</h3>
	<table border="1">
		<th>Ten</th>
		<th>Don gia</th>
		<th>Hinh anh</th>
		<th>Loai san pham</th>
		<th>Nha san xuat</th>
		<c:forEach var="sanpham" items="${sanphamList}" varStatus="status">
			<tr>
				<td>${sanpham.getTENSP()}</td>
				<td><fmt:formatNumber type="number" maxFractionDigits="3"
						value="${sanpham.getDONGIA()}" /></td>
				<td><img height= "200px" width= "300px" src="<c:url value='/resources/HinhAnhSP/${sanpham.getHINHANH()}'/>" /></td>
				<td>${sanpham.getLsp().getTENLOAISP()}</td>
				<td>${sanpham.getNsx().getTENNSX()}</td>
			</tr>
		</c:forEach>
	</table>
</div>
