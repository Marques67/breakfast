package br.com.unidac.breakfast.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unidac.breakfast.dto.FormRegister;
import br.com.unidac.breakfast.models.Collaborator;
import br.com.unidac.breakfast.models.Items;
import br.com.unidac.breakfast.repositories.CollaboratorRepository;
import br.com.unidac.breakfast.repositories.ItemsRepository;
import br.com.unidac.breakfast.services.IServiceCollaborator;

@Service
public class ServiceCollaborator implements IServiceCollaborator {

	@Autowired
	CollaboratorRepository cr;
	
	@Autowired
	ItemsRepository ir;
	
	@Override
	public ModelAndView listEvents() {
		 ModelAndView mv = new ModelAndView("index.html");
	     Iterable<Collaborator> collaborators = cr.findAll();
	     mv.addObject("collaborators", collaborators);
	     return mv;
	}
	
	// return repository.findById(id)
	//    .orElseThrow(() -> new EntityNotFoundException(id));
	
	@Override
	public String save(FormRegister form, RedirectAttributes attributes) {
		
		
//		Optional<Coll> register = cr.findByCpf(form.getCpf());
//		if (register.isPresent()) {
//			attributes.addFlashAttribute("message", "Cpf já cadastrado!");
//			return "redirect:/";
//		}	
		
		Collaborator collaborator = new Collaborator();
		collaborator.setCpf(form.getCpf());
		collaborator.setName(form.getName());
		
		Items items = new Items();
		items.setDescription(form.getDescription());
				
		ir.save(items);
				
		collaborator.setDescription(items.getDescription());
		
		cr.save(collaborator);
		attributes.addFlashAttribute("message", "Cadastrado com sucesso!");
		return "redirect:/registerItem";
	}

	@Override
	public String deleteCollaborator(Integer cpf) {
		Collaborator collaborator = cr.findByCpf(cpf);
		cr.delete(collaborator);
		return "redirect:/";
	}
}