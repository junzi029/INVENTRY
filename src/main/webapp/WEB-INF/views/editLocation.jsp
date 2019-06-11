<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>場所更新</h1>
		<div class="row">
			<div class="col-md-12">
				<form:form modelAttribute="item">
					<form:hidden path="id" items="id" />

					<div class="form-group">
						<label for="name">場所 (必須)</label>
						<form:errors path="name" cssClass="error-message" />
						<form:input path="name" cssClass="form-control" />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="更新" /> <a href="<spring:url value="/listItem" />" class="btn btn-light">キャンセル</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
