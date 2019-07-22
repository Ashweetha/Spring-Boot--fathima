package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.MyRepository;

@Service
public class PersonServiceImpl implements PersonService 
{
	
	  private MyRepository repository;

	  @Autowired 	
	  public void setRepository(MyRepository repository) {
		this.repository = repository;
	   	}

	@Override
	public List<Person> listAllPersons() {
		// TODO Auto-generated method stub
		  List<Person> personList =(List<Person>) repository.findAll();
	         
	        if(personList.size() > 0) {
	            return personList;
	        } else {
	            return new ArrayList<Person>();
	        }
	}

	

	@Override
	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return repository.save(person);
	}

	@Override
	public void deletePerson(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Person> per=repository.findById(id);
		 if(per.isPresent())
			 	return per.get();
		 else
			 return null;
		}

}
