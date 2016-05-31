package br.com.listen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object controller) throws Exception{
		 String uri = request.getRequestURI();
	      if(uri.endsWith("index")){
	        return true;
	      }
	      
	      if(request.getSession()
	          .getAttribute("usuarioLogado") != null) {
	        return true;
	      }
	      return true;
	     // response.sendRedirect("login");
	     // return false;
	}
	
}
