<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <%@page import="java.util.*" %>  
 <%@ page errorPage="error_page.jsp" %>  
 
 <%
 	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000000);
 %>
 <%   
 HttpSession session2=request.getSession(false);  

 %>
<!DOCTYPE html>
<html>
    <head>
        <title>Merchant checkout page</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Evrsoft First Page">

        <!--css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="newCascadeStyleSheet.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
        </style>

    </head>
    <body>

        <%@include file="navbar.jsp" %>

        <main class="primary-background  banner-background"  style="padding-bottom: 80px;">

            <div class="container">

                <div class="col-md-6 offset-md-3">

                    <div class="card">
                        <div class="card-header text-center primary-background text-white">
                            <span class="fa fa-3x fa-user-circle"></span>
                            <br>
                            Submit Fee
                        </div>
                        <div class="card-body">
                            <form id="reg-form" action="pgRedirect.jsp" method="POST">

                                <div class="form-group">
                                    <label for="user_name"> Order id</label>
                                 <input id="ORDER_ID" tabindex="1" maxlength="20" size="20"
						                           name="ORDER_ID" autocomplete="off"
						                               value="ORDS_<%= randomInt %>">                   
						                                            </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Cust ID</label>
                                 <input id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST001<%= randomInt %>">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your id with anyone else.</small>
                                </div>



                                <div class="form-group">
                                    <label for="exampleInputPassword1">amount</label>
                                      <input title="TXN_AMOUNT" tabindex="10"
					                         	type="text" name="TXN_AMOUNT"
					                              	value="1">      
					                              	                          </div>



<!-- 
                                <div class="form-check">
                                    <input name="check" type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">agree terms and conditions</label>
                                </div>
 -->
                                <br>

                                <div class="container text-center" id="loader" style="display: none;">
                                    <span class="fa fa-refresh fa-spin fa-4x"></span>
                                    <h4>Please wait..</h4>
                                </div>

                                <button id="sumbimt-btn" type="submit" class="btn btn-primary">Check Out</button>
                            </form>

                        </div>


                    </div>




                </div>
            </div>

        </main>


        <!--javascripts-->
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
  <!--       <script>
            $(document).ready(function () {
                console.log("loaded........")

                $('#reg-form').on('submit', function (event) {
                    event.preventDefault();



                    let form = new FormData(this);

                    $("#sumbimt-btn").hide();
                    $("#loader").show();
                    //send register servlet:
                    $.ajax({
                        url: "AddAccountant",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data)

                            $("#sumbimt-btn").show();
                            $("#loader").hide();

                            if (data.trim() === 'done')
                            {

                                swal("Registered successfully..")
                                        .then((value) => {
                                            window.location = "AddAccountant2.jsp"
                                        });
                            } else
                            {

                                swal(data);
                            }

                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $("#sumbimt-btn").show();
                            $("#loader").hide();
                            swal("something went wrong..try again");

                        },
                        processData: false,
                        contentType: false

                    });



                });


            });



        </script> -->


    </body>
</html>
