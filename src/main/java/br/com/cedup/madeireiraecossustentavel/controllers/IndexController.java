package br.com.cedup.madeireiraecossustentavel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	
	@RequestMapping("/")
	public String index() {
		return "index.html" ;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.html";
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("cadastro.html");
		
		return mv;
	}
}
