<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="adapter.Database" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>




<style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #1183ca;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}


</style>




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
    
    <%

int j=0;
try{
	j=Integer.parseInt((String)session.getAttribute("admin"));
}
catch(Exception e)
{
	
}

if(j==0)
{
	response.sendRedirect("login.jsp");
}
Connection con=Database.getCon();

PreparedStatement ps6=con.prepareStatement("select * from admin where id=?  ");
ps6.setString(1,Integer.toString(j));	
ResultSet rs6=ps6.executeQuery();
int total=0;
String A[]=new String[7];
while(rs6.next()){

	A[0]=Integer.toString(rs6.getInt(1));
	A[1]=rs6.getString(2);
	A[2]=rs6.getString(3);
	A[3]=rs6.getString(4);
	A[4]=rs6.getString(5);



//out.print(A[1]+A[0]+ A[2]+ A[3]+ A[4]);
}

%>

        <%@include file="navbar.jsp" %>

        <main class="primary-background  banner-background"  style="padding-bottom: 80px;">

            <div class="container">

                <div class="col-md-6 offset-md-3">

                    <div class="card">
                        <div class="card-header text-center primary-background text-white">
                            <span class="fa fa-3x fa-user-circle"></span>
                            <br>
                            ADMIN
                        </div>
                        <div class="card-body">
                        
                        
                        
                     

<center>


    <div class="form-group">
                                    <label > ID :     <h5><% out.print(A[0]); %></h5></label>
                                </div>
                         
                         <div class="form-group">
                                    <label > Name :     <h5><% out.print(A[1]); %></h5></label>
                                </div>
                                <div class="form-group">
                                    <label > Email :     <h5><% out.print(A[2]); %></h5></label>
                                </div>
                                <div class="form-group">
                                    <label > Gender :     <h5><% out.print(A[3]); %></h5></label>
                                </div>
                                  <div class="form-group">
                                    <label > Contact :     <h5><% out.print(A[4]); %></h5></label>
                            </div>



                                <div class="form-group">
                                
                         
                                   <a href="AddAccountant2.jsp">
                                   <button class="button" style="vertical-align:middle"><span>ADD  </span>  </button>
                                   </a> 
                                   
                                    <a href="Delete_Accountant.jsp">
                 <button class="button" style="vertical-align:middle"><span>Delete  </span>  </button>
                                    </a>
                                   </div>

                             



                             


                                <div class="form-group">
                                  <a href="Check_Fee_Details.jsp">
   <button class="button" style="vertical-align:middle"><span>Check Fee  </span>  </button>
</a>

<a href="View_Accountant.jsp">
   <button class="button" style="vertical-align:middle"><span>View   </span>  </button>
</a>
                                </div>

                         


</center>                  

                                <br>

                               


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
                        url: "addStudent",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data)

                            $("#sumbimt-btn").show();
                            $("#loader").hide();

                            if (data.trim() === 'done')
                            {

                                swal("Registered successfully..We are going to redirect to login page")
                                        .then((value) => {
                                            window.location = "Save_Student.jsp"
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
