package com.todorestapi.todorestapi.controllers;

import com.todorestapi.todorestapi.consts.Consts;
import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.models.TodoList;
import com.todorestapi.todorestapi.models.User;
import com.todorestapi.todorestapi.repositories.TodoListRepository;
import com.todorestapi.todorestapi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Consts.BASE_USER_URL)
@CrossOrigin
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User Login(@RequestBody User user){

        List<User> userList = userRepository.findUserByMailPass(user.getMail(),user.getPassword());
        if (userList != null && userList.size()>0) {
            return userList.get(0);
        }
        else{
            return null;
        }
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public User saveUser(@RequestBody User user){
            return userRepository.save(user);
    }





}
