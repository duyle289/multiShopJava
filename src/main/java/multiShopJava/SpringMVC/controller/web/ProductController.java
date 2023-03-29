package multiShopJava.SpringMVC.controller.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.dao.loaisanphamDAO.loaisanphamDAO;
import multiShopJava.SpringMVC.dao.nhasanxuatDAO.nhasanxuatDAO;
import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.dao.chitietspDAO.chitietspDAO;
import multiShopJava.SpringMVC.dao.mausacDAO.mausacDAO;
import multiShopJava.SpringMVC.model.chitietsp;
import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.sanpham;

@Controller(value = "ProductController")
@RequestMapping(value={"Product"})
public class ProductController {
	@Autowired
	private sanphamDAO sanphamDAO;
	@Autowired
	private loaisanphamDAO loaisanphamDAO;
	@Autowired
	private chitietspDAO chitietspDAO;
	@Autowired
	private mausacDAO mausacDAO;
	private List<sanpham> sp;
	private String type="";
	private String sorttype="";
	@RequestMapping(value={"/product-detail"},method = RequestMethod.GET)
	public ModelAndView trangchu(@RequestParam int id,HttpServletRequest request) {
		tongSoLuong(request);
        
		List<loaisanpham> listloaiSanphams = loaisanphamDAO.list();
		List<Object[]> listNSX = sanphamDAO.listNSX();
		sanpham sp=sanphamDAO.getByID(id);
		List<Object[]> ctsps =chitietspDAO.getCTSP(id);
		List<mausac> ms =mausacDAO.list();
		System.out.println(ctsps.size());
		
		ModelAndView model = new ModelAndView("web/Product-detail");
		model.addObject("loaisanphamList", listloaiSanphams);
		model.addObject("listNSX", listNSX);
		model.addObject("sp", sp);
		model.addObject("ctsps", ctsps);
		model.addObject("ms", ms);
		return model;
	}
	@RequestMapping(value={"/{pageid}"},method = RequestMethod.GET)
	public ModelAndView showProduct(HttpServletRequest request,@PathVariable int pageid) {
		tongSoLuong(request);
		List<mausac> ms = mausacDAO.list();
        ModelAndView model = new ModelAndView("web/ShowProduct");
        model.addObject("pageid", pageid); 
        
        int total=9;
        int slsp=0;
        pageid=(total*pageid)-total;  
        List<sanpham> listspPagination =null;
        
        	listspPagination = sp.stream().skip(pageid).limit(total).collect(Collectors.toList());
        	slsp = (int)Math.ceil((double)sp.size()/9);
        
        
        model.addObject("listsp", listspPagination);
        model.addObject("listms", ms);
        model.addObject("slsp", slsp);
        model.addObject("type", type);
        model.addObject("sorttype", sorttype);
        return model;

		
	}
	@RequestMapping(value={"/SortProduct/{pageid}"},method = RequestMethod.GET)
	public ModelAndView SortProduct(@PathVariable int pageid,HttpServletRequest request,@RequestParam("sortType") String sortType) {
		if(sortType.equals("asc")) {
			sp = sp.stream().sorted((item1,item2)-> item1.getDONGIA()>item2.getDONGIA()?1:-1).collect(Collectors.toList());
			sorttype="asc";
			
		}else {
			sp = sp.stream().sorted((item1,item2)-> item1.getDONGIA()<item2.getDONGIA()?1:-1).collect(Collectors.toList());
			sorttype="desc";
		}
        
        return showProduct(request,pageid);
	}
//	@RequestMapping(value={"/FilterProduct/{pageid}"},method = RequestMethod.GET)
//	public ModelAndView FilterProduct(@PathVariable int pageid,HttpServletRequest request) {
//		filterType= Integer.parseInt(request.getParameter("filterPrice"));
//		
//		if(filterType == 1) {
//			lsp = sp.stream().filter(s -> s.getDONGIA() < 15000000).collect(Collectors.toList());
//		}else if(filterType == 2) {
//			lsp = sp.stream().filter(s -> s.getDONGIA() >= 15000000&& s.getDONGIA() < 25000000).collect(Collectors.toList());
//		}else if(filterType == 3) {
//			lsp = sp.stream().filter(s -> s.getDONGIA() >= 25000000&& s.getDONGIA() < 40000000).collect(Collectors.toList());
//		}else {
//			lsp = sp.stream().filter(s ->  s.getDONGIA() > 40000000).collect(Collectors.toList());
//		}
//		
//        
//        return showProduct(request,pageid);
//	}
	@RequestMapping(value={"/ShowAllProduct/{pageid}"},method = RequestMethod.GET)
	public ModelAndView ShowAllProduct(@PathVariable int pageid,HttpServletRequest request ) {

        sp = sanphamDAO.list();
        type="Tất cả sản phẩm";
        sorttype="";
        return showProduct(request,pageid);
	}
	@RequestMapping(value={"/ShowProductByCategory/{pageid}"},method = RequestMethod.GET)
	public ModelAndView ShowProductByCategory(HttpServletRequest request,@PathVariable int pageid,@RequestParam("id") int id,@RequestParam("name") String name ) {

         sp = sanphamDAO.getProductByCaterogy(id);
         type="Sản phẩm theo danh mục: "+name;
         sorttype="";
        return showProduct(request,pageid);
		
	}
	@RequestMapping(value={"/ShowNewProducts/{pageid}"},method = RequestMethod.GET)
	public ModelAndView ShowNewProducts(HttpServletRequest request,@PathVariable int pageid ) {

         sp = sanphamDAO.listSPM();
         type="Sản phẩm mới";
         sorttype="";
        return showProduct(request,pageid);
		
	}
	@RequestMapping(value={"/ShowFeaturedProducts/{pageid}"},method = RequestMethod.GET)
	public ModelAndView ShowFeaturedProducts(HttpServletRequest request,@PathVariable int pageid) {

         sp = sanphamDAO.listSPNB();
         type="Sản phẩm nổi bật";
         sorttype="";
        return showProduct(request,pageid);
		
	}
	@RequestMapping(value={"/ShowProductByBrand/{pageid}"},method = RequestMethod.GET)
	public ModelAndView ShowProductByBrand(@PathVariable int pageid,HttpServletRequest request ) {

         sp = sanphamDAO.list();
         sorttype="";
        
         return showProduct(request,pageid);
        
        
//		List<loaisanpham> listloaiSanphams = loaisanphamDAO.list();
//		List<Object[]> listNSX = sanphamDAO.listNSX();
//		sanpham sp=sanphamDAO.getByID(id);
//		List<Object[]> ctsps =chitietspDAO.getCTSP(id);
//		List<mausac> ms =mausacDAO.list();
//		System.out.println(ctsps.size());
		
		
//		model.addObject("loaisanphamList", listloaiSanphams);
//		model.addObject("listNSX", listNSX);
//		model.addObject("sp", sp);
//		model.addObject("ctsps", ctsps);
//		model.addObject("ms", ms);
		
	}
	@RequestMapping(value={"/ShowProductByBrandOfCategory/{pageid}"},method = RequestMethod.GET)
	public ModelAndView ShowProductByBrandOfCategory(@PathVariable int pageid,HttpServletRequest request ) {
		tongSoLuong(request);
        ModelAndView model = new ModelAndView("web/ShowProduct");
        
        sorttype="";
        return model;
        
        
//		List<loaisanpham> listloaiSanphams = loaisanphamDAO.list();
//		List<Object[]> listNSX = sanphamDAO.listNSX();
//		sanpham sp=sanphamDAO.getByID(id);
//		List<Object[]> ctsps =chitietspDAO.getCTSP(id);
//		List<mausac> ms =mausacDAO.list();
//		System.out.println(ctsps.size());
		
		
//		model.addObject("loaisanphamList", listloaiSanphams);
//		model.addObject("listNSX", listNSX);
//		model.addObject("sp", sp);
//		model.addObject("ctsps", ctsps);
//		model.addObject("ms", ms);
		
	}
	public void tongSoLuong(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		int tongsl = CartController.tongSoLuong(request);
        session.setAttribute("tongsl", tongsl);
	}
}
