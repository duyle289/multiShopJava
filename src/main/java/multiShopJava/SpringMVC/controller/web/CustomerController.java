package multiShopJava.SpringMVC.controller.web;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import multiShopJava.SpringMVC.MD5;
import multiShopJava.SpringMVC.dao.khachhangDAO.khachhangDAO;
import multiShopJava.SpringMVC.model.khachhang;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Controller(value = "CustomerController")
@RequestMapping(value = { "Customer" })
public class CustomerController {
	@Autowired
	private khachhangDAO khachhangDAO;
	@Autowired
	private MailSender mailSender;

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession(true);
		khachhang kh = (khachhang) session.getAttribute("khachhang");
		if (kh != null) {
			session.setAttribute("khachhang", null);
		}
		return "redirect:/Home/";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, khachhang khachhang, ModelMap m) {
		ModelAndView model = new ModelAndView("web/register");
		return model;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(HttpServletRequest request, @ModelAttribute("khachhang") @Valid khachhang kh,
			BindingResult br, RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "web/register";
		} else {
			boolean isCustomerExist = isCustomerExist(kh, redirectAttributes);

			if (isCustomerExist) {
				redirectAttributes.addFlashAttribute("khachhang", kh);
				return "redirect:register";
			} else {
				khachhang customer = new khachhang(kh.getTENKH(), kh.getDIACHI(), kh.getUSERNAME(),
						MD5.getMd5(kh.getPASSWORD()), kh.getSDT(), kh.getCCCD(), kh.getEMAIL(), kh.getNGAYSINH(), true);
				khachhangDAO.save(customer);
				redirectAttributes.addFlashAttribute("Message",
						"Đăng ký thành công. Bạn đã có thể " + "<a href=\"/multiShopJava/login\">đăng nhập</a> ");
				return "redirect:register";
			}

		}

	}

	@RequestMapping(value = { "/forgotPassword" }, method = RequestMethod.GET)
	public String ForgotPassword(khachhang kh) {

		return "web/forgotPassword";
	}

	@RequestMapping(value = { "/forgotPassword" }, method = RequestMethod.POST)
	public String ForgotPassword(HttpServletRequest request, @ModelAttribute("khachhang") khachhang kh,
			BindingResult br, RedirectAttributes redirectAttributes) {

		khachhang cus = khachhangDAO.findByEmail(kh.getEMAIL());
		if (cus != null) {
			try {
				String newPassword = randomChar();
				cus.setPASSWORD(MD5.getMd5(newPassword));
				khachhangDAO.update(cus);
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("multishoplaptop@gmail.com");
				message.setTo(kh.getEMAIL());
				message.setSubject("Mật khẩu đăng nhập mới");
				message.setText("Đây là mail gởi từ website MultiShop \n Mật khẩu đăng nhập mới của bạn là: "
						+ newPassword
						+ "\n Sau khi đăng nhập thành công bạn nên thay đổi mật khẩu để tiện cho lần đăng nhập kế tiếp <3");
				mailSender.send(message);
				System.out.println("Sending text done!");
				redirectAttributes.addFlashAttribute("Message",
						"Đã gửi mật khẩu mới qua email được cung cấp. <a href=\"/multiShopJava/login\">Đăng nhập</a>");
				return "redirect:forgotPassword";
			} catch (Exception e) {
				System.out.println(e);
				redirectAttributes.addFlashAttribute("Message", "Có lỗiiii");
				return "redirect:forgotPassword";
			}

		} else {
			redirectAttributes.addFlashAttribute("Message", "Email không tồn tại");
			return "redirect:forgotPassword";
		}

	}

	public boolean isCustomerExist(khachhang kh, RedirectAttributes redirectAttributes) {
		List<khachhang> listcus = khachhangDAO.list();
		boolean userexist = listcus.stream().anyMatch(s -> s.getUSERNAME().equals(kh.getUSERNAME()));
		boolean emailexist = listcus.stream().anyMatch(s -> s.getEMAIL().equals(kh.getEMAIL()));
		boolean sdtexist = listcus.stream().anyMatch(s -> s.getSDT().equals(kh.getSDT()));
		boolean cccdexist = listcus.stream().anyMatch(s -> s.getCCCD().equals(kh.getCCCD()));
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

	public static String randomChar() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		char[] stringChars = new char[8];
		Random random = new Random();
		for (int i = 0; i < stringChars.length; i++) {
			stringChars[i] = chars.charAt(random.nextInt(chars.length()));
		}
		String finalString = new String(stringChars);
		return finalString;
	}
}
