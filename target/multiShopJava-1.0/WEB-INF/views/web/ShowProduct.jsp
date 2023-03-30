<%@ include file="/common/tablib.jsp"%>
<c:set var="cartSum" value="${sessionScope.tongsl}" />
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
				<a href="" class="text-decoration-none d-block d-lg-none"> <span
					class="h1 text-uppercase text-dark bg-light px-2">Multi</span> <span
					class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
				</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="/multiShopJava/" class="nav-item nav-link">Trang chủ</a>
						<a href="/multiShopJava/Product/ShowAllProduct/1"
							class="nav-item nav-link active">Shop</a>
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
				<span class="breadcrumb-item active">Shop List</span> <span
					class="breadcrumb-item active">${type}</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->
<!-- Shop Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<!-- Shop Sidebar Start -->

		<div class="col-lg-2 col-md-3">
			
		</div>

		<!-- Shop Sidebar End -->


		<!-- Shop Product Start -->
		<div class="col-lg-9 col-md-8">
			<div class="row pb-3">
				<div class="col-12 pb-1">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<div class="ml-2">
							<div class="btn-group">
								<select class="btn btn-sm btn-light dropdown-toggle"
									data-toggle="dropdown" onchange="location = this.value;">
									<option value="" class="dropdown-item">Sắp xếp</option>
									<option class="dropdown-item"
										value="/multiShopJava/Product/SortProduct/1?sortType=asc"
										<c:if  test='${sorttype.equals("asc")}'> selected </c:if>>
										Giá từ thấp đến cao</option>
									<option class="dropdown-item"
										value="/multiShopJava/Product/SortProduct/1?sortType=desc"
										<c:if test='${sorttype.equals("desc")}'> selected </c:if>>
										Giá từ cao đến thấp</option>
								</select>
							</div>
							<div class="btn-group ml-2">
								<button type="button"
									class="btn btn-sm btn-light dropdown-toggle"
									data-toggle="dropdown">Showing</button>
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="#">10</a> <a
										class="dropdown-item" href="#">20</a> <a class="dropdown-item"
										href="#">30</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="product" items="${listsp}">
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">

								<img class="img-fluid w-100"
									src="<c:url value='/resources/HinhAnhSP/${product.getHINHANH()}'/>"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square"
										href="/multiShopJava/Product/product-detail?id=${product.MASP}"><i
										class="fa fa-shopping-cart"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate"
									href="/multiShopJava/Product/product-detail?id=${product.MASP}">${product.getTENSP() }</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>
										<fmt:formatNumber type="number" maxFractionDigits="3"
											value="${product.getDONGIA()}" />
									</h5>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>

				<div class="col-12">
					<nav>
						<ul class="pagination justify-content-center">
							<c:forEach var="i" begin="1" end="${slsp}">

								<c:choose>
									<c:when test="${i == pageid }">
										<li class="page-item active"><a class="page-link"
											href="/multiShopJava/Product/${i}">${i}</a></li>
									</c:when>

									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/multiShopJava/Product/${i}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- Shop Product End -->
	</div>
</div>
<!-- Shop End -->