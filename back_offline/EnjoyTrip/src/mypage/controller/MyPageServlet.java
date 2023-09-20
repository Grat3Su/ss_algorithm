package mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		case "change": change(request, response);	break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void change(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("login");
		String userID = request.getSession().getParameter("userID");
		String userPassword = request.getSession().getParameter("userID");
		
		
		//DB 로그인 성공
		//사용자 정보를 DB에서 가져와서 UserDto 객체를 만든 후 session에 저장해서 사용
		UserDto userDto =myPageService.change(userID, userPassword);
		
		//성공
		if(userDto!=null) {
			request.getRequestDispatcher("/main").forward(request, response);
		} else {
			request.getRequestDispatcher("/login/loginFail.jsp").forward(request, response);
		}
		
	}

}
