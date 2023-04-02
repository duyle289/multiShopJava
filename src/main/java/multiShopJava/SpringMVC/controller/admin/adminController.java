package multiShopJava.SpringMVC.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.model.nhanvien;

@Controller(value = "adminController")
@RequestMapping(value={"admin"})
public class adminController {
	@RequestMapping(value={""},method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/index");
		return model;
	}

	@RequestMapping(value={"/logout"},method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		nhanvien nv = (nhanvien) session.getAttribute("nhanvien");
		if (nv != null) {
			session.setAttribute("nhanvien", null);
		}
		return "redirect:/admin/";
	}
}
