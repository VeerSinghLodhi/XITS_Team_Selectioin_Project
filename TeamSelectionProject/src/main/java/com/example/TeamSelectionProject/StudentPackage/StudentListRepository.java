package com.example.TeamSelectionProject.StudentPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentListRepository extends JpaRepository<StudentList,Integer> {

    @Query(value = "SELECT * FROM StudentList ORDER BY sid LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<StudentList> getPaginated(@Param("limit") int limit, @Param("offset") int offset);

}
