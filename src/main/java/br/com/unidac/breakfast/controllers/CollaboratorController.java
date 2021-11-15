package br.com.unidac.breakfast.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unidac.breakfast.dto.FormRegister;
import br.com.unidac.breakfast.repositories.CollaboratorRepository;
import br.com.unidac.breakfast.services.impl.ServiceCollaborator;

@Controller
public class CollaboratorController {

	@Autowired
	CollaboratorRepository cr;
	
	@Autowired
	ServiceCollaborator sc;
		
	@RequestMapping("/registerItem")
	public String register() {
		return "/registerItem";
	}
	
	@RequestMapping("/")
    public ModelAndView listEvents() {
	     return sc.listEvents();
    }
		
	@RequestMapping(value = "/registerItem", method = RequestMethod.POST)
	public String save(FormRegister form, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Verifique os campos!");
            return "redirect:/";
        }
		
		return sc.save(form, attributes);
	
	}
	
	@RequestMapping("/deleteCollaborator")
    public String deleteCollaborator(Integer cpf) {
        return sc.deleteCollaborator(cpf);
    }
}