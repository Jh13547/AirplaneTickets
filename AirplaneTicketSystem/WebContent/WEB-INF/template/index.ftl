<div class="content">
    <form id="searchform" action="FlightSearchLogin" method="post">
    <input type="hidden" name="flSearch" value="Search">
        <table>
        <tr>
        	<td>    
            	<label for="">Departure:</label>
            </td>
            <td>
            	<input type="text" name="departure" style="width: 200px;" class="form-group" id="dept">
            </td>
        </tr>
        <tr>
        	<td>
            	<label for="">Destination:</label>
            </td>
            <td>
           		<input type="text" name="destination" style="width: 200px;" class="form-group" id="dest">
            </td>
        </tr>
        <tr>
        	<td>
           		<label for="">Date:</label>
            </td>
            <td>
            	<input type="date" name="date" style="width: 200px;" class="form-group" id="date">
            </td>
        </tr>
        </table>
    </form>
    <input type="submit" id="searchBtn" class="btn btn-success">
</div>