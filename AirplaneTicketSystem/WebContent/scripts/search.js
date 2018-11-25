$(function() 
{
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

    //destination text box
    // untested ...
    // $.ajax ({
    //     url: '[servletname]',
    //     data: { status: 'getDestList' },
    //     cache: false,
    //     success: function (arr) {
    //         $('#dest').autocomplete ({
    //             source: arr
    //         });
    //     }
    // });


    //departure text box
    // untested ...
    // $.ajax ({
    //     url: '[servletname]',
    //     data: { status: 'getDeptList' },
    //     cache: false,
    //     success: function (arr) {
    //         $('#dept').autocomplete ({
    //             source: arr
    //         });
    //     }
    // });


    // date pickers
    $('#deptDate').datepicker();
    $('#returnDate').datepicker();
    
    $('#returnDateEffect').hide();

    //return date event
    $('#returnFlightcbx').click(returnFlightCbxPress);


    //airline select options
    // unfinished ...
    // $.ajax ({
    //     url: '[servletname]',
    //     data: { status: 'getAirlineList' },
    //     cache: false,
    //     success: function (arr) {
    //         for(let i = 0; i < arr.length; i++ )
    //         {
    //             $('#AirlineOp').append('<option value="' + arr[i] + '">'+ arr[i] +'</option>');
    //         }
    //     }
    // });


    // set event for search button
    $('#searchBtn').click(searchBtnPress);

});

function returnFlightCbxPress()
{
    //console.log('checked!');
    $('#returnDateEffect').toggle('blind', 500);
}

function searchBtnPress() 
{
    //ajax call with all the data needed to query and retrun a list of flights the user wants

    var departure = $('#dept').val();
    
    var destination = $('#dest').val();
    
    var departDate = $('#deptDate').val();
    
    var returnFlightDate;
    if ($('#returnFlightcbx').is(':checked'))
    {
        returnFlightDate = 1;
    }
    else returnFlightDate = 0;

    var returnDate = $('#returnDate').val();
    
    var airline = $('#AirlineOp').val();
    
    var directFlight;
    if ($('#directFlight').is(':checked'))
    {
        directFlight = 1;
    }
    else directFlight = 0;

    console.log(departure, destination, departDate, returnFlightDate, returnDate, airline, directFlight);

    // unfinished...
    // $.ajax ({
    //     url: '[servletname]',
    //     data: { status: 'getFlightList' },
    //     cache: false,
    //     success: function (arr) 
    //     {
    //         for(let i = 0; i < arr.length; i++ )
    //         {
    //             $('#searchResults').append();
    //         }
    //     }
    // });

}