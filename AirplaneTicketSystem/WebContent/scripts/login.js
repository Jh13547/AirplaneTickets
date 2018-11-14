//Creating the objects to hold the elements / could honestly change all this to jquery calls
var submitbtn;
var loginForm;
var email;
var emailError;
var pass;
var passError;

//Sumbit form button
function login(){
	submitbtn = document.getElementById("Loginbtn");
	loginForm = document.getElementById("LoginForm");
	email = document.getElementById("EmailText");
	emailError = document.getElementById("EmailError");
	pass = document.getElementById("PassText");
	passError = document.getElementById("PassError");
	
	//Checks the email and pass via regular expressions
	var good=true;
	if(!emailCheck())
		good=false
	if(!passCheck())
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