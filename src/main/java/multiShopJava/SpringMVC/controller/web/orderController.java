package multiShopJava.SpringMVC.controller.web;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.dao.hoadonDAO.hoadonDAO;
import multiShopJava.SpringMVC.dao.mausacDAO.mausacDAO;
import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.dao.chitiethdDAO.chitiethdDAO;
import multiShopJava.SpringMVC.model.cart;
import multiShopJava.SpringMVC.model.chitiethd;
import multiShopJava.SpringMVC.model.hoadon;
import multiShopJava.SpringMVC.model.khachhang;
import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.sanpham;

@Controller(value = "orderController")
@RequestMapping(value = { "order" })
public class orderController {

	@Autowired
	private hoadonDAO hoadonDAO;
	@Autowired
	private chitiethdDAO chitiethdDAO;
	@Autowired
	private sanphamDAO sanphamDAO;
	@Autowired
	private mausacDAO mausacDAO;
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		ModelAndView model = new ModelAndView("web/orderConfirm");

		String tenkh = request.getParameter("TENKH");
		String sdt = request.getParameter("SDT");
		String dcgh = request.getParameter("DCGH");
		String yck = request.getParameter("YCK");
		
		SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, 10);
		
		@SuppressWarnings("unchecked")
		List<cart> gh = (List<cart>) session.getAttribute("cart");
		List<hoadon> Listhd = hoadonDAO.list();
		hoadon hd = new hoadon();
		
		hd.setMAHD("DH-" + dtf.format(now) + "-" + randomChar());
		for (hoadon item : Listhd) {
			if (item.getMAHD().equals(hd.getMAHD())) {
				hd.setMAHD("DH-" + dtf.format(now) + "-" + randomChar());
			}
		}
		System.out.println(hd.getMAHD());
		hd.setNGAYLAP(now);
		hd.setNGAYGIAO(cal.getTime());
		hd.setTONGTIEN(tongTien(request));
		hd.setTRANGTHAI(0);
		hd.setKh((khachhang)session.getAttribute("khachhang"));
		hd.setTENKH(tenkh);
		hd.setSDTKH(sdt);
		hd.setDIACHIGIAOHANG(dcgh);
		hd.setYEUCAUKHAC(yck);
		hoadonDAO.save(hd);
		for(cart item : gh) {
			chitiethd cthd = new chitiethd();
			mausac ms = mausacDAO.getById(item.getMamau());
			sanpham sp = sanphamDAO.getByID(item.getMasp());
			cthd.setHd(hd);
			cthd.setMs(ms);
			cthd.setSp(sp);
			cthd.setSOLUONG(item.getSoluong());
			cthd.setDONGIA(item.getDongia());
			chitiethdDAO.save(cthd);
			
		}
		session.setAttribute("cart",null);
		return model;
	}

	public static String randomChar() {
		String chars = "0123456789";
		char[] stringChars = new char[4];
		Random random = new Random();
		for (int i = 0; i < stringChars.length; i++) {
			stringChars[i] = chars.charAt(random.nextInt(chars.length()));
		}
		String finalString = new String(stringChars);
		return finalString;
	}

	private double tongTien(HttpServletRequest request) // lấy tổng tiền của giỏ hàng
	{
		HttpSession session = request.getSession(true);
		double tongTien = 0;
		@SuppressWarnings("unchecked")
		List<cart> listProductInCart = (List<cart>) session.getAttribute("cart");
		if (listProductInCart != null) {
			tongTien = listProductInCart.stream().mapToDouble(o -> o.getTongtien()).sum();
		}
		return tongTien;
	}
}
