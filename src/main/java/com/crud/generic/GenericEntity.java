package com.crud.generic;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericEntity<ID>	{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public ID id;

	public GenericEntity() {
		super();
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
