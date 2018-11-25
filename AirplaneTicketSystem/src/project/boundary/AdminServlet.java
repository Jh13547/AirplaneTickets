package project.boundary;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import project.logic.LoginLogic;
import project.object.Companies;
import project.object.Planes;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String tempDir = "/WEB-INF/template";
    Configuration cfg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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

		if(request.getParameter("status").equals("AddNewCompany"))
		{
			String companyName = request.getParameter("companyName").toString();
			System.out.println(companyName);
			boolean createdNewCompany = AddNewCompany(request, response, companyName);	
		}
		
		if(request.getParameter("status").equals("GetCompanyList"))
		{
			loadCompanyList(request, response);
		}
		
		if(request.getParameter("status").equals("AddNewPlane"))
		{
			String companyName = request.getParameter("companyName").toString();
			String planeType = request.getParameter("type").toString();
			String seatNumber = request.getParameter("seats").toString();
			boolean createNewPlane = AddNewPlane(request, response, companyName, planeType, seatNumber);
		}
	}

	private boolean AddNewPlane(HttpServletRequest request, HttpServletResponse response, String companyName,
			String planeType, String seatNumber) 
	{
		LoginLogic ll = new LoginLogic();
		Planes newPlane = new Planes(companyName, seatNumber, planeType);
	}

	private void loadCompanyList(HttpServletRequest request, HttpServletResponse response) 
	{
		LoginLogic ll = new LoginLogic();
		List<String> compList = null;
		try 
		{
			compList = ll.getCompanies();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			response.setContentType("application/json");
			OutputStream outputStream= response.getOutputStream();
			Gson gson=new Gson();       
			outputStream.write(gson.toJson(compList).getBytes());
			outputStream.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}

	private boolean AddNewCompany(HttpServletRequest request, HttpServletResponse response, String compName) 
	{
		LoginLogic ll = new LoginLogic();
		Companies newCompany = new Companies(compName);
		boolean created = ll.createCompany(newCompany);
		return created;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
