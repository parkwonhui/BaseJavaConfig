<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title><spring:message code="title" text="사이트" /></title>
</head>
<body>
<h1>
	<spring:message code="hello" text="기본 text" />
</h1>
<p>Session Locale : <c:out value="${sessionLocale}" /></p>
</body>
</html>
