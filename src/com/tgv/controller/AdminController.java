/**
 * 
 */
package com.tgv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tgv.pojo.Admin;

/**
 * @author jperedo
 *
 */
@Controller
public class AdminController {

	@RequestMapping("/admin")
	/*
	 * Model es una interface que usaremos para poder ingresar
	 * parametros, es valido solo para este metodo, no podremos enviar estos 
	 * a otro metodo, por ejemplo about
	 */
	public String Administrador(Model model, @ModelAttribute("resultado") String resultado) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		return "administrador";
	}
	
	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
	public String handlAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra, @RequestParam("fuera") String fuera) {
		model.addAttribute("adminForm", adminForm);
		System.out.println("Esto es lo que se graba: "+ adminForm);
		System.out.println("El request param que recibo es "+ fuera);
		ra.addFlashAttribute("resultado", "Cambios Realizados con Éxito");
		
		return "redirect:/admin";
	}
}
