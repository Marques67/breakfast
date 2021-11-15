package br.com.unidac.breakfast.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.unidac.breakfast.models.Collaborator;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator, String> {
	
	Collaborator findByCpf(Integer cpf);
	
	String findByDescription(String description);
}
