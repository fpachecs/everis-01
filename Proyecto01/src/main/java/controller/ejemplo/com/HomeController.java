package controller.ejemplo.com;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView login() throws Exception {
		
		ModelAndView model = new ModelAndView("Login");
		
		return model;
	}
	@RequestMapping(value="/Principal", method = RequestMethod.GET)
	public ModelAndView principal() throws Exception {
		
		ModelAndView model = new ModelAndView("Principal");
		
		return model;
	}
	
	
}
