package com.rhm.demo.services;

import com.rhm.demo.models.Person;
import com.rhm.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final  PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return (Person) this.personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person newPerson) {
        return this.personRepository.save(newPerson);
    }


    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }


    public List<Person> getUnlicensedPeople() {
        return personRepository.findByLicenseIdIsNull();
    }
}
