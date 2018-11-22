
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

                <form action="" method="post">
                    <input type="button" value="Login">
                    <input type="button" value="Signup">
                </form>

            </div>

            <div class="searchCriteria" id="searchCri">

                <h2>Search Criteria</h2>

                <form action="" method="post">
                    <label for="">Destination:</label> <input type="text" name="destination" id="dest">
                    <br>
                    <label for="">Departure:</label> <input type="text" name="departure" id="dep">
                    <br>
                    <label for="">Date:</label> <input type="date" name="date" id="date">
                    <br>
                    <label for="">Return flight?</label> <input type="checkbox" name="returnFlight" id="returnFlight">
                    <br>
                    <label for="">Return Date:</label> <input type="date" name="returnDate" id="returnDate">
                    <br>
                    <label for="">Airline:</label> <select name="AirlineOption" id="AirlineOp">
                    
                                                  <#list airlines as airline>
												<option value="${airline}">${airline}</option>
												</#list>
                                                    </select>
                    <br>
                    <label for="">Direct flight?</label> <input type="checkbox" name="directFlight" id="directFlight">
                    <br>
                    <input type="submit" value="Search">
                </form>

            </div>

            <div class="searchResults" id="searchResults">

            </div>

        </div>
</body>

</html>