<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="editStaff"
						modelAttribute="nhanvien">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Sửa nhân viên</h1>
							<hr />
							<div class="form-group">
								<label class="control-label col-md-2" >ID</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="ID" value="${nhanvien.getMANV()}"  />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >Tên nhân viên</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="TENNV" value="${nhanvien.getTENNV()}" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >Email</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="EMAIL" value="${nhanvien.getEMAIL()}" />
								</div>
								<span style="color: red">${errorMessageEmail}</span>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >Số điện thoại</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="SDT"  value="${nhanvien.getSDT()}"/>
								</div>
								<span style="color: red">${errorMessageSDT}</span>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >CCCD</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="CCCD" value="${nhanvien.getCCCD()}" />
								</div>
								<span style="color: red">${errorMessageCCCD}</span>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >Tài khoản</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="USERNAME" value="${nhanvien.getUSERNAME()}"  />
								</div>
								<span style="color: red">${errorMessageUsername}</span>
							</div>
							<div class="form-group">
								<label class="control-label col-md-2" >Mật khẩu</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name="PASSWORD" value="${nhanvien.getPASSWORD()}" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<input type="submit" value="Sửa"
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