//Probably neeed to use json here to pass the user object back and forth

$(document).ready(function(){
	//Setting the click outside of the popup to hide it
	$("#bannerPopupBG").click(function(){
		$("#bannerPopup").css('display','none');
		$("#bannerPopupBG").css('display','none');
		console.log("hide");
	});
	
	//Seeing if there is a session already and show/hide the proper buttons
	sessionCheck();
})

function sessionCheck(){
	$.ajax({
		url:'BannerServlet',
		data:{action: 'session'},
		cache:false,
		success:function(text){
			if(text=="fail"){
				//show login/signup buttons
				console.log("did not find session");
				$("#loginbtn").css('display','block');
				$("#signupbtn").css('display','block');
			}else{
				//show account button for account popup
				console.log("session found="+text);
				$("#accounttabbtn").css('display','block');
			}
		}
	});
}


function showLogin(){
	popupHTML('Login')}

function showSignup(){
	popupHTML('Signup')}

function showAccountTab(){
	popupHTML('AccountTab')}


//Load popup, based on which template you want to load
function popupHTML(temp){
	$.ajax({
		url:'BannerServlet',
		data:{action:"template",template: temp},
		cache:false,
		success:function(text){
			$("#bannerPopup").html(text);
			$("#bannerPopup").css('display','block');
			$("#bannerPopupBG").css('display','block');
			}
	});
}

//With session/signed-in buttons

function gotoAccount(){
	
}

function gotoBookings(){
	
	
}

function gotoAdmin(){
	
}

function signOut(){
	$.ajax({
		url:'BannerServlet',
		data:{action:"signout"},
		cache:false,
		success:function(text){
			console.log(text);
		}
	});
}




