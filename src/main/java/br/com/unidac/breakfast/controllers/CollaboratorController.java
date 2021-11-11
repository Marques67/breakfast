package br.com.unidac.breakfast.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public Optional<Collaborator> save(@Valid Collaborator collaborator) {
		Optional<Collaborator> coll = Optional.ofNullable(cr.findByCpf(collaborator.getCpf()));
		if (coll.isPresent()) {
			return Optional.ofNullable(null);
		}
		
		cr.save(collaborator);
		return Optional.empty();
	}
	
	@RequestMapping("/deleteCollaborator")
    public String deleteCollaborator(Integer cpf) {
        Collaborator collaborator = cr.findByCpf(cpf);
        cr.delete(collaborator);
        return "redirect:/";
    }
}
