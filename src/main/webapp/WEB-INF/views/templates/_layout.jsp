<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
			<a class="navbar-brand" href="trang-chu.html">Trang chủ</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li>
					<a href="home.html">Trang Chủ</a>
				</li>
				<li>
					<a href="about.html">Về Chúng Tôi</a>
				</li>

				<li>
					<a href="tim-quanh-day.html">Tìm quanh đây</a>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a class="btn-dangtin" href="${pageContext.request.contextPath}/user/motel/add"><i class="fas fa-edit"></i> Đăng tin ngay</a></li>
				<li><a href="${pageContext.request.contextPath}/auth/index.html"><i class="fas fa-user-circle"></i> Đăng nhập / Đăng ký</a></li>
			</ul>

		</div>
	</div>
</nav>


<div id="dailogfind" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Tìm kiếm</h4>
			</div>
			<div class="modal-body">
				<form onsubmit="return false">
					<input type="hidden" name="_token" value="{{ csrf_token() }}">
					<input id="vcategory" type="hidden" name="category" value="{{$category->id}}">
					<div class="form-group">
						<label class="dk">Chọn danh mục</label>
						<select id="category" name="category" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
							<!-- <option value="0">Chọn tất cả</option> -->
							@foreach ($categorys as $category)
							<option @if($category->id==1) selected @endif value="{{$category->id}}">{{$category->name}}</option>
							@endforeach
						</select>
					</div>
					<div class="form-group">
						<label class="dk">Chọn tỉnh</label>
						<select onchange="provinceChange(this.value)" id="province" name="province" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
							<option value="0">Chọn tất cả</option>
							@foreach ($provinces as $province)
							<option @if($province->id==1) selected @endif value="{{$province->id}}">{{$province->name}}</option>
							@endforeach
						</select>
					</div>
					<div class="form-group">
						<label class="dk">Chọn quận/huyện</label>
						<select onchange="districtChange(this.value)" id="district" name="district" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
							<option value="0">Chọn tất cả</option>
							@foreach ($districts as $district)
							<option @if($district->id==1) selected @endif  value="{{$district->id}}">{{$district->name}}</option>
							@endforeach
						</select>
					</div>
					<div class="form-group">
						<label class="dk">Chọn khoản giá</label>
						<select id="price" name="price" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
							<option min="0" max="10000000">Chọn tất cả</option>
							<option min="0" max="600000">Từ 400.000 - 600.000 vnđ</option>
							<option min="600000" max="800000">Từ 600.000 - 800.000 vnđ</option>
							<option min="800000" max="1000000">Từ 800.000 - 1.000.000 vnđ</option>
							<option min="1000000" max="1200000">Từ 1.000.000 - 1200.000 vnđ</option>
							<option min="1200000" max="1400000">Từ 1.200.000 - 1.400.000 vnđ</option>
							<option min="1400000" max="10000000">Từ 1.400.000 - 10.000.000 vnđ</option>
						</select>
					</div>
					<div class="form-group">
						<label class="dk">Chọn diện tích</label>
						<select id="acreage" name="acreage" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
							<option min="0" max="100">Chọn tất cả</option>
							<option min="10" max="20">Từ 10 20 m2</option>
							<option min="20" max="25">Từ 20 - 25 m2</option>
							<option min="25" max="30">Từ 25 - 30 m2</option>
							<option min="30" max="35">Từ 30 -35 m2</option>
							<option min="35" max="40">Từ 35 - 40 m2</option>
							<option min="40" max="45">Từ 40 - 45 m2</option>
							<option min="45" max="100">Từ 45 - 100 m2</option>
						</select>
					</div>
					<div class="form-group">
						<label class="dk">Tiện nghi</label>
						<select id="convenient" name="convenient[]" class="selectpicker form-control" multiple data-selected-text-format="count > 3" data-show-subtext="true" data-live-search="true"  data-actions-box="true">
							<optgroup label="Tiện nghi nhà trọ">
								@foreach ($convenients as $convenient)
								@if($convenient->kind ==1)
								<option value="{{$convenient->id}}">{{$convenient->name}}</option>
								@endif
								@endforeach
							</optgroup>
							<optgroup label="Tiện nghi phòng trọ">
								@foreach ($convenients as $convenient)
								@if($convenient->kind ==2)
								<option value="{{$convenient->id}}">{{$convenient->name}}</option>
								@endif
								@endforeach
							</optgroup>
						</select>
					</div>
					<div class="form-group">
						<label class="dk">Tìm theo tên</label>
						<input id="name" type="text" name="name" class="form-control">
					</div>
					<button class="btn btn-success form-control" onclick="searchMotelajax()">Tìm kiếm</button>
				</form>
			</div>
		</div>

	</div>
</div>


<div id="menu-category" class="menu-category">
	@foreach ($categorys as $category)
	@if($category->kind == 2)
	<a href="{{$category->slug}}.html">{{$category->name}}</a>
	@endif
	@endforeach
</div>

<div class="navbar-fixed-bottom navbar-default" role="navigation">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-center">
			<li><a  id="menu"><span class="glyphicon glyphicon-align-justify"></span></a></li>
			<li><a href="trang-chu.html"><span class="glyphicon glyphicon-home"></span></a></li>
			<li><a href="user/motel/add"><span class="fas fa-edit"></span></a></li>
			<li><a href="user/profile"><span class="glyphicon glyphicon-user"></span></a></li>
			<li><a data-toggle="modal" data-target="#dailogfind"><span class="glyphicon glyphicon-search"></span></a></li>
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
					<span>MENU</span>

					<li>
						<a href="home.html">Trang Chủ</a>
					</li>
					<li>
						<a href="about.html">About</a>
					</li>
					<li>
						<a href="find.html">Tìm Quanh Đây</a>
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

<script type="text/javascript">
	$(document).ready(function(){
		$("#menu").click(function(){
			$("#menu-category").slideToggle("slow");
		});
	});
</script>
</body>
</html>
