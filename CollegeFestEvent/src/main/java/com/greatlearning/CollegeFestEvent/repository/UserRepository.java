package com.greatlearning.CollegeFestEvent.repository;


import com.greatlearning.CollegeFestEvent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    //select * from User where username='jai'
    //@uery("select u from User where u.username=?1 and password=?2

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User getUserByUsername(String username);

}
