
  <h1> Booking History</h1>
      
      <table class="results">
      <tr>
          <th> Confirmation Number </th>
          <th> Destination </th>
          <th> Depature </th>
          <th> Departure Date </th>
          </tr>
          
           <#list bookings as b>

           <tr> 
          <td> ${b.confnumber} </td>
          <td> ${b.deplocation}</td>
          <td> ${b.destlocation}</td>
          <td> ${b.deptdate}</td>

          </tr>
          </#list>
          
      </table>
