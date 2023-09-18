package loginout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;

/**
 * Servlet implementation class Loginout
 */
@WebServlet("/Loginout")
public class Loginout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		switch (job) {
		case "login": login(request, response);	break;
		case "logout": logout(request, response);	break;

		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		System.out.println(userEmail);
		System.out.println(userPassword);
		
		//DB 로그인 성공
		//사용자 정보를 DB에서 가져와서 UserDto 객체를 만든 후 session에 저장해서 사용
		UserDto userDto =new UserDto(1, "홍길동", "hong@gmail.com",null);
		
		//세션에 로그인한 사용자 정보를 저장
		request.getSession().setAttribute("userDto", userDto);
		
		//화면
		request.getRequestDispatcher("/main").forward(request, response);
	}
		

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout");
		request.getSession().invalidate();//세션 무효
		
		//화면
		request.getRequestDispatcher("/main").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
