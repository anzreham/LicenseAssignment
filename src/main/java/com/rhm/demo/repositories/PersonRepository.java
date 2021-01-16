package com.rhm.demo.repositories;

import java.util.List;

import com.rhm.demo.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    //SELECT * FROM DLs
    List<Person> findAll();
    @Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
    List<Person> findByNoLicense();

    List<Person> findByLicenseIdIsNull();
}