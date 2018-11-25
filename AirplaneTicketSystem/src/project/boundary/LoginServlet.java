package project.boundary;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
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

import project.db.*;
import project.logic.*;
import project.object.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Servlet implementation class IMDBServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		private String tempDir = "/WEB-INF/template";
	    Configuration cfg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		HttpSession session = request.getSession();
		synchronized(session) {
			
			//servlet handling for signup page code works don't touch me should be an example for how the logic is set up to be handled
			if(request.getParameter("signup") != null) {
				String firstname = request.getParameter("first");
				String lastname = request.getParameter("last");
				String uemail = request.getParameter("email");
	
				String upass = request.getParameter("pass");
				User u = new User(firstname, lastname, uemail, upass);
				LoginLogic log = new LoginLogic();
				Boolean signedup = log.signUp(u);
				if(signedup) {
					System.out.println("Success");
				}
				else
					System.out.println("Failure");
			}
				
				
			//code for handling log in request and allowing user id to be stored in the session
			if(request.getParameter("login") != null) {
				String user = request.getParameter("email");
				String pass = request.getParameter("pass");
				System.out.println(user+" "+pass);
				LoginLogic log = new LoginLogic();
				String id = log.login(user, pass);
				
				//if id is null something went wrong with retreiving this user
				if(id == null) {
					System.out.println("Show error message here/call login ftl again with failed boolean");
					
				}
				else {
					//set user id as session attribute
					session.setAttribute("userid", id);
				
					//print userid for the session
					//System.out.println(session.getAttribute("userid"));
					
				}
						
			}
			//System.out.println(session.toString());
			
		}
		
			
		System.out.println("End of GET");
	}
		//end of method stub
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doGet(request, response);
	}

}

