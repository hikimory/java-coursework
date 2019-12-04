package edu.javavt17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "index";
    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String printJpa(ModelMap model) {
        return "about";
    }
}