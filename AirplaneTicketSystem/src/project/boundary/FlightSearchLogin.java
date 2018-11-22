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
	
	
	// TODO Auto-generated method stub
	// Create your Configuration instance, and specify if up to what FreeMarker
	// version (here 2.3.27) do you want to apply the fixes that are not 100%
	// backward-compatible. See the Configuration JavaDoc for details.
	cfg = new Configuration(Configuration.VERSION_2_3_28);

	// Specify the source where the template files come from. Here I set a
	// plain directory for it, but non-file-system sources are possible too:
	
		File file = new File(getServletContext().getRealPath(tempDir));
		try {
			cfg.setDirectoryForTemplateLoading(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	// Set the preferred charset template files are stored in. UTF-8 is
	// a good choice in most applications:
	cfg.setDefaultEncoding("UTF-8");

	// Sets how errors will appear.
	// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

	// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
	cfg.setLogTemplateExceptions(false);

	// Wrap unchecked exceptions thrown during template processing into TemplateException-s.
	cfg.setWrapUncheckedExceptions(true);
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Get method");
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	// TODO attach logic to handle web pages
	
	
		//servlet handling for signup page code works don't touch me should be an example for how the logic is set up to be handled
//		if(request.getParameter("signup") != null) {
//			String firstname = request.getParameter("first");
//			String lastname = request.getParameter("last");
//			String uemail = request.getParameter("email");
//
//			String upass = request.getParameter("pass");
//			User u = new User(firstname, lastname, uemail, upass);
//			LoginLogic log = new LoginLogic();
//			Boolean signedup = log.signUp(u);
//			if(signedup) {
//				System.out.println("Success");
//			}
//			else
//				System.out.println("Failure");
//		}
	
			//System.out.println(request.getParameter("flSearch"));
			
	
	Writer out;
	String templateName;
	Map<String, Object> root = new HashMap<>();
	
	
		//flight search stuff 
	if(request.getParameter("flSearch")!= null) 
	
	
		{
		
		try {
			
			out = response.getWriter();
			templateName = "search.ftl";
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
				
				
//				idk ignore this stuff it's just verification of the information being pulled
//				System.out.println(destination);
//				System.out.println(departure);
//				System.out.println(date);
//				System.out.println(airline);
//				System.out.println(returnFlight);
//				System.out.println(directFlight);
				
				root.put("des", destination);
				root.put("dep", departure);
				root.put("date", date);
				root.put("airline", airline);
				
				
				if(returnFlight.equals("on")) {
					//if returnflight has been clicked do something here
				}
				if(directFlight.equals("on")) {
					//if directFlight has been clicked do something here
					List<Flights> lf = new ArrayList<>();
					lf = ll.rtnFlightList(departure, destination, date);
					
					root.put("flights", lf);
					
					
					
					
					
					
				}
				
				
				
				
				
		
		
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		}
	
		//need to add the right stuff but this generates the search page correctly
		//done
		if(request.getParameter("tstButton") != null)
		
		{
			
			//creates a search template with airline options added
			try 
			{
				System.out.println("I'm here");
					out = response.getWriter();
					templateName = "search.ftl";
					List <String> myComp = new ArrayList<>();
					LoginLogic ll = new LoginLogic();
				
					myComp = ll.getCompanies();
			
			
						root.put("airlines", myComp);
						Template temp = cfg.getTemplate(templateName);
						temp.process(root, out);
			
			}
			catch(Exception e) {
				e.printStackTrace();
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

