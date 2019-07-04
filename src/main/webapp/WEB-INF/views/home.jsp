<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="ko">
<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
	<title><spring:message code="title" text="사이트" /></title>
	<script>
		$(function(){
			console.log('시작');
			
			$("#btn1").click(function(){
				//var list = [{id:1},{id:2},{id:3},{id:4},{id:5}];
				//var list = [1,2,3];
				var list = "왜 못받을까요?";
				$.ajax({
					url: "/sendListTest",
					type: "POST",
					dataType : 'json',
					data: list,
					success: function(data) {
						console.log('send 완료!');
					},
					error: function() {
						console.log('error!');	
					}					
				});
			});
		});
	</script>
</head>
<body>
<h1>
	<spring:message code="hello" text="기본 text" />
</h1>
<p>Session Locale : <c:out value="${sessionLocale}" /></p>
<button id="btn1">button클릭</button>
</body>
</html>
