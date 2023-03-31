<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="addCategory"
						modelAttribute="loaisanpham" enctype="multipart/form-data">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Thêm mới loại sản phẩm</h1>
							<hr />
							<div class="form-group">
								<form:label class="control-label col-md-2" path="TENLOAISP">Tên sản phẩm</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="TENLOAISP" />
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
										href="category" class="btn btn-danger">Trở lại</a>
								</div>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>