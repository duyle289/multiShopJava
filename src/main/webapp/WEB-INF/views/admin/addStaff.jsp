<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="addStaff"
						modelAttribute="nhanvien">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Thêm nhân viên</h1>
							<hr />
							<div class="form-group">
								<form:label class="control-label col-md-2" path="TENNV">Tên nhân viên</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="TENNV" />
								</div>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="EMAIL">Email</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="EMAIL" />
								</div>
								<span style="color: red">${errorMessageEmail}</span>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="SDT">Số điện thoại</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="SDT" />
								</div>
								<span style="color: red">${errorMessageSDT}</span>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="CCCD">CCCD</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="CCCD" />
								</div>
								<span style="color: red">${errorMessageCCCD}</span>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="USERNAME">Tài khoản</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="USERNAME" />
								</div>
								<span style="color: red">${errorMessageUsername}</span>
							</div>
							<div class="form-group">
								<form:label class="control-label col-md-2" path="PASSWORD">Mật khẩu</form:label>
								<div class="col-md-10">
									<form:input class="form-control" type="text" path="PASSWORD" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<input type="submit" value="Thêm"
										class="btn btn-default btn btn-info create-admin" /> <a
										href="staff" class="btn btn-danger">Trở lại</a>
								</div>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>