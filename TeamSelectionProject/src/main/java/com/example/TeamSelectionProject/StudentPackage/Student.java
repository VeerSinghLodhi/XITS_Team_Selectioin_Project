package com.example.TeamSelectionProject.StudentPackage;

import com.example.TeamSelectionProject.CaptainPage.Captain;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @Column(name="captain_id")
////    @ManyToOne
//    private int captainId ;
    @ManyToOne
    @JoinColumn(name = "captainid") // This is the key fix!
    private Captain captain;

    public Student() {
    }

    public Student(String name,Captain captain) {
        this.captain = captain;
        this.name = name;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }
}
