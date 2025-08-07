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
import java.util.Collections;
import java.util.List;

@Controller
public class SecondController {

    @Autowired
    StudentListRepository studentListRepository;

    @Autowired
    CaptainRepository captainRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("captains", new ArrayList<>());
        return "captain";
    }

    @PostMapping("/saveCaptains")
    public String saveCaptains(@RequestParam List<String> names) {
        for (String name : names) {
            captainRepository.save(new Captain(name));
        }
        return "redirect:/assign";
    }

    @GetMapping("/assign")
    public String showNextBatch(@RequestParam(defaultValue = "0") int page, Model model) {
        int limit = 3;
        int offset = page * limit;

        List<StudentList> studentBatch = studentListRepository.getPaginated(limit, offset);
        model.addAttribute("studentBatch", studentBatch);
        model.addAttribute("currentPage", page);

        model.addAttribute("students", studentRepository.findAll());
        List<Captain>captains=captainRepository.findTop3ByOrderByIdDesc();
        model.addAttribute("captains", captains);

        model.addAttribute("captain1Players", studentRepository.findByCaptainId(captains.get(0).getId()));
        model.addAttribute("captain2Players", studentRepository.findByCaptainId(captains.get(1).getId()));
        model.addAttribute("captain3Players", studentRepository.findByCaptainId(captains.get(2).getId()));
        if(studentBatch.isEmpty()){
            model.addAttribute("notStudentFound", true);
        }


        return "student";
    }
    @PostMapping("/assign")
    public String assignBatch(@RequestParam int page, RedirectAttributes redirectAttributes) {
        int limit = 3;
        int offset = page * limit;

        List<StudentList> batch = studentListRepository.getPaginated(limit, offset);
        List<Captain> captains = captainRepository.findTop3ByOrderByIdDesc();

        if (batch.isEmpty() || captains.size() < 3) {
            redirectAttributes.addFlashAttribute("error", "Nothing to assign or captains missing.");
            return "redirect:/assign?page=" + page;
        }

        Collections.shuffle(captains); // Randomize captain order

        for (int i = 0; i < batch.size(); i++) {
            Student s = new Student();
            s.setName(batch.get(i).getStudentname());
            s.setCaptain(captains.get(i % 3)); // 1 to each
            studentRepository.save(s);
        }

        redirectAttributes.addFlashAttribute("success", "Assigned 3 players.");
        return "redirect:/assign?page=" + (page + 1); // Load next 3
    }

}
