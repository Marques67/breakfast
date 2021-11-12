package br.com.unidac.breakfast.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Collaborator implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String name;
	
	@Id
	@NotBlank
	private Integer cpf;
	
	@NotBlank
	private Items description;
		
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

	public Items getDescription() {
		return description;
	}

	public void setDescription(Items description) {
		this.description = description;
	}
}
