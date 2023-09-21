package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;
import mypage.service.MyPageService;
import mypage.service.MyPageServiceImpl;

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MyPageService myPageService= new MyPageServiceImpl();  
	
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		switch (job) {
		case "changePW": change(request, response);	break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session != null) {
			UserDto userDto = (UserDto) request.getSession().getAttribute("userDto");
			String userID = userDto.getUserId();
			String userPassword = userDto.getUserPsssword();

			System.out.println("change");
			String changePW = request.getParameter("changePW");

			if (userPassword == "" || userPassword == changePW) {// 빈칸이거나 같으면 동작하지 않는다
				return;
			}

			// DB 로그인 성공
			// 사용자 정보를 DB에서 가져와서 UserDto 객체를 만든 후 session에 저장해서 사용
			userDto = myPageService.change(userID, userPassword);

			// 성공하든 실패하든 원래 페이지 refresh
			request.getRequestDispatcher("/EnjoyTrip/mypage.jsp").forward(request, response);

		}

	}

}
