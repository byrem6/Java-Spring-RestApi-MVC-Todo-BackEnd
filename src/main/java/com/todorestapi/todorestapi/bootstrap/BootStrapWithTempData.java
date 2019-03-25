package com.todorestapi.todorestapi.bootstrap;

import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.models.TodoList;
import com.todorestapi.todorestapi.models.User;
import com.todorestapi.todorestapi.repositories.TodoListRepository;
import com.todorestapi.todorestapi.repositories.TodoRepository;
import com.todorestapi.todorestapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class BootStrapWithTempData implements CommandLineRunner {

    private TodoRepository todoRepository;
    private TodoListRepository todoListRepository;
    private UserRepository userRepository;

    public BootStrapWithTempData(TodoRepository todoRepository, TodoListRepository todoListRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        // TODO TEMP DATA ADD

        Calendar date =  new GregorianCalendar();

        Todo t1 = new Todo();
        t1.setTitle("Todo 1");
        t1.setExpires(date.getTime());
        t1.setCreateDate(date.getTime());
        t1.setList_Id((long)1);
        t1.setCompleted(false);


        Todo t2 = new Todo();
        t2.setTitle("Todo 2");
        t2.setExpires(date.getTime());
        t2.setCreateDate(date.getTime());
        t2.setList_Id((long)2);
        t2.setCompleted(false);

        Todo t3 = new Todo();
        t3.setTitle("Todo 3");
        t3.setExpires(date.getTime());
        t3.setCreateDate(date.getTime());
        t3.setList_Id((long)1);
        t3.setCompleted(false);


        todoRepository.save(t1);
        todoRepository.save(t2);
        todoRepository.save(t3);


        User u1 = new User();
        u1.setName("Ahmet Taş");
        u1.setMail("a@a.com");
        u1.setPassword("000");



        User u2 = new User();
        u2.setName("Mehmet Kaya");
        u2.setMail("b@b.com");
        u2.setPassword("000");


        userRepository.save(u1);
        userRepository.save(u2);



        TodoList l1 = new TodoList();
        l1.setTitle("Home");
        l1.setUserId((long)1);


        TodoList l2 = new TodoList();
        l2.setTitle("Work");
        l2.setUserId((long)1);


        todoListRepository.save(l1);
        todoListRepository.save(l2);



    }
}
