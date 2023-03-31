package multiShopJava.SpringMVC.controller.admin;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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

@Controller(value = "categoryAdminController")
@RequestMapping(value = { "admin" })
public class categoryAdminController {

	@Autowired
	private loaisanphamDAO loaisanphamDAO;

	@Autowired
	private sanphamDAO sanphamDAO;

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)
	public ModelAndView listcategory(HttpServletRequest request) {
		List<loaisanpham> lsp = loaisanphamDAO.list();
		ModelAndView model = new ModelAndView("admin/listcategory");
		model.addObject("listcategory", lsp);
		return model;
	}

	@RequestMapping(value = { "/addCategory" }, method = RequestMethod.GET)
	public ModelAndView addCategory(HttpServletRequest request, String uploadInfor, loaisanpham loaisanpham) {

		ModelAndView model = new ModelAndView("admin/addcategory");

		return model;
	}
	
	@RequestMapping(value = { "/addCategory" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String addCategory(HttpServletRequest request, @ModelAttribute("loaisanpham") loaisanpham lsp,


			@RequestParam("hinhanh") MultipartFile img,RedirectAttributes redirectAttributes) {

		// Upload file
		uploadfile hinhanhsp = uploadfile(request, img);
		if (hinhanhsp.code) {

			loaisanpham loaisanpham = new loaisanpham(lsp.getTENLOAISP(), lsp.isTRANGTHAI(), hinhanhsp.filename);
			try {
				
				loaisanphamDAO.save(loaisanpham);
				return "redirect:category";
			} catch (Exception e) {
				System.out.println(e);
				return "redirect:category";
			}

		} else {
			redirectAttributes.addFlashAttribute("listcategory", lsp);
			return "redirect:/addCategory";
			//return addCategory(request, hinhanhsp.message, lsp);
		}

	}
	@RequestMapping(value={"/detailcategory"},method = RequestMethod.GET)
	public ModelAndView detailcategory(@RequestParam int id,HttpServletRequest request ,loaisanpham loaisanpham) {
		loaisanpham lsp = loaisanphamDAO.getById(id);
		
		ModelAndView model = new ModelAndView("admin/detailcategory");
		model.addObject("category", lsp);
		return model;
	}
	@RequestMapping(value={"/editcategory"},method = RequestMethod.GET)
	public ModelAndView editcategory(@RequestParam int id,HttpServletRequest request ,loaisanpham loaisanpham) {
		loaisanpham lsp = loaisanphamDAO.getById(id);
		
		ModelAndView model = new ModelAndView("admin/editcategory");
		model.addObject("category", lsp);
		return model;
	}
	@RequestMapping(value = {"/editcategory"}, method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String editcategory(HttpServletRequest request,
			@RequestParam("hinhanh") MultipartFile img,RedirectAttributes redirectAttributes) {
		String name =  request.getParameter("TENLOAI");
		int id=  Integer.valueOf(request.getParameter("MALSP"));
		boolean isTT = Boolean.parseBoolean(request.getParameter("TRANGTHAI"));		
		
		// Upload file
		uploadfile hinhanhsp = uploadfile(request, img);
			

		
		if (hinhanhsp.code) {
			
			try {
				
				loaisanphamDAO.update(id,name,isTT,hinhanhsp.filename);
				return "redirect:category";
			} catch (Exception e) {
				System.out.println(e);
				return "redirect:category";
			}

		} else {
			
			return "redirect:/category";
			
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
		String saveDirectory = request.getServletContext().getRealPath("resources/HinhAnhSP");
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
