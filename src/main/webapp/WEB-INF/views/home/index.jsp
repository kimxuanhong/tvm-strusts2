<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<div id="totop"  class="container">
	<div id="find">
		<h3 class="title-comm"><span class="title-holder">LỌC TIN NHANH</span></h3>
		<div class="find">
			<div class="row">
				<form onsubmit="return false">
					<input type="hidden" name="_token" value="{{ csrf_token() }}">
					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Chọn danh mục</label>
							<select id="category_2" name="category_2" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
								<option value="0">Chọn tất cả</option>
								@foreach ($categorys as $category)
								<option @if($category->id==1) selected @endif value="{{$category->id}}">{{$category->name}}</option>
								@endforeach
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Chọn tỉnh/thành phố</label>
							<select onchange="provinceChange(this.value)" id="province_2" name="province" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
								<option value="0">Chọn tất cả</option>
								@foreach ($provinces as $province)
								<option @if($province->id==1) selected @endif value="{{$province->id}}">{{$province->name}}</option>
								@endforeach
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Chọn quận/huyện</label>
							<select onchange="districtChange(this.value)" id="district_2" name="district" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
								<option value="0">Chọn tất cả</option>
								@foreach ($districts as $district)
								<option @if($district->id==1) selected @endif  value="{{$district->id}}">{{$district->name}}</option>
								@endforeach
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Chọn khoản giá</label>
							<select id="price_2" name="price" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
								<option min="0" max="10000000">Chọn tất cả</option>
								<option min="0" max="600000">Từ 400.000 - 600.000 vnđ</option>
								<option min="600000" max="800000">Từ 600.000 - 800.000 vnđ</option>
								<option min="800000" max="1000000">Từ 800.000 - 1.000.000 vnđ</option>
								<option min="1000000" max="1200000">Từ 1.000.000 - 1200.000 vnđ</option>
								<option min="1200000" max="1400000">Từ 1.200.000 - 1.400.000 vnđ</option>
								<option min="1400000" max="10000000">Từ 1.400.000 - 10.000.000 vnđ</option>
							</select>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Chọn diện tích</label>
							<select id="acreage_2" name="acreage" class="selectpicker form-control" data-show-subtext="true" data-live-search="true">
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
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Chọn tiện nghi</label>
							<select id="convenient_2" name="convenient[]" class="selectpicker form-control" multiple data-selected-text-format="count > 3" data-show-subtext="true" data-live-search="true"  data-actions-box="true">
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
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="dk">Tìm theo tên</label>
							<input id="name_2" type="text" name="name" class="form-control">
						</div>
					</div>
					<div class="col-md-3">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<button style="margin-top: 25px" class="btn btn-info form-control" onclick="searchMotelajax_2()">Tìm kiếm</button>
							</div>
							<div class="col-md-6 col-xs-6">
								<button style="margin-top: 25px" class="btn btn-warning form-control" ">Xóa lọc</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- <button id="myBtn" data-toggle="tooltip" title="Tìm kiếm"><span class="glyphicon glyphicon-search"></span></button> -->
	<button id="btntop" data-toggle="tooltip" title="TO TOP"><span class="glyphicon glyphicon-chevron-up"></span></button>
	<div class="" >
		<ul class="breadcrumb">
			<li class="active"><a href="trang-chu.html">Trang Chủ</a></li>
		</ul>
	</div>
	<div id="content">
		<!-- map -->

		<!-- danh mục -->
		<h3 class="title-comm"><span class="title-holder">XEM NHIỀU NHẤT</span><!-- <marquee>Nhiều người quan tâm - hãy xem nó có phù hợp với bạn</marquee> --></h3>
		    <jsp:include page="/WEB-INF/views/product/list.jsp">
                <jsp:param name="product" value="xuanhong 1"/>
            </jsp:include>
		<!-- danh mục -->
		<h3 class="title-comm"><span class="title-holder">GIÁ TỐT NHẤT</span><!-- <marquee>Phù hợp với bạn nào có hồ bao không lớn - nhưng vẫn có nơi ở tốt</marquee> --></h3>
			<jsp:include page="/WEB-INF/views/product/list.jsp">
                <jsp:param name="product" value="xuanhong 2"/>
            </jsp:include>
		<!-- danh mục -->
		<h3 class="title-comm"><span class="title-holder">MỚI THÊM GẦN ĐÂY</span><!-- <marquee>Nơi ở mới luôn được cập nhật hằng ngày</marquee> --></h3>
			<jsp:include page="/WEB-INF/views/product/list.jsp">
                <jsp:param name="product" value="xuanhong 3"/>
            </jsp:include>
	</div>
</div>