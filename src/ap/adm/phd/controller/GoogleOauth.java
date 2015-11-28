package ap.adm.phd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

import ap.adm.phd.utilities.Google2Api;

/**
 * Servlet implementation class GoogleOauth
 */
@WebServlet("/GoogleOauth")
public class GoogleOauth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLIENT_ID = "301569527192-4ka4p88k9rmhr7uclpl9qb5rdmjbcl37.apps.googleusercontent.com"; 
	private static final String CLIENT_SECRET = "UKlG85Kl0o3BmMkMv-AhM14S";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleOauth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Configure 
	      ServiceBuilder builder= new ServiceBuilder(); 
	      OAuthService service = builder.provider(Google2Api.class) 
	         .apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET).callback("http://localhost:8080/PhdAdmissionWeb/GAuthCallback").scope("email").debug().build(); //Now build the call
	      HttpSession sess = request.getSession(); 
	      sess.setAttribute("oauth2Service", service);
	      System.out.println(sess.getAttribute("oauth2Service"));
	      response.sendRedirect(service.getAuthorizationUrl(null)); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
