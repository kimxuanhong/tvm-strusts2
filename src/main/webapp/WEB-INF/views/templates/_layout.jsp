<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<s:url action="index" namespace="/home" var="homeUrl"/>
<s:url action="index" namespace="/home" var="aboutUrl"/>
<s:url action="index" namespace="/home" var="findUrl"/>
<s:url action="index" namespace="/home" var="createMotelUrl"/>
<s:url action="index" namespace="/auth" var="loginUrl"/>
<s:url action="logout" namespace="/auth" var="logoutUrl"/>
<s:url action="index" namespace="/auth" var="profileUrl"/>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Trang web thuộc trường đại học Trà Vinh | cung cấp thông tin nhà trọ chính xác | phục vụ cho sinh viên và người lao động">
	<meta name="author" content="">
	<meta name="csrf-token" content="{{ csrf_token() }}">
	<base href="{{asset('')}}">
	<title>System Support Student | Nhà Trọ Trà Vinh | Giải Phám Tìm Kiếm An Toàn</title>

	<!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/bootstrap/bootstrap-select.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/fileinput.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/awesome/css/fontawesome-all.css">

	<!-- Custom CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/footer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/navbar.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/banner.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/login.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/assets/css/product.css">

	<script src="${pageContext.request.contextPath}/public/assets/js/jquery.min.js"></script>
</head>
<body>

<div class="banner">
	<div class="container-fluid">
		<div class="topnav">
			<a href="https://www.tvu.edu.vn/">Trang Chủ TVU</a>
			<a href="https://ktcn.tvu.edu.vn/">Khoa Kỹ thuật & Công nghệ</a>
			<a href="http://sit.tvu.edu.vn/">Bộ môn Công nghệ Thông Tin</a>
			<a href="http://ttsv.tvu.edu.vn/">Trang thông tin sinh viên</a>
		</div>
	</div>
</div>

<div class="header">
	<div class="container-fluid">
		<img class="img_banner" src="${pageContext.request.contextPath}/public/images/bg.png">
	</div>

</div>

<nav id="navbar" class="navbar navbar-inverse" role="navigation">
	<div class="container" >
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<s:a href="%{homeUrl}" class="navbar-brand"> <span class="glyphicon glyphicon-home"></span> Trang chủ</s:a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li>
                    <s:a href="%{findUrl}"><span class="glyphicon glyphicon-map-marker"></span> Tìm Quanh Đây</s:a>
            	</li>
			</ul>

			<s:if test="%{#session.loginStatus == true}">
			    <ul class="nav navbar-nav navbar-right">
			    	<li><s:a href="%{createMotelUrl}" class="btn-dangtin"><i class="fas fa-edit"></i> Đăng tin ngay</s:a></li>
			    	<li class="dropdown">
			    		<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fas fa-user-circle"></i> ${session.account.fullName} <span class="caret"></span></a>
			    		<ul class="dropdown-menu">
			    			<li><s:a href="%{profileUrl}">Thông tin chi tiết</s:a></li>
			    			<li><s:a href="%{logoutUrl}">Thoát</s:a></li>
			    		</ul>
			    	</li>
			    	<li><s:a href="%{logoutUrl}"><i class="fas fa-sign-in-alt"></i> Đăng xuất</s:a></li>
			    </ul>
			</s:if>
            <s:else>
			    <ul class="nav navbar-nav navbar-right">
			    	<li><s:a href="%{createMotelUrl}" class="btn-dangtin"><i class="fas fa-edit"></i> Đăng tin ngay</s:a></li>
			    	<li><s:a href="%{loginUrl}"><i class="fas fa-user-circle"></i> Đăng nhập / Đăng ký</s:a></li>
			    </ul>
			</s:else>
		</div>
	</div>
</nav>

<div class="navbar-fixed-bottom navbar-default" role="navigation">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-center">
			<li><s:a href="%{homeUrl}"><span class="glyphicon glyphicon-home"></span></s:a></li>
			<li><s:a href="%{homeUrl}"><span class="fas fa-edit"></span></s:a></li>
			<li><s:a href="%{profileUrl}"><span class="glyphicon glyphicon-user"></span></s:a></li>
		</ul>
	</div>
</div>

<!-- contain content -->
<div id="wraper" style="background-color: #F5F5F5; min-height: 400px">
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>

<!-- Footer -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="fb-page" data-href="https://www.facebook.com/doankhoaktcntvu/" data-small-header="true" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/doankhoaktcntvu/" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/doankhoaktcntvu/">Đoàn Khoa Kỹ thuật và Công nghệ - TVU</a></blockquote></div>
			</div>

			<div class="col-md-4">
				<ul class="menu">
					<span>Doanh Mục</span>
					<li>
						<s:a href="%{homeUrl}">Trang Chủ</s:a>
					</li>
					<li>
					    <s:a href="%{findUrl}">Tìm Quanh Đây</s:a>
					</li>

				</ul>
			</div>

			<div class="col-md-4">
				<ul class="address">
					<span>Contact</span>
					<li>
						<i class="fa fa-phone" aria-hidden="true"></i> <a href="tellto:02943855690">0294.3855690</a>
					</li>
					<li>
						<i class="fa fa-map-marker" aria-hidden="true"></i> <a href="#">Số 126 Nguyễn Thiện Thành, Khóm 4, Phường 5, TP. Trà Vinh, tỉnh Trà Vinh</a>
					</li>
					<li>
						<i class="fa fa-envelope" aria-hidden="true"></i> <a href="mailto:ktcn@tvu.edu.vn">ktcn@tvu.edu.vn</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</footer>

<script src="${pageContext.request.contextPath}/public/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/public/assets/bootstrap/bootstrap-select.min.js"></script>
<script src="${pageContext.request.contextPath}/public/assets/js/fileinput/fileinput.js"></script>
<script src="${pageContext.request.contextPath}/public/assets/js/fileinput/vi.js"></script>
<script src="${pageContext.request.contextPath}/public/admin_assets/bower_components/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/assets/js/totop.js"></script>
</body>
</html>
