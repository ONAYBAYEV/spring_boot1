package bitlabspringboot.techorda.controller;

import bitlabspringboot.techorda.db.DBManager;
import bitlabspringboot.techorda.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model ){
        ArrayList<Student> StudentArray= DBManager.getStudents();
        model.addAttribute("studentter",StudentArray);
        return "index";
    }
    @GetMapping(value = "/add")
    public String addPage(Model model ){
        ArrayList<Student> StudentArray= DBManager.getStudents();
        model.addAttribute("studentter",StudentArray);
        return "add-student";
    }

    @PostMapping(value = "/add-student")
    public String  addStudent(Student student){
        DBManager.addStudent(student);
        int examResult = student.getExam();
        String baga = "";

        if (examResult >= 90) {
            baga = "A";
        } else if (examResult >= 75) {
            baga = "B";
        } else if (examResult >= 60) {
            baga = "C";
        } else if (examResult >= 50) {
            baga = "D";
        } else {
            baga = "F";
        }

        student.setMark(baga);
        return "redirect:/";
    }
}
