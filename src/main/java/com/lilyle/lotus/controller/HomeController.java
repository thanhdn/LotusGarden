package com.lilyle.lotus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lilyle.lotus.model.Customers;
import com.lilyle.lotus.service.CustomerService;

@Controller
public class HomeController {
    
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = { "/", "/index" })
    public String index(Model model) {
        model.addAttribute("customer", new Customers());
        return "index";
    }

    @RequestMapping(value = "/view-customer")
    public ModelAndView viewCustomer() {
        ModelAndView model = new ModelAndView();
        model.addObject("listCustomer", customerService.findAll());
        model.setViewName("view-customer");
        return model;
    }
    
    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    public ModelAndView doAddEmployee(@ModelAttribute("customer") Customers customer, BindingResult result) {
        customerService.save(customer);
        ModelAndView model = new ModelAndView("redirect:/view-customer");
        return model;
    }
}
