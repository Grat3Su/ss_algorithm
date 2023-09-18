package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		switch (job) {
		case "G": goUsers(request, response);	break;
		case "A": addUsers(request, response);	break;
		case "M": modifyUsers(request, response);	break;
		case "L": listUsers(request, response);	break;
		case "D": detailUsers(request, response);	break;
		case "R": removeUsers(request, response);	break;
		}
	}

	private void removeUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/users/users.jsp").forward(request, response);
		System.out.println("remove");
	}

	private void detailUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/users/users.jsp").forward(request, response);
		System.out.println("detail");
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/users/users.jsp").forward(request, response);
		System.out.println("list");
	}

	private void modifyUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/users/users.jsp").forward(request, response);
		System.out.println("modify");
	}

	private void addUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/users/users.jsp").forward(request, response);
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String useraPassword = request.getParameter("useraPassword");
		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(useraPassword);
		
		//회원등록 성공, 실패
		request.getRequestDispatcher("users/userResgisterSuccess.jsp");
	}

	private void goUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/users/users.jsp").forward(request, response);
		System.out.println("go");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
