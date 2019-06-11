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
		<div class="row align-items-center my-2">
			<div class="col-sm">
				備品リスト
			</div>
			<div class="col-sm">
				<form:form modelAttribute="location" class="form-inline float-right">
					<form:select path="id" class="custom-select" onchange="submit(this.form)">
						<form:options items="${locationList}" itemLabel="name" itemValue="id" />
					</form:select>
				</form:form>
			</div>
		</div>

		<div class="row">

			<div class="col-md-12">
				<table class="table table-bordered">
					<tr>
						<th>品名</th>
						<th>数量</th>
						<th>場所</th>
						<th>備考</th>
						<th>登録日</th>
						<th>更新日</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach items="${itemList}" var="item">
						<tr>
							<td><c:out value="${item.name}" /></td>
							<td><c:out value="${item.amount}" /></td>
							<td><c:out value="${item.location.name}" /></td>
							<td><c:out value="${item.note}" /></td>
							<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm" value="${item.registered}" /></td>
							<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm" value="${item.updated}" /></td>
							<td><a href="<spring:url value="/editItem?id=${item.id}" />" class="btn btn-primary">編集</a></td>
							<td><a href="<spring:url value="/deleteItem?id=${item.id}" />" class="btn btn-danger" onclick='if(confirm("データを削除してもよろしいですか？")==false) return false; '>削除</a></td>
						</tr>
					</c:forEach>
				</table>
				<a href="<spring:url value="/addItem" />" class="btn btn-primary">備品の追加</a>
				<a href="<spring:url value="/addLocation" />" class="btn btn-primary">場所の追加</a>
			</div>
		</div>
	</div>
	<c:import url="parts/footer.jsp" />
</body>
</html>
