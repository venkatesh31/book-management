package org.bookmanagement.controller;

import org.bookmanagement.entity.UserEntity;
import org.bookmanagement.request.UserLoginRequest;
import org.bookmanagement.response.CommonResponse;
import org.bookmanagement.service.BookService;
import org.bookmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<CommonResponse> get() {
        List<Map<String,Object>> returnList= bookService.getBooks();
       if(returnList==null || returnList.isEmpty()){
           CommonResponse response = new CommonResponse();
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
       }
        CommonResponse response = new CommonResponse();
       response.setData(returnList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
