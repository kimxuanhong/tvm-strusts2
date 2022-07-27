<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="row motel-hot">
	<div class="col-md-4 col-sm-6">
		<div class="motel-item">
				<div class="wrap-img" style="background: url(${pageContext.request.contextPath}/public/uploads/images/no_image.png) center; background-size: cover;">
					<div class="category">
						<a href="category.html">${param.product}</a>
					</div>
				</div>
			<div class="motel-detail">
				<h4><a href="${pageContext.request.contextPath}/product/detail.html">Ten nha tro</a></h4>
				<div class="motel-meta">
					<span><i class="fas fa-user-circle"></i> Người đăng: <a href="/">Nguyen Van A</a></span>
					<span class="pull-right"><i class="far fa-clock">30/03/2022</i>
					</span>
				</div>
				<div class="motel-description"><i class="fas fa-audio-description"></i>
					Day la dong mo ta them
				</div>
				<div class="motel-info">
					<span><i class="far fa-stop-circle"></i> Diện tích: <b>15 m<sup>2</sup></b></span>
					<span class="pull-right"><i class="fas fa-eye"></i> Lượt xem: <b>33</b></span>
					<div><i class="fas fa-map-marker"></i>
						Địa chỉ: 56 Yen The, W3, Tan Binh, HCM
					</div>
					<div style="color: #e74c3c">
						<i class="far fa-money-bill-alt"></i> Giá thuê:
						<b>15000000 VNĐ</b>
					</div>
				</div>
			</div>
			<div class="motel-btn text-center">
				<a class="btn btn-info" href="${pageContext.request.contextPath}/product/detail.html"> <i class="fas fa-shopping-cart"></i> Xem chi tiết</a>
			</div>
		</div>
	</div>

<div class="col-md-4 col-sm-6">
		<div class="motel-item">
				<div class="wrap-img" style="background: url(${pageContext.request.contextPath}/public/uploads/images/no_image.png) center; background-size: cover;">
					<div class="category">
						<a href="category.html">Ten Danh Muc</a>
					</div>
				</div>
			<div class="motel-detail">
				<h4><a href="${pageContext.request.contextPath}/product/detail.html">Ten nha tro</a></h4>
				<div class="motel-meta">
					<span><i class="fas fa-user-circle"></i> Người đăng: <a href="/">Nguyen Van A</a></span>
					<span class="pull-right"><i class="far fa-clock">30/03/2022</i>
					</span>
				</div>
				<div class="motel-description"><i class="fas fa-audio-description"></i>
					Day la dong mo ta them
				</div>
				<div class="motel-info">
					<span><i class="far fa-stop-circle"></i> Diện tích: <b>15 m<sup>2</sup></b></span>
					<span class="pull-right"><i class="fas fa-eye"></i> Lượt xem: <b>33</b></span>
					<div><i class="fas fa-map-marker"></i>
						Địa chỉ: 56 Yen The, W3, Tan Binh, HCM
					</div>
					<div style="color: #e74c3c">
						<i class="far fa-money-bill-alt"></i> Giá thuê:
						<b>15000000 VNĐ</b>
					</div>
				</div>
			</div>
			<div class="motel-btn text-center">
				<a class="btn btn-info" href=".${pageContext.request.contextPath}/product/detail.html"> <i class="fas fa-shopping-cart"></i> Xem chi tiết</a>
			</div>
		</div>
	</div>

	<div class="col-md-4 col-sm-6">
    		<div class="motel-item">
    				<div class="wrap-img" style="background: url(${pageContext.request.contextPath}/public/uploads/images/no_image.png) center; background-size: cover;">
    					<div class="category">
    						<a href="category.html">Ten Danh Muc</a>
    					</div>
    				</div>
    			<div class="motel-detail">
    				<h4><a href="${pageContext.request.contextPath}/product/detail.html">Ten nha tro</a></h4>
    				<div class="motel-meta"> <a href="/">Nguyen Van A</a></span>
    					<span class="pull-right"><i class="far fa-clock">30/03/2022</i>
    					</span>
    				</div>
    				<div class="motel-description"><i class="fas fa-audio-description"></i>
    					Day la dong mo ta them
    				</div>
    				<div class="motel-info">
    					<span><i class="far fa-stop-circle"></i> Diện tích: <b>15 m<sup>2</sup></b></span>
    					<span class="pull-right"><i class="fas fa-eye"></i> Lượt xem: <b>33</b></span>
    					<div><i class="fas fa-map-marker"></i>
    						Địa chỉ: 56 Yen The, W3, Tan Binh, HCM
    					</div>
    					<div style="color: #e74c3c">
    						<i class="far fa-money-bill-alt"></i> Giá thuê:
    						<b>15000000 VNĐ</b>
    					</div>
    				</div>
    			</div>
    			<div class="motel-btn text-center">
    				<a class="btn btn-info" href="${pageContext.request.contextPath}/product/detail.html"> <i class="fas fa-shopping-cart"></i> Xem chi tiết</a>
    			</div>
    		</div>
    	</div>
</div>