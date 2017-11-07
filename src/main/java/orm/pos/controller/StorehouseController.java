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

import orm.pos.entity.Storehouses;
import orm.pos.service.StorehouseService;

@Controller
@RequestMapping("/storehouse")
public class StorehouseController {

	@Autowired
	private StorehouseService storehouseService;
		
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
		
	@GetMapping("/list")
	public String listStorehouses(Model theModel) {
			
		List<Storehouses> theStorehouses = storehouseService.getStorehouses();
			
		theModel.addAttribute("storehouses", theStorehouses);
			
		return "list-storehouses";
	}
		
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
			
		Storehouses theStorehouse = new Storehouses();
			
		theModel.addAttribute("storehouse", theStorehouse);
			
		return "form-storehouse";
	}
		
	@PostMapping("/saveStorehouse")
	public String saveStorehouse(@Valid @ModelAttribute("storehouse") Storehouses theStorehouse,
			BindingResult theBindingResult, Model theModel) {
			
		if(theBindingResult.hasErrors()) {
			return "form-storehouse";
		}
		else {
			storehouseService.saveStorehouse(theStorehouse);
			
			return "redirect:/storehouse/list";
		}
	}
		
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("storehouseId") int theId,
			Model theModel) {
			
		Storehouses theStorehouse = storehouseService.getStorehouse(theId);
			
		theModel.addAttribute("storehouse", theStorehouse);
			
		return "form-storehouse";
	}
		
	@GetMapping("/delete")
	public String deleteStorehouse(@RequestParam("storehouseId") int theId) {
			
		storehouseService.deleteStorehouse(theId);
			
		return "redirect:/storehouse/list";
	}
		
	@PostMapping("/search")
	public String searchStorehouses(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	    List<Storehouses> theStorehouses = storehouseService.searchStorehouses(theSearchName);
	                
	    theModel.addAttribute("storehouses", theStorehouses);

	    return "list-storehouses";        
	}
	
}
