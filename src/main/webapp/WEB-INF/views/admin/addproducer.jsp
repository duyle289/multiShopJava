<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="addProducer"
						modelAttribute="nhasanxuat" enctype="multipart/form-data">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Thêm mới nhà sản xuất</h1>
							<hr/>
							<div class="form-group">
								<label class="control-label col-md-2" >Tên nhà sản xuất<label>
								<div class="col-md-10">
									<input class="form-control" name="TENNSX" type="text" />
								</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-2">Thêm hình ảnh</label>

								<div class="col-md-10">
									<input type="file" class="form-control"
										name="hinhanh"  multiple="multiple"/>
									<span style="color: red">${uploadInfor}</span>

								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >Trạng Thái<label>
								<div class="col-md-10">
									<input type="checkbox" class="form-control" name="TRANGTHAI"  />
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