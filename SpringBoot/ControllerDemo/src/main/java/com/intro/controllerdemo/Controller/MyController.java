package com.intro.controllerdemo.Controller;

import com.intro.controllerdemo.Service.WebService;
import com.intro.controllerdemo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MyController {
    private final WebService webServe;
    @Autowired
    public MyController(WebService webServe){
        this.webServe = webServe;
    }
    @GetMapping("home")
    public String mainPage() {

        return "index";
    }
    @GetMapping("adder")
    public String adderPage(){
        return "addUser";
    }

    @GetMapping("remover")
    public String delPage(){return "delUser";}
    @PostMapping("add")
    public ModelAndView addUser(User user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("status","User Added Successfully");
        mv.addObject("user",webServe.addUser(user));
        mv.setViewName("process");
        return mv;
    }

    @PostMapping("delete")
    public ModelAndView deleteUser(@RequestParam("id") int Id){
        ModelAndView mv = new ModelAndView();
        if(!webServe.deleteUser(Id)){
            mv.addObject("status","User not found, Deletion unsuccessful");
        }
        else{
            mv.addObject("status","Deletion successful");
        }
        mv.setViewName("process");
        return mv;
    }

    @GetMapping("users")
    public ModelAndView render(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",webServe.getAll());
        mv.setViewName("Users");
        return mv;
    }

    @GetMapping("/processData/{userId}")
    public String updateUser(@PathVariable int userId, Model model){
        User u = webServe.getUser(userId);
        ModelAndView mv = new ModelAndView();
        model.addAttribute("oldId",userId);
        model.addAttribute("oldName",u.getName());
        model.addAttribute("oldEmail",u.getEmail());
        return "updateUser";
    }
    @PostMapping("/update")
    public ModelAndView updateUser(User user){
        webServe.addUser(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("status","User Upated Successfully");
        mv.setViewName("process");
        return mv;
    }

}
