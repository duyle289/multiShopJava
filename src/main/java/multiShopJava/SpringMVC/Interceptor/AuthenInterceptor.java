package multiShopJava.SpringMVC.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (request.getRequestURI().toString().contains("order")) {
			if (session != null && session.getAttribute("khachhang") != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
		}else if(request.getRequestURI().toString().contains("admin")){
			if (session != null && session.getAttribute("nhanvien") != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
		}
		return true;

	}

}
