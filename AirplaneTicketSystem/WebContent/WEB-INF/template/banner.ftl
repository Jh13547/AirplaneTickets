<!--Call this template before any others. 
It will load the banner and you can pass it a list called 'scripts' 
and it will load those scripts with the page.
It needs an if statement to change it if the user is already logged in by checking the session and passing this template a boolean-->

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="styles/main.css"/>
		<title>A Real Ticket Service, not a Project</title>
		<script src="scripts/jquery.js"></script>
		<#list 0..scripts?size-1 as i>
			<script src="scripts/${scripts[i]}.js"></script>
		</#list>
	</head>
	
	<body>
	<div id="banner">
		<input class="banner" type="button" value="Login" onclick="showLogin()">
		<input class="banner" type="button" value="Signup" onclick="showSignup()">
		<div id="bannerPopupBG"></div>
		<div id="bannerPopup">pop</div>
	</div>
	