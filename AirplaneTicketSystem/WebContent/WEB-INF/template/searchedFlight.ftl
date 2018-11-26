<div class="searchCriteria" id="searchCri">

                <h2>Search Criteria</h2>

                <form id="searchform" action="FlightSearchLogin" method="POST">
                	<table>
                    <tr><td><label for="">Destination:</label></td> <td><input type="text" name="destination" id="dest" class="form-control"></td></tr>
                    <tr><td><label for="">Departure:</label></td> <td><input type="text" name="departure" id="dept" class="form-control"></td></tr>
                    <tr><td><label for="">Date:</label></td> <td><input type="date" name="date" id="date" class="form-control"></td></tr>
                    <tr><td><label for="">Airline:</label></td> 
                    <td><select name="AirlineOption" id="AirlineOp" class="form-control">
                      <#list airlines as airline>
  								<option value="${airline}">${airline}</option>
  						</#list></td></tr>
                   
                   <input type="hidden" name="flSearch" value="Search">
                   </table> 
                   </form>
                   <input type="submit" id="searchBtn" name="flSearch" value="Search" class="btn btn-success">
               

            </div>
			<#assign x = 1>
			
            <div class="searchResults" id="searchResults">
           
           
            <form action="FlightSearchLogin" class="results" method="post">
						<table style="padding: 5px;">
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
							<table class="oddoreven${x}" style="padding-right: 50px;">
							<tr>
								
								<td>${Flights.departureDate[10..15]}</td>
								<td>$${Flights.price}</td>
								
							<div class="form-group">
								<td colspan="3"><input type="number" name="seatsreq" style="width:75px; margin-left: 100px;" value= "1" min="1"/></td>
							</div>
								<input type="hidden" value="${Flights.id}" name="idbutton">
								<input type="hidden" value="${Flights.price}" name="pricevalue">
							</tr>
								<tr>
								<td colspan="3">
								<input type="submit" name="buyBooking" value="Buy" id="buybutton" class="btn btn-primary"></td>
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