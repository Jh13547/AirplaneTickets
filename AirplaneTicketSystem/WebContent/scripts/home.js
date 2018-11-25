// on load function
$(function ()
{
    // on load get a array of all destinations and departures
    
    // add autocomplete to both text boxes
    var arr = ["Atlanta", "Dallas", "Houston", "New York","Austin"];
    
    $('#dept').autocomplete ({
        source: arr
    });
    
    $('#dest').autocomplete ({
        source: arr
    });

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

    // date picker
    $('#date').datepicker();

});