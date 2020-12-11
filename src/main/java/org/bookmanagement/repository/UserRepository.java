package org.bookmanagement.repository;

import org.bookmanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserNameAndPassword(String userName,String password);
}
