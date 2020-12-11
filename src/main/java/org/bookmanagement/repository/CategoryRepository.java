package org.bookmanagement.repository;

import org.bookmanagement.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

    List<CategoryEntity> findAll();
}
