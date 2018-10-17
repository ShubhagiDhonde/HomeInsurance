<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>HomeIns - Signup</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		<script language="JavaScript" type="text/javascript">
			function check_values() {
				var userId = document.getElementById("UserId").value;
				var pass = document.getElementById("Password").value;
				var confirmPass= document.getElementById("confirmPass").value;
				
				if(userId.length > 20){
					console.log("Username has to be less than 20 characters");
				    document.getElementById('userIdMessage').innerHTML = 'Username has to be less than 20 characters';
					return false;
				}
				else if(pass.length > 20){
					console.log("Password has to be less than 20 characters");
				    document.getElementById('passMessage').innerHTML = 'Password has to be less than 20 characters';
					return false;
				}
				else if(pass != confirmPass){
				    document.getElementById('confpassMessage').innerHTML = 'Passwords need to match';
					return false;
				}
				else{
				    document.getElementById('userIdMessage').innerHTML = '';
				    document.getElementById('passMessage').innerHTML = '';
				    document.getElementById('confpassMessage').innerHTML = '';
					return true;
				}
			}
		</script>
	</head>
	<body>
		<div id="overlay">
			<div class="container">
				<div class="jumbotron text-center">
					<h1 style="padding-bottom: 54px;">Homeowner Insurance Login</h1>
					<div class="inner-jumbotron">
						 <form class="form" action="Register" method="post">
						    <div class="inputs">
						        <input class="inputReg" type ="text" id="UserId" name="UserId" placeholder="Username" onkeyup='check_values()' required/>
						    	<span class="spanMess" id="userIdMessage"></span>
						    </div>
						    <br/>
						     <div class="inputs">
						        <input class="inputReg" type="password" id="Password" name="Password" placeholder="Password" onkeyup='check_values()' required/>
						     	<span class="spanMess" id="passMessage"></span>
						     </div>
						     <br/>
						     <div class="inputs">
						     	<input class="inputReg" type="password" id="confirmPass" name="confirmPass" placeholder="Confirm Password" onkeyup='check_values()' required/>
						     	<span class="spanMess" id="confpassMessage"></span>
						     </div>
						     <br/>
						     <div>
						     	<button id="submitReg" type="submit" value="register" onclick="return check_values()">
						     		Register
						     	</button>     
						     </div>  
					    </form>
						</div>
						<div id="loginCont">
							<a id="login" href="login.jsp">Go back to login</a>
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
				height: 100%;
		  	}
		  	.form{
		  		width: 290px;
		  		margin: auto;
		  	}
			input::placeholder{
				color: #fff;
			}
			.inputs{
				width: 350px;
			}
			.inputReg{
				border: 0;
				outline: 0;
				background: transparent;
				border-bottom: 1px solid deeppink;
				width: 70%;
				color: #fff;
				float: left;
			}
			.spanMess{
				width: 30%;
				float: left;
				color: #fff;
				font-family: verdana;
				font-size: 10px;
				text-align: center;
			}
			#submitReg {
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
			#submitReg:hover {
			    opacity: 0.85;
			}
		  	#registerLabel{
		  		text-decoration: none;
		  		color: hotpink;
		  	}
		  	#loginCont{
		  		
		  	}
		  	#login{
		  		text-decoration: none;
		  		color: hotpink;
		  	}
		  	#login:hover{
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



