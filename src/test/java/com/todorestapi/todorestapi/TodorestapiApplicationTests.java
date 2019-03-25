package com.todorestapi.todorestapi;

import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.repositories.TodoListRepository;
import com.todorestapi.todorestapi.repositories.TodoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodorestapiApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void getUserTodoList(TodoListRepository repository) {
        Assert.assertNull(repository.findUserTodoListById((long)1));
    }

    @Test
    public void getTodosinTodoLists(TodoRepository repository) {
        Assert.assertNull(repository.findTodoListById((long)1));
    }

    @Test
    public void saveTodo(TodoRepository repository) {
        Todo t1 = new Todo();
        t1.setTitle("Todo 1");
        Calendar d =  new GregorianCalendar();
        t1.setExpires(d.getTime());
        t1.setCreateDate(d.getTime());
        t1.setList_Id((long)1);
        t1.setCompleted(false);


        Assert.assertNull(repository.save(t1));
    }

}
