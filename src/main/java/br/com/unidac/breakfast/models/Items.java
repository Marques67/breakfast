package br.com.unidac.breakfast.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, unique = true)
	private String description;
	
	@ManyToOne
	private Collaborator collaborator;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	private Integer id;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
