package com.todorestapi.todorestapi.repositories;

import com.todorestapi.todorestapi.models.Todo;
import com.todorestapi.todorestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT t FROM User t where t.mail = :mail AND t.password= :pass")
    List<User> findUserByMailPass(@Param("mail") String mail,@Param("pass") String pass);

}
