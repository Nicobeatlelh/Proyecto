/**
 * 
 */
package com.tgv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tgv.pojo.Admin;
import org.tgv.service.AdminService;

/**
 * @author jperedo
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminservice;

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
		List<Admin> admins= adminservice.buscarTodos();
		model.addAttribute("admins", admins);
		return "administrador";
	}
	
	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
//	Se puede pasar un @RequestParam("fuera") String fuera para pasar un valor que no es parte del objeto(POJO)
	public String handlAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra) {
		model.addAttribute("adminForm", adminForm);
		System.out.println("Esto es lo que se graba: "+ adminForm);
//		System.out.println("El request param que recibo es "+ fuera);
		if(adminForm.getIdAd()!=0) {
			adminservice.actualizar(adminForm);
		}else {
		if(adminservice.save(adminForm)) {
			ra.addFlashAttribute("resultado", "Se han guardado los datos correctamente");
		}else {
			ra.addFlashAttribute("resultado", "No se han guardado los datos correctamente");
		}
		}
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/admin/{idAd}/actualizar",method=RequestMethod.GET)
//	Se puede pasar un @RequestParam("fuera") String fuera para pasar un valor que no es parte del objeto(POJO)
	public String actualizar(Model model, @PathVariable("idAd") int idAd,  RedirectAttributes ra) {
		if(adminservice.buscarXId(idAd)!=null) {
			Admin admin1 = adminservice.buscarXId(idAd);
			model.addAttribute("admin",admin1);
		}else {
			ra.addFlashAttribute("resultado", "No se ha encontrado el Admin que se intenta actualizar");
		}
		return "administrador";
	}
	// /admin/${ item.idAd }/actualizar
	@RequestMapping(value="/admin/{idAd}/borrar",method=RequestMethod.GET)

	public String borrar(Model model, @PathVariable("idAd") int idAd,  RedirectAttributes ra) {
		if(adminservice.borrar(idAd)&&(idAd!=0)) {
			ra.addFlashAttribute("resultado", "El admin se borró correctamente");
		}else {
			ra.addFlashAttribute("resultado", "No se ha podido borrar el admin");
		}
		return "redirect:/admin";
	}
	
}
