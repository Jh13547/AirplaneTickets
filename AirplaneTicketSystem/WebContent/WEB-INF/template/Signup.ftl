<table>
	<tr>
		<td>First name: </td>
		<td><input id="FirstText" type="text" name="first"></input></td>
	</tr>
	<tr>
		<td colspan="2"><div id="FirstError"class="error"style="color:red;"></div></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input id="LastText" type="text" name="pass"></input></td>
	</tr>
	<tr>
		<td colspan="2"><div id="LastError"class="error"style="color:red;"></div></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input id="EmailText" type="text" name="email"></input></td>
	</tr>
	<tr>
		<td>Email Again:</td>
		<td><input id="EmailText2" type="text" ></input></td>
	</tr>
	<tr>
		<td colspan="2"><div id="EmailError"class="error"style="color:red;"></div></td>
	</tr>
	<tr>
		<td>Pass:</td>
		<td><input id="PassText" type="password" name="pass"></input></td>
	</tr>
	<tr>
		<td>Pass Again:</td>
		<td><input id="PassText2" type="password"></input></td>
	</tr>
	<tr>
		<td colspan="2"><div id="PassError"class="error"style="color:red;"></div></td>
	</tr>
</table>
<input type="submit" id="Signupbtn" name="signup" value="Signup" onclick="signup()"></input>
