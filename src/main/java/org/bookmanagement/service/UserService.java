package org.bookmanagement.service;

import org.bookmanagement.entity.UserEntity;
import org.bookmanagement.repository.UserRepository;
import org.bookmanagement.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity validateUser(UserLoginRequest userLoginRequest){
        return userRepository.findByUserNameAndPassword(userLoginRequest.getUserName(), userLoginRequest.getPassword());

    }
}
