<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="row motel-hot">
	<s:iterator value="params.motels" var="motel">
    	    <s:url action="detail" namespace="/product" var="detailUrl">
                <s:param name="id">${motel.id}</s:param>
            </s:url>

            <div class="col-md-4 col-sm-6">
                <div class="motel-item">
                    <div class="wrap-img" style="background: url(${pageContext.request.contextPath}/public/uploads/images/no_image.png) center; background-size: cover;">
                        <div class="category">
                            <s:a href="%{detailUrl}">${motel.category.name}</s:a>
                        </div>
                    </div>
                    <div class="motel-detail">
                        <h4><s:a href="%{detailUrl}">${motel.name}</s:a></h4>
                        <div class="motel-meta">
                            <span><i class="fas fa-user-circle"></i> Người Đăng: <a href="/"> ${motel.createBy.fullName}</a></span>
                            </span>
                        </div>
                        <div class="motel-description"><i class="fas fa-audio-description"></i>
                            ${motel.description}
                        </div>
                        <div class="motel-info">
                            <span><i class="far fa-stop-circle"></i> Diện Tích: <b>${motel.acreage} m<sup>2</sup></b></span>
                            <span class="pull-right"><i class="fas fa-eye"></i> Lượt Xem: <b>10</b></span>
                            <div><i class="fas fa-map-marker"></i>
                                Địa Chỉ: ${motel.address.name} ${motel.address.number} ${motel.address.street}
                            </div>
                            <div style="color: #e74c3c">
                                <i class="far fa-money-bill-alt"></i> Giá Thuê:
                                <b>${motel.price} VNĐ</b>
                            </div>
                        </div>
                    </div>
                    <div class="motel-btn text-center">
                        <s:a class="btn btn-info" href="%{detailUrl}"> <i class="fas fa-shopping-cart"></i> Xem Chi Tiết</s:a>
                    </div>
                </div>
            </div>
    </s:iterator>
</div>