<%@ include file="/common/tablib.jsp"%>
<c:set var="khachhang" value="${sessionScope.khachhang}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>MultiShop - Online Shop Website</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="<c:url value='/template/web/img/favicon.ico' />" rel="icon">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="<c:url value='/template/web/lib/animate/animate.min.css'/>"
	rel="stylesheet">
<link
	href="<c:url value='/template/web/lib/owlcarousel/assets/owl.carousel.min.css'/>"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet">
</head>

<body>
	<!-- Topbar Start -->
	<div class="container-fluid">

		<div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
			<div class="col-lg-4">
				<a href="" class="text-decoration-none"> <span
					class="h1 text-uppercase text-primary bg-dark px-2">Multi</span> <span
					class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Shop</span>
				</a>
			</div>
			<div class="col-lg-4 col-6 text-left">
				<form action="">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for products">
						<div class="input-group-append">
							<span class="input-group-text bg-transparent text-primary">
								<i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</form>
			</div>
			<c:choose>
				<c:when test="${khachhang == null }">
					<div class="col-lg-4 col-6 text-right">
						<div class="btn-group">
							<button type="button"
								class="btn btn-sm btn-light dropdown-toggle"
								data-toggle="dropdown">Tài khoản</button>
							<div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="/multiShopJava/login">Đăng
									nhập</a>
								<button class="dropdown-item" type="button">Đăng ký</button>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-lg-4 col-6 text-right">
						<div class="d-inline-flex align-items-center">
							<div class="btn-group">
								<button type="button"
								class="btn btn-sm btn-light dropdown-toggle"
								data-toggle="dropdown">${khachhang.getTENKH() }</button>
								<div class="dropdown-menu dropdown-menu-right">
									<button class="dropdown-item" type="button">
										Hồ sơ của tôi
									</button>
									<button  class="dropdown-item" type="button">
										Đổi mật khẩu
									</button>
									<button  class="dropdown-item" type="button">
										Lịch sử đặt hàng
									</button>
									<button  onclick="location.href='/multiShopJava/Customer/logout'" id="btn-Logout"  class="dropdown-item" type="button">
										Đăng xuất
									</button>
								</div>
							</div>

						</div>

					</div>
				</c:otherwise>

			</c:choose>

		</div>
	</div>
	<!-- Topbar End -->

	<!-- co' the su dung include de add nhung file partial -->
	
	<dec:body />

	<!-- Footer Start -->
	<div class="container-fluid bg-dark text-secondary mt-5 pt-5">
		<div class="row px-xl-5 pt-5">
			<div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
				<h5 class="text-secondary text-uppercase mb-4">Get In Touch</h5>
				<p class="mb-4">No dolore ipsum accusam no lorem. Invidunt sed
					clita kasd clita et et dolor sed dolor. Rebum tempor no vero est
					magna amet no</p>
				<p class="mb-2">
					<i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street,
					New York, USA
				</p>
				<p class="mb-2">
					<i class="fa fa-envelope text-primary mr-3"></i>info@example.com
				</p>
				<p class="mb-0">
					<i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890
				</p>
			</div>
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">Quick Shop</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shop Detail</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a> <a
								class="text-secondary" href="#"><i
								class="fa fa-angle-right mr-2"></i>Contact Us</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">My Account</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shop Detail</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a> <a
								class="text-secondary" href="#"><i
								class="fa fa-angle-right mr-2"></i>Contact Us</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">Newsletter</h5>
						<p>Duo stet tempor ipsum sit amet magna ipsum tempor est</p>
						<form action="">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Your Email Address">
								<div class="input-group-append">
									<button class="btn btn-primary">Sign Up</button>
								</div>
							</div>
						</form>
						<h6 class="text-secondary text-uppercase mt-4 mb-3">Follow Us</h6>
						<div class="d-flex">
							<a class="btn btn-primary btn-square mr-2" href="#"><i
								class="fab fa-twitter"></i></a> <a
								class="btn btn-primary btn-square mr-2" href="#"><i
								class="fab fa-facebook-f"></i></a> <a
								class="btn btn-primary btn-square mr-2" href="#"><i
								class="fab fa-linkedin-in"></i></a> <a
								class="btn btn-primary btn-square" href="#"><i
								class="fab fa-instagram"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row border-top mx-xl-5 py-4"
			style="border-color: rgba(256, 256, 256, .1) !important;">
			<div class="col-md-6 px-xl-0">
				<p class="mb-md-0 text-center text-md-left text-secondary">
					&copy; <a class="text-primary" href="#">Domain</a>. All Rights
					Reserved. Designed by <a class="text-primary"
						href="https://htmlcodex.com">HTML Codex</a>
				</p>
			</div>
			<div class="col-md-6 px-xl-0 text-center text-md-right">
				<img class="img-fluid"
					src="<c:url value='/template/web/img/payments.png'/>" alt="">
			</div>
		</div>
	</div>
	<!-- Footer End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-primary back-to-top"><i
		class="fa fa-angle-double-up"></i></a>
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value='/template/web/lib/easing/easing.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/lib/owlcarousel/owl.carousel.min.js'/>"></script>

	<!-- Contact Javascript File -->
	<script
		src="<c:url value='/template/web/mail/jqBootstrapValidation.min.js'/>"></script>
	<script src="<c:url value='/template/web/mail/contact.js'/>"></script>

	<!-- Template Javascript -->
	<script src="<c:url value='/template/web/js/main.js'/>"></script>
</body>

</html>