package org.jsp.controller;

import org.jsp.dao.UserDao;
import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names= {"u"})
public class Usercontroller {
     @Autowired
     private UserDao dao;
     
     @PostMapping("/save")
     public ModelAndView saveUser(ModelAndView view ,User user) {
    	 view.setViewName("print.jsp");
    	 user=dao.saveUser(user);
    	 view.addObject("msg", "user saved with id:"+user.getId());
    	 return view;
    	 }
    	 
     @PostMapping("/update")
     public ModelAndView update(ModelAndView view ,@ModelAttribute User user) {
    	 view.setViewName("print.jsp");
    	 user=dao.updateUser(user);
    	 view.addObject("u",user);
    	 view.addObject("msg", "user update with id:"+user.getId());
    	 view.setViewName("print.jsp");
    	 return view;
    	 }
     
     
     
     @PostMapping("/login")
     public ModelAndView login( @RequestParam long phone , @RequestParam String password) {
    	 User user =dao.verifyUser(phone, password);
    	 ModelAndView view = new ModelAndView();
    	 if(user!=null)
    	 {
    		 view.addObject("u",user);
    		 view.setViewName("home.jsp");
    		  return view;
    		  
    	 }else {
    		 view.addObject("msg","invalid phone nuber or password");
    		 view.setViewName("login.jsp");
    		  return view;
    	 }
    	 
     }
     
     @GetMapping("/delete")
    	     public ModelAndView deleteUser(@RequestParam int id, ModelAndView view ,@ModelAttribute User user) {
    	    	 boolean isDeleted = dao.deleteUser(id);
    	    	 
    	      if(isDeleted) {
    	    	  view.setViewName( "login.jsp");
    	    	  view.addObject("msg","you Account to delete");
    	    	  return view;
    	      } else {
    	    	  view.setViewName( "login.jsp");
    	    	  view.addObject("msg","you mustlogin to delete");
    	    	  return view;
    	      }
    	    	  
    	      }

     }
