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

		<div
			class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
			<div class="col-lg-4">
				<a href="/multiShopJava/Home/" class="text-decoration-none"> <span
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
									nhập</a> <a class="dropdown-item"
									href="/multiShopJava/Customer/register">Đăng Ký</a>
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
									<button class="dropdown-item" type="button">Hồ sơ của
										tôi</button>
									<button class="dropdown-item" type="button">Đổi mật
										khẩu</button>
									<button class="dropdown-item" type="button">Lịch sử
										đặt hàng</button>
									<button
										onclick="location.href='/multiShopJava/Customer/logout'"
										id="btn-Logout" class="dropdown-item" type="button">
										Đăng xuất</button>
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
                <h5 class="text-secondary text-uppercase mb-4">Thông tin liên hệ</h5>

                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>49/1E, đường số 7, phường Linh Tây, thành phố Thủ Đức</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>multishoplaptop@gmail.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+84 907943574</p>
            </div>
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">Kết nối với chúng tôi</h5>
                        <div id="fb-root"></div>
                        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v15.0" nonce="4EbOmLvJ"></script>
                        <div class="fb-page" data-href="https://www.facebook.com/profile.php?id=100084024889741" data-tabs="timeline" data-width="" data-height="" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/profile.php?id=100084024889741" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/profile.php?id=100084024889741">MultiShop</a></blockquote></div>
                        
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">Vị trí cửa hàng</h5>

							<iframe style="width: 200%; height: 250px;"
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.3352290221987!2d106.75111881471923!3d10.86208729226345!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752768f8b79947%3A0xf40161ff1bbb963b!2zNDkvMWUgxJAuIFPhu5EgNywgTGluaCBUw6J5LCBUaOG7pyDEkOG7qWMsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1656501097726!5m2!1svi!2s"
								width="600" height="450" style="border:0;" allowfullscreen=""
								loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
					</div>
				</div>
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