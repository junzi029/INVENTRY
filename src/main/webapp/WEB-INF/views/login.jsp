<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<spring:url value="/css/bootstrap.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
<title>備品管理</title>
</head>
<body id="loginPage">
<div class="container">
  <div class="row">
    <div class="col-md-offset-3 col-md-6">
      <div class="panel panel-default">
        <div class="panel-heading">備品管理システム ログイン</div>
        <div class="panel-body">
          <form:errors path="user" element="div" cssClass="alert alert-danger" />
          <form:form modelAttribute="user">
            <div class="form-group">
              <form:errors path="loginId" cssClass="error-message" />
              <form:input path="loginId" placeholder="ログインID" cssClass="form-control" />
            </div>
            <div class="form-group">
              <form:errors path="loginPass" cssClass="error-message" />
              <form:password path="loginPass" placeholder="パスワード" cssClass="form-control" />
            </div>
            <div class="form-group">
              <input type="submit" class="btn btn-primary btn-block" value="ログイン" />
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
