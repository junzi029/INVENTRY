<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="parts/head.jsp" />
<title>備品管理</title>
</head>
<body>
	<div class="container">
		<c:import url="parts/header.jsp">
			<c:param name="page" value="myPage" />
		</c:import>
		<h1>マイページ</h1>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<tr>
						<th>id</th>
						<td><c:out value="${user.id}" /></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><c:out value="${user.name}" /></td>
					</tr>
					<tr>

						<th>種類</th>
						<td><c:out value="${user.userType.typeName}" /></td>
					</tr>
					<tr>

						<th>登録日</th>
						<td><c:out value="${user.registered}" /></td>
					</tr>
					<tr>

						<th>更新日</th>
						<td><c:out value="${user.updated}" /></td>
					</tr>
				</table>
				<a href="<spring:url value="/editUser" />" class="btn btn-primary">編集</a>
			</div>
		</div>
	</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
