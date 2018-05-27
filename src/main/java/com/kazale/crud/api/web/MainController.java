package com.kazale.crud.api.web;

import com.kazale.crud.api.documents.Student;
import com.kazale.crud.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web")
public class MainController {
    @Autowired
    private StudentService studentService;

    // Injectez (inject) de l'application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }
    @RequestMapping(value = { "/studentList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 //List<Student> students=new ArrayList<Student>();
        List<Student>  students=studentService.getAllStudents();
        model.addAttribute("students", students);

        return "studentList";
    }

    @RequestMapping(value = { "/addStudent" }, method = RequestMethod.GET)
    public String addStudentForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        return "addStudent";
    }

    @RequestMapping(value = { "/addStudent" }, method = RequestMethod.POST)
    public String addStudentSave(Model model, //
                                 @Valid @ModelAttribute("student") Student student,BindingResult bindingresult) {
        if (bindingresult.hasErrors()) {
             String error = "First Name & Last Name is required!";
            error+= "  or City must be not Empty";
             error+=" Email must be valid ";
            model.addAttribute("errorMessage", error);
            return "addStudent";
        }

        String name = student.getName();
        String email = student.getEmail();
        String city = student.getCity();

       // if (firstName != null && firstName.length() > 0 //
        //        && lastName != null && lastName.length() > 0) {
           Student newStudent = new Student(name,email,city);
        studentService.addStudent(newStudent);

            return "redirect:/web/studentList";
        }
      //  String error = "First Name & Last Name is required!";
      //  model.addAttribute("errorMessage", error);
       // return "addStudent";
    }

