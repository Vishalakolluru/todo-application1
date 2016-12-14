package com.akii.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.akii.model.Task;
import com.google.gson.Gson;





@Controller
public class TaskController {
	@Autowired
	com.akii.service.TaskService pd;
	@RequestMapping("/")
	public ModelAndView display()
	{
		ModelAndView m1=new ModelAndView("todo");
		return m1;		
	}
	//request mapping for all pages
	@RequestMapping("/todo")
	public ModelAndView display1()
	{
		ModelAndView m1=new ModelAndView("todo");
		return m1;		
	}
	@RequestMapping("/addtask")
	public ModelAndView display2()
	{
		ModelAndView m2=new ModelAndView("addtask");
		m2.addObject("task", new Task());
        List tasks= pd.getTaskList();
        m2.addObject("tasks", tasks);
		return m2;		
	}
	@RequestMapping("/edittask")
	public ModelAndView display3()
	{
		ModelAndView m3=new ModelAndView("edittask");
		return m3;		
	}
	@RequestMapping("/RetriveTASK")
	public ModelAndView display5()
	{
		ModelAndView m1=new ModelAndView("RetriveTASK");
		return m1;		
	}
	@RequestMapping("/Dashboard")
	public ModelAndView display4()
	{
		ModelAndView m1=new ModelAndView("Dashboard");
		return m1;		
	}
	
	//adding model attribute
	@ModelAttribute("Task")
	public Task addtask(){
		return new Task();
	}
	//creating  a task
	@RequestMapping(value="storetask",method=RequestMethod.POST)
	public ModelAndView addtask(HttpServletRequest request,@Valid @ModelAttribute("Task")Task task,BindingResult result)
	       {
	 System.out.println("values are successfully inserted");
	        pd.addTask(task);
	    	return new ModelAndView("RetriveTASK");
      }
	//editing or updating
	@RequestMapping(value="/update",method=RequestMethod.POST)
    public ModelAndView updateChair(HttpServletRequest request,@Valid @ModelAttribute("Task")Task task,BindingResult result)
    {
        pd.updateTask(task);
    	return new ModelAndView("RetriveTASK");
    }
	//retrieving all
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
    public @ResponseBody String showList(){
    	List list=pd.getTaskList();
    	Gson x=new Gson();
    	String json=x.toJson(list);
    	return json;
    }

}
