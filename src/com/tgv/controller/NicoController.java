package com.tgv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.tgv.pojo.Nico;

@Controller
public class NicoController {

	@RequestMapping("/nico")
	public String showNico(Model model) {
		Nico nico = new Nico();
		model.addAttribute("nico", nico);
		return "nico";
	}
}
