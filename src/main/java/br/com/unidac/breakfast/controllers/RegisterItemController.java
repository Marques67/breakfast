package br.com.unidac.breakfast.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterItemController {
	
	@RequestMapping("/registerItem")
	public String register() {
		return "/registerItem";
	}
}
