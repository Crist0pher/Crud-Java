package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<ID, Model, Repository extends JpaRepository<Model, ID>> {

	@Autowired
    protected Repository repository;
	
	public void save(Model model) {
		repository.save(model);
	}

	public Optional<Model> read(ID id){
		return repository.findById(id);
	}
	
	public List<Model> list(ID id){
		return repository.findAll();
	}
	
	
	public Model delete(ID id){
		Optional<Model> model = repository.findById(id);
		if(model.isPresent()) {
			repository.delete(model.get());
			return model.get();

		}
		return model.get();
	}
}
