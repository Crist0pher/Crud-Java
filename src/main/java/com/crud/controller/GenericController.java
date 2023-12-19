package com.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.entity.GenericEntity;
import com.crud.service.GenericService;

public abstract class GenericController<ID, Model extends GenericEntity<ID>, Repository extends JpaRepository<Model, ID>, Service extends GenericService<ID, Model, Repository>> {

	@Autowired
	GenericService<ID, Model, Repository> service;

	@PostMapping
	public ResponseEntity<Model> create(@RequestParam Model model) {
		service.save(model);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Model> read(@RequestParam ID id) {

		Optional<Model> model = service.read(id);
		if(model.isPresent()) {
			return new ResponseEntity<Model>(model.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Model> update(@RequestParam Model model, @PathVariable ID id){
		service.save(model);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	@PostMapping("/delete/{id}")
	public ResponseEntity<Model> delete(@PathVariable ID id){
		service.delete(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}