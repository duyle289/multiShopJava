package multiShopJava.SpringMVC.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.model.khachhang;
import multiShopJava.SpringMVC.model.sanpham;

@Controller(value = "productAdminController")
@RequestMapping(value={"admin/product"})
public class productAdminController {
	@Autowired
	private sanphamDAO sanphamDAO;
	@RequestMapping(value={""},method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		List<sanpham> sp = sanphamDAO.list();
		ModelAndView model = new ModelAndView("admin/product");
		model.addObject("listProduct", sp);
		return model;	
	}
}
