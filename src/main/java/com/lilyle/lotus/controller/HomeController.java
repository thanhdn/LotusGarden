package com.lilyle.lotus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lilyle.lotus.model.Customers;
import com.lilyle.lotus.service.CustomerService;
import com.lilyle.lotus.validator.CustomerValidator;

@Controller
public class HomeController {
    
    @Autowired
    CustomerValidator validator;
    
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
    
    @RequestMapping(value = "/view-detail/{customerId}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable("customerId") String customerId, Model model) {
        if(!StringUtils.isEmpty(customerId)) {
            Customers cus = customerService.findById(Long.valueOf(customerId));
            model.addAttribute("detailCustomer", cus);
        }
        return "detail";
    }
    
    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    public String doAddEmployee(@ModelAttribute("customer") Customers customer, BindingResult result, Model model) {
        validator.validate(customer, result);
        if(result.hasErrors()) {
            return "index";
        }
        customerService.save(customer);
        return "redirect:/view-customer";
    }
}
