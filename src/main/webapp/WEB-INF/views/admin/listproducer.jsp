<%@ include file="/common/tablib.jsp"%>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Danh sách nhà sản xuất</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<button type="button" class="btn btn-info create-admin" onclick="location.href='addProducer'">Thêm mới nhà sản xuất</button>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Tên nhà sản xuất</th>
							<th>Hình ảnh</th>
							<th>Trạng thái</th>
							<th>#</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="producer" items="${listProducer}">
							<tr>
								<td>${producer.getTENNSX()}</td>
								<td><img height="150px" width="200px"
									src="<c:url value='/resources/logoSP/${producer.getICON()}'/>" /></td>	
									     <td>
                                             
                                                
                                                <c:choose>
							    <c:when test="${producer.isTRANGTHAI()==true}">
							    <abbr title="Hết hàng">
                                             <p style = " color : green; "> Hợp tác </p>
                                                   
                                                </abbr>
							    </c:when>
							    <c:when test="${producer.isTRANGTHAI()==false}">
							        <abbr title="Còn hàng">
                                                    <p style = " color : red; "> Ngưng hợp tác </p>
                                                </abbr>
							    </c:when>
							    <c:otherwise>
							        <!-- Nội dung hiển thị khi không có điều kiện nào đúng -->
							    </c:otherwise>
							</c:choose>
                                            </td>											
																		
								<td class="invert"><abbr title="Sửa">
										<button type="button"
											class="btn btn-info modal-change-password"
											onclick="location.href='updateProducer?id=${producer.getMANSX()}'">
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