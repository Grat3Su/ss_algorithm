package ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.digester.SystemPropertySource;

import com.google.gson.Gson;

import dto.UserDto;

/**
 * Servlet implementation class SimpleFetchGetListServelt
 */
@WebServlet("/SimpleFetchGetListServelt")//톰캣이 관리하는 다이나믹 모듈을 관리하는 서블릿
//어느 서블릿을 사용할지 결정
public class SimpleFetchGetListServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
		
		//data 준비
		ArrayList<UserDto> userList = new ArrayList<>();
		
		userList.add(new UserDto(1111, "홍길돛ㅇ", "hong@gmai.com"));
		userList.add(new UserDto(1111, "이길돛ㅇ", "hong2@gmai.com"));
		userList.add(new UserDto(1111, "삼길돛ㅇ", "hong3@gmai.com"));
		
		//userlist를 http로 클라이언트에 보내야함
		//java obj -> json으로 내려야함
		Gson gson = new Gson();
		String jsonStr = gson.toJson(userList);
		System.out.println(jsonStr);
		
		//cors 이슈 해결
		
		//내려준다
		response.addHeader("Access-Control-Allow-Origin", "*");//모두에게 허락한다
		response.setContentType("application/json; charset=utf-8");//json을 내려준다.  utf-8  처리
		response.getWriter().write(jsonStr);
	}

}
