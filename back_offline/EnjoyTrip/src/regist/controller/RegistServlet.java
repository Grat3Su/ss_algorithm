package regist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.UserDto;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		switch (job) {
		case "join": join(request, response);	break;
		case "joinout": joinout(request, response);	break;
		case "join_ajax": join_ajax(request, response);	break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void joinout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void join_ajax(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("loginAjax");
	    String userEmail = request.getParameter("userEmail");
	    String userPassword = request.getParameter("userPassword");
	    System.out.println(userEmail);
	    System.out.println(userPassword);
	    
	    // DB 로그인 성공
	    // 사용자정보를 DB 에석 가져와서 UserDto 객체를 만든 후 session 에 저장
	    UserDto userDto = RegistService.login(userEmail, userPassword);
	    System.out.println(userDto);
	    
	    Gson gson = new Gson();
	    JsonObject jsonObject = new JsonObject();
	    
	    if(userDto!=null) {
	    	request.getSession().setAttribute("userDto", userDto);
	    	jsonObject.addProperty("result", "success");
	    }else {
	    	jsonObject.addProperty("result", "fail");
	    	
	    }
	    String jsonStr = gson.toJson(jsonObject);
	    System.out.println(jsonStr);
	    
	    response.getWriter().write(jsonStr);
		
	}

}
