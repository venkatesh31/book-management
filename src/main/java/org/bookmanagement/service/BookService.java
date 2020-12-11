package org.bookmanagement.service;

import org.bookmanagement.entity.BookEntity;
import org.bookmanagement.entity.CategoryEntity;
import org.bookmanagement.entity.UserEntity;
import org.bookmanagement.repository.BookRepository;
import org.bookmanagement.repository.CategoryRepository;
import org.bookmanagement.repository.UserRepository;
import org.bookmanagement.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Map<String,Object>> getBooks(){
        List<Map<String,Object>> returnList = new ArrayList<>();
        List<CategoryEntity> categoryList = categoryRepository.findAll();
        for(CategoryEntity categoryEntity: categoryList){
            Map<String,Object> bookData = new HashMap<>();
            List<BookEntity> bookList = bookRepository.findByCategoryId(categoryEntity.getCategoryId());
            if(bookList==null || bookList.isEmpty()){
                continue;
            }
            bookData.put("category",categoryEntity);
            bookData.put("books",bookList);
            returnList.add(bookData);
        }
        return returnList;
    }


}
