<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Account Information</title>
  </head>
  <body>
      <div class="header">
      </div>
      
      <div class="avatar">
          <img src="https://www.w3schools.com/w3images/avatar2.png">
      </div>
      
      <div class="infoPersonal">
       
          <form>
            <label>Name</label>
              ${user.firstname} ${user.lastname}
              <br>
              <label> Email</label>
        		${user.email}
              <br>
              <input type="submit" name ="editInfoBtn" value="Edit Personal Information">
          </form>
      </div>
         <hr>
      <div class="infoAccount">
        <form>
          <label>Username</label>
            <input type="text" name="infoUsername">
            <br>
            <label>Password</label>
            <input type="password" name="infoPassword">
            <br>
            <input type="submit" name="editAccountBtn" value="Edit Account Information">
          </form>
      </div>
         <hr>
      <div class="infoBilling">
          <ul>
            <li>
            <a href="#">Debit Card ending with 9999 </a>
            </li>
               <li>
            <a href="#">Debit Card ending with 9090 </a>
            </li>
          </ul>
      </div>
      
      <div class="bookingHistory">
          <button> View Booking History</button>
      </div>
  </body>
</html>