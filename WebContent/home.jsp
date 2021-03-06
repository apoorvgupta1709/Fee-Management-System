<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quantum accounts</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="newCascadeStyleSheet.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
             .banner-background{
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 80%, 65% 66%, 34% 85%, 0% 70%, 0 0);
            }
           
        </style>
       </head>
    <body>
        <!--navbar-->
        <%@include file="navbar.jsp"%>
     
        <!--container-->
        <div class="container-fluid p-0 m-0">
            <div class="jumbotron primary-background text-white">
                <div class="container">
                <h3 class="display-3">Welcome To Quantum University Accounts Deppt.</h3>
                <a href="login.jsp" class="btn btn-outline-light  btn-lg"><span class="fa fa-user-circle fa-spin"></span>Login</a>
                </div>
            </div>
        </div>
        
        
        <!--javascript-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/myjs.js" type="text/javascript"></script>
    </body>
</html>
