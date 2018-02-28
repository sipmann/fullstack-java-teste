package br.com.lemontech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lemontech.dao.ViagemDAO;
import br.com.lemontech.model.Viagem;
import br.com.lemontech.services.ViagemService;

/**
 * Controller de listagem de viagens. Responsável pela chamada do processo de
 * consulta ao webservice e encaminhamento do resultado ao processo de
 * persistencia em banco.
 * 
 * @author sipmann
 *
 */
@Controller
@RequestMapping("/viagens")
public class ViagemController {

	private final String viewName = "viagens/listagem";
	
	@Autowired
	private ViagemDAO dao;
	
	@Autowired
	private ViagemService viagemService;

	/**
	 * Realiza a chamada da consulta ao WS e encaminha os dados para o view
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listagem() throws Exception {
		List<Viagem> lst = viagemService.getViagens(3);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("listagem", lst);
		mv.setViewName(viewName);
		return mv;
	}

	/**
	 * Realiza a listagem diretamente do banco de dados.
	 * 
	 * @return
	 */
	@RequestMapping("/fromdb")
	public ModelAndView listagemFromDb() {
		List<Viagem> lst = dao.listar();
		ModelAndView mv = new ModelAndView();
		mv.addObject("listagem", lst);
		mv.setViewName(viewName);
		return mv;
	}
}
