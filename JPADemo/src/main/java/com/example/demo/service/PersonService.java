package com.example.demo.service;

import com.example.demo.model.Person;

public interface PersonService 
{
	   Iterable<Person> listAllPersons();

	   Person getPersonById(Long id);

	   Person savePerson(Person product);

	    void deletePerson(Integer id);
}
