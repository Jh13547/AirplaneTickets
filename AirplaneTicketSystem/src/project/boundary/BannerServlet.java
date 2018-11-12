package project.boundary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import project.logic.*;
import project.object.User;

@WebServlet("/BannerServlet")
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Configuration cfg;
	String templateDir = "/WEB-INF/template";
	LoginLogic LoginLogic=new LoginLogic();

    public BannerServlet() {
        super();}
    
    
    
    //This servlet handles banner actions (Ajax stuuf as of right now) for logging in and signing up
    //It also loads templates by retrieving templates as strings and passing them to the response writer as 'reply'
    //This is used to load the login/signup templates as a popup from a ajax request
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply="fail",template=request.getParameter("template"),
				email=request.getParameter("email"),pass=request.getParameter("pass");
		response.setContentType("text/html");
		//if the request isnt for a template then it will try to login or signup
		if(template==null) {
			HttpSession session = request.getSession();
			synchronized(session) {
				//if logging in
				if(request.getParameter("action").equals("login")) {
					System.out.println("Trying to login...");
					//if current session email is null
					if(session.getAttribute("email")==null){
						//try to sign in
						String id=LoginLogic.login(request.getParameter("email"),request.getParameter("pass"));
						//if user was found/not found
						if(id==null) {
							reply="fail";
							System.out.println("login not found");
						}else{
							session.setAttribute("email",request.getParameter("email"));
							reply="success";
							System.out.println("login Sucessful id="+id);
						}
					//if session isn't null, then you should be already signed in
					}else{
						System.out.println("found session with '"+session.getAttribute("email")+"'");
						reply="success";
					}
				//If signning up
				}else if(request.getParameter("action").equals("signup")) {
					String first = request.getParameter("first");
					String last = request.getParameter("last");
					User u = new User(first, last, email, pass);
					if(LoginLogic.signUp(u)) {
						System.out.println("signup=Success");
						reply="success";
					}
					else {
						System.out.println("signup=Failure");
						reply="fail";
					}
				}
			}
		//if template isn't null then respond with the template requested template
		}else{
			try{
				reply=cfg.getTemplate(template+".ftl").toString();
				System.out.println("Requested '"+template+".ftl'");
			}catch(Exception e) {
				reply="fail";
			}
		}
		response.getWriter().write(reply);
	}

	
	
	
	
	
	
	
	
	
	//FreeMarker templates load method
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		cfg=new Configuration(Configuration.VERSION_2_3_28);
		try{
			cfg.setDirectoryForTemplateLoading(new File(getServletContext().getRealPath(templateDir.toString())));
		}catch(IOException e){
			System.out.println("No Tempates");}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);}
}
