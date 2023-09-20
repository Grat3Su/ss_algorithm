package regist.controller;

import java.io.IOException;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.UserDto;
import regist.service.RegistService;
import regist.service.RegistServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistService registService = new RegistServiceImpl();

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

	private void joinout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("joinout");
		request.getSession().invalidate();//세션 무효
		
		//화면
		request.getRequestDispatcher("/EnjoyTrip/index.jsp").forward(request, response);		
	}

	private void join_ajax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("joinAjax");
	    String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
	    String userPassword = request.getParameter("userPassword");
	    System.out.println(userID);
		System.out.println(userName);
	    System.out.println(userPassword);
	    
	    // DB 로그인 성공
	    // 사용자정보를 DB 에서 가져와서 UserDto 객체를 만든 후 session 에 저장
	    UserDto userDto = registService.join(userID, userName, userPassword);
	    System.out.println(": "+ userDto);
	    Gson gson = new Gson();
	    JsonObject jsonObject = new JsonObject();
	    
	    if(userDto!=null) {
	    	request.getSession().setAttribute("userDto", userDto);
	    	jsonObject.addProperty("result", "fail");
	    }else {
	    	jsonObject.addProperty("result", "success");
	    	
	    }
	    String jsonStr = gson.toJson(jsonObject);
	    System.out.println(jsonStr);
	    
	    response.getWriter().write(jsonStr);
		
	}

}
