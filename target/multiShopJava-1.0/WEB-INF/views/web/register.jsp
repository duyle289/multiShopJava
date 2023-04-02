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

<title>SB Admin 2 - Register</title>

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

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Đăng ký thành viên</h1>
							</div>
							<form:form class="user" method="POST" action="register"
								modelAttribute="khachhang">
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										path="TENKH" placeholder="Họ và tên" />
									<form:errors path="TENKH" cssClass="text-danger" />
								</div>

								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										path="EMAIL" placeholder="Email" />
									<form:errors path="EMAIL" cssClass="text-danger" />
									<span style="color: red">${errorMessageEmail}</span>
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										path="USERNAME" placeholder="Tên tài khoản" />
									<form:errors path="USERNAME" cssClass="text-danger" />
									<span style="color: red">${errorMessageUsername}</span>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:input type="password"
											class="form-control form-control-user" path="PASSWORD"
											placeholder="Mật khẩu" />
										<form:errors path="PASSWORD" cssClass="text-danger" />
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											placeholder="Nhập lại mật khẩu" />
										<form:errors path="PASSWORD" cssClass="text-danger" />
									</div>
								</div>
								<div class="form-group">
									<form:input type="date" class="form-control form-control-user"
										path="NGAYSINH" />
									<form:errors path="NGAYSINH" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										path="DIACHI" placeholder="Địa chỉ" />
									<form:errors path="DIACHI" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										path="SDT" placeholder="Số diện thoại" />
									<form:errors path="SDT" cssClass="text-danger" />
									<span style="color: red">${errorMessageSDT}</span>
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control form-control-user"
										path="CCCD" placeholder="CCCD" />
									<form:errors path="CCCD" cssClass="text-danger" />
									<span style="color: red">${errorMessageCCCD}</span>
								</div>
								<div class="form-group" hidden="hidden">
									<div class="col-md-1">
										<div class="checkbox">
											<form:checkbox name="TRANGTHAI" class="form-control"
												path="TRANGTHAI" checked="checked" />
										</div>
									</div>
								</div>
								<input type="submit" value="Đăng ký tài khoản"
									class="btn btn-primary btn-user btn-block" />
								<hr>

							</form:form>
							${Message}
							<hr>
							<div class="text-center">
								<a class="small" href="/multiShopJava/login">Đã có tài
									khoản? Đăng nhập!</a>
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
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>

</body>

</html>