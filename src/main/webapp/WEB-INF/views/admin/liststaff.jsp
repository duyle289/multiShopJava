<%@ include file="/common/tablib.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Danh sách nhân viên</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<button type="button" class="btn btn-info create-admin"
				onclick="location.href='addStaff'">Thêm mới nhân viên</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Họ Tên</th>
							<th>Email</th>
							<th>Số Điện Thoại</th>
							<th>CMND/CCCD</th>
							<th>Tài khoản</th>
							<th>#</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="staff" items="${listStaff}">
							<tr>
								<td>${staff.getTENNV()}</td>
								<td>${staff.getEMAIL()}</td>
								<td>${staff.getSDT()}</td>
								<td>${staff.getCCCD()}</td>
								<td>${staff.getUSERNAME()}</td>
								<td class="invert"><abbr title="Sửa">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='editStaff?id=${staff.getMANV()}'">
											<i class="fa fa-pen"></i>
										</button>
								</abbr> <abbr title="Xem chi tiết sản phẩm">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='@Url.Action("
											ChiTietSanPham", "Admin", new {id=item.MASP})'">
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