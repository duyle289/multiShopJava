<%@ include file="/common/tablib.jsp"%>
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="col-sm-12">
					<form:form method="POST" action="updateProducer"
						modelAttribute="nhasanxuat" enctype="multipart/form-data">
						<div class="form-horizontal">
							<h1 class="h3 mb-2 text-gray-800">Sửa thông tin nhà sản xuất</h1>
							<hr/>
							
							<div class="form-group">
								<label id="id2" class="control-label col-md-2"  >id<label>
								<div class="col-md-10">
									<input class="form-control" name="id" value="${nhasanxuat.getMANSX()}" type="text" />
								</div>
							</div>
											
							<div class="form-group">
								<label id="nsx" class="control-label col-md-2"  >Tên nhà sản xuất<label>
								<div class="col-md-10">
									<input class="form-control" value="${nhasanxuat.getTENNSX()}" name="TENNSX" type="text" />
								</div>
							</div>	
												
							<div id="icon" class="form-group">
								<label class="control-label col-md-2">Icon</label>

								<div class="col-md-10">
									<input type="file" class="form-control"
										name="hinhanh"  multiple="multiple"/>
									<span style="color: red">${uploadInfor}</span>
								</div>
							</div>
							
							<label class="control-label col-md-2" name ="TRANGTHAI" >Trạng thái</label>
								<div class="col-md-1">
								<c:choose>
							    <c:when test="${nhasanxuat.isTRANGTHAI()==true}">
							        <div class="checkbox">
										<form:checkbox name="TRANGTHAI" class="form-control"
											path="TRANGTHAI" checked="true"/>
									</div>
							    </c:when>
							    <c:when test="${nhasanxuat.isTRANGTHAI()==false}">
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
							
							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<input type="submit" value="Sửa"
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