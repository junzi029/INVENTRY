<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<spring:url value="/css/bootstrap.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
<title>備品管理</title>
</head>
<body>
<div class="container">
  <h1>ログアウト</h1>
  <div class="row">
    <div class="col-md-12">
      <p>ログアウトしました。</p>
      <p><a href="<spring:url value="/login" />">ログイン画面に戻る</a></p>
    </div>
  </div>
</div>
<script src="<spring:url value="/js/jquery-1.10.2.min.js" />"></script>
<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
</body>
</html>
