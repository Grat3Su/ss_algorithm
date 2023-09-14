package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSsafy
 */
@WebServlet("/ssafy")// url 매핑
//@WebServlet("/HelloSsafy")
public class HelloSsafy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//텍스트를 넘길거니까 html로 해석해라
		//response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1> Hello Ssafy </h1>");
		out.println("		<h4> 안냥 </h4>");
		out.println("	</body>");
		out.println("</html>");
		
		
		
		
		
	}

}
