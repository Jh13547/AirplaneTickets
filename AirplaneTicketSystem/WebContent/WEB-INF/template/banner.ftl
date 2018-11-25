<!--Call this template before any others. 
It will load the banner and you can pass it a list called 'scripts' 
and it will load those scripts with the page.
It needs an if statement to change it if the user is already logged in by checking the session and passing this template a boolean-->

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="styles/main.css"/>
		<link rel="stylesheet" href="styles/search.css"/>
		<title>A Real Ticket Service, not a Project</title>
		<script src="scripts/jquery.js"></script>
		<script src="scripts/banner.js"></script>
		<script src="scripts/loginSignup.js"></script>
	</head>
	<div class="bg"></div>
	<body>
	
	<div id="banner">
		<input class="banner" id="searchbtn" value="Search" type="button" onclick="gotoSearch()" style="display:block;">
		<input class="banner" id="loginbtn" value="Login" type="button" onclick="showLogin()">
		<input class="banner" id="signupbtn" value="SignUp" type="button" onclick="showSignup()">
		<input class="banner" id="accounttabbtn" value="My Account" type="button" onclick="showAccountTab()">
		<div id="bannerPopupBG" onlclick="hidePopup()"></div>
		<div id="bannerPopup">pop</div>
	</div>
	