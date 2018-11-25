<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>title</title>
  </head>
  <body>
  <h1> Booking History</h1>
      
      <table>
      <tr>
          <th> Date </th>
          <th> Destination </th>
          <th> Airline </th>
          <th> Payment </th>
          </tr>
           <#list bookings as b>
          <tr> 
          <td> ${b.date} </td>
          <td> ${b.destination}</td>
          <td> ${b.airline}</td>
          <td> ${b.payment}</td>
          </tr>
          </#list>
      </table>
  </body>
</html>