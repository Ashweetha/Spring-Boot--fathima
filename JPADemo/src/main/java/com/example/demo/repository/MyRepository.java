package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface MyRepository extends CrudRepository<Person, Long>
{

	
}
