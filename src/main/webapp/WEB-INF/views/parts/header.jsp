<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2">
	<a class="navbar-brand" href="<spring:url value="/" />">備品管理</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item<c:if test="${param.page == 'myPage'}"> active</c:if>"><a class="nav-link" href="<spring:url value="/mypage" />"><i class="fas fa-shopping-cart"></i> マイページ</a></li>
			<li class="nav-item<c:if test="${param.page == 'myPage'}"> active</c:if>"><a class="nav-link" href="<spring:url value="/mypage" />"><i class="fas fa-shopping-cart"></i> マイページ</a></li>
			<li class="nav-item<c:if test="${param.page == 'myPage'}"> active</c:if>"><a class="nav-link" href="<spring:url value="/mypage" />"><i class="fas fa-shopping-cart"></i> マイページ</a></li>
		</ul>

		<ul class="navbar-nav navbar-right">
			<c:choose>
				<c:when test="${not empty sessionScope.userName}">
					<li class="nav-item"><a class="nav-link text-white" href="<spring:url value="/mypage" />"><i class="fas fa-user"></i> ${sessionScope.userName} さん</a></li>
					<li class="nav-item navbar-right"><a class="nav-link" href="<spring:url value="/logout" />"><i class="fas fa-sign-out-alt"></i> ログアウト</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item navbar-right"><a class="nav-link" href="<spring:url value="/login" />"><i class="fas fa-sign-in-alt"></i> ログイン</a></li>
				</c:otherwise>
			</c:choose>
			<li class="nav-item<c:if test="${param.page == 'myPage'}"> active</c:if>"><a class="nav-link" href="<spring:url value="/mypage" />"><i class="fas fa-shopping-cart"></i> マイページ</a></li>
			<c:choose>
				<c:when test="${sessionScope.userTypeId == '0'}">
					<li class="nav-item"><a class="nav-link" href="<spring:url value="/admin/listItem" />"><i class="fas fa-edit"></i> 管理画面</a></li>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		</ul>

	</div>
</nav>