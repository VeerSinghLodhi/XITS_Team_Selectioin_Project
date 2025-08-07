package com.example.TeamSelectionProject.StudentPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student>findByCaptainId(Long captainId);
//    long countByCaptainId(Long captainId);

}
