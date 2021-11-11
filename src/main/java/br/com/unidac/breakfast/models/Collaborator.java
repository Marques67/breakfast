package br.com.unidac.breakfast.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Collaborator {
	
	@NotBlank
	private String name;
	
	@Id
	@NotBlank
	private Integer cpf;
	
	@NotBlank
	private Items descriptionItems;
	
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

	public Items getDescriptionItems() {
		return descriptionItems;
	}

	public void setDescriptionItems(Items descriptionItems) {
		this.descriptionItems = descriptionItems;
	}
}
