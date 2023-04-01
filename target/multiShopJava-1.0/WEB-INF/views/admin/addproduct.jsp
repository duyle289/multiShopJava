<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="addProduct"
						modelAttribute="sanpham" enctype="multipart/form-data">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Thêm mới sản phẩm</h1>
							<hr />
							<div class="form-group">
								<form:label class="control-label col-md-2" path="TENSP">Tên sản phẩm</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="TENSP" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2">Loại sản phẩm</label>
								<div class="col-md-10">
									<select class="form-control" name="loaisanpham">
										<c:forEach items="${listlsp}" var="lsp">
											<option value="${lsp.MALSP}">${lsp.getTENLOAISP()}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-2">Nhà sản xuất</label>
								<div class="col-md-10">
									<select class="form-control" name="nhasanxuat">
										<c:forEach items="${listnsx}" var="nsx">
											<option value="${nsx.MANSX}">${nsx.getTENNSX()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2">Màu sắc</label>
								<div class="col-md-10">
								<div class="col-md-1">
									<c:forEach items="${listms}" var="ms">
										<label>${ms.getTENMAU()}</label>
										<input type="checkbox" name="mausac" value="${ms.MAMAU}" class="form-control"/>
									</c:forEach>
								</div>
								</div>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="DONGIA">Đơn giá</form:label>
								<div class="col-md-10">
									<form:input type="number" name="DONGIA" min="0" value="0"
										maxlength="18"
										oninput="this.value = this.value.slice(0,this.maxlength)"
										class="form-control" path="DONGIA" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2">Hình sản phẩm</label>

								<div class="col-md-10">
									<input type="file" class="form-control"
										name="hinhanh"  multiple="multiple"/>
									<span style="color: red">${uploadInfor}</span>

								</div>

							</div>
							
							<div class="form-group">
								<form:label class="control-label col-md-2" path="CAUHINH">Cấu hình</form:label>
								<div class="col-md-10">
									<form:textarea name="CAUHINH" class="form-control"
										path="CAUHINH" />
								</div>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="MOTA">Mô tả</form:label>
								<div class="col-md-10 ">
									<form:textarea name="MOTA" class="form-control" path="MOTA" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2">Số lương tồn</label>

								<div class="col-md-10">
									<input class="form-control" type="number" name="SOLUONGTON"
										min="0" maxlength="18"
										oninput="this.value = this.value.slice(0,this.maxlength)" />
								</div>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="SANPHAMMOI">Sản phẩm mới</form:label>
								<div class="col-md-1">
									<form:checkbox name="SPMOI" class="form-control"
										path="SANPHAMMOI" />
								</div>
							</div>

							<div class="form-group">
								<form:label class="control-label col-md-2" path="SPNOIBAT">Sản phẩm nổi bật</form:label>
								<div class="col-md-1">
									<form:checkbox name="SPNB" class="form-control" path="SPNOIBAT" />
								</div>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="TRANGTHAI">Trạng thái</form:label>
								<div class="col-md-1">
									<div class="checkbox">
										<form:checkbox name="TRANGTHAI" class="form-control"
											path="TRANGTHAI" />
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<input type="submit" value="Thêm"
										class="btn btn-default btn btn-info create-admin" /> <a
										href="product" class="btn btn-danger">Trở lại</a>
								</div>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>