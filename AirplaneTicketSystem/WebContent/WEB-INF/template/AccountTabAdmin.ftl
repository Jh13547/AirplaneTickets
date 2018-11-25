
<table>
	<tr>
	<td>
	<form action="AccountInfoServlet" method="post">
	<input id="accountbtn" type="submit" name="status" value="My Account">
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<form action="AccountInfoServlet" method="post">
	<input id="bookingsbtn" type="submit" name="status" value="My Bookings">
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<form action="BannerServlet" method="post">
	<input id="adminbtn" type="submit" name="template" value="Admin">
	<input type="hidden" name="action" value="template">
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<input id="signoutbtn" type="button" value="Sign Out" onclick="signOut()">
	</td>
	</tr>
</table>
