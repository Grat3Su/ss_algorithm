package com.ssafy.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeevletLifeCycle
 */
@WebServlet("/lifecycle")
public class SeevletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeevletLifeCycle() {
        super();
        System.out.println("생성자가 호출됩니다");
    }
    
    @Override
	public void destroy() {
    	System.out.println("destroy()가 호출됩니다");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()이 호출됩니다");;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()이 호출됩니다");
	}


}
