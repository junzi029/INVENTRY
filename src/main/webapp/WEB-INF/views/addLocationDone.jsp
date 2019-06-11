<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
  <h1>備品更新</h1>
  <div class="row">
    <div class="col-md-12">
      <p>備品の更新が完了しました。</p>
      <p><a href="<spring:url value="/listItem" />">備品リストに戻る</a></p>
    </div>
  </div>
</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
