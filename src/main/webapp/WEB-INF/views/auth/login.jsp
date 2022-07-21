<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<div class="container">
   <br>
   <h3 >${params.accountList.get(0).email} </h3>

   <h3 >Chào mừng bạn trở lại ${params.account.email} </h3>
   <br>
  <s:form id="loginForm" class="loginForm" theme="css_xhtml" action="login">
      <table class="login">
        <tbody>
          <tr>
            <td><s:label value="UserName:" for="username" /></td>
            <td><s:textfield name="loginForm.username" id="username" class="form-control" /></td>
          </tr>
          <tr>
            <td><s:label value="Password:" for="password" /></td>
            <td><s:password name="loginForm.password" id="password" class="form-control"/></td>
          </tr>
          <tr>
          <td><s:submit name="login" value="Login" class="btn btn-success form-control center"/></td>
          </tr>
        </tbody>
      </table>
  </s:form>
</div>