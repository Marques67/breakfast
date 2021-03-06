package br.com.unidac.breakfast.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Collaborator implements Serializable {
	private static final long serialVersionUID = 1L;

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
