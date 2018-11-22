//creating the objects to hold the elements / could honestly change all this to jquery calls
var submitbtn;
var loginForm;
var email;
var pass;
var first;
var last;
var emailError;
var passError;
var firstError;
var lastError;

////////Signup functions
function signup(){
	submitbtn = document.getElementById("Signupbtn");
	loginForm = document.getElementById("SignupForm");
	email = document.getElementById("EmailText");
	pass = document.getElementById("PassText");
	first = document.getElementById("FirstText");
	last = document.getElementById("LastText");
	emailError = document.getElementById("EmailError");
	passError = document.getElementById("PassError");
	firstError = document.getElementById("FirstError");
	lastError = document.getElementById("LastError");
	
	var good=true;
	if(!emailCheck())
		good=false
	if(!passCheck())
		good=false;
	if(!firstCheck())
		good=false
	if(!lastCheck())
		good=false;
	if(good){
		$.ajax({
			url:'BannerServlet',
			data:{action: 'signup',first: first.value,last: last.value,email: email.value,pass: pass.value},
			cache: false,
			success: function(text){
				console.log(text);
				//If user not found, or just a server error
				if(text=="success"){
					passError.innerHTML="~User created!";
				}else
					passError.innerHTML="User was not created";
				
			}
		});
	}
	
}
//Checks if valid email, using a regualr expression
function emailCheck(){
	if(email.value==""){
		emailError.innerHTML="The Email must be filled in";
		return false;
	}else if(!(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+$/).test(email.value)){
		emailError.innerHTML="The Email must be an  valid email";
		return false;
	}else if(email.value!=document.getElementById("EmailText2").value){
		emailError.innerHTML="The Emails must match ";
		return false;
	}
	emailError.innerHTML="";
	return true
}

//Checks if password is empty or not
function passCheck(){
	if(pass.value==""){
		passError.innerHTML="The Password  must be filled in";
		return false;
	}else if(!((/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z]).{8,15}$/).test(pass.value))){
		passError.innerHTML="The Pass must contain at least ONE capital letter, ONE digit, and be 8-15 characters long";
		return false;
	}else if(pass.value!=document.getElementById("PassText2").value){
		passError.innerHTML="The Passwords must match ";
		return false;
	}
	passError.innerHTML="";
	return true
}
//Checks the first name, starts with a capital and allows for 2 worded first names
function firstCheck(){
	if(first.value==""){
		firstError.innerHTML="The first name must be filled in";
		return false;
	}else if(!(/^[A-Z][a-zA-Z]*([ ][A-Z])*[a-zA-Z]*$/).test(first.value)){
		firstError.innerHTML="Enter a first valid name, Starting with a capital letter";
		return false;
	}
	firstError.innerHTML="";
	return true
}
//Checks the last name, starts with a capital
function lastCheck(){
	if(last.value==""){
		lastError.innerHTML="The last name  must be filled in";
		return false;
	}else if(!(/^[A-Z][a-zA-Z]*$/).test(last.value)){
		lastError.innerHTML="Enter a vlid last name, Starting with a capital letter";
		return false;
	}
	lastError.innerHTML="";
		return true
}

//////Login funtions
function login(){
	submitbtn = document.getElementById("Loginbtn");
	loginForm = document.getElementById("LoginForm");
	email = document.getElementById("EmailText");
	emailError = document.getElementById("EmailError");
	pass = document.getElementById("PassText");
	passError = document.getElementById("PassError");
	
	//Checks the email and pass via regular expressions
	var good=true;
	if(!emailCheckLG())
		good=false
	if(!passCheckLG())
		good=false;
	if(good){
		$.ajax({
			url:'BannerServlet',
			data:{action: 'login',email: email.value,pass: pass.value},
			cache: false,
			success: function(text){
				console.log(text);
				//If user not found, or just a server error
				if(text=="success"){
					//Need to change banner to have a logged in account button////////////////////////////
					passError.innerHTML="!!User found!! or found a session";
					passError.style.color="green";
					sessionCheck();
				}else
					passError.innerHTML="Login credentials not found";
				
			}
		});
	}
}

//When a key is released and one of the inputs are focused
//email.onkeyup = emailCheck;
//pass.onkeyup = passCheck;

//Checks if valid email, using a regualr expression
function emailCheckLG(){
	if(email.value==""){
		emailError.innerHTML="The Email must be filled in";
		return false;
	}else if(!(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+$/).test(email.value)){
		emailError.innerHTML="The Email must be an  valid email";
		return false;
	}
	emailError.innerHTML="";
	return true
}

//Checks if password is empty or not
function passCheckLG(){
	if(pass.value==""){
		passError.innerHTML="The Password must be filled in";
		return false;
	}
		passError.innerHTML="";
	return true
}
