<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="editcategory" modelAttribute="loaisanpham" enctype="multipart/form-data">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Cập nhật mới loại sản phẩm </h1>
							<hr />
							
							<div class="form-group">
								<label class="control-label col-md-2" >id</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name ="MALSP"  value="${category.getMALSP()}" />
								</div>
								
							</div>	
							
							<div class="form-group">
								<label class="control-label col-md-2" >Tên sản phẩm</label>
								<div class="col-md-10">
									<input class="form-control" type="text" name ="TENLOAI"  value="${category.getTENLOAISP()}" />
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
								<label class="control-label col-md-2" name ="TRANGTHAI" >Trạng thái</label>
								<div class="col-md-1">
								<c:choose>
							    <c:when test="${category.isTRANGTHAI()==true}">
							        <div class="checkbox">
										<form:checkbox name="TRANGTHAI" class="form-control"
											path="TRANGTHAI" checked="true"/>
									</div>
							    </c:when>
							    <c:when test="${category.isTRANGTHAI()==false}">
							        <div class="checkbox">
										<form:checkbox name="TRANGTHAI" class="form-control"
											path="TRANGTHAI" />
									</div>
							    </c:when>
							    <c:otherwise>
							        <!-- Nội dung hiển thị khi không có điều kiện nào đúng -->
							    </c:otherwise>
							</c:choose>
								
								</div>
							</div>


							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<input type="submit" value="Cập Nhật"
										class="btn btn-default btn btn-info create-admin" /> <a
										href="category" class="btn btn-danger">Trở lại</a>
								</div>
							</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>