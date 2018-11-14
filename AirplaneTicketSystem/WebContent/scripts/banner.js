$(document).ready(function(){
	$("#bannerPopupBG").click(function(){
		$("#bannerPopup").css('display','none');
		$("#bannerPopupBG").css('display','none');
	})
})


function showLogin(){
	popupHTML('Login')}

function showSignup(){
	popupHTML('Signup')}

//Load popup, based on which template you want to load
function popupHTML(temp){
	$.ajax({
		url:'BannerServlet',
		data:{template: temp},
		cache:false,
		success:function(text){
			$("#bannerPopup").html(text);
			$("#bannerPopup").css('display','block');
			$("#bannerPopupBG").css('display','block');
			}
	});
}