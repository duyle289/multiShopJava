package multiShopJava.SpringMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.MD5;
import multiShopJava.SpringMVC.dao.khachhangDAO.khachhangDAO;
import multiShopJava.SpringMVC.dao.nhanvienDAO.nhanvienDAO;
import multiShopJava.SpringMVC.model.khachhang;
import multiShopJava.SpringMVC.model.nhanvien;

@Controller(value = "loginController")
@RequestMapping(value = { "login" })
public class loginController {
	@Autowired
	private khachhangDAO khachhangDAO;
	@Autowired
	private nhanvienDAO nhanvienDAO;
	private String referer = "";

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		referer = request.getHeader("Referer");
		// System.out.println(request.getRequestURI());
		ModelAndView model = new ModelAndView("Login");
		return model;
	}

	@RequestMapping(value = { "" }, method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap model) {

		HttpSession session = request.getSession(true);
		String tk = request.getParameter("taikhoan");
		String mk = request.getParameter("matkhau");
		String role = request.getParameter("role");
		System.out.println(role);
		System.out.println(tk);
		System.out.println(mk);
		if (role.equals("user")) {
			khachhang kh = khachhangDAO.findByUsername(tk);
			if (kh == null) {
				request.setAttribute("error", "Tên đăng nhập không tồn tại");
				return "Login";
			} else if (!kh.getPASSWORD().equals(MD5.getMd5(mk))) {
				// Mật khẩu không đúng
				request.setAttribute("error", "Mật khẩu không đúng");
				return "Login";
			} else {
				// Đăng nhập thành công, lưu thông tin khách hàng vào session
				session.setAttribute("khachhang", kh);
				return "redirect:" + referer;
			}
		} else if (role.equals("admin")) {
			nhanvien nv = nhanvienDAO.findByUsername(tk);
			if (nv == null) {
				request.setAttribute("error", "Tên đăng nhập không tồn tại");
				return "Login";
			} else if (!nv.getPASSWORD().equals(MD5.getMd5(mk))) {
				// Mật khẩu không đúng
				request.setAttribute("error", "Mật khẩu không đúng");
				return "Login";
			} else {
				// Đăng nhập thành công, lưu thông tin khách hàng vào session
				session.setAttribute("nhanvien", nv);
				return "redirect:/admin/";
			}
		} else {
			request.setAttribute("error", "Chọn quyền");
			return "Login";
		}

	}
}
