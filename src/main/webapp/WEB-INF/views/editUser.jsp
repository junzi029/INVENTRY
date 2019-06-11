<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<c:import url="parts/head.jsp" />
<title>備品管理</title>
</head>
<body>
	<div class="container">
		<c:import url="parts/header.jsp">
			<c:param name="page" value="mypage" />
		</c:import>
		<h1>ユーザー情報更新</h1>
		<div class="row">
			<div class="col-md-12">
				<form:form modelAttribute="user">
					<form:hidden path="id" items="id" />

					<div class="form-group">
						<label for="name">名前 (必須)</label>
						<form:errors path="name" cssClass="error-message" />
						<form:input path="name" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label for="loginId">ログインID</label>
						<form:input path="loginId" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label for="loginPass">ログインパス (必須)</label>
						<form:errors path="loginPass" cssClass="error-message" />
						<form:password path="loginPass" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label for="userType.id">タイプ (必須)</label>
						<form:select path="userType.id" items="${userTypeList}" itemLabel="typeName" itemValue="id" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:hidden path="registered" />
						<form:hidden path="updated" />
						<input type="submit" class="btn btn-primary" value="更新" /> <a href="<spring:url value="/listItem" />" class="btn btn-dark">キャンセル</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
