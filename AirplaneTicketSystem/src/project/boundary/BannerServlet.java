package project.boundary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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
	Map root = new HashMap();
    public BannerServlet() {
        super();}
    
    
    
    //This servlet handles banner actions (Ajax stuuf as of right now) for logging in and signing up
    //It also loads templates by retrieving templates as strings and passing them to the response writer as 'reply'
    //This is used to load the login/signup templates as a popup from a ajax request
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply="fail",action=request.getParameter("action"),
				email=request.getParameter("email"),pass=request.getParameter("pass");
		response.setContentType("text/html");
		//if the request isn't for a template then it will try to login or signup
		HttpSession session = request.getSession();
		synchronized(session) {
			
			//if logging in
			if(request.getParameter("action").equals("login")) {
				System.out.println("Trying to login...");
				
				//if current session email is null
				if(session.getAttribute("user")==null){
					//try to sign in
					String id=LoginLogic.login(request.getParameter("email"),request.getParameter("pass"));
					System.out.println("found id="+id);
					String[] names=LoginLogic.getFirstLast(id);
					boolean admin = LoginLogic.isAdmin(id);
					//if user was found/not found
					if(id==null) {
						reply="fail";
						System.out.println("login not found");
					}else{
						session.setAttribute("user",new User(id,names[0],names[1],email,pass,admin));
						reply="success";
						System.out.println("login Sucessful id="+id);
					}
					
				//if session isn't null, then you should be already signed in
				}else{
					System.out.println("found session with '"+session.getAttribute("user"));
					reply="success";
				}
				
				
				
			//If signning up
			}else if(request.getParameter("action").equals("signup")) {
				String first = request.getParameter("first");
				String last = request.getParameter("last");
				User user = new User(first, last, email, pass,false);
				if(LoginLogic.signUp(user)) {
					System.out.println("signup=Success");
					session.setAttribute("user", user);
					reply="success";
				}
				else {
					System.out.println("signup=Failure");
					reply="fail";
				}
			}
			
			
			
			//if template isn't null then respond with the template requested template
			else if(action.equals("template")){
				String template=request.getParameter("template");
				try{
					
					if(template.equals("index")) {
						cfg.getTemplate("banner.ftl").process(root,response.getWriter());
						cfg.getTemplate("index.ftl").process(root,response.getWriter());
						cfg.getTemplate("footer.ftl").process(root,response.getWriter());
					}else if(template.equals("admin")) {
						cfg.getTemplate("admin.ftl").process(root,response.getWriter());
					}else{
						if(template.equals("AccountTab")&&((User)session.getAttribute("user")).getAdmin())
							template+="Admin";
						reply=cfg.getTemplate(template+".ftl").toString();
						System.out.println("Requested '"+template+".ftl'");
					}
				}catch(Exception e) {
					reply="fail";
				}
			
			
			
			//Sees if there is a session, if so then return the user (probably need to use json here)
			}else if(action.equals("session")) {
				
				if(session.getAttribute("user")==null) {
					
					reply="fail";
				}else{
					User user=(User) session.getAttribute("user");
					System.out.println("found user="+user.getFirstName()+","+user.getEmail());
					reply=user.toString();
				}
				
				
			//invalidates the session
			}else if(action.equals("signout")) {
				if (session != null) 
				    session.invalidate();
				///////////////////////need to refresh the page to the home screen, so if they're on they're account page it will leave it.
				reply="session invalidated";
			}
		}
		if(request.getParameter("template")!=null) {
			if(!request.getParameter("template").equals("index"))
				response.getWriter().write(reply);
		}else
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
