<table class="bannerbtn">
	<tr>
	<td>
	<form action="AccountInfoServlet" method="post">
	<input id="accountbtn" class="bannerbtn btn btn-info" type="submit" name="status" value="My Account">
	<br>
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<form action="AccountInfoServlet" method="post">
	<input id="bookingsbtn" class="bannerbtn btn btn-info" type="submit" name="status" value="My Bookings">
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<form action="BannerServlet" method="post">
	<input id="adminbtn" class="bannerbtn btn btn-info" type="submit" name="template" value="Admin">
	<input type="hidden" name="action" value="template">
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<input id="signoutbtn" class="bannerbtn btn btn-info" type="button" value="Sign Out" onclick="signOut()">
	</td>
	</tr>
</table>
