<%@ include file="/common/tablib.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Chi tiết đơn hàng ${madh}</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Mã hóa đơn</th>
							<th>Tên sản phẩm</th>
							<th>Màu sắc</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Mã hóa đơn</th>
							<th>Tên sản phẩm</th>
							<th>Màu sắc</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="orderdetail" items="${listOrderDetail}">
							<tr>
								<td>${orderdetail.getHd().getMAHD()}</td>
								<td>${orderdetail.getSp().getTENSP()}</td>
								<td>${orderdetail.getMs().getTENMAU()}</td>
								<td>${orderdetail.getSOLUONG()}</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="3"
										value="${orderdetail.getDONGIA()}" /></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<c:choose>
					<c:when test="${hd.getTRANGTHAI() == 0}">
						<button  onclick="location.href='/multiShopJava/admin/order-processing/?id=${hd.MAHD}&type=${hd.getTRANGTHAI()}'" class="btn btn-default btn btn-info create-admin"> Xác nhận đơn hàng</button>
					</c:when>
					<c:when test="${hd.getTRANGTHAI() == 1}">
						<button onclick="location.href='/multiShopJava/admin/order-processing/?id=${hd.MAHD}&type=${hd.getTRANGTHAI()}'" class="btn btn-default btn btn-info create-admin">Xác nhận giao hàng </button>
					</c:when>
					<c:when test="${hd.getTRANGTHAI() == 2}">
						<button onclick="location.href='/multiShopJava/admin/order-processing/?id=${hd.MAHD}&type=${hd.getTRANGTHAI()}'" class="btn btn-default btn btn-info create-admin">Xác nhận đã giao hàng </button>
					</c:when>
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
				<a href="/multiShopJava/admin/order" class="btn btn-danger">Trở
					lại</a>
			</div>
		</div>
	</div>

</div>