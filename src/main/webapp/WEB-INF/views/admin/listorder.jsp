<%@ include file="/common/tablib.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Danh sách đơn hàng</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<!-- <div class="card-header py-3">
			<button type="button" class="btn btn-info create-admin"
				onclick="location.href='addProduct'">Thêm mới sản phẩm</button>
		</div> -->
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Mã hóa đơn</th>
							<th>Ngày đặt</th>
							<th>Ngày giao dự kiến</th>
							<th>Tổng tiền</th>
							<th>Tên khách hàng</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ giao hàng</th>
							<th>Yêu cầu của khách hàng</th>
							<th>Trạng thái</th>
							<th>#</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Mã hóa đơn</th>
							<th>Ngày đặt</th>
							<th>Ngày giao dự kiến</th>
							<th>Tổng tiền</th>
							<th>Tên khách hàng</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ giao hàng</th>
							<th>Yêu cầu của khách hàng</th>
							<th>Trạng thái</th>
							<th>#</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="order" items="${listOrder}">
							<tr>
								<td>${order.MAHD}</td>
								<td><fmt:formatDate type="date" dateStyle="short"
										timeStyle="short" value="${order.getNGAYLAP()}" /></td>
								<td><fmt:formatDate type="date" dateStyle="short"
										timeStyle="short" value="${order.getNGAYGIAO()}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="3"
										value="${order.getTONGTIEN()}" /></td>
								<td>${order.getTENKH()}</td>
								<td>${order.getSDTKH()}</td>
								<td>${order.getDIACHIGIAOHANG()}</td>
								<td>${order.getYEUCAUKHAC()}</td>

								<c:choose>
									<c:when test="${order.getTRANGTHAI() == 0}">
										<td class="invert" style="color: red; font: bold">Đơn
											hàng mới</td>
									</c:when>
									<c:when test="${order.getTRANGTHAI() == 1}">
										<td class="invert" style="color: red; font: bold">Đã xác
											nhận</td>
									</c:when>
									<c:when test="${order.getTRANGTHAI() == 2}">
										<td class="invert" style="color: green; font: bold">Đang
											giao</td>
									</c:when>
									<c:otherwise>
										<td class="invert" style="color: blue; font: bold">Đã
											giao</td>
									</c:otherwise>
								</c:choose>




								<td class="invert"><abbr title="Xem chi tiết sản phẩm">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='order-detail/?id=${order.MAHD}'">
											<i class="fa fa-eye"></i>
										</button>
								</abbr></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>