package org.bookmanagement.controller;

import org.bookmanagement.entity.UserEntity;
import org.bookmanagement.request.UserLoginRequest;
import org.bookmanagement.response.CommonResponse;
import org.bookmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse> add(@RequestBody UserLoginRequest userLoginRequest) {
        UserEntity userEntity= userService.validateUser(userLoginRequest);
       if(userEntity==null){
           CommonResponse response = new CommonResponse();
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
       }
        CommonResponse response = new CommonResponse();
       response.setRecordinfo(userEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
