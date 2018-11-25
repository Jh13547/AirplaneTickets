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

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import project.logic.AccountInfoLogic;
import project.logic.LoginLogic;
import project.object.Booking;
import project.object.User;

/**
 * Servlet implementation class AccountInfoServlet
 */
@WebServlet("/AccountInfoServlet")
public class AccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String tempDir = "/WEB-INF/template";
    Configuration cfg;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		synchronized(session) {
		Writer out;
		String templateName;
		Map<String, Object> root = new HashMap<>();
		
		User user=(User) session.getAttribute("user");
		String id = user.id();
		if(request.getParameter("accountinfo") != null) {
			
			try {
				
				out = response.getWriter();
				templateName = "userInfo.ftl";
				AccountInfoLogic log = new AccountInfoLogic();
				User u = log.getUserInfo(id);
				root.put("user", u);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("bookinghistory") != null) {
			
	try {
				templateName = "bookingHistory.ftl";
				AccountInfoLogic log = new AccountInfoLogic();
				ArrayList<Booking> bookingList = (ArrayList<Booking>) log.getBookings(id);
			
				for (int i = 0; i < bookingList.size(); i++) {
					Booking book = bookingList.get(i);
					String[] flightinfo = log.getFlightInfo(book.getFlightid());
					String company = log.getCompany(book.getFlightid());
					book.setDeparture(flightinfo[0]);
					book.setDestination(flightinfo[1]);
					book.setCompany(company);
				}
				root.put("bookings", bookingList);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
