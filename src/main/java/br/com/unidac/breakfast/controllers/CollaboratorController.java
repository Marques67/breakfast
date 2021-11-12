package br.com.unidac.breakfast.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unidac.breakfast.models.Collaborator;
import br.com.unidac.breakfast.repositories.CollaboratorRepository;

@Controller
public class CollaboratorController {

	@Autowired
	CollaboratorRepository cr;
	
	@RequestMapping("/registerItem")
	public String register() {
		return "/registerItem";
	}
	
	@RequestMapping("/")
    public ModelAndView listEvents() {
        ModelAndView mv = new ModelAndView("index.html");
        Iterable<Collaborator> collaborators = cr.findAll();
        mv.addObject("collaborators", collaborators);
        return mv;
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Collaborator collaborator, BindingResult result, RedirectAttributes attributes) {
		//Optional<Collaborator> coll = Optional.ofNullable(cr.findByCpf(collaborator.getCpf()));
		//if (coll.isPresent()) {
		//	return "redirect:/";
		//}
		
		if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Verifique os campos!");
            return "redirect:/";
        }
		
		cr.save(collaborator);
		attributes.addFlashAttribute("message", "Cadastrado com sucesso!");
		return "redirect:/registerItem";
	}
	
	@RequestMapping("/deleteCollaborator")
    public String deleteCollaborator(Integer cpf) {
        Collaborator collaborator = cr.findByCpf(cpf);
        cr.delete(collaborator);
        return "redirect:/";
    }
}
