package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.Student;
import rikkei.academy.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public String showListStudent(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("listStudent", studentList);
        return "student/list";
    }
    @PostMapping("/search")
    public String showListSearch(Model model, @RequestParam("search") String search){
        List<Student> studentList = studentService.findByNameStatic(search);
        model.addAttribute("listStudent", studentList);
        return "student/list";
    }
    @GetMapping("/create")
    public  String showCreateForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "student/create";
    }
    @PostMapping("/create")
    public String actionCreateStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable Long id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        return "student/delete";
    }
    @PostMapping("/delete")
    public  String actionDelete(@ModelAttribute("student") Student student){
        studentService.deleteById(student.getId());
        return "redirect:/";
    }
}
