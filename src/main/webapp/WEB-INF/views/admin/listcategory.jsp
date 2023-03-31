<%@ include file="/common/tablib.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Danh sách loại sản phẩm</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<button type="button" class="btn btn-info create-admin" onclick="location.href='addCategory'">Thêm mới loại sản phẩm</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Tên loại sản phẩm</th>
							
							<th>Hình ảnh</th>
							
							<th>#</th>
						</tr>
					</thead>
						
					<tbody>
						<c:forEach var="category" items="${listcategory}">
							<tr>
								<td>${category.getTENLOAISP()}</td>
								
								<td><img height="150px" width="200px"
									src="<c:url value='/resources/HinhAnhSP/${category.getICON()}'/>" /></td>
								
								<td class="invert"><abbr title="Sửa">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='editcategory?id=${category.getMALSP()}'"}>
											<i class="fa fa-pen"></i>
										</button>
								</abbr> <abbr title="Xem chi tiết sản phẩm">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='detailcategory?id=${category.getMALSP()}'"}>
											<i class="fa fa-eye"></i>
										</button>
								</abbr> 

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>