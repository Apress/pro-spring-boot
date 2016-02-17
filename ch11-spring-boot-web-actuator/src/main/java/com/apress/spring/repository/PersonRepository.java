package com.apress.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apress.spring.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}