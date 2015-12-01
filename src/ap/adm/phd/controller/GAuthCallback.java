package ap.adm.phd.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class GAuthCallback
 */
@WebServlet(urlPatterns={"/GAuthCallback"}, asyncSupported = true) 
public class GAuthCallback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GAuthCallback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Check if the user have rejected 
	      String error = request.getParameter("error"); 
	      if ((null != error) && ("access_denied".equals(error.trim())))
	    { 
	         HttpSession sess = request.getSession(); 
	         sess.invalidate(); 
	         response.sendRedirect(request.getContextPath()); 
	         return; 
	      }
	      //OK the user have consented so lets find out about the user 
	      AsyncContext ctx = request.startAsync(); 
	      ctx.start(new GetUserInfo(request, response, ctx)); 
	   } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public class GetUserInfo implements Runnable { 
		   private HttpServletRequest req; 
		   private HttpServletResponse resp; 
		   private AsyncContext asyncCtx; 
		   public GetUserInfo(HttpServletRequest req, HttpServletResponse resp, AsyncContext asyncCtx) { 
		      this.req = req; 
		      this.resp = resp; 
		      this.asyncCtx = asyncCtx; 
		   }
		   @Override 
		   public void run() {  
		      HttpSession sess = req.getSession(); 
		      OAuthService service = (OAuthService)sess.getAttribute("oauth2Service");
		      //Get the all important authorization code 
		      String code = req.getParameter("code"); 
		      //Construct the access token 
		      Token token = service.getAccessToken(null, new Verifier(code)); 
		      //Save the token for the duration of the session 
		      sess.setAttribute("token", token);
		      //Perform a proxy login 
		      try { 
		         req.login("fred", "fredfred"); 
		      } catch (ServletException e) { 
		         //Handle error - should not happen 
		      }
		      //Now do something with it - get the user's G+ profile 
		      OAuthRequest oReq = new OAuthRequest(Verb.GET,"https://www.googleapis.com/oauth2/v2/userinfo"); 
		      service.signRequest(token, oReq); 
		      Response oResp = oReq.send(); 

		      //Read the result 
		      JsonReader reader = Json.createReader(new ByteArrayInputStream( 
		            oResp.getBody().getBytes())); 
		      JsonObject profile = reader.readObject(); 
		      //Save the user details somewhere or associate it with 
		      sess.setAttribute("guser_name", profile.getString("name")); 
		      sess.setAttribute("guser_email", profile.getString("email"));
		      sess.setAttribute("logged_in_user",true);
		      try {
		    	  resp.addCookie(new Cookie("guser_name", profile.getString("name")));
		    	  resp.addCookie(new Cookie("guser_email", profile.getString("email")));
			      System.out.println(req.getServerName());
		    	  resp.sendRedirect("UserController");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      asyncCtx.complete(); 
		   } 
		}

}
