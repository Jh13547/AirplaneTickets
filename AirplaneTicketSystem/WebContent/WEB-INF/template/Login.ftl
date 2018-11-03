<script type="text/javascript" src="scripts/login.js"></script>
<form id="LoginForm" action="LoginServlet" method="Posts">
	<table>
		<tr>
			<td>Email:
			</td>
			<td><input id="EmailText" type="text" name="email"></input>
			</td>
			<td><div id="EmailError"class="error"style="color:red;"></div>
			</td>
		</tr>
		<tr>
			<td>Pass:
			</td>
			<td><input id="PassText" type="password" name="pass"></input>
			</td>
			<td><div id="PassError"class="error"style="color:red;"></div>
			</td>
		</tr>
	</table>
	<input type="hidden" name="login" value="login">
</form>
<input type="submit" id="Loginbtn" name="login" value="Login"></input><br>
