package com.todorestapi.todorestapi.controllers;

import com.todorestapi.todorestapi.consts.Consts;
import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.models.TodoList;
import com.todorestapi.todorestapi.repositories.TodoListRepository;
import com.todorestapi.todorestapi.repositories.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Consts.BASE_TODOLIST_URL)
@CrossOrigin
public class TodoListController {

    private TodoListRepository todoListRepository;

    public TodoListController(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }



    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoList> getTodoListById(@PathVariable Long Id){
        return todoListRepository.findUserTodoListById(Id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList saveTodoList(@RequestBody TodoList todolist){
        return todoListRepository.save(todolist);
    }


    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean deleteTodoListById(@PathVariable Long Id){
        todoListRepository.deleteById(Id);
        return true;
    }


}
