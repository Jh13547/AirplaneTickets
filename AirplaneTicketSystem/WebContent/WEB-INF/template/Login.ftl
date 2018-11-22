<script type="text/javascript" src="scripts/login.js"></script>
<form id="LoginForm" action="BannerServlet" method="Post">
	<table>
		<tr>
			<td>Email:</td>
			<td><input id="EmailText" type="text" name="email"></input></td>
		</tr>
		<tr>
			<td colspan="2"><div id="EmailError"class="error"style="color:red;"></div></td>
		</tr>
		<tr>
			<td>Pass:</td>
			<td><input id="PassText" type="password" name="pass"></input></td>
		</tr>
		<tr>
			<td colspan="2"><div id="PassError"class="error"style="color:red;"></div></td>
		</tr>
	</table>
</form>
<input type="submit" id="Loginbtn" name="login" value="Login" onclick="login()"></input><br>