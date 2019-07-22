package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController 
{
	@Autowired
	PersonService service;
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
	 @GetMapping
	 public ResponseEntity<List<Person>> getAllPersons() {
	        List<Person> list = (List<Person>) service.listAllPersons();
	 
	        return new ResponseEntity<List<Person>>(list, new HttpHeaders(), HttpStatus.OK);
	 }
	 @GetMapping("/{id}")
	 public ResponseEntity<Person> getBiId(@PathVariable("id") Long id) {
	        Person list = service.getPersonById(id);
	 
	        return new ResponseEntity<Person>(list, new HttpHeaders(), HttpStatus.OK);
	 }
	
	@PostMapping(value = "/addperson")
	 public ResponseEntity<Person> savePerson(Person person)
	 {
		 System.out.println(person.getName());
		 person.setName("Ann");
		 person.setCountry("Germany");
		 Person list = service.savePerson(person);
		 return new ResponseEntity<Person>(list, new HttpHeaders(), HttpStatus.OK);
	 }

}
