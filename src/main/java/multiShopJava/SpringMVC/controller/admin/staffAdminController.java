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

import multiShopJava.SpringMVC.dao.nhanvienDAO.nhanvienDAO;
import multiShopJava.SpringMVC.dao.loaisanphamDAO.loaisanphamDAO;
import multiShopJava.SpringMVC.dao.mausacDAO.mausacDAO;
import multiShopJava.SpringMVC.dao.nhasanxuatDAO.nhasanxuatDAO;
import multiShopJava.SpringMVC.dao.sanphamDAO.sanphamDAO;
import multiShopJava.SpringMVC.MD5;
import multiShopJava.SpringMVC.dao.chitietspDAO.chitietspDAO;
import multiShopJava.SpringMVC.model.nhanvien;
import multiShopJava.SpringMVC.model.chitietsp;
import multiShopJava.SpringMVC.model.khachhang;
import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.nhasanxuat;
import multiShopJava.SpringMVC.model.sanpham;
import multiShopJava.SpringMVC.model.uploadfile;

@Controller(value = "staffAdminController")
@RequestMapping(value = {"admin"})

public class staffAdminController {
	
	@Autowired
	private nhanvienDAO nhanvienDAO;
	
	@RequestMapping(value = { "/staff" }, method = RequestMethod.GET)
	public ModelAndView listProduct(HttpServletRequest request) {
		List<nhanvien> st = nhanvienDAO.list();
		ModelAndView model = new ModelAndView("admin/liststaff");
		model.addObject("listStaff", st);
		return model;
	}
	@RequestMapping(value = { "/addStaff" }, method = RequestMethod.GET)
	public ModelAndView addStaff(nhanvien nv) {
		ModelAndView model = new ModelAndView("admin/addStaff");
		return model;
	}
	@RequestMapping(value = { "/addStaff" }, method = RequestMethod.POST)
	public String addStaff(HttpServletRequest request,@ModelAttribute("nhanvien")nhanvien nv,RedirectAttributes redirectAttributes ) {
		boolean isStaffExist = isStaffExist(nv,redirectAttributes);
		
		if (isStaffExist) {
			redirectAttributes.addFlashAttribute("nhanvien", nv);
			return "redirect:addStaff";
		}else {
			nhanvien staff = new nhanvien(nv.getTENNV(),nv.getUSERNAME(),MD5.getMd5(nv.getPASSWORD()),nv.getSDT(),nv.getCCCD(),nv.getEMAIL(),true);
			nhanvienDAO.save(staff);
			return "redirect:staff";
		}
	}
	public boolean isStaffExist(nhanvien nv,RedirectAttributes redirectAttributes) {
		List<nhanvien> listStaff = nhanvienDAO.list();
		boolean userexist = listStaff.stream().anyMatch(s -> s.getUSERNAME().equals(nv.getUSERNAME()));
		boolean emailexist = listStaff.stream().anyMatch(s -> s.getEMAIL().equals(nv.getEMAIL()));
		boolean sdtexist = listStaff.stream().anyMatch(s -> s.getSDT().equals(nv.getSDT()));
		boolean cccdexist = listStaff.stream().anyMatch(s -> s.getCCCD().equals(nv.getCCCD()));
		if (userexist) {
			redirectAttributes.addFlashAttribute("errorMessageUsername", "Tên tài khoản đã tồn tại");
			return true;
		} else if (emailexist) {
			redirectAttributes.addFlashAttribute("errorMessageEmail", "Email đã được đăng ký mời nhập email khác");
			return true;
		} else if (sdtexist) {
			redirectAttributes.addFlashAttribute("errorMessageSDT", "SĐT đã được đăng ký mời nhập SĐT khác");
			return true;
		} else if (cccdexist) {
			redirectAttributes.addFlashAttribute("errorMessageCCCD", "CCCD đã được đăng ký mời nhập CCCD khác");
			return true;
		} else {
			return false;
		}
	}

	
	@RequestMapping(value = { "/editStaff" }, method = RequestMethod.GET)
	public ModelAndView suaNhanVien(@RequestParam int id) {
		nhanvien nv = nhanvienDAO.getById(id);
		ModelAndView model = new ModelAndView("admin/editStaff");
		model.addObject("nhanvien", nv);
	return model;
	}

		
	@RequestMapping(value = { "/editStaff" }, method = RequestMethod.POST)
	public String editStaff(HttpServletRequest request,@ModelAttribute("nhanvien")nhanvien nv,RedirectAttributes redirectAttributes ) {
		boolean isStaffExist = isStaffExist(nv,redirectAttributes);
		int id=  Integer.valueOf(request.getParameter("ID"));
		String name= request.getParameter("TENNV");
		String email= request.getParameter("EMAIL");
		String sdt= request.getParameter("SDT");
		String cccd= request.getParameter("CCCD");
		String userName= request.getParameter("USERNAME");
		String Pass= request.getParameter("PASSWORD");
		System.out.println(nv.getTENNV());
		if (isStaffExist) {
		
			nhanvienDAO.update2( id,name,email,sdt, cccd,userName,MD5.getMd5(Pass));
			return "redirect:staff";
		}else {
			nhanvienDAO.update2( id,name,email,sdt, cccd,userName,MD5.getMd5(Pass));
			return "redirect:staff";
		}
	}
	


	





}
