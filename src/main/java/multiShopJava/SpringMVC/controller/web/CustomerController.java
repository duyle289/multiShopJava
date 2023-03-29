package multiShopJava.SpringMVC.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.MD5;
import multiShopJava.SpringMVC.dao.khachhangDAO.khachhangDAO;
import multiShopJava.SpringMVC.model.khachhang;
@Controller(value = "CustomerController")
@RequestMapping(value={"Customer"})
public class CustomerController {
	@Autowired
	private khachhangDAO khachhangDAO;

	@RequestMapping(value={"/logout"},method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession(true);
		khachhang kh = (khachhang) session.getAttribute("khachhang");
		if(kh!=null) {
			session.setAttribute("khachhang", null);
		}
		return "redirect:/Home/";	
	}
}
