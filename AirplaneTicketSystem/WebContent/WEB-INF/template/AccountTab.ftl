<script type="text/javascript" src="scripts/login.js"></script>
<form id="AccountForm" action="BannerServlet" method="Post">
	<div>
	<table>
		<tr>
		<td>
		<input id="accountbtn" type="button" value="My Account" name="accountinfo"  onclick="gotoAccount()">
		</td>
		</tr>
		<tr>
		<td>
		<input id="bookingsbtn" type="button" value="My Bookings" name="bookinghistory" onclick="gotoBookings()">
		</td>
		</tr>
		<tr>
		<td>
		<input id="adminbtn" type="button" value="Admin Page"onclick="gotoAdmin()" class="admin">
		</td>
		</tr>
		<tr>
		<td>
		<input id="signoutbtn" type="button" value="Sign Out" onclick="signOut()">
		</td>
		</tr>
		
	</table>
	<div>
</form>
<input type="submit" id="Loginbtn" name="login" value="Login" onclick="login()"></input><br>