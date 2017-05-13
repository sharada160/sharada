<!-- carousel--> 
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            
            <spring:url value="/resources/im/s2.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
        </div>

        <div class="item">
           
             <spring:url value="/resources/im/s3.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
            
        </div>

        <div class="item">
           
             <spring:url value="/resources/im/card.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
        </div>

        <div class="item">
            
             <spring:url value="/resources/im/buy.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
        </div>
  </div>

  <!-- Left and right controls -->
 <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
