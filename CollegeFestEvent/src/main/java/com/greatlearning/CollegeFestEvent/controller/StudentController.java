package com.greatlearning.CollegeFestEvent.controller;

import com.greatlearning.CollegeFestEvent.entity.Student;
import com.greatlearning.CollegeFestEvent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
	
		// get Students from db
		List<Student> theStudents = studentService.findAll();
		

		// add to the spring model
		theModel.addAttribute("students", theStudents);

		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("students", theStudent);

		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {

		// get the Students from the service
		Student theStudent = studentService.findById(theId);


		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("students", theStudent);

		// send over to our form
		return "student-form";
	}


	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {

		//System.out.println("id controller"+id);
		Student theStudent;
		if(id!=0)
		{
			theStudent=studentService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}
		else {
			theStudent = new Student(name, department, country);
		}

		// save the student
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the student
		studentService.deleteById(theId);

		// redirect to /students/list
		return "redirect:/students/list";

	}
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}


	
}


















