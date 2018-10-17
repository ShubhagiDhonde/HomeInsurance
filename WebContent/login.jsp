<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
	if(session.getAttribute("username")!=null){
		response.sendRedirect("Index.jsp");
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<title>HomeIns - Login</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	<body>
		<div id="overlay">
			<div class="container">
				<div class="jumbotron text-center">
					<h1 style="padding-bottom: 54px;">Homeowner Insurance Login</h1>
					<div class="inner-jumbotron">
						 <form class="form-right" action="Login" method="post">
						    <div>
						        <!-- <label>User Name: </label>  -->
						        <input class="inputLogin" type = "text" name="UserId" placeholder="Username" required/>
						    </div>
						    <br/>
						     <div>
						         <!-- <label>Password: </label> -->
						        <input class="inputLogin" type="password" name="Password" placeholder="Password" required/>
						     </div>
						     <br/>
						     <div>
						     	<button id="submitLogin" type="submit" value="login">Login</button>         
						     <!--   <input id="submitLogin" type = "submit" value="Login"/> -->
						     </div>
						    <label id="registerLabel">New Users: </label>
						    <a id="register" href="register.jsp">Register Here</a>      
					    </form>
						</div>
				    </div>
				</div>
 		 	<%@ include file="footer.html" %>
		</div>
		<style>
			body{
				background: url('http://davidcools.com/wp-content/uploads/2018/08/home-wallpaper-for-desktop-luxury-house-806590-2560x1440-ipad-retina.jpg') no-repeat center center fixed;
				 -webkit-background-size: cover;
				 -moz-background-size: cover;
				 -o-background-size: cover;
				 background-size: cover;
			}
			#overlay {
			    position: fixed;
			    width: 100%;
			    height: 100%;
			    left: 0;
			    top: 0;
			    background: rgba(0,0,0,0.45);
			    z-index: 10;
			    color: white;
		  	}
		  	.jumbotron{
		  		position: absolute;
		  		top: 50%;
		  		left: 50%;
		  		transform: translate(-50%, -50%);
		  		border: 1px solid deeppink;
		  		background: transparent;
		  		color: white;
		  		border-radius: 10px;
		  	}
		  	.inner-jumbotron{
		  		display: flex;
				justify-content: space-between;
				width: 100%;
		  	}
		  	.text-left{
		  		width: 500px;
		  	}
		  	.form-right{
		  		width: 290px;
		  		margin: auto;
		  	}
			input::placeholder{
				color: #fff;
			}
			.inputLogin{
				border: 0;
				outline: 0;
				background: transparent;
				border-bottom: 1px solid deeppink;
				width: 75%;
				color: #fff;
			}
			#submitLogin {
			    font-family: Montserrat-Bold;
			    font-size: 15px;
			    line-height: 1.5;
			    color: #fff;
			    text-transform: uppercase;
			    width: 75%;
			    height: 30px;
			    border: 0;
			    border-radius: 25px;
			    background: #1F136E;
			    justify-content: center;
			    align-items: center;
			    padding: 0 25px;
			}
			#submitLogin:hover {
			    opacity: 0.85;
			}
		  	#registerLabel{
		  		text-decoration: none;
		  		color: hotpink;
		  	}
		  	#register{
		  		text-decoration: none;
		  		color: hotpink;
		  	}
		  	#register:hover{
		  		text-decoration: none;
		  		color: cyan;
		  	}
		  	.footer{
		  		position: absolute;
		  		background-color: black;
		  	}
		</style>
	</body>
</html>



