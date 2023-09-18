package main;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.StudentDto;
import dto.SidoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("/ request");
		//DB Access
		// 뿌려줄 데이터를 추출
		java.util.List<StudentDto> studentList = new ArrayList<>();
		studentList.add(new StudentDto(1, "g홍"));
		studentList.add(new StudentDto(2, "길"));
		studentList.add(new StudentDto(3, "동"));

		java.util.List<SidoDto> sidoList = new ArrayList<>();
		sidoList.add(new SidoDto(1, "졸려"));
		sidoList.add(new SidoDto(2, "진짜"));
		sidoList.add(new SidoDto(3, "베리"));
		
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("sidoList", sidoList);
		
		//index.jsp
		//forward
		
		
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
