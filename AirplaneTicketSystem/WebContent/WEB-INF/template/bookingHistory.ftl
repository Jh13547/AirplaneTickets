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
          <th> Confirmation Number </th>
          <th> Departure </th>
          <th> Destination </th>
          <th> Airline </th>
          </tr>
          <tr> 
           <#list bookings as b>
          <td> ${b.bookingid} </td>
          <td> ${b.company}</td>
          td> ${b.Departure}</td>
          <td> ${b.Destination}</td>
          </#list>
          </tr>
      </table>
  </body>
</html>