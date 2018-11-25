<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Admin Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="styles/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="styles/admin.css" />
        <script src="scripts/jquery.js"></script>
        <script src="scripts/jquery-ui.js"></script>
        <script src="scripts/admin.js"></script>
    </head>
<body>

    <button class="tablink" onclick="openPage('Companies', this)" id="defaultOpen">Companies</button>
    <button class="tablink" onclick="openPage('Planes', this)">Planes</button>
    <button class="tablink" onclick="openPage('Flights', this)">Flights</button>
    <button class="tablink" onclick="openPage('Airports', this)">Airports</button>
    <button id="Exit" class="tablink" onclick="exitAdminPage()">Exit Admin Console</button>
    
    <div id="Companies" class="tabcontent">
        <h3>Companies</h3>
        <p>Add a new plane company</p>
        <label>Company Name: <input type="text" name="companyNameTxt" id="companyNameTxt"> </label>
        <button id="addCompany" onclick="addNewCompany()">Add Company</button>

        <div id="CompanyList">

        </div>
    </div>
    
    <div id="Planes" class="tabcontent">
        <h3>Planes</h3>
        <p>Add a new plane</p>
        <label>Company Name:</label>
        <select id="CompanySelect" class="CompanySelect">
        </select>
        
        <br>
        
        <label>Plane Type: <input type="text" id="planeTypeTxt"> </label>

        <br>
        
        <label>Total Seats: <input type="number" id="planeSeatNbr"> </label>

        <br>
        <button id="AddPlane" onclick="addPlaneBtnPress()">Add Plane</button>

        <div id="PlaneList">
            
        </div>
    </div>
    
    <div id="Flights" class="tabcontent">
        <h3>Flights</h3>
        <p>Add a flight</p>
		<label>Departure: <input type="text" id="deptTxt"> </label>
        	
    	<br>
    	
    	<label>Destination: <input type="text" id="destTxt"> </label>
    	
    	<br>
    	
    	<label>Company: </label>
    	<select id="CompanySelect2" class="CompanySelect">
    	</select>
    	
    	<br>
    	
    	<label>Available seats: <input type="number" id="AvalibleTicketNbr"> </label>

        <br>
    	
        <label>Departure Date/Time: <input type="datetime-local" name="deptdatetime"> </label>

        <br>
        
        <label>Destination Date/Time: <input type="datetime-local" name="destdatetime"> </label>

        <br>

        <button id="addFlight" onclick="AddFlightBtnPress()">Add Flight</button>

        <div id="FlightList">
        
        </div>
    </div>

    <div id="Airports" class="tabcontent">
        <h3>Airports</h3>
        <p>Add an Airport</p>
        <label>City: <input type="text" id="cityTxt"> </label>
    
        <br>
        
        <label>State: <input type="text" id="stateTxt"> </label>

        <br>

        <label>Country: <input type="text" id="countryTxt"> </label>

        <br>

        <button id="addAirport" onclick="addNewAirport()">Add Flight</button>

        <div id="AirportList">
        
        </div>

    </div>

</body>
</html>