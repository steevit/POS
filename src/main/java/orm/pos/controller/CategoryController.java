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

import orm.pos.entity.Categories;
import orm.pos.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

		@Autowired
		private CategoryService categoryService;
		
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
				
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
		
		@GetMapping("/list")
		public String listCategories(Model theModel) {
			
			//pobierz kategorie z serwisu
			List<Categories> theCategories = categoryService.getCategories();
			
			//dodaj kategorie do modelu
			theModel.addAttribute("categories", theCategories);
			
			return "list-categories";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			//utwórz now¹ kategoriê, by przypisz jej model do formularzu
			Categories theCategory = new Categories();
			
			theModel.addAttribute("category", theCategory);
			
			return "form-category";
		}
		
		@PostMapping("/saveCategory")
		public String saveCategory(@Valid @ModelAttribute("category") Categories theCategory,
				BindingResult theBindingResult, Model theModel) {
			
			if(theBindingResult.hasErrors()) {
				//jeœli wprowadzone dane zawieraj¹ b³êdy, powróæ do formularzu i wyœwietl b³êdy
				return "form-category";
			}
			else {
				//jeœli nie ma b³êdów, zapisz kategoriê
				categoryService.saveCategory(theCategory);
			
				return "redirect:/category/list";
			}
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("categoryId") int theId,
				Model theModel) {
			
			//pobierz kategoriê o danym id
			Categories theCategory = categoryService.getCategory(theId);
			
			//ustaw kategoriê jako atrybut modelu by wype³niæ formularz aktualnymi danymi
			theModel.addAttribute("category", theCategory);
			
			//przekieruj do widoku formularzu
			return "form-category";
		}
		
		@GetMapping("/delete")
		public String deleteCategory(@RequestParam("categoryId") int theId) {
			
			//usuñ kategoriê
			categoryService.deleteCategory(theId);
			
			return "redirect:/category/list";
		}
		
	    @PostMapping("/search")
	    public String searchCategories(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // wyszukaj kategorie
	        List<Categories> theCategories = categoryService.searchCategories(theSearchName);
	                
	        // dodaj kategorie do atrybutu modelu
	        theModel.addAttribute("categories", theCategories);

	        return "list-categories";        
	    }
	
}
