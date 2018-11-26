<table>
	<tr sytle="width:100%">
		<td>Email:</td>
		<td><input id="EmailText" class="form-group" type="text" name="email"></input></td>
	</tr>
	<tr>
		<td colspan="2"><div id="EmailError"class="error"style="color:red;"></div></td>
	</tr>
	<tr>
		<td>Pass:</td>
		<td><input id="PassText" class="form-group"type="password" name="pass"></input></td>
	</tr>
	<tr>
		<td colspan="2"><div id="PassError"class="error"style="color:red;"></div></td>
	</tr>
</table>
<input type="submit" id="Loginbtn" class="bannerbtn btn btn-info" name="login" value="Login" onclick="loginBook()"></input><br>