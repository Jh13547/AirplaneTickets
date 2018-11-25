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
        		$('#CompanySelect').append('<option>' + result[i] + '</option>');
        	}
        },
        error: function() {
       	 alert('Bitch Please');
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
        	 compName.text("");
         },
         error: function() {
        	 alert('Error');
         }
     });
}

function addPLaneBtnPress() 
{
	var company = $('#CompanySelect').val();
	var planeType = $('#planeTypeTxt').val();
	var seatNumber = $('#planeSeatNbr').val();
	
	//console.log(company + planeType + seatNumber);
	$.ajax ({
        url: 'AdminServlet',
        data: {status:'AddNewPlane',
        		companyName:company,
        		type:planeType,
        		seats:seatNumber},
        cache: false,
        success: function () {
       	 alert('Added new plane ' + company + " " + planeType + " " + seatNumber);
       	 company.text("");
       	 planeType.text("");
       	 seatNumber.text("");
        },
        error: function() {
       	 alert('Error');
        }
    });
}

function exitAdminPage()
{
    //puch ftl for a regualar page
    alert('Leaving Admin Console');
}