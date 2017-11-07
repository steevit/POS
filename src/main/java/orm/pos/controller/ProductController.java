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

import orm.pos.entity.Products;
import orm.pos.service.CategoryService;
import orm.pos.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
		
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
		
	@GetMapping("/list")
	public String listProducts(Model theModel) {
			
		List<Products> theProducts = productService.getProducts();
			
		theModel.addAttribute("products", theProducts);
			
		return "list-products";
	}
		
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
			
		Products theProduct = new Products();
		//pobranie nazw kategorii z bazy
		List<String> theCategories = categoryService.getCategoriesName();
			
		theModel.addAttribute("product", theProduct);
		theModel.addAttribute("categories", theCategories);
			
		return "form-product";
	}
		
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Products theProduct,
			BindingResult theBindingResult, Model theModel) {
			
		if(theBindingResult.hasErrors()) {
			List<String> theCategories = categoryService.getCategoriesName();
			theModel.addAttribute("categories", theCategories);
			return "form-product";
		}
		else {
			String name = theProduct.getCategoryName();

			theProduct.setCategory(categoryService.getCategory(name));
			
			productService.saveProduct(theProduct);
			
			return "redirect:/product/list";
		}
	}
		
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
			Model theModel) {
			
		Products theProduct = productService.getProduct(theId);
		List<String> theCategories = categoryService.getCategoriesName();
			
		theModel.addAttribute("product", theProduct);
		theModel.addAttribute("categories", theCategories);
			
		return "form-product";
	}
		
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
			
		productService.deleteProduct(theId);
			
		return "redirect:/product/list";
	}
		
	@PostMapping("/search")
	public String searchProducts(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	    List<Products> theProducts = productService.searchProducts(theSearchName);
	                
	    theModel.addAttribute("products", theProducts);

	    return "list-products";        
	}
	
}
