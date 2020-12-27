<nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <a class="navbar-brand" href="#"><span class="fa fa-university"></span> Accounts</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <!-- Button trigger modal -->
<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button> -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
  <!--   <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Test Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
                <center><h5>Accountant details</h5></center>
                <h6>Email: Rohit@gmail.com</h6>
        <h6>ID    : AC28053   </h6>   
        </br>
             <center><h5>Student details</h5></center>
                <h6>Email: sam@gmail.com</h6>
        <h6>ID    : ST1762   </h6>   
        </br>
             <center><h5>Admin details</h5></center>
                <h6>Email: apoorv@gmail.com</h6>
        <h6>ID    : AD5050   </h6>   
        </br>
   
   <%
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
   response.setHeader("Progma","no-cache");
   response.setDateHeader("Expires",0);
   %>
     
     
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div> -->
  </div>
</div>

<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button> -->

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"> <span class="fa fa-desktop"> Home <span class="sr-only">(current)</span></a>
      </li>
     <!--  <li class="nav-item">
        <a class="nav-link"  data-toggle="modal" data-target="#exampleModal"href="#"> <span class="fa fa-address-book"></span>Test Details</a>
      </li> -->
   <!--    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <span class="	fa fa-check-square-o"></span> Catgories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Admin</a>
          <a class="dropdown-item" href="#">Accountant</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Student</a>
        </div>
      </li> -->
      </li>
    <!--   <li class="nav-item">
        <a class="nav-link" href="login.jsp"> <span class="fa fa-user-circle fa-spin"></span>LOGIN</a>
      </li> -->
    
    </ul>
    <form action="logout" method="get""form-inline my-2 my-lg-0">
      <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Logout</button>
    </form>
  </div>
</nav>
