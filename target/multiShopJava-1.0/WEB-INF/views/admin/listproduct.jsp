<%@ include file="/common/tablib.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Danh sách sản phẩm</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<button type="button" class="btn btn-info create-admin" onclick="location.href='addProduct'">Thêm mới sản phẩm</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Tên sản phẩm</th>
							<th>Đơn giá</th>
							<th>Hình ảnh</th>
							<th>Loại sản phẩm</th>
							<th>Nhà sản xuất</th>
							<th>Sản phẩm mới</th>
							<th>Sản phẩm nổi bật</th>
							<th>Cấu hình</th>
							<th>Mô tả</th>
							<th>#</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Tên sản phẩm</th>
							<th>Đơn giá</th>
							<th>Hình ảnh</th>
							<th>Loại sản phẩm</th>
							<th>Nhà sản xuất</th>
							<th>Sản phẩm mới</th>
							<th>Sản phẩm nổi bật</th>
							<th>Cấu hình</th>
							<th>Mô tả</th>
							<th>#</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="product" items="${listProduct}">
							<tr>
								<td>${product.getTENSP()}</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="3"
										value="${product.getDONGIA()}" /></td>
								<td><img height="150px" width="200px"
									src="<c:url value='/resources/HinhAnhSP/${product.getHINHANH()}'/>" /></td>
								<td>${product.getLsp().getTENLOAISP()}</td>
								<td>${product.getNsx().getTENNSX()}</td>
								<td>${product.isSANPHAMMOI()}</td>
								<td>${product.isSPNOIBAT()}</td>
								<td>${fn:substring(product.getCAUHINH(), 0, 100)}...</td>
								<td>${fn:substring(product.getMOTA(), 0, 100)}...</td>
								<td class="invert"><abbr title="Sửa">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='@Url.Action("
											SuaSP", "Admin", new {id=item.MASP})'">
											<i class="fa fa-pen"></i>
										</button>
								</abbr> <abbr title="Xem chi tiết sản phẩm">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='@Url.Action("
											ChiTietSanPham", "Admin", new {id=item.MASP})'">
											<i class="fa fa-eye"></i>
										</button>
								</abbr> <!-- @if (item.TRANGTHAI)
                                            {
                                                <abbr title="Hết hàng">
                                                    <button type="button" class="btn btn-danger modal-change-sp" data-toggle="modal" data-target="#changeTTSP" data-account="@item.MASP" data-accountName="@item.TENSP"><i class="fa fa-lock" aria-hidden="true"></i></button>
                                                </abbr>
                                            }
                                            else
                                            {
                                                <abbr title="Còn hàng">
                                                    <button type="button" class="btn btn-danger modal-change-sp" data-toggle="modal" data-target="#changeTTSP" data-account="@item.MASP" data-accountName="@item.TENSP"><i class="fa fa-unlock" aria-hidden="true"></i></button>
                                                </abbr>
                                            } --></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>