package multiShopJava.SpringMVC.controller.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.dao.loaisanphamDAO.loaisanphamDAO;
import multiShopJava.SpringMVC.dao.nhasanxuatDAO.nhasanxuatDAO;
import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.nhasanxuat;
import multiShopJava.SpringMVC.model.sanpham;


/**
 * Handles requests for the application home page.
 */
@Controller(value="HomeController")
@RequestMapping(value={"Home"})
public class HomeController {


	@Autowired
	private sanphamDAO sanphamDAO;
	@Autowired
	private loaisanphamDAO loaisanphamDAO;
	@Autowired
	private nhasanxuatDAO nhasanxuatDAO;
	
	
	@RequestMapping(value={"/trangchu","/"})
	public ModelAndView trangchu(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		int tongsl = CartController.tongSoLuong(request);
		session.setAttribute("tongsl", tongsl);
		List<Object[]> listNSX = sanphamDAO.listNSX();
		List<Object[]> listLSP = sanphamDAO.listLSP();
		List<sanpham> listSPMOI = sanphamDAO.listSPM();
		List<sanpham> listSPNB = sanphamDAO.listSPNB();
		List<loaisanpham> listloaiSanphams = loaisanphamDAO.list();
		List<nhasanxuat> nsx = nhasanxuatDAO.list();
		
		
		
		
		ModelAndView model = new ModelAndView("web/TrangChu");
		model.addObject("loaisanphamList", listloaiSanphams);
		model.addObject("listNSX", listNSX);
		model.addObject("listLSP", listLSP);
		model.addObject("listSPMOI", listSPMOI.stream().limit(8).collect(Collectors.toList()));
		model.addObject("listSPNB", listSPNB.stream().limit(8).collect(Collectors.toList()));
		model.addObject("NSXS", nsx);
		
		
		
		return model;
	}
//	@RequestMapping(value="/Student/new", method = RequestMethod.GET)
//	public ModelAndView create() {
//		List<Class> listClasss = classDAO.list();
//		ModelAndView model = new ModelAndView("Student");
//		model.addObject("classList", listClasss);
//		return model;
//	}
//	@RequestMapping(value="/Student/new", method = RequestMethod.POST)
//	public String create(@RequestParam("name") String name,@RequestParam("class") String cl) {
//		Class clss = classDAO.getById(Integer.parseInt(cl)+1);
//		Student st = new Student(name,clss);
//		studentDAO.save(st);
//	    return "redirect:/";
//	}
//	@RequestMapping(value="/Student/edit", method = RequestMethod.GET)
//	public ModelAndView editCustomerForm(@RequestParam int id) {
//
//	    Student st = studentDAO.getById(id);
//	    List<Class> listClasss = classDAO.list();
//
//	    ModelAndView mav = new ModelAndView("editStudent");
//	    mav.addObject("classList", listClasss);
//	    mav.addObject("student", st);
//
//	    return mav;
//	}
//	@RequestMapping(value="/Student/edit", method = RequestMethod.POST)
//	public String editCustomerForm(HttpServletRequest request) {
//		String name = request.getParameter("Name");
//		String id = request.getParameter("id");
//		String cl = request.getParameter("CLASS");
//		Class clss = classDAO.getById(Integer.parseInt(cl)+1);
//		Student st = studentDAO.getById(Integer.parseInt(id));
//		st.setName(name);
//		st.setCLASS(clss);
//		studentDAO.update(st);
//
//	    return "redirect:/";
//	}
//	@RequestMapping(value="/Many-to-Many")
//	public ModelAndView home2() {
//		List<Cource_Student> listCource_Students = Cource_StudentDAO.list();
//		ModelAndView model = new ModelAndView("ManyToMany");
//		model.addObject("listCource_Students", listCource_Students);
//		return model;
//	}

}
