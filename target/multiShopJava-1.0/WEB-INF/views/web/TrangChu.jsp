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
						<a href="" class="nav-item nav-link active">Trang chủ</a> <a
							href="/multiShopJava/Product/ShowAllProduct/1" class="nav-item nav-link">Shop</a>
					</div>
					<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
						<a href="/multiShopJava/Cart/ViewCart" class="btn px-0 ml-3"> <i
							class="fas fa-shopping-cart text-primary"></i> 
							<c:choose>
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


<!-- Carousel Start -->
<div class="container-fluid mb-3">
	<div class="row px-xl-5">
		<div class="col-lg-8">
			<div id="header-carousel"
				class="carousel slide carousel-fade mb-30 mb-lg-0"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#header-carousel" data-slide-to="0" class="active"></li>
					<li data-target="#header-carousel" data-slide-to="1"></li>
					<li data-target="#header-carousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item position-relative active"
						style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="img/carousel-1.jpg" style="object-fit: cover;">
					</div>
					<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="img/carousel-2.jpg" style="object-fit: cover;">
					</div>
					<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="img/carousel-3.jpg" style="object-fit: cover;">
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="product-offer mb-30" style="height: 200px;">
				<img class="img-fluid" src="img/offer-1.jpg" alt="">
			</div>
			<div class="product-offer mb-30" style="height: 200px;">
				<img class="img-fluid" src="img/offer-2.jpg" alt="">
			</div>
		</div>
	</div>
</div>
<!-- Carousel End -->


<!-- Featured Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5 pb-3">
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">Sản phẩm chất lượng</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
				<h5 class="font-weight-semi-bold m-0">Miễn phí vận chuyển</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">Đổi-trả 14 ngày</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">Hỗ trợ 24/7</h5>
			</div>
		</div>
	</div>
</div>
<!-- Featured End -->


<!-- Categories Start -->
<div class="container-fluid pt-5">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Danh mục sản phẩm</span>
	</h2>
	<div class="row px-xl-5 pb-3">
		<c:forEach var="lsp" items="${listLSP}" varStatus="status">
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<a class="text-decoration-none" href="/multiShopJava/Product/ShowProductByCategory/1?id=${lsp[3]}&name=${lsp[0]}">
					<div class="cat-item d-flex align-items-center mb-4">
						<div class="overflow-hidden" style="width: 100px; height: 100px;">
							<img class="img-fluid"
								src="<c:url value='/resources/HinhAnhSP/${lsp[2]}'/>" alt="">
						</div>
						<div class="flex-fill pl-3">
							<h6>${lsp[0]}</h6>
							<small class="text-body">${lsp[1]} sản phẩm</small>
						</div>
					</div>
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<!-- Categories End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Sản phẩm mới</span>
	</h2>
	<div class="row px-xl-5">
		<c:forEach var="spm" items="${listSPMOI}" varStatus="status">
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<div class="product-item bg-light mb-4">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100"
							src="<c:url value='/resources/HinhAnhSP/${spm.getHINHANH() }'/>"
							alt="">
						<div class="product-action">
							<a class="btn btn-outline-dark btn-square"
								href="/multiShopJava/Product/product-detail?id=${spm.MASP}"><i
								class="fa fa-shopping-cart"></i></a>
						</div>
					</div>
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate"
							href="/multiShopJava/Product/product-detail?id=${spm.MASP}">${spm.getTENSP()}</a>
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${spm.getDONGIA()}" />
							</h5>
						</div>
						<div class="d-flex align-items-center justify-content-center mb-1">
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
	</div>
	<div class="block" id="gaming">

		<a href="/multiShopJava/Product/ShowNewProducts/1" type="submit" class="block-btn"> <span>Xem tất
				cả sản phẩm mới</span>
		</a>

	</div>
</div>
<!-- Products End -->


<!-- Offer Start -->
<div class="container-fluid pt-5 pb-3">
	<div class="row px-xl-5">
		<div class="col-md-6">
			<div class="product-offer mb-30" style="height: 300px;">
				<img class="img-fluid" src="img/offer-1.jpg" alt="">
			</div>
		</div>
		<div class="col-md-6">
			<div class="product-offer mb-30" style="height: 300px;">
				<img class="img-fluid" src="img/offer-2.jpg" alt="">
			</div>
		</div>
	</div>
</div>
<!-- Offer End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Sản phẩm nổi bật</span>
	</h2>
	<div class="row px-xl-5">
		<c:forEach var="spnb" items="${listSPNB}" varStatus="status">
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<div class="product-item bg-light mb-4">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100"
							src="<c:url value='/resources/HinhAnhSP/${spnb.getHINHANH() }'/>"
							alt="">
						<div class="product-action">
							<a class="btn btn-outline-dark btn-square"
								href="/multiShopJava/Product/product-detail?id=${spnb.MASP}"><i
								class="fa fa-shopping-cart"></i></a>
						</div>
					</div>
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate"
							href="/multiShopJava/Product/product-detail?id=${spnb.MASP}">${spnb.getTENSP()}</a>
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${spnb.getDONGIA()}" />
							</h5>
						</div>
						<div class="d-flex align-items-center justify-content-center mb-1">
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
	</div>
	<div class="block" id="gaming">

		<a href="/multiShopJava/Product/ShowFeaturedProducts/1" type="submit" class="block-btn"> <span>Xem tất
				cả sản phẩm nổi bật</span>
		</a>

	</div>
</div>
<!-- Products End -->
<!-- Vendor Start -->
<div class="container-fluid py-5">
	<div class="row px-xl-5">
		<div class="col">
			<div class="owl-carousel vendor-carousel">
				<c:forEach var="nsx" items="${NSXS}" varStatus="status">
					<div class="bg-light p-4">
						<img src="<c:url value='/resources/logoSP/${ nsx.getICON()}'/>"
							alt="">
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<!-- Vendor End -->
<style type="text/css">
#gaming .block-btn-more, #gaming .block-btn {
	background: linear-gradient(92.4deg, #ffd400 0%, #febf00 100%);
	box-shadow: 0 0 20px #b88a00;
}

.block-btn {
	background-color: #fff;
	border-radius: 4px;
	color: #333;
	display: block;
	font-size: 14px;
	line-height: 18px;
	margin: 10px auto 0;
	max-width: 350px;
	padding: 10px 10px;
	text-align: center;
	width: 100%;
	text-transform: uppercase;
}
</style>