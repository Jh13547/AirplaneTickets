<div class="searchCriteria" id="searchCri">

                <h2>Search Criteria</h2>

                <form action="FlightSearchLogin" method="POST">
                	<table>
                    <tr><td><label for="">Destination:</label></td> <td><input type="text" name="destination" id="dest"></td></tr>
                    <tr><td><label for="">Departure:</label></td> <td><input type="text" name="departure" id="dept"></td></tr>
                    <tr><td><label for="">Date:</label></td> <td><input type="date" name="date" id="date"></td></tr>
                    <!--
                    	<tr><td><label for="">Return flight?</label></td> <td><input type="checkbox" name="returnFlight" id="returnFlight"></td></tr>
                    	<tr><td><label for="">Return Date:</label></td> <td><input type="date" name="returnDate" id="returnDate"></td></tr>
                    -->
                    <tr><td><label for="">Airline:</label></td> 
                    <td><select name="AirlineOption" id="AirlineOp">
                      <#list airlines as airline>
  								<option value="${airline}">${airline}</option>
  						</#list></td></tr>
                   <tr><td> <input type="submit" name="flSearch" value="Search"></td></tr>
                   
                   </table>
                </form>

            </div>
			<#assign x = 1>
			
            <div class="searchResults" id="searchResults">
           
           
            <form action="FlightSearchLogin" class="results" method="post">
						<table>
							<tr>

								<td>Flight Time</th>
								<td>Flight Cost</th>
								<td colspan="1">Seats Requested</th>
								
								</tr>
								<#list flights as Flights>
							<#if x=1>
							<#assign x=0>
							<#else>
							<#assign x=1>
							</#if>
							<table class="oddoreven${x}">
							<tr>
								
								<td>${Flights.departureDate[10..15]}</td>
								<td>$${Flights.price}</td>
								
							
								<td colspan="2"><input type="number" name="seatsreq" min="1"></td>
								<td colspan="2">
								<input type="hidden" value="${Flights.id}" name="idbutton">
								<input type="hidden" value="${Flights.price}" name="pricevalue">
							</tr>
								<tr>
								<td colspan="3">
								<input type="submit" name="buyBooking" value="Buy Now" </td>
								</td>
							</tr>
							</table>
							</#list>
						</table>
				</form>
				
            </div>
          

        </div>
</body>
</html>