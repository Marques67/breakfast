package br.com.unidac.breakfast.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class FormRegister {

	@NotBlank
	private String name;
	
	@Column(nullable = false, unique = true)
	@Id
	private Integer cpf;
	
	@Column(nullable = false, unique = true)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
