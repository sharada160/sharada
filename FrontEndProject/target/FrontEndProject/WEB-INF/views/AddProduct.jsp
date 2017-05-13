<%@include file="Header.jsp"%>
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
    
     </div> 
    <div class="row">
<div class="page-header">
<div>
<h2 style="color:black;" font-weight:100%;><strong>PRODUCT FORM</strong></h2>
</div>
</div>
</div>


<form:form modelAttribute="prod"  cssClass="form-horizontal" action="saveProduct"  method="POST">
  <div class="form-group">
    <label class="control-label col-sm-2" for="productid"><h4 style="color:Black;" ><strong>PRODUCT ID:</strong></h4></label>
    <div class="col-sm-4">
      <form:input class="form-control" path="productid"  value="${prod.productid}"/>
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="productname"><h4 style="color:Black;" ><strong>PRODUCT NAME:</strong></h4></label>
    <div class="col-sm-4">
      <form:input class="form-control" path="productname" value="${prod.productname}"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="price"><h4 style="color:black;"><strong>PRICE: </strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="price"  value="${prod.price}" />
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="category"><h4 style="color:black;"><strong>CATEGORY:</strong></h4></label>
    <div class="col-sm-4"> 
      <form:input class="form-control" path="category"  value="${prod.category}"/>
    </div>
  </div> 
 <%-- <div class="form-group">
		<label for="img" class="col-sm-2 control-label">Upload Image:</label>
		<div class="col-sm-8">
			<form:input path="img" value="${pro.img}" type="file" cssClass="form-control"/>
		</div>
	</div>--%>
  
    <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-warning" data-toggle="modal" data-target=".bs-example-modal-lg"><strong style="color:Black;">SUBMIT</strong></button>
        <a href="#" class="btn btn-warning" role="button"><strong style="color:Black;">Back</strong></a>
         
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