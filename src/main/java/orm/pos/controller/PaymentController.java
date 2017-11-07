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

import orm.pos.entity.Payments;
import orm.pos.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

		@Autowired
		private PaymentService paymentService;
		
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
				
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
		
		@GetMapping("/list")
		public String listPayments(Model theModel) {
			
			List<Payments> thePayments = paymentService.getPayments();
			
			theModel.addAttribute("payments", thePayments);
			
			return "list-payments";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			Payments thePayment = new Payments();
			
			theModel.addAttribute("payment", thePayment);
			
			return "form-payment";
		}
		
		@PostMapping("/savePayment")
		public String savePayment(@Valid @ModelAttribute("payment") Payments thePayment,
				BindingResult theBindingResult, Model theModel) {
			
			if(theBindingResult.hasErrors()) {
				return "form-payment";
			}
			else {
				paymentService.savePayment(thePayment);
				
				return "redirect:/payment/list";
			}
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("paymentId") int theId,
				Model theModel) {
			
			Payments thePayment = paymentService.getPayment(theId);
			
			theModel.addAttribute("payment", thePayment);
			
			return "form-payment";
		}
		
		@GetMapping("/delete")
		public String deletePayment(@RequestParam("paymentId") int theId) {
			
			paymentService.deletePayment(theId);
			
			return "redirect:/payment/list";
		}
		
		@PostMapping("/search")
	    public String searchPayments(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        List<Payments> thePayments = paymentService.searchPayments(theSearchName);
	                
	        theModel.addAttribute("payments", thePayments);

	        return "list-payments";        
	    }
	
}
