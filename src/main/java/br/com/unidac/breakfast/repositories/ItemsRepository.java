package br.com.unidac.breakfast.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.unidac.breakfast.models.Items;

@Repository
public interface ItemsRepository extends CrudRepository<Items, String>{

	public void findByDescription(String description);
}
