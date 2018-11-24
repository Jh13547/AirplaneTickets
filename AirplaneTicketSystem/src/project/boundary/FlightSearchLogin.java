package project.boundary;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import project.logic.LoginLogic;
import project.object.Booking;
import project.object.Flights;
import project.object.User;

/**
 * Servlet implementation class FlightSearchLogin
 */
@WebServlet("/FlightSearchLogin")
public class FlightSearchLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String tempDir = "/WEB-INF/template";
    Configuration cfg;
   
/**
 * @see HttpServlet#HttpServlet()
 */
public FlightSearchLogin() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * @see Servlet#init(ServletConfig)
 */
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	
	super.init(config);
	cfg = new Configuration(Configuration.VERSION_2_3_28);
		File file = new File(getServletContext().getRealPath(tempDir));
		try {
			cfg.setDirectoryForTemplateLoading(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	cfg.setDefaultEncoding("UTF-8");
	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	cfg.setLogTemplateExceptions(false);
	cfg.setWrapUncheckedExceptions(true);
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Get method");
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	// TODO attach logic to handle web pages
	
	
			
	HttpSession session = request.getSession();
	synchronized(session) {
	Writer out;
	String templateName;
	Map<String, Object> root = new HashMap<>();
	
	String bannerTemplate = "banner.ftl";
	
	
	
		//flight search stuff 
	if(request.getParameter("flSearch")!= null) 
	
	
		{
		
		try {
			
			out = response.getWriter();
			templateName = "searchedFlight.ftl";
			List <String> myComp = new ArrayList<>();
			LoginLogic ll = new LoginLogic();
				String destination = request.getParameter("destination");
				String departure = request.getParameter("departure");
				String date = request.getParameter("date");
				String airline = request.getParameter("AirlineOption");
				//maybe this functionality goes for now and can be saved for a later day. 
				String returnFlight = request.getParameter("returnFlight");
				//idk this functionality might have to go 
				String directFlight = request.getParameter("directFlight");		
				
//				
//				System.out.println(destination);
//				System.out.println(departure);
//				System.out.println(date);
//				System.out.println(airline);
//				System.out.println(returnFlight);
//				System.out.println(directFlight);
//			
//				
				
				
				
				if(returnFlight != null) {
					
					
					String returnDate = request.getParameter("returnDate");
					root.put("des", destination);
					root.put("dep", departure);
					root.put("date", date);
					root.put("airline", airline);						
					List<Flights> lf = new ArrayList<>();
					lf = ll.rtnFlightList(departure, destination, date);
					List<Flights> rf = new ArrayList<>();
					rf = ll.rtnFlightList(destination, departure, returnDate);
					root.put("flights", lf);
					root.put("returnFlights", rf);
					
					
					
					myComp = ll.getCompanies();
					root.put("airlines", myComp);
					Template temp = cfg.getTemplate(bannerTemplate);
					temp.process(root, out);
					temp = cfg.getTemplate(templateName);
					temp.process(root, out);
				}
//				else if(returnFlight.equals("on") && directFlight.equals("off")) {
//					//if returnflight has been clicked do something here
//					
//					
//					
//					
//				}
				else{
					//if directFlight has been clicked do something here
					
					root.put("des", destination);
					root.put("dep", departure);
					root.put("date", date);
					root.put("airline", airline);						
					List<Flights> lf = new ArrayList<>();
					lf = ll.rtnFlightList(departure, destination, date);
					root.put("flights", lf);
					myComp = ll.getCompanies();
					root.put("airlines", myComp);
					Template temp = cfg.getTemplate(bannerTemplate);
					temp.process(root, out);
					temp = cfg.getTemplate(templateName);
					temp.process(root, out);
				
					
				}
				
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		}
	
		//handles new booking
		if(request.getParameter("buyBooking") != null) {
			try {
				out = response.getWriter();
				templateName = "bookingconf.ftl";
				LoginLogic ll = new LoginLogic();
				User u = (User) session.getAttribute("user");
				System.out.println(u.getEmail());
				
				String userid = u.id().toString();
				
				String flightid = request.getParameter("idbutton");
				
				String amount = request.getParameter("pricevalue");
				Booking b = new Booking(userid, flightid, amount);
				ll.createBooking(b);
				
				
				Template temp = cfg.getTemplate(templateName);
				temp.process(root, out);
				
				
			}
			catch(Exception e) {
				
			}
		}
	
		//need to add the right stuff but this generates the search page correctly
		//done
		if(request.getParameter("tstButton") != null)
		
		{
			
			//creates a search template with airline options added
			try 
			{
				//System.out.println("I'm here");
					out = response.getWriter();
					templateName = "searchedFlight.ftl";
					List <String> myComp = new ArrayList<>();
					LoginLogic ll = new LoginLogic();
				
					myComp = ll.getCompanies();
			
			
						root.put("airlines", myComp);
						Template temp = cfg.getTemplate(bannerTemplate);
						temp.process(root, out);
						temp = cfg.getTemplate(templateName);
						temp.process(root, out);
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			}	
	}
		
}
	//end of method stub
	


/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//System.out.println("post");
	doGet(request, response);
}

}

