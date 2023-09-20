package basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieMakeServlet
 */
@WebServlet("/CookieMakeServlet")
public class CookieMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c1 = new Cookie("C1", "v1");
		c1.setPath("/basic");
		c1.setMaxAge(60*5);
		response.addCookie(c1);

		Cookie c2 = new Cookie("C2", "v2");
		c2.setPath("/basic");
		response.addCookie(c2);
		
		System.out.println("cokie make");
		response.getWriter().append("Check cookie");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
