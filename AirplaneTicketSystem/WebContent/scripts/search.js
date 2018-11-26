$(document).ready(function(){
    //on load function

    //load everything needed for the search filters
    
    // testing
	var arr = ["Atlanta", "Dallas", "Houston", "New York","Austin","Boston","Orlando"];
    
    $('#dept').autocomplete ({
        source: arr
    });

    $('#dest').autocomplete ({
        source: arr
    });


    // date pickers
    $('#deptDate').datepicker();




    // set event for search button
    $('#searchBtn').click(searchBtnPress);
    console.log("loaded");
});


function searchBtnPress() {
	console.log("pressed "+document.getElementById("date").value);
	if($('#dept').val()!=""&&$('#dest').val()!=""&&$('#date').val()!="")
		searchflight();
	
}

function searchflight()
{
    //ajax call with all the data needed to query and retrun a list of flights the user wants

    var departure = $('#dept').val();
    
    var destination = $('#dest').val();
    
    var departDate = $('#deptDate').val();
    
    var airline = $('#AirlineOp').val();

    console.log(departure, destination, departDate,airline);
    
    $("#searchform").submit();
}