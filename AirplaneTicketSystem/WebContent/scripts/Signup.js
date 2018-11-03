window.onload = function(){
	//Getting the elements
	var submitbtn = document.getElementById("Signupbtn");
	var loginForm = document.getElementById("SignupForm");
	var email = document.getElementById("EmailText");
	var pass = document.getElementById("PassText");
	var first = document.getElementById("FirstText");
	var last = document.getElementById("LastText");
	var emailError = document.getElementById("EmailError");
	var passError = document.getElementById("PassError");
	var firstError = document.getElementById("FirstError");
	var lastError = document.getElementById("LastError");
	
	//Sumbit form button
	submitbtn.onclick =function(){
		var good=true;
		if(!emailCheck())
			good=false
		if(!passCheck())
			good=false;
		if(!firstCheck())
			good=false
		if(!lastCheck())
			good=false;
		if(good)
			loginForm.submit();
		
	}
	
	//When a key is released and one of the inputs are focused
	//email.onkeyup = emailCheck;
	//pass.onkeyup = passCheck;
	
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
		}else if(!(/^(?=.*\d)(?=.*[A-Z])(?=.*[a-zA-Z]).{8,15}$/).test(pass.value)){
			passError.innerHTML="The Pass must contain at least ONE capital letter, ONE digit, and be 8-15 characters long";
			return false;
		}else if(pass.value!=document.getElementById("PassText2").value){
			passError.innerHTML="The Passwords must match ";
			return false;
		}
		passError.innerHTML="";
		return true
	}
	
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
	
}