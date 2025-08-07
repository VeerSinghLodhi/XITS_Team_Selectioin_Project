package com.example.TeamSelectionProject.CaptainPage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaptainRepository extends JpaRepository<Captain,Long> {

    List<Captain> findTop3ByOrderByIdDesc();
}
