package multiShopJava.SpringMVC.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.dao.chitietspDAO.chitietspDAO;
import multiShopJava.SpringMVC.dao.loaisanphamDAO.loaisanphamDAO;
import multiShopJava.SpringMVC.dao.mausacDAO.mausacDAO;
import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.model.cart;
import multiShopJava.SpringMVC.model.chitiethd;
import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.sanpham;

@Controller(value = "CartController")
@RequestMapping(value = { "Cart" })
public class CartController {
	@Autowired
	private sanphamDAO sanphamDAO;
	@Autowired
	private loaisanphamDAO loaisanphamDAO;
	@Autowired
	private chitietspDAO chitietspDAO;
	@Autowired
	private mausacDAO mausacDAO;

	@RequestMapping(value = { "/AddtoCart" })
	public String addProductToCart(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		String referer = request.getHeader("Referer");
		int tongsl = 0;
		int sl = 1;
		if (request.getParameter("maMau") == null) {
			return "redirect:" + referer;
		}
		int masp = Integer.parseInt(request.getParameter("masp"));
		int mamau = Integer.parseInt(request.getParameter("maMau"));
		sl = Integer.parseInt(request.getParameter("soluong"));
		
		List<cart> listProductInCart = GetCart(request);
		

		cart product = listProductInCart.stream().filter(s -> s.getMamau() == mamau && s.getMasp() == masp).findAny().orElse(null);
		if (product == null) {
			product = new cart(masp, mamau, sl);
			listProductInCart.add(product);
			tongsl = tongSoLuong(request);
			session.setAttribute("cart", listProductInCart);
			session.setAttribute("tongsl", tongsl);
			return "redirect:" + referer;
		} else {
			int slg=product.getSoluong()+ sl;
			product.setSoluong(slg) ;
			tongsl = tongSoLuong(request);
			session.setAttribute("cart", listProductInCart);
			session.setAttribute("tongsl", tongsl);
			return "redirect:" + referer;
		}
	}

	@RequestMapping(value = { "/ViewCart" })
	public ModelAndView viewCart(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		int tongsl = tongSoLuong(request);
        session.setAttribute("tongsl", tongsl);
        
        
		ModelAndView model = new ModelAndView("web/viewCart");
		List<cart> listProductInCart = GetCart(request);
		for (cart c : listProductInCart) {
			sanpham sp = sanphamDAO.getByID(c.getMasp());
			c.setTensp(sp.getTENSP());
			c.setHinhanh(sp.getHINHANH());
			c.setDongia(sp.getDONGIA()) ; 
			c.setTongtien(c.getSoluong()*c.getDongia());
			mausac ms = mausacDAO.getById(c.getMamau());
			c.setTenmau(ms.getTENMAU());
			List<Object[]> ctspList = chitietspDAO.getCTSP(c.getMasp(), c.getMamau());
			Object[] ctsp = ctspList.get(0);
			c.setSlton((int) ctsp[1]);
		}
		session.setAttribute("cart", listProductInCart);
		model.addObject("listProductInCart", listProductInCart);
		return model;


	}
	@RequestMapping(value = { "/UpdateQuantity" },method = RequestMethod.POST)
	public ModelAndView UpdateQuantity(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("web/viewCart");
		List<cart> listProductInCart = GetCart(request);
		int masp = Integer.parseInt(request.getParameter("masp"));
		int mamau = Integer.parseInt(request.getParameter("mamau"));
		int sl = Integer.parseInt(request.getParameter("soluong"));
		if(sl==0) {
			return RemoveOneProduct(request);
		}
		cart product = listProductInCart.stream().filter(s -> s.getMamau() == mamau && s.getMasp() == masp).findAny().orElse(null);
		if(product !=null) {
			product.setSoluong(sl);
			product.setTongtien(product.getSoluong()*product.getDongia());
		}
		HttpSession session=request.getSession(true);
		int tongsl = tongSoLuong(request);
        session.setAttribute("tongsl", tongsl);
		model.addObject("listProductInCart", listProductInCart); 
		return model;
	}
	@RequestMapping(value = { "/RemoveOneProduct" },method = RequestMethod.POST)
	public ModelAndView RemoveOneProduct(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("web/viewCart");
		List<cart> listProductInCart = GetCart(request);
		int masp = Integer.parseInt(request.getParameter("masp"));
		int mamau = Integer.parseInt(request.getParameter("mamau"));
		cart product = listProductInCart.stream().filter(s -> s.getMamau() == mamau && s.getMasp() == masp).findAny().orElse(null);
		if(product !=null) {
			listProductInCart.remove(product);
		}
		HttpSession session=request.getSession(true);
		int tongsl = tongSoLuong(request);
		session.setAttribute("tongsl", tongsl);
		model.addObject("listProductInCart", listProductInCart);
		return model;
	}
	@RequestMapping(value = { "/RemoveAllProduct" },method = RequestMethod.GET)
	public ModelAndView RemoveAllProduct(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("web/viewCart");
		List<cart> listProductInCart = GetCart(request);
		if(listProductInCart !=null) {
			listProductInCart.clear();
		}
		HttpSession session=request.getSession(true);
		int tongsl = tongSoLuong(request);
		session.setAttribute("tongsl", tongsl);
		model.addObject("listProductInCart", listProductInCart);
		return model;
	}
	public List<cart> GetCart(HttpServletRequest request) // tạo list giỏ hàng hoặc lấy giỏ hàng
	{
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<cart> lstSPInCart = (List<cart>) session.getAttribute("cart");
		if (lstSPInCart == null) {
			lstSPInCart = new ArrayList<cart>();
			session.setAttribute("cart", lstSPInCart);
		}
		return lstSPInCart;
	}

	public static int tongSoLuong(HttpServletRequest request) // lấy tổng số lượng trong giỏ hàng
	{
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<cart> lstgh = (List<cart>) session.getAttribute("cart");
		if (lstgh == null) {
			return 0;
		}

		return lstgh.stream().mapToInt(o -> o.getSoluong()).sum();
	}



}
