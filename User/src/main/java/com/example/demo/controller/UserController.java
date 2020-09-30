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
    public String addUser(@Valid User user, BindingResult result, Model model) {
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
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result,
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
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userepository.delete(user);
        model.addAttribute("user", userepository.findAll());
        return "index";
    }
}

