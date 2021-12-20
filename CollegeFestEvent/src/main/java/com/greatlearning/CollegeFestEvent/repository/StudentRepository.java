package com.greatlearning.CollegeFestEvent.repository;



import com.greatlearning.CollegeFestEvent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //select * from student where name like '%name' and country
   // List<Student> findByNameContainsAndCountryContainsAllIgnoreCase(String name, String country);

    //findBy  ==Jpa
    //Name= Student class field
   // contains= jpa
    // and = jpa
    //country=field

}
