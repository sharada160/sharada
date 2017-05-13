<%@ include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body style="background-color:#76D7C4;">
<div class="container">
<div class="row">
    <div class="col-lg-4">
                         
    <spring:url value="/resources/im/bag2.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
     </div>
     <div class="column-lg-8">
     <h1 style="color:black" font-weight:100%;><strong>SHOPPING CART</strong></h1>
     </div>
     <a href="addtocart" class="btn btn-primary">
          <span class="glyphicon glyphicon-home"></span> Home
        </a>&nbsp;
        
        
        <a href="#" class="btn btn-primary">
          <span class="glyphicon glyphicon-log-out"></span> Sign out
        </a>&nbsp;
         <a href="totablecart" class="btn btn-primary">
          <span class="glyphicon glyphicon-shopping-cart"></span> Cart
        </a>
      </p> 
     </div>
    <div class="row">
<div class="page-header">
<div>
<h2 style="color:black;" font-weight:100%;><strong>USER DETAILS FORM</strong></h2>
</div>
</div>
</div>

<form:form modelAttribute="userdetail"  cssClass="form-horizontal" action="saveUserDetail" method="POST">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email"><h4 style="color:Black;" ><strong>User ID:</strong></h4></label>
    <div class="col-sm-4">
      <form:input class="form-control" path="userId" value="${detail.userId}"/>
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="email"><h4 style="color:Black;" ><strong>First Name:</strong></h4></label>
    <div class="col-sm-4">
      <form:input class="form-control" path="firstname" value="${userdetail.firstname }"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="price"><h4 style="color:black;"><strong>Last Name:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="lastname" value="${userdetail.lastname}" />
    </div>
  </div>
  
<!--    <div class="form-group"> -->
<!--     <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>Login Id:</strong></h4></label> -->
<!--     <div class="col-sm-4">  -->
<%--       <form:input class="form-control" path="loginId" value="${userdetail.loginId }"/> --%>
<!--     </div> -->
<!--   </div>  -->
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>Contact:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="contact" value="${userdetail.contact }"/>
    </div>
  </div> 
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>Shipping:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="shipping" value="${userdetail.shipping }"/>
    </div>
  </div> 
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>Area:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="area" value="${userdetail.area}"/>
    </div>
  </div> 
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>City:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="city" value="${userdetail.city }"/>
    </div>
  </div> 
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>Pin code:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="pincode" value="${userdetail.pincode }"/>
    </div>
  </div> 
  
    <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-4">
    
      <button type="submit" class="btn btn-warning" data-toggle="modal" data-target=".bs-example-modal-lg"><strong style="color:Black;">SUBMIT</strong></button>
        <a href="tocarttable" class="btn btn-warning" role="button"><strong style="color:Black;">Back</strong></a>
          <a href="gotopayment" class="btn btn-warning" role="button"><strong style="color:Black;">Next</strong></a>
    </div>
  </div>
    
</form:form>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    
      <div class="modal-body">
     
      <h1>"${success}"</h1>
     
      </div>
    </div>
  </div>
</div>

    </div>
    <%@include file="Footer.jsp"%>