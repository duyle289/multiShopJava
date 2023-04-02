<%@ include file="/common/tablib.jsp"%>
<c:set var="cartSum" value="${sessionScope.tongsl}" />
<c:set var="total" value="0" />
<!-- Navbar Start -->
<div class="container-fluid bg-dark mb-30">
	<div class="row px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a
				class="btn d-flex align-items-center justify-content-between bg-primary w-100"
				data-toggle="collapse" href="#navbar-vertical"
				style="height: 65px; padding: 0 30px;">
				<h6 class="text-dark m-0">
					<i class="fa fa-bars mr-2"></i>Danh mục
				</h6> <i class="fa fa-angle-down text-dark"></i>
			</a>
			<nav
				class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light"
				id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
				<div class="navbar-nav w-100">


					<c:forEach var="lsp" items="${loaisanphamList}" varStatus="status">
						<div class="nav-item dropdown dropright">
							<a href="#" class="nav-link dropdown-toggle"
								data-toggle="dropdown">${lsp.getTENLOAISP() } <i
								class="fa fa-angle-right float-right mt-1"></i></a>

							<div
								class="dropdown-menu position-absolute rounded-0 border-0 m-0">
								<c:forEach var="nsx" items="${listNSX}" varStatus="status">
									<c:if test="${nsx[0] == lsp.MALSP}">
										<a href="" class="dropdown-item">${nsx[2]}</a>
									</c:if>
								</c:forEach>
							</div>

						</div>
					</c:forEach>


				</div>
			</nav>
		</div>
		<div class="col-lg-9">
			<nav
				class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
				
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="/multiShopJava/" class="nav-item nav-link">Trang chủ</a>
						<a href="/multiShopJava/Product/ShowAllProduct/1"
							class="nav-item nav-link">Shop</a>
					</div>
					<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
						<a href="/multiShopJava/Cart/ViewCart" class="btn px-0 ml-3">
							<i class="fas fa-shopping-cart text-primary"></i> <c:choose>
								<c:when test="${cartSum <= 0}">
									<span
										class="badge text-secondary border border-secondary rounded-circle"
										style="padding-bottom: 2px;">0</span>
								</c:when>

								<c:otherwise>
									<span
										class="badge text-secondary border border-secondary rounded-circle"
										style="padding-bottom: 2px;">${cartSum}</span>
								</c:otherwise>
							</c:choose>
						</a>
					</div>
				</div>
			</nav>
		</div>
	</div>
</div>
<!-- Navbar End -->
<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<span class="breadcrumb-item active">Shopping Cart</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->
<!-- Cart Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-lg-8 table-responsive mb-5">
			<table
				class="table table-light table-borderless table-hover text-center mb-0">
				<thead class="thead-dark">
					<tr>
						<th>Hình ảnh sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Màu</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Tổng tiền</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody class="align-middle">

					<c:forEach var="product" items="${listProductInCart}">
						<input type="hidden" value="${total = total+product.tongtien }" />

						<tr>
							<td><img
								src="<c:url value='/resources/HinhAnhSP/${product.getHinhanh()}'/>"
								alt="" style="width: 50px;"></td>
							<td class="align-middle"><a
								href="/multiShopJava/Product/product-detail?id=${product.getMasp()}">
									${product.getTensp() }</a></td>
							<td class="align-middle">${product.getTenmau() }</td>
							<td class="align-middle"><fmt:formatNumber type="number"
									maxFractionDigits="3" value="${product.dongia}" /></td>

							<form:form action="/multiShopJava/Cart/UpdateQuantity"
								method="POST">
								<td class="align-middle"><input type="hidden" name="masp"
									value="${product.masp}"> <input type="hidden"
									name="mamau" value="${product.mamau}">
									<div class="input-group quantity mx-auto" style="width: 100px;">
										<div class="input-group-btn">
											<button class="btn btn-sm btn-primary btn-minus">
												<i class="fa fa-minus"></i>
											</button>
										</div>
										<input type="text"
											class="form-control form-control-sm bg-secondary border-0 text-center"
											name="soluong" value="${product.soluong}" readonly>
										<div class="input-group-btn">
											<button class="btn btn-sm btn-primary btn-plus">
												<i class="fa fa-plus"></i>
											</button>
										</div>

									</div></td>
							</form:form>
							<td class="align-middle"><fmt:formatNumber type="number"
									maxFractionDigits="3" value="${product.tongtien}" /></td>
							<form:form action="/multiShopJava/Cart/RemoveOneProduct"
								method="POST">
								<td class="align-middle"><input type="hidden" name="masp"
									value="${product.masp}"> <input type="hidden"
									name="mamau" value="${product.mamau}">
								<td class="align-middle">
									<button class="btn btn-sm btn-danger">
										<i class="fa fa-times"></i>
									</button>
								</td>
							</form:form>
						</tr>
					</c:forEach>


				</tbody>
				<tfoot>
					<tr>
						<td colspan="7" id="cart-next"><a href=""
							class="btn btn-info"> <i class="fa fa-shopping-cart"></i>
								Chọn thêm sản phẩm khác
						</a> <abbr title="Xóa sản phẩm">
								<button type="button"
									class="btn btn-danger modal-change-password"
									onclick="return confirm('Bạn có muốn xóa tất cả sản phẩm trong giỏ hàng?'), location.href='/multiShopJava/Cart/RemoveAllProduct'">
									<i class="fa fa-trash" aria-hidden="true"></i> Xóa giỏ hàng
								</button>
						</abbr></td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="col-lg-4">
		<form action="/multiShopJava/order/" method="post">
			<div class="mb-5 collapse show" id="shipping-address" style="">
				<h5 class="section-title position-relative text-uppercase mb-3">
					<span class="bg-secondary pr-3">Địa chỉ giao hàng</span>
				</h5>
				<div class="bg-light p-30">
					<div class="row">
						<div class="col-md-6 form-group">
							<label>Họ và tên</label> <input name="TENKH" class="form-control"
								type="text">
						</div>
						<div class="col-md-6 form-group">
							<label>Số điện thoại</label> <input name="SDT"
								class="form-control" type="text">
						</div>
						<div class="col-md-6 form-group">
							<label>E-mail</label> <input name="EMAIL" class="form-control"
								type="text">
						</div>
						<div class="col-md-6 form-group">
							<label>Yêu cầu khác</label> <input name="YCK"
								class="form-control" type="text">
						</div>
						<div class="col-md form-group">
							<label>Địa chỉ giao hàng</label> <input name="DCGH"
								class="form-control" type="text">
						</div>
					</div>
				</div>
			</div>
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Tổng tiền giỏ hàng</span>
			</h5>
			<div class="bg-light p-30 mb-5">
				<div class="pt-2">
					<div class="d-flex justify-content-between mt-2">
						<h5>Tổng:</h5>
						<h5>
							<fmt:formatNumber type="number" maxFractionDigits="3"
								value="${total}" />
						</h5>
					</div>
					<input type="submit" 
						class="btn btn-block btn-primary font-weight-bold my-3 py-3"
						value="Đặt hàng" />
				</div>
			</div>
		</form>
		</div>
	</div>
</div>
<!-- Cart End -->