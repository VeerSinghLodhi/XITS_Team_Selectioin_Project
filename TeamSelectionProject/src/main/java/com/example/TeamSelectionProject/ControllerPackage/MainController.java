package com.example.TeamSelectionProject.ControllerPackage;

import com.example.TeamSelectionProject.CaptainPage.Captain;
import com.example.TeamSelectionProject.CaptainPage.CaptainRepository;
import com.example.TeamSelectionProject.StudentPackage.Student;
import com.example.TeamSelectionProject.StudentPackage.StudentList;
import com.example.TeamSelectionProject.StudentPackage.StudentListRepository;
import com.example.TeamSelectionProject.StudentPackage.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    CaptainRepository captainRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentListRepository studentListRepository;

//    @GetMapping("/home")
//    public String homePage(Model model) {
//        model.addAttribute("captains", new ArrayList<>());
//        return "captain";
//    }

//    @PostMapping("/saveCaptains")
//    public String saveCaptains(@RequestParam List<String> names) {
//        for (String name : names) {
//            captainRepository.save(new Captain(name));
//        }
//        return "redirect:/students";
//    }

//    @GetMapping("/students")
//    public String studentPage(Model model) {
//        model.addAttribute("students", studentRepository.findAll());
//        List<Captain>captains=captainRepository.findTop3ByOrderByIdDesc();
//        model.addAttribute("captains", captains);
//
//        model.addAttribute("captain1Players", studentRepository.findByCaptainId(captains.get(0).getId()));
//        model.addAttribute("captain2Players", studentRepository.findByCaptainId(captains.get(1).getId()));
//        model.addAttribute("captain3Players", studentRepository.findByCaptainId(captains.get(2).getId()));
//        return "student";
//    }
//
//    @PostMapping("/addStudent")
//    public String addStudent(@RequestParam String studentName) {
//        List<Captain> captains = captainRepository.findTop3ByOrderByIdDesc();
//
//        List<Captain> availableCaptains = captains.stream().filter(captain -> studentRepository.countByCaptainId(captain.getId())<10).collect(Collectors.toList());
//
//        if (captains.isEmpty()) {
//            throw new IllegalStateException("No captains available!");
//        }
//
//        Captain randomCaptain = captains.get(new Random().nextInt(captains.size()));
//
//        Student student = new Student();
//        student.setName(studentName);
//        student.setCaptain(randomCaptain);
//        studentRepository.save(student);
//
//        return "redirect:/students";
//    }
//
//
//    @GetMapping("/assign-students")
//    public String assignThreeStudents(@RequestParam(defaultValue = "0") int page,
//                                      RedirectAttributes redirectAttributes) {
//
//        int pageSize = 3;
//        int offset = page * pageSize;
//
//        // 1. Get next 3 students
//        List<StudentList> batch = studentListRepository.getPaginated(pageSize, offset);
//
//        if (batch.isEmpty()) {
//            redirectAttributes.addFlashAttribute("error", "No more students to assign.");
//            return "redirect:/students";
//        }
//
//        // 2. Get latest 3 captains
//        List<Captain> captains = captainRepository.findTop3ByOrderByIdDesc();
//
//        if (captains.size() < 3) {
//            redirectAttributes.addFlashAttribute("error", "Not enough captains.");
//            return "redirect:/students";
//        }
//
//        // 3. Assign one student per captain
//        for (int i = 0; i < batch.size(); i++) {
//            Student student = new Student();
//            student.setName(batch.get(i).getStudentname());
//            student.setCaptain(captains.get(i % 3));
//            studentRepository.save(student);
//        }
//
//        // 4. Redirect to student list page
//        redirectAttributes.addFlashAttribute("success", "Assigned " + batch.size() + " students.");
//        return "redirect:/assign-students?page=" + (page + 1);
//    }
//

}
