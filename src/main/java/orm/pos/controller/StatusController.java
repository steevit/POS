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

import orm.pos.entity.Status;
import orm.pos.service.StatusService;

@Controller
@RequestMapping("/status")
public class StatusController {

		@Autowired
		private StatusService statusService;
		
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
				
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
		
		@GetMapping("/list")
		public String listStatuses(Model theModel) {
			
			List<Status> theStatuses = statusService.getStatuses();
			
			theModel.addAttribute("status", theStatuses);
			
			return "list-status";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			Status theStatus = new Status();
			
			theModel.addAttribute("status", theStatus);
			
			return "form-status";
		}
		
		@PostMapping("/saveStatus")
		public String saveStatus(@Valid @ModelAttribute("status") Status theStatus,
				BindingResult theBindingResult, Model theModel) {
			
			if(theBindingResult.hasErrors()) {
				return "form-status";
			}
			else {
				statusService.saveStatus(theStatus);
				
				return "redirect:/status/list";
			}
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("statusId") int theId,
				Model theModel) {
			
			Status theStatus = statusService.getStatus(theId);
			
			theModel.addAttribute("status", theStatus);
			
			return "form-status";
		}
		
		@GetMapping("/delete")
		public String deleteStatus(@RequestParam("statusId") int theId) {
			
			statusService.deleteStatus(theId);
			
			return "redirect:/status/list";
		}
		
		@PostMapping("/search")
	    public String searchStatus(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        List<Status> theStatus = statusService.searchStatus(theSearchName);
	                
	        theModel.addAttribute("status", theStatus);

	        return "list-status";        
	    }
	
}
