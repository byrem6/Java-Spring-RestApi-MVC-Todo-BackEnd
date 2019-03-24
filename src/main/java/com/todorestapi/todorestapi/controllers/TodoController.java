package com.todorestapi.todorestapi.controllers;

import com.todorestapi.todorestapi.consts.Consts;
import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.repositories.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(Consts.BASE_TODO_URL)
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @CrossOrigin
    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos(@PathVariable Long Id){
        return todoRepository.findTodoListById(Id);
    }


    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo saveTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }


    @CrossOrigin
    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodoById(@PathVariable Long Id){
        todoRepository.deleteById(Id);
    }



    @Transactional
    @CrossOrigin
    @PatchMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public void CheckTodoById(@PathVariable Long Id,@RequestBody Todo todo){
        todoRepository.checkTodoById(todo.getCompleted(),Id);
    }


}
