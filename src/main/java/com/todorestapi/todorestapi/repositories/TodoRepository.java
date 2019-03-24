package com.todorestapi.todorestapi.repositories;


import com.todorestapi.todorestapi.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    @Query("SELECT t FROM Todo t where t.list_Id = :id")
    List<Todo> findTodoListById(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Todo t SET t.completed = :completed WHERE t.id = :id")
    void checkTodoById(@Param("completed") Boolean completed, @Param("id") Long id);

}


