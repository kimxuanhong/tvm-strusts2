<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<div class="container">
   <br>
   <h3 >Chào mừng bạn trở lại</h3>
   <br>
  <s:form id="loginForm" class="loginForm" theme="css_xhtml" action="login">
      <table class="login">
        <tbody>
          <tr>
            <td><s:label value="UserName:" for="username" /></td>
            <td><s:textfield name="loginForm.username" id="username" /></td>
          </tr>
          <tr>
            <td><s:label value="Password:" for="password" /></td>
            <td><s:password name="loginForm.password" id="password" /></td>
          </tr>
          <tr>
          <td><s:submit name="login" value="Login"/></td>
          </tr>
        </tbody>
      </table>
  </s:form>
   <table class="tbCenter">
      <tr>
         <td><hr></td>
      </tr>
      <tr>
         <td>
            <a style="width: 100%;height: 35px;" class="btn btn-danger form-control" href="auth/google'">Đăng nhập / Đăng ký bằng <i class="fab fa-google-plus-g"></i> </a>
         </td>
      </tr>
   </table>
</div>
<style type="text/css">
.tbCenter{
   margin: auto; width: 30%; padding-top: 100px
}

.container{
    text-align: center;
}

.loginForm{
    margin-left: 40%;
    margin-right: 40%;
}