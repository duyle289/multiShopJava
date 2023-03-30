package multiShopJava.SpringMVC.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminController")
@RequestMapping(value={"admin"})
public class adminController {
	@RequestMapping(value={""},method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/index");
		return model;
	}
	
	
<<<<<<< HEAD
	//oke la
=======
	//test của Duy
>>>>>>> 69208fcd8f20a9467b288ab013770cc28e309671
}
