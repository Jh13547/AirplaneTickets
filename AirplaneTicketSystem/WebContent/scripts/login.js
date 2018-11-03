window.onload = function(){
	//Getting the elements
	var submitbtn = document.getElementById("Loginbtn");
	var loginForm = document.getElementById("LoginForm");
	var email = document.getElementById("EmailText");
	var emailError = document.getElementById("EmailError");
	var pass = document.getElementById("PassText");
	var passError = document.getElementById("PassError");
	
	//Sumbit form button
	submitbtn.onclick =function(){
		var good=true;
		if(!emailCheck())
			good=false
		if(!passCheck())
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
		}
		emailError.innerHTML="";
		return true
	}
	
	//Checks if password is empty or not
	function passCheck(){
		if(pass.value==""){
			passError.innerHTML="The Password must be filled in";
			return false;
		}
			passError.innerHTML="";
		return true
	}
}