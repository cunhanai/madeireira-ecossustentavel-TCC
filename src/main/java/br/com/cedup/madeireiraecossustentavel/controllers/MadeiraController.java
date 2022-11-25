package br.com.cedup.madeireiraecossustentavel.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cedup.madeireiraecossustentavel.models.Madeira;
import br.com.cedup.madeireiraecossustentavel.models.Reflorestamento;
import br.com.cedup.madeireiraecossustentavel.models.User;
import br.com.cedup.madeireiraecossustentavel.repository.MadeiraRepository;
import br.com.cedup.madeireiraecossustentavel.repository.ReflorestamentoRepository;
import br.com.cedup.madeireiraecossustentavel.repository.UserRepository;

@Controller
public class MadeiraController {
	
	// INJECOES DE DEPENDENCIA
	
	@Autowired
	private MadeiraRepository madeiraRepository;
	
	@Autowired
	private ReflorestamentoRepository reflorestRepository;
	
	@Autowired
	private UserRepository ur;

	// METODOS
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView("dashboard/dashboard");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usuario = auth.getName();
		mv.addObject("nomeUser", ur.findByLogin(usuario).getNomeCompleto());
		
		Iterable<Madeira> madeiras = madeiraRepository.findAll();
		mv.addObject("madeiras", madeiras);
		
		Iterable<Reflorestamento> reflorestamento = reflorestRepository.findAll();
		mv.addObject("reflorestamento", reflorestamento);
		
		
		
		double nd = 0;
		for (Madeira madeira : madeiras) {
			nd += madeira.getQtdeMCubicos();
		}
		mv.addObject("nd", nd);
		
		double nr = 0;
		for (Reflorestamento reflo : reflorestamento) {
			nr += reflo.getQtdeMCubicos();
		}
		mv.addObject("nr", nr);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/cadastrar-madeira", method = RequestMethod.GET)
	public ModelAndView cadastrarMadeira() {
		ModelAndView mv = new ModelAndView("dashboard/cadastrarMadeira");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usuario = auth.getName();
		mv.addObject("nomeUser", ur.findByLogin(usuario).getNomeCompleto());
		
		return mv;
	}
	
	@RequestMapping(value = "/cadastrar-madeira", method = RequestMethod.POST)
	public String cadastrarMadeira(Madeira madeira, RedirectAttributes attributes) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usuario = auth.getName();
		User user = ur.findByLogin(usuario);
		
		madeira.setDataHora(LocalDateTime.now());
		madeira.calcularReflorestamento();
		madeira.setUserResp(user);
		
		madeiraRepository.save(madeira);
		
		attributes.addFlashAttribute("mensagem", "Madeira cadastrada com sucesso!");
		
		return "redirect:/cadastrar-madeira";
	}
	
	
	@RequestMapping(value = "/cadastrar-reflorestamento", method = RequestMethod.GET)
	public ModelAndView cadastrarReflorestamento() {
		ModelAndView mv = new ModelAndView("dashboard/informarReflorestamento");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usuario = auth.getName();
		mv.addObject("nomeUser", ur.findByLogin(usuario).getNomeCompleto());
		
		return mv;
	}
	
	@RequestMapping(value = "/cadastrar-reflorestamento", method = RequestMethod.POST)
	public String cadastrarReflorestamentoPost(Reflorestamento reflorestamento, RedirectAttributes attributes) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usuario = auth.getName();
		User user = ur.findByLogin(usuario);
		
		reflorestamento.setDataHora(LocalDateTime.now());
		reflorestamento.setUserResp(user);
		
		reflorestRepository.save(reflorestamento);
		
		attributes.addFlashAttribute("mensagem", "Reflorestamento cadastrado com sucesso!");
		
		return "redirect:/cadastrar-reflorestamento";
	}
	
	@RequestMapping(value = "/madeira", method = RequestMethod.GET)
	public ModelAndView registroMadeiras() {
		ModelAndView mv = new ModelAndView("madeira/registroMadeiras");
		Iterable<Madeira> madeiras = madeiraRepository.findAll();
		mv.addObject("madeiras", madeiras);
		return mv;
	}
	
}
