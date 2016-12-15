package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
       String uri = request.getRequestURI();
		
		if(uri.endsWith("cadastrarUsuario") ||
		   uri.endsWith("login") || uri.endsWith("irParaInicio") )  //precisa sem login
				return true;
			
		
		if(request.getSession().getAttribute("usuario_logado")!=null){
			return true;
		}
		
		response.sendRedirect("irParaInicio");
		return false;
	}
}
	

