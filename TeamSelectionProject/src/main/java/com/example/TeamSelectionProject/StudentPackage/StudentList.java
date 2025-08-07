package com.example.TeamSelectionProject.StudentPackage;

import jakarta.persistence.*;

@Entity
@Table(name="studentList")
public class StudentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;
    private String studentname;

    public StudentList() {
    }

    public StudentList(int sid, String studentname) {
        this.sid = sid;
        this.studentname = studentname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
}
