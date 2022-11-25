package br.com.cedup.madeireiraecossustentavel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cedup.madeireiraecossustentavel.models.User;
import br.com.cedup.madeireiraecossustentavel.repository.UserRepository;

@Controller
public class IndexController {

	// BEANS
	
	@Autowired
	private UserRepository userRepository;
	
//	@RequestMapping("/")
//	public String index() {
//		return "index.html" ;
//	}
	
	@RequestMapping("/")
	public String redirectIndex() {
		
		String redirect;
		
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			redirect = "dashboard";
		} catch (Exception e) {
			redirect = "login";
		}
		
		return "redirect:/" + redirect;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.html";
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrar() {
		
		return "cadastro.html";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(User user, RedirectAttributes attributes) {
		
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		userRepository.save(user);
		
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
		
		return "redirect:/login";
	}
}
