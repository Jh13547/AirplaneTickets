<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="styles/search.css" />
    <script src="scripts/search.js"></script>
</head>
<body>
        <div class="bg">

            <div class="banner" id="banner">

               

            </div>

            <div class="searchCriteria" id="searchCri">

                <h2>Search Criteria</h2>

                <form action="FlightSearchLogin" method="POST">
                	<table>
                    <tr><td><label for="">Destination:</label></td> <td><input type="text" name="destination" id="dest"></td></tr>
                    <tr><td><label for="">Departure:</label></td> <td><input type="text" name="departure" id="dep"></td></tr>
                    <tr><td><label for="">Date:</label></td> <td><input type="date" name="date" id="date"></td></tr>
                    <tr><td><label for="">Return flight?</label></td> <td><input type="checkbox" name="returnFlight" id="returnFlight"></td></tr>
                    <tr><td><label for="">Return Date:</label></td> <td><input type="date" name="returnDate" id="returnDate"></td></tr>
                    <tr><td><label for="">Airline:</label></td> 
                    <td><select name="AirlineOption" id="AirlineOp">
                      <#list airlines as airline>
  								<option value="${airline}">${airline}</option>
  						</#list></td></tr>
                    <tr><td><label for="">Direct flight?</label></td> <td><input type="checkbox" name="directFlight" id="directFlight">
                    </td></tr>
                   <tr><td> <input type="submit" name="flSearch" value="Search"></td></tr>
                   
                   </table>
                </form>

            </div>

            <div class="searchResults" id="searchResults">

            </div>

        </div>
</body>
</html>