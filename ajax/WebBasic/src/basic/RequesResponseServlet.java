package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.callback.UsernameCallback;

/**
 * Servlet implementation class RequesResponseServlet
 */
@WebServlet("/reqres")
public class RequesResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터 처리
		String username = request.getParameter("username");
		System.out.println(username);

		// html, json에 한글 사용
		response.setContentType("text/html; charset=utf-8");
		// response.setContentType("application/json; charset=utf-8");

		// response
		PrintWriter writer = response.getWriter();
		writer.append("졸려");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//파라미터
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobby");

		System.out.println(username);
		System.out.println(password);

		for (String hobby : hobbies) {
			System.out.println(hobby);
		}
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// response
		PrintWriter writer = response.getWriter();
		writer.append("받음");
	}

}
