package orm.pos.controller;

import java.util.Date;
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

import orm.pos.entity.OrderItems;
import orm.pos.entity.OrderItemsID;
import orm.pos.entity.Orders;
import orm.pos.service.CustomerService;
import orm.pos.service.OrderItemService;
import orm.pos.service.OrderService;
import orm.pos.service.PaymentService;
import orm.pos.service.StatusService;

@Controller
@RequestMapping("/order")
public class OrderController {

		@Autowired
		private OrderService orderService;
		@Autowired
		private OrderItemService orderItemService;
		@Autowired
		private StatusService statusService;
		@Autowired
		private PaymentService paymentService;
		@Autowired
		private CustomerService customerService;
		
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
				
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
		
		@GetMapping("/list")
		public String listOrders(Model theModel) {
			
			List<Orders> theOrders = orderService.getOrders();
			
			theModel.addAttribute("orders", theOrders);
			
			return "list-orders";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			Orders theOrder = new Orders();
			
			//pobranie aktualnej daty
			Date date = new Date();
			theOrder.setDate(date);
			
			//pobranie typów statusów i p³atnoœci zamówieñ
			List<String> theStatuses = statusService.getStatusesName();
			List<String> thePayments = paymentService.getPaymentsName();
			
			//dodanie atrybutów modelu
			theModel.addAttribute("order", theOrder);
			theModel.addAttribute("statuses", theStatuses);
			theModel.addAttribute("payments", thePayments);
			
			return "form-order";
		}
		
		@PostMapping("/saveOrder")
		public String saveOrder(@Valid @ModelAttribute("order") Orders theOrder,
				BindingResult theBindingResult, Model theModel) {
			
			if(theBindingResult.hasErrors()) {
				List<String> theStatuses = statusService.getStatusesName();
				List<String> thePayments = paymentService.getPaymentsName();
				theModel.addAttribute("statuses", theStatuses);
				theModel.addAttribute("payments", thePayments);
				return "form-order";
			}
			else {
				//ustawienie klienta na podstawie id
				theOrder.setCustomer(customerService.getCustomer(theOrder.getCustomer().getId()));
				
				//ustawienie statusu na podstawie nazwy
				String name = theOrder.getStatusName();
				theOrder.setStatus(statusService.getStatus(name));
				
				//ustawienie p³atnoœci na podstawie nazwy
				String name2 = theOrder.getPaymentName();
				theOrder.setPayment(paymentService.getPayment(name2));
				
				//zapisanie zamówienia
				orderService.saveOrder(theOrder);
				
				return "redirect:/order/list";
			}
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("orderId") int theId,
				Model theModel) {
			
			Orders theOrder = orderService.getOrder(theId);
			theOrder.setCustomer(customerService.getCustomer(theOrder.getCustomer().getId()));
			List<String> theStatuses = statusService.getStatusesName();
			List<String> thePayments = paymentService.getPaymentsName();
			
			theModel.addAttribute("order", theOrder);
			theModel.addAttribute("items", theOrder.getItems());
			theModel.addAttribute("statuses", theStatuses);
			theModel.addAttribute("payments", thePayments);
			
			return "form-order";
		}
	    
	    @GetMapping("/deleteItem")
		public String deleteOrderItem(@RequestParam("orderItemOId") int theOId, @RequestParam("orderItemPId") String thePId) {
			
	    	OrderItemsID theId = new OrderItemsID(theOId, thePId);
	    	
			orderItemService.deleteOrderItem(theId);
			
			return "redirect:/order/list";
		}
	    
	    @GetMapping("/showFormForItemAdd")
		public String showFormForItemAdd(@RequestParam("orderItemOId") int theOId, Model theModel) {
			
	    	//utwórz nowy produkt w zamówieniu i przypisz mu id zamówienia
			OrderItems theOrderItem = new OrderItems();
			theOrderItem.setOrderId(theOId);
			
			theModel.addAttribute("orderItem", theOrderItem);
			
			return "form-orderitem";
		}
	    
	    @PostMapping("/saveOrderItem")
		public String saveOrderItem(@Valid @ModelAttribute("orderItem") OrderItems theOrderItem,
				BindingResult theBindingResult, Model theModel) {
			
	    	if(theBindingResult.hasErrors()) {
	    		return "form-orderitem";
			}
			else {
				//utwórz klucz kompozytowy obiektu na podstawie id zamówienia i id produktu 
				//oraz zapisz nowy obiekt w zamówieniu 
		    	OrderItemsID id = new OrderItemsID(theOrderItem.getOrderId(), theOrderItem.getId().getProductId());
		    	theOrderItem.setId(id);
				orderItemService.saveOrderItem(theOrderItem);
				
				return "redirect:/order/list";
	    	}
		}
	
}
