package orm.pos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import orm.pos.entity.Employees;
import orm.pos.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
		
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
		
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
			
		List<Employees> theEmployees = employeeService.getEmployees();
			
		theModel.addAttribute("employees", theEmployees);
			
		return "list-employees";
	}
		
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
			
		Employees theEmployee = new Employees();
			
		theModel.addAttribute("employee", theEmployee);
			
		return "form-employee";
	}
		
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employees theEmployee,
			BindingResult theBindingResult, Model theModel) {
			
		if(theBindingResult.hasErrors()) {
			return "form-employee";
		}
		else {
			employeeService.saveEmployee(theEmployee);
			
			return "redirect:/employee/list";
		}
	}
		
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
			Model theModel) {
			
		Employees theEmployee = employeeService.getEmployee(theId);
			
		theModel.addAttribute("employee", theEmployee);
			
		return "form-employee";
	}
		
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
			
		employeeService.deleteEmployee(theId);
			
		return "redirect:/employee/list";
	}
		
	@PostMapping("/search")
	public String searchEmployees(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	    List<Employees> theEmployees = employeeService.searchEmployees(theSearchName);
	                
	    theModel.addAttribute("employees", theEmployees);

	    return "list-employees";        
	}
	
}
