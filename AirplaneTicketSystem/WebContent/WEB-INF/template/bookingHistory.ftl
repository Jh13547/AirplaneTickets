
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
          td> ${b.Departure}</td>
          <td> ${b.Destination}</td>
          <td> ${b.company}</td>
          </#list>
          </tr>
      </table>
