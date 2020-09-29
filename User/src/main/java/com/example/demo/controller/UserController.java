package com.example.demo.controller;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;



import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;


//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//

@Controller
@RequestMapping("/users/")
public class UserController {

    private final UserRepository userepository;

    @Autowired
    public UserController(UserRepository userpository) {
        this.userepository = userpository;
    }

    @GetMapping("signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("user", userepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user"+user;
        }

        userepository.save(user);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	User user=  userepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user",user);
        return "update-student";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid User user, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userepository.save(user);
        model.addAttribute("user", userepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        User user = userepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userepository.delete(user);
        model.addAttribute("user", userepository.findAll());
        return "index";
    }
}
//
//@RestController
//public class UserController {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@RequestMapping(value = "/students/createUser", method = RequestMethod.POST)
//	public User createUser(@RequestBody User user) {
//		return userRepository.save(user);
//	}
//
//	@RequestMapping(value = "/students/findAllUser", method = RequestMethod.GET)
//	public List<User> findAllUser() {
//		return userRepository.findAll();
//	}
//
//	@RequestMapping(value = "/students/user/{id}", method = RequestMethod.DELETE)
//	public void deleteUser(@PathVariable int id) {
//		userRepository.deleteById(id);
//	}
//	
////	@GetMapping("edit/{id}")
//	@RequestMapping(value = "/students/edit/{id}", method = RequestMethod.GET)
//    public String showUpdateForm(@PathVariable("id") int id, Model model) {
//        
////            .orElseThrow(() - > new IllegalArgumentException("Invalid student Id:" + id));
//        model.addAttribute("student", userRepository.findById(id));
//        return "update-student";
//    }
//
////    @PostMapping("/students/update/{id}")
//    @RequestMapping(value = "/students/update/{id}", method = RequestMethod.POST)
//    public String updateStudent(@PathVariable("id") int id, @Valid User user, BindingResult result,
//        Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-student";
//        }
//
//        userRepository.save(user);
//        model.addAttribute("students", userRepository.findAll());
//        return "index";
//    }
//	
//}
