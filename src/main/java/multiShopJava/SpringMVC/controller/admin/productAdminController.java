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

@Controller(value = "productAdminController")
@RequestMapping(value = {"admin"})
public class productAdminController {
	
	@Autowired
	private sanphamDAO sanphamDAO;
	
	@Autowired
	private mausacDAO mausacDAO;
	@Autowired
	private loaisanphamDAO loaisanphamDAO;
	@Autowired
	private nhasanxuatDAO nhasanxuatDAO;
	@Autowired
	private chitietspDAO chitietspDAO;

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public ModelAndView listProduct(HttpServletRequest request) {
		List<sanpham> sp = sanphamDAO.list();
		ModelAndView model = new ModelAndView("admin/listproduct");
		model.addObject("listProduct", sp);
		return model;
	}

	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
	public ModelAndView addProduct(HttpServletRequest request,sanpham sp) {
		ModelAndView model = new ModelAndView("admin/addproduct");
		List<mausac> listms = mausacDAO.list();
		List<loaisanpham> listlsp = loaisanphamDAO.list();
		List<nhasanxuat> listnsx = nhasanxuatDAO.list();
		model.addObject("listms", listms);
		model.addObject("listlsp", listlsp);
		model.addObject("listnsx", listnsx);
		return model;
	}

	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String addProduct(HttpServletRequest request, @ModelAttribute("sanpham") sanpham sp,
			@RequestParam("hinhanh") MultipartFile img,RedirectAttributes redirectAttributes) {

		// Upload file
		uploadfile hinhanhsp = uploadfile(request,img);
		if (hinhanhsp.code) {
			int soluongton = Integer.parseInt(request.getParameter("SOLUONGTON"));
			
			loaisanpham lsp = loaisanphamDAO.getById(Integer.parseInt(request.getParameter("loaisanpham")));
			nhasanxuat nsx = nhasanxuatDAO.getById(Integer.parseInt(request.getParameter("nhasanxuat")));
			sanpham sanpham = new sanpham(sp.getTENSP(),sp.getDONGIA(),hinhanhsp.filename,sp.isTRANGTHAI(),sp.isSANPHAMMOI(),sp.isSPNOIBAT(),sp.getCAUHINH(),sp.getMOTA(),lsp,nsx);
			
			try {
				sanphamDAO.save(sanpham);
				String[] listms = request.getParameterValues("mausac");
				if (listms != null && listms.length > 0) {
					for(String mausp : listms) {
						mausac ms = mausacDAO.getById(Integer.parseInt(mausp));
						chitietsp ctsp = new chitietsp(soluongton,ms,sanpham);
						chitietspDAO.save(ctsp);
					}
				}else {
					System.out.println("lõiiiiiii");
					redirectAttributes.addFlashAttribute("message", "Có lỗi xảy ra");
				}
				return "redirect:product";
			}catch (Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("message", "Có lỗi xảy ra");
				return "redirect:addProduct";
			}
			
			
			
		} else {
			redirectAttributes.addFlashAttribute("sanpham", sp);
			redirectAttributes.addFlashAttribute("uploadInfor", hinhanhsp.message);
			return "redirect:addProduct";
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
