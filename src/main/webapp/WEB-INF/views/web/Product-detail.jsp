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
				
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="/multiShopJava/" class="nav-item nav-link">Trang chủ</a>
						<a href="/multiShopJava/Product/ShowAllProduct/1" class="nav-item nav-link">Shop</a>
					</div>
					<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
						<a href="/multiShopJava/Cart/ViewCart" class="btn px-0 ml-3"> <i
							class="fas fa-shopping-cart text-primary"></i> <c:choose>
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
				<span class="breadcrumb-item active">Chi tiết sản phẩm</span> <span
					class="breadcrumb-item active">${sp.getTENSP()}</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Detail Start -->
<div class="container-fluid pb-5">
	<div class="row px-xl-5">
		<div class="col-lg-5 mb-30">
			<div id="product-carousel" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner bg-light">
					<div class="carousel-item active">
						<img class="w-100 h-100"
							src="<c:url value='/resources/HinhAnhSP/${sp.getHINHANH()}'/>"
							alt="Image">
					</div>
				</div>
				<a class="carousel-control-prev" href="#product-carousel"
					data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
				</a> <a class="carousel-control-next" href="#product-carousel"
					data-slide="next"> <i class="fa fa-2x fa-angle-right text-dark"></i>
				</a>
			</div>
		</div>

		<div class="col-lg-7 h-auto mb-30">
			<div class="h-100 bg-light p-30">
				<h3>${sp.getTENSP()}</h3>
				<div class="d-flex mb-3"></div>
				<h3 class="font-weight-semi-bold mb-4">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${sp.getDONGIA()}" />
				</h3>
				<p class="mb-4"></p>
				<form:form action="/multiShopJava/Cart/AddtoCart" method="POST">
					<input type="hidden" name="masp" value="${sp.MASP}">
					<div class="d-flex mb-4">
						<strong class="text-dark mr-3">Màu sắc:</strong>
						<c:forEach var="i" begin="1" end="${ctsps.size()}">
							<div class="custom-control custom-radio custom-control-inline">
								<c:forEach var="ms" items="${ms}">
									<c:if test="${ms.MAMAU == ctsps[i-1][1]}">
										<input type="radio" class="custom-control-input"
											id="${ms.MAMAU}" value="${ms.MAMAU}" name="maMau">
										<label class="custom-control-label" for="${ms.MAMAU}">${ms.getTENMAU()}</label>
									</c:if>
								</c:forEach>
							</div>
						</c:forEach>
					</div>
					<div class="d-flex align-items-center mb-4 pt-2">
						<div class="input-group quantity mr-3" style="width: 130px;">
							<div class="input-group-btn">
								<button type="button" class="btn btn-primary btn-minus">
									<i class="fa fa-minus"></i>
								</button>
							</div>
							<input type="text" name="soluong"
								class="form-control bg-secondary border-0 text-center" value="1">
							<div class="input-group-btn">
								<button type="button" class="btn btn-primary btn-plus">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<button type="submit" onclick="checkColor()" class="btn btn-primary px-3">
							<i class="fa fa-shopping-cart mr-1"></i> Thêm vào giỏ hàng
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div class="bg-light p-30">
				<div class="nav nav-tabs mb-4">
					<a class="nav-item nav-link text-dark active" data-toggle="tab"
						href="#tab-pane-1">Mô tả</a> <a
						class="nav-item nav-link text-dark" data-toggle="tab"
						href="#tab-pane-2">Thông tin</a> <a
						class="nav-item nav-link text-dark" data-toggle="tab"
						href="#tab-pane-3">Bình luận(0)</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Mô tả sản phẩm</h4>
						<p>${sp.getMOTA()}</p>
					</div>
					<div class="tab-pane fade" id="tab-pane-2">
						<h4 class="mb-3">Thông tin bổ sung</h4>
						<p>Phần này chịu</p>
					</div>
					<div class="tab-pane fade" id="tab-pane-3">
						<div class="row">
							<div class="col-md-6">
								<h4 class="mb-4">1 review for "Product Name"</h4>
								<div class="media mb-4">
									<img src="img/user.jpg" alt="Image" class="img-fluid mr-3 mt-1"
										style="width: 45px;">
									<div class="media-body">
										<h6>
											John Doe<small> - <i>01 Jan 2045</i></small>
										</h6>
										<div class="text-primary mb-2">
											<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i>
											<i class="far fa-star"></i>
										</div>
										<p>Diam amet duo labore stet elitr ea clita ipsum, tempor
											labore accusam ipsum et no at. Kasd diam tempor rebum magna
											dolores sed sed eirmod ipsum.</p>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<h4 class="mb-4">Leave a review</h4>
								<small>Your email address will not be published.
									Required fields are marked *</small>
								<div class="d-flex my-3">
									<p class="mb-0 mr-2">Your Rating * :</p>
									<div class="text-primary">
										<i class="far fa-star"></i> <i class="far fa-star"></i> <i
											class="far fa-star"></i> <i class="far fa-star"></i> <i
											class="far fa-star"></i>
									</div>
								</div>
								<form>
									<div class="form-group">
										<label for="message">Your Review *</label>
										<textarea id="message" cols="30" rows="5" class="form-control"></textarea>
									</div>
									<div class="form-group">
										<label for="name">Your Name *</label> <input type="text"
											class="form-control" id="name">
									</div>
									<div class="form-group">
										<label for="email">Your Email *</label> <input type="email"
											class="form-control" id="email">
									</div>
									<div class="form-group mb-0">
										<input type="submit" value="Leave Your Review"
											class="btn btn-primary px-3">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Shop Detail End -->


<!-- Products Start -->
<!-- <div class="container-fluid py-5">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">You May Also Like</span>
	</h2>
	<div class="row px-xl-5">
		<div class="col">
			<div class="owl-carousel related-carousel">
				<div class="product-item bg-light">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100" src="img/product-1.jpg" alt="">
						<div class="product-action">
							<a class="btn btn-outline-dark btn-square" href=""><i
								class="fa fa-shopping-cart"></i></a> <a
								class="btn btn-outline-dark btn-square" href=""><i
								class="far fa-heart"></i></a> <a
								class="btn btn-outline-dark btn-square" href=""><i
								class="fa fa-sync-alt"></i></a> <a
								class="btn btn-outline-dark btn-square" href=""><i
								class="fa fa-search"></i></a>
						</div>
					</div>
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate" href="">Product
							Name Goes Here</a>
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>$123.00</h5>
							<h6 class="text-muted ml-2">
								<del>$123.00</del>
							</h6>
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
		</div>
	</div>
</div> -->
<!-- Products End -->
<script>
	function checkColor() {
		if ($('input[type=radio]:checked').length > 0) {
			return alert('Đã thêm sản phẩm vào giỏ hàng');
		} else {
			alert('Vui lòng chọn màu sắc!!!');
			return;
		}
	}
</script>