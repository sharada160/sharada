<%@include file="Header.jsp"%>



<body style="background-color:#76D7C4;">
<div class="container">
<div class="row">
    <div class="col-lg-4">
                         
    <spring:url value="/resources/im/bag2.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
     </div>
     <div class="column-lg-8">
     <h1 style="color:black" font-weight:100%;><strong>SHOPPING CART</strong></h1>
     </div>
    
      </p> 
     </div> 
  <div class="row">
<div class="page-header">
<div>
<h2 style="color:black" font-weight:100%;><strong>PRODUCT DETAILS TABLE</strong></h2>
</div>
</div>
</div>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th><h3 style=color:black;><strong>PRODUCT ID</strong></h3></th> 
          <th><h3 style=color:black;><strong>PRODUCT NAME</strong></h3></th> 
        <th><h3 style=color:black;><strong>PRODUCT PRICE</strong></h3></th>
        <th><h3 style=color:black;><strong>PRODUCT CATEGORY</strong></h3></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="prod" items="${pList}" varStatus="status">
    
      <tr>
          <td><h4 style=color:black;>${prod.productid}</h4></td>
          <td><h4 style=color:black;>${prod.productname}</h4></td>
        <td><h4 style=color:black;>${prod.price}</h4></td>
        <td><h4 style=color:black;>${prod.category}</h4></td>
          
          <td>
            <p>
            
            
            <a href = "edit.do?Id=${prod.productid}" class = "btn btn-primary" role = "button">
               EDIT
            </a> 
            
            <a href = "del.do?Id=${prod.productid}" class = "btn btn-primary" role = "button">
               DELETE
            </a>
         </p>  
          </td>
      </tr>
      </c:forEach>
        </tbody>
  </table>

</div>

<%@include file="Footer.jsp"%>