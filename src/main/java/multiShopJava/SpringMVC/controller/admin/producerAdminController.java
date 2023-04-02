package multiShopJava.SpringMVC.controller.admin;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import multiShopJava.SpringMVC.dao.loaisanphamDAO.loaisanphamDAO;
import multiShopJava.SpringMVC.dao.mausacDAO.mausacDAO;
import multiShopJava.SpringMVC.dao.nhasanxuatDAO.nhasanxuatDAO;
import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.dao.chitietspDAO.chitietspDAO;
import multiShopJava.SpringMVC.model.chitietsp;
import multiShopJava.SpringMVC.model.khachhang;
import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.nhasanxuat;
import multiShopJava.SpringMVC.model.sanpham;
import multiShopJava.SpringMVC.model.uploadfile;

@Controller(value = "producerAdminController")
@RequestMapping(value = {"admin"})

public class producerAdminController {
	
	@Autowired
	private nhasanxuatDAO nhasanxuatDAO;
	@Autowired

	@RequestMapping(value = { "/producer" }, method = RequestMethod.GET)
	public ModelAndView listProducer(HttpServletRequest request) {
		List<nhasanxuat> nsx = nhasanxuatDAO.list();
		ModelAndView model = new ModelAndView("admin/listproducer");
		model.addObject("listProducer", nsx);
		return model;
	}
	// thêm nhà sản xuất
	@RequestMapping(value = { "/addProducer" }, method = RequestMethod.GET)
	public ModelAndView addProducer(HttpServletRequest request, String uploadInfor) {
		ModelAndView model = new ModelAndView("admin/addproducer");
		return model;
	}
	@RequestMapping(value = { "/addProducer" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String addProducer(HttpServletRequest request, @ModelAttribute("nhasanxuat") nhasanxuat NSX,
			@RequestParam("hinhanh") MultipartFile img,RedirectAttributes redirectAttributes) {
		String name =  request.getParameter("TENNSX");
		boolean isTT = Boolean.parseBoolean(request.getParameter("TRANGTHAI"));
		// Upload file
		uploadfile hinhanhsp = uploadfile(request, img);
		if (hinhanhsp.code) {
			nhasanxuat nhasanxuat = new nhasanxuat(name,isTT,hinhanhsp.filename);	
			try {	
				nhasanxuatDAO.save(nhasanxuat);
				return "redirect:producer";
			} catch (Exception e) {
				System.out.println(e);
				return "redirect:producer";
			}
		} else {
			redirectAttributes.addFlashAttribute("loaisanpham", NSX);
			redirectAttributes.addFlashAttribute("uploadInfor", hinhanhsp.message);
			return "redirect:addProducer";	
		}
	}
	
	// sửa thông tin nhà sản xuất
	@RequestMapping(value = { "/updateProducer" }, method = RequestMethod.GET)
	
	public ModelAndView updateProducer( @RequestParam int id, HttpServletRequest request , String uploadInfor) {	
		nhasanxuat NSX = nhasanxuatDAO.getById(id);
		
		ModelAndView model = new ModelAndView("admin/updateproducer");
		model.addObject("nhasanxuat", NSX);
		return model;
	}
	@RequestMapping(value = { "/updateProducer" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String updateProducer(HttpServletRequest request, @ModelAttribute("nhasanxuat") nhasanxuat NSX,
@RequestParam("hinhanh") MultipartFile img,RedirectAttributes redirectAttributes) {
	String name =  request.getParameter("TENNSX");
	int id=  Integer.valueOf(request.getParameter("id"));
	boolean isTT = Boolean.parseBoolean(request.getParameter("TRANGTHAI"));		
	//
	
	uploadfile hinhanhsp = uploadfile(request, img);
	if (hinhanhsp.code) {	
		try {	
			System.out.println(name);
			System.out.println(id);
			nhasanxuatDAO.update(id,name,isTT,hinhanhsp.filename);
			return "redirect:producer";
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:producer";
		}
	} else {
		redirectAttributes.addFlashAttribute("uploadInfor", hinhanhsp.message);
		return "redirect:updateProducer?id="+id;	
	}
}
	public String filename(MultipartFile img) {
		LocalDate t = LocalDate.now();
		Random rand = new Random();
		double double_random = rand.nextDouble() * 1000;
		String filename = t.toString() + "-" + double_random + "-" + img.getOriginalFilename();
		return filename;
	}

	public uploadfile uploadfile(HttpServletRequest request, MultipartFile img) {
		uploadfile result = new uploadfile();
		String filename = filename(img);
		String saveDirectory = request.getServletContext().getRealPath("resources/logoSP");
		if (img.isEmpty()) {
			result.code = false;
			result.message = "Chọn file cần upload";
			return result;
		} else {
			try {
				String path = saveDirectory + "/" + filename;
				System.out.println(path);
				img.transferTo(new File(path));

				result.code = true;
				result.message = null;
				result.filename = filename;
				return result;
			} catch (Exception e) {
				result.code = false;
				result.message = "Lỗi upload file";
				return result;
			}
		}
	}

}

