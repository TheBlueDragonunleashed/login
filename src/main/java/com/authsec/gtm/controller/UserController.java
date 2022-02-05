package com.authsec.gtm.controller;


import com.authsec.gtm.entity.Use;
import com.authsec.gtm.entity.User;
import com.authsec.gtm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    //handler method to handle list students and return mode and view



    @GetMapping("/registerUser")
    public String listStudents(Model model)
    {
        model.addAttribute("Usersbro",new User());


        return "registerUserPage";
    }

    @PostMapping("/registerUser")
    public String PostRegister( @ModelAttribute("Usersbro") User user, Model model )

    {
        System.out.println("yesh ma khas return Type Student chai kna xa Why??");
        System.out.println(user.getEmail());
        System.out.println(user.getFirstname());
        user.setPassword(user.getPassword());

        userRepository.save(user);

        return "home";
    }


    @GetMapping("/")
    public String home()
    {
        return "home";
    }

  @GetMapping("/hey")
    public String hom2e(Model model)
    {

                Use student= new Use();
        model.addAttribute("s",student);
        return "login";
    }


    @GetMapping("/welcome")
    public String hom3e()
    {
        return "welcome";
    }



    @PostMapping("/register")
    public String PostRegister(User user)

    {
        System.out.println("yesh ma khas return Type Student chai kna xa Why??");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());


        return "welcome";
    }




    //   @GetMapping("/students/new")
//    public String createStudent(Model model)
//    {

//        return "edit_student";
//    }

//    @PostMapping("/heythere")
//    public String show(@ModelAttribute Student student)
//    {
//        System.out.println(student.getEmail());
//        return "index";
//    }
//
//

//   @GetMapping("/students/new")
//    public String createStudent(Model model)
//    {
//        Student student= new Student();
//        model.addAttribute("s",student);
//        return "edit_student";
//    }
//
//    @GetMapping("/students/edit/{id}")
//    public String editStudent(@PathVariable Long id, Model model)
//    {
//
//        model.addAttribute("s",studentService.getStudentById(id));
//        return "create_student";
//    }
//    @GetMapping("/students/delete/{id}")
//    public String deleteStudent(@PathVariable Long id,Student student)
//    {
//
//        Student prevailingstud = studentService.getStudentById(id);
//        studentService.deleteStudent(prevailingstud);
//        System.out.println(studentService.deleteStudent(prevailingstud));
//        return "redirect:/students";
//    }
//
//    @PostMapping("/students/{id}")
//    public String editStudent(@PathVariable Long id,@ModelAttribute("stud") Student student, Model model )
//
//    {
//        Student prevailingstud = studentService.getStudentById(id);
//        prevailingstud.setId(id);
//        prevailingstud.setFirstname(prevailingstud.getFirstname());
//        prevailingstud.setLastname(prevailingstud.getLastname());
//        prevailingstud.setEmail(prevailingstud.getEmail());
//
//
//        System.out.println("yesh ma khas return Type Student chai kna xa Why??");
//        System.out.println(studentService.updateStudent(prevailingstud));
//
    //  studentService.updateStudent(prevailingstud);
//        return "redirect:/students";
//    }
//
//    @PostMapping("/students")
//    public String saveStudent(@ModelAttribute("s") Student student)
//    {
//        System.out.println("yoo post mapping chalexena");
//        studentService.saveStudent(student);
//        System.out.println(studentService.saveStudent(student));
//
//        return "redirect:/students";
//    }




}
