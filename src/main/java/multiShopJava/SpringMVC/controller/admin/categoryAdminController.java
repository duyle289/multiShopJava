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
		List<loaisanpham> sp = loaisanphamDAO.list();
		ModelAndView model = new ModelAndView("admin/listcategory");
		model.addObject("listcategory", sp);
		return model;
	}
	@RequestMapping(value = { "/addCategory" }, method = RequestMethod.GET)
	public ModelAndView addCategory(HttpServletRequest request, String uploadInfor, loaisanpham loaisanpham) {

		ModelAndView model = new ModelAndView("admin/addcategory");

		return model;
	}

	@RequestMapping(value = { "/addCategory" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ModelAndView addCategory(HttpServletRequest request, @ModelAttribute("loaisanpham") loaisanpham lsp,

			@RequestParam("hinhanh") MultipartFile img) {

		// Upload file
		uploadfile hinhanhsp = uploadfile(request,img);
		if (hinhanhsp.code) {
//			String tenloai = request.getParameter("TENLOAISP");
			Boolean Trangthai =  Boolean.valueOf(request.getParameter("TRANGTHAI"));
			List<loaisanpham> lsp1 = loaisanphamDAO.list();
			
			loaisanpham loaisanpham = new loaisanpham("ok",Trangthai,hinhanhsp.filename );
			
			try {
				
				
				loaisanphamDAO.save(loaisanpham);
				return listcategory(request);
			}catch (Exception e) {
				System.out.println(e);
				return addCategory(request, "", loaisanpham);
			}
			
			
			
		} else {
			
			return addCategory(request, hinhanhsp.message, lsp);
		}

	}
	public String filename(MultipartFile img) {
		LocalDate t = LocalDate.now();
		Random rand = new Random();
		double double_random = rand.nextDouble() * 1000;
		String filename = t.toString() + "-" + double_random + "-" + img.getOriginalFilename();
		return filename;
	}
	public uploadfile uploadfile(HttpServletRequest request,MultipartFile img) {
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
