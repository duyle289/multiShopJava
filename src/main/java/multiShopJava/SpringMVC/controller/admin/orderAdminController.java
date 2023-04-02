package multiShopJava.SpringMVC.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.model.chitiethd;
import multiShopJava.SpringMVC.model.hoadon;
import multiShopJava.SpringMVC.model.nhanvien;
import multiShopJava.SpringMVC.model.sanpham;

import multiShopJava.SpringMVC.dao.hoadonDAO.hoadonDAO;
import multiShopJava.SpringMVC.dao.chitiethdDAO.chitiethdDAO;

@Controller(value = "orderAdminController")
@RequestMapping(value = {"admin"})
public class orderAdminController {
	
	@Autowired
	private hoadonDAO hoadonDAO;
	@Autowired
	private chitiethdDAO chitiethdDAO;
	
	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public ModelAndView listOrder(HttpServletRequest request) {
		List<hoadon> hd = hoadonDAO.list();
		ModelAndView model = new ModelAndView("admin/listorder");
		model.addObject("listOrder", hd);
		return model;
	}
	@RequestMapping(value = { "/order-detail" }, method = RequestMethod.GET)
	public ModelAndView orderdetail(HttpServletRequest request, @RequestParam("id") String id ) {
		List<chitiethd> hds = chitiethdDAO.listOrderDetailByOrderId(id);
		hoadon hd = hoadonDAO.getOrderById(id);
		ModelAndView model = new ModelAndView("admin/orderdetail");
		model.addObject("listOrderDetail", hds);
		model.addObject("madh", id);
		model.addObject("hd", hd);
		return model;
	}
	@RequestMapping(value = { "/order-processing" }, method = RequestMethod.GET)
	public String orderprocessing(HttpServletRequest request, @RequestParam("id") String id,@RequestParam("type") int type ) {
		HttpSession session = request.getSession(true);
		hoadon hd = hoadonDAO.getOrderById(id);
		nhanvien nv = (nhanvien)session.getAttribute("nhanvien");
		hd.setTRANGTHAI(type+1);
		hd.setNv(nv);
		hoadonDAO.update(hd);
		return "redirect:/admin/order";
	}
}
