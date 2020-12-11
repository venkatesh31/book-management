package org.bookmanagement.repository;

import org.bookmanagement.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {

    List<BookEntity> findByCategoryId(Integer categoryId);
}
