package br.com.unidac.breakfast.services;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unidac.breakfast.dto.FormRegister;

public interface IServiceCollaborator {

	public ModelAndView listEvents();
	
	public String save(FormRegister form, RedirectAttributes attributes);
	
	public String deleteCollaborator(Integer cpf);
}
