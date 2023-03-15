package com.jpa.examples.repository;

import com.jpa.examples.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person,Long> {
}
