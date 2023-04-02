<%@ include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value='/template/admin/css/sb-admin-2.min.css'/>"
	rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<form action="/multiShopJava/login" method="POST"
										class="user">
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name="taikhoan" placeholder="Tai khoan">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												name="matkhau" placeholder="Mat khau">
										</div>
										<div class="form-group">
											<select name="role" class="dmm">
												<option value="" selected="selected">--- Chọn quyền ---</option>
												<option value="user">Khách hàng</option>
												<option value="admin">Admin</option>
											</select>
										</div>
										<button type="submit"
											class="btn btn-primary btn-user btn-block">Login</button>

									</form>
									<hr>
									${error }
									<hr>
									<div class="text-center">
<<<<<<< HEAD
										<a class="small" href="Customer/forgotPassword">Quên mật khẩu?</a>
									</div>
									<div class="text-center">
										<a class="small" href="Customer/register">Tạo tài khoản</a>
=======
										<a class="small" href="forgot-password.html">Forgot
											Password?</a>
									</div>
									<div class="text-center">
										<a class="small" href="register.html">Create an Account!</a>
>>>>>>> 3fb17b47a97451a4a99639172a5df43cdc557687
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>


</body>
<style>
.dmm {
	outline: none;
	width: 100%;
	height: 48px;
	border-radius: 10rem;
	padding-left: 3%;
	border: 1px solid #d1d3e2;
	color: #6e707e;
}
</style>
</html>