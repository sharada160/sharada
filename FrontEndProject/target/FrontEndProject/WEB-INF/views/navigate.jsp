<%@include file="Header.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body style="background-color:#DFF6F1;">
<div class="container">
    <div class="row">
    <div class="col-lg-4">
                         
    <spring:url value="/resources/im/bag2.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
     </div>
     <div class="column-lg-8">
    <h1 style="color:black" font-weight:100%;><strong>SHOPPING CART</strong></h1>
     </div>
        <!-- navbar-->
        <nav>
        <div style="margin-top:40px";>
        
        
    <sec:authorize access="hasRole('ROLE_USER')">
		
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		 <a href="home" class="btn btn-primary">
          <span class="glyphicon glyphicon-home"></span> Back</a>&nbsp;
		</c:if>
	</sec:authorize>
	   <sec:authorize access="hasRole('ROLE_ADMIN')">
		
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		 <a href="adm" class="btn btn-primary">
          <span class="glyphicon glyphicon-home"></span> Back</a>&nbsp;
		</c:if>
	</sec:authorize>
        
           <sec:authorize access="hasRole('ROLE_SUPP')">
		
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		 <a href="supplir" class="btn btn-primary">
          <span class="glyphicon glyphicon-home"></span> Back</a>&nbsp;
		</c:if>
	</sec:authorize>
         
        
       
        
        
        <a href="#" class="btn btn-primary">
          <span class="glyphicon glyphicon-search"></span>Back 
       </a>&nbsp;  
        <c:if test="${pageContext.request.userPrincipal.name== null}">
        <a href="logins" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-in"></span> Sign in
        </a>&nbsp;</c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name== null}">
        <a href="toregistration" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-out"></span> Sign up
         </a>&nbsp;</c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name!= null}">
        <a href="javascript:formSubmit()" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-out"></span> Sign out
        </a>&nbsp;</c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name!= null}">
         <a href="totablecart" class="btn btn-primary">
          <span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
        <a href="#" class="btn btn-link"><span ></span>Hi :${pageContext.request.userPrincipal.name}
        </a>
        </c:if>
        <!-- ========================= -->
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
        <!-- ========================= -->
      </p> 
                   
                </ul>
               
            </div>
       </nav>
<!--- nav ends-->