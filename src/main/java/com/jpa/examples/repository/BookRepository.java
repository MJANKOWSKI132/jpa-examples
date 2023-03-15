package com.jpa.examples.repository;

import com.jpa.examples.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {
}