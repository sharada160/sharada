<%@include file="Header.jsp"%>
<div class="row">
<div class="page-header">
<div>
<h2 style="color:black" font-weight:100%;><strong>USERS TABLE</strong></h2>
</div>
</div>
</div>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th><h3 style=color:black;><strong>USER ID</strong></h3></th> 
          <th><h3 style=color:black;><strong>PASSWORD</strong></h3></th> 
        <th><h3 style=color:black;><strong>ROLE</strong></h3></th>
        <th><h3 style=color:black;><strong>USERNAME</strong></h3></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="user" items="${uList}" varStatus="status">
    
      <tr>
          <td><h4 style=color:black;>${user.userId}</h4></td>
          <td><h4 style=color:black;>${user.password}</h4></td>
        <td><h4 style=color:black;>${user.role}</h4></td>
        <td><h4 style=color:black;>${user.username}</h4></td>
          
          <td>
            <p>
            
            
            <a href = "edit.udo?Id=${user.userId}" class = "btn btn-primary" role = "button">
               EDIT
            </a> 
            
           
         </p>  
          </td>
      </tr>
      </c:forEach>
        </tbody>
  </table>
</div>
 
 