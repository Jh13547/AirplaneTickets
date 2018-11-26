$(function()
{
	//Planes tab
	//get company list
	$.ajax ({
		url: 'AdminServlet',
        data: {status:'GetCompanyList'},
        cache: false,
        success: function (result) {
        	for(var i=0;i<result.length;i++)
        	{
        		$('.CompanySelect').append('<option>' + result[i] + '</option>');
        	}
        },
        error: function() {
       	 alert('Error');
        }
	});
	
    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
    $( "#datepicker" ).datepicker();
    
    var city = ["Atlanta", "Dallas", "Houston", "New York"];
    
    $('#cityTxt').autocomplete ({
        source: city
    });

    var state = ["Georgia", "Texas", "New York", "California"];
    
    $('#stateTxt').autocomplete ({
        source: state
    });

    var country = ["United States", "Pakistan", "Iran", "China"];
    
    $('#countryTxt').autocomplete ({
        source: country
    });

});

function openPage(pageName, elmnt) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
    }
    document.getElementById(pageName).style.display = "block";
    elmnt.style.backgroundColor = '#777';

}

function addNewCompany()
{
	var compName = $('#companyNameTxt').val();
	
     $.ajax ({
         url: 'AdminServlet',
         data: {status:'AddNewCompany',
        	 	companyName:compName},
         cache: false,
         success: function () {
        	 alert('Added new company ' + compName);
         },
         error: function() {
        	 alert('Error');
         }
     });
}

function addPlaneBtnPress() 
{
	var company = $('#CompanySelect').val();
	var planeType = $('#planeTypeTxt').val();
	var seatNumber = $('#planeSeatNbr').val();
	
	console.log(company + planeType + seatNumber);
	$.ajax ({
        url: 'AdminServlet',
        data: {status:'AddNewPlane',
        		companyName:company,
        		type:planeType,
        		seats:seatNumber},
        cache: false,
        success: function () {
       	 alert('Added new plane ' + company + " " + planeType + " " + seatNumber);
        },
        error: function() {
       	 alert('Error');
        }
    });
}

function AddFlightBtnPress()
{
	var dept = $('#deptTxt').val();
	var dest = $('#destTxt').val();
	var comp = $('#CompanySelect2').val();
	var seats = $('#AvalibleTicketNbr').val();
	var deptdate = $('#deptdatetime').val();
	var destdate = $('#destdatetime').val()
	
	$.ajax ({
        url: 'AdminServlet',
        data: {status:'AddNewFLight',
        		departure:dept,
        		destination:dest,
        		company:comp,
        		seats:seats,
        		deptdate:deptdate,
        		destdate:destdate},
        cache: false,
        success: function () {
       	 alert('Added new flight ' + dept + " " + dest + " " + comp + " " + seats + " " + date);
        },
        error: function() {
       	 alert('Error');
        }
    });
	
}

function addNewAirport()
{
	var citytxt = $('#cityTxt').val();
	var statetxt = $('#stateTxt').val();
	var countrytxt = $('#countryTxt').val();
	
	console.log(citytxt + statetxt + countrytxt);
	$.ajax ({
        url: 'AdminServlet',
        data: {status:'AddNewAirport',
        		city:citytxt,
        		state:statetxt,
        		country:countrytxt},
        cache: false,
        success: function () {
       	 alert('Added new Airport ' + citytxt + " " + statetxt + " " + countrytxt);
        },
        error: function() {
       	 alert('Error');
        }
    });
}

function exitAdminPage()
{
    //puch ftl for a regualar page
    //alert('Leaving Admin Console');
	window.location.href ="index.html"
}