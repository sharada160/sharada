<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<sec:authorize access="">
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
		
		<c:if test="${pageContext.request.userPrincipal.name== null}">
			<%System.out.println("eual to null"); %>
			<c:redirect url="/logins"></c:redirect>
			
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		<%System.out.println("not null"); %>
		<c:redirect url="/home"></c:redirect>
</c:if>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
		
		<c:if test="${pageContext.request.userPrincipal.name== null}">
			<%System.out.println("eual to null"); %>
			<c:redirect url="/logins"></c:redirect>
			
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		<%System.out.println("not null"); %>
		<c:redirect url="/adm"></c:redirect>
</c:if>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_SUPP')">
		
		<c:if test="${pageContext.request.userPrincipal.name== null}">
			<%System.out.println("eual to null"); %>
			<c:redirect url="/logins"></c:redirect>
			
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		<%System.out.println("not null"); %>
		<c:redirect url="/supplir"></c:redirect>
</c:if>
</sec:authorize>
</body>

</html>