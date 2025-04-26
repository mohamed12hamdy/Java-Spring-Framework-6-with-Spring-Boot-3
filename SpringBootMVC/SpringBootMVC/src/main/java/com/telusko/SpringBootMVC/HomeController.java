package com.telusko.SpringBootMVC;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
///this is not REST Controller this is EndPoint for MVC Project
/// you have both options model object and ModelAndView
/// can we have Model as attribute i think yes
/// you can skip @Modelattribute in 90 % of cases as you pass same name from Controller to view
public class HomeController {
    @RequestMapping("/")
    public String home(){
        System.out.println("home is called");
        return "index";
    }
    @RequestMapping("add")
    public ModelAndView CalculateSum(@RequestParam ("num1")int num1, @RequestParam ("num2")int num2, ModelAndView model){
        int calculationSum = num1 + num2;

        model.addObject("sum",calculationSum);
        model.setViewName("result");
        return model;
    }
    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien alien){

        return "result";
    }

}
