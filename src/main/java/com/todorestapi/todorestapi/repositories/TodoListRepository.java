package com.todorestapi.todorestapi.repositories;

import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.models.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {


    @Query("SELECT t FROM TodoList t where t.UserId = :id")
    List<TodoList> findUserTodoListById(@Param("id") Long id);

}
