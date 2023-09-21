package config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.UserDto;
//주의!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//적용한거 까먹지말기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
@WebFilter("/*")
public class LoginFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        
        String contextPath = httpServletRequest.getContextPath();
        String path = httpServletRequest.getRequestURI();
        
        System.out.println("BoardWebAjaxJson - doFilter path : " + path ); 

        HttpSession session = httpServletRequest.getSession();
        
        // exclude 제어문
        if( //여기는 적용하지 않음
                ! path.contains("/img/") 
                && ! path.contains("/css/") 
                && ! path.contains("/js/") 
                && ! path.contains("/register") 
                && ! path.contains("/isEmailUnique")//이메일이 중복되는지 여부 확인 
                && ! path.contains("/login") 
        ) {
        	//세션에서 로그인 되어잇는지 확인
            UserDto userDto = (UserDto) session.getAttribute("userDto");

            if(userDto == null) {
            	//로그인 페이지로 접속 요청
                httpServletResponse.sendRedirect(contextPath + "/jsp/login.jsp");
                return;
            }
        }

        chain.doFilter(req, res);
    }

}
