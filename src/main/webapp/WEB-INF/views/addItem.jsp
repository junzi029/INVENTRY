<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="parts/head.jsp" />
<title>備品管理</title>
</head>
<body>
<div class="container">
		<c:import url="parts/header.jsp">
			<c:param name="page" value="listItem" />
		</c:import>
  <h1>備品登録</h1>
  <div class="row">
    <div class="col-md-12">
      <form:form modelAttribute="item">
        <div class="form-group">
          <label for="name">品名 (必須)</label>
          <form:errors path="name" cssClass="error-message" />
          <form:input path="name" cssClass="form-control" />
        </div>
        <div class="form-group">
          <label for="amount">数量 (必須)</label>
          <form:errors path="amount" cssClass="error-message" />
          <form:input path="amount" cssClass="form-control" />
        </div>
        <div class="form-group">
          <label for="location.id">場所 (必須)</label>
          <form:select path="location.id" items="${locationList}"
          itemLabel="name" itemValue="id" cssClass="form-control" />
        </div>
        <div class="form-group">
          <label for="note">備考</label>
          <form:textarea path="note" cssClass="form-control" />
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-primary" value="登録" />
          <a href="<spring:url value="/listItem" />" class="btn btn-dark">キャンセル</a>
        </div>
      </form:form>
    </div>
  </div>
</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
