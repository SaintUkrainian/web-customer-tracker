package part4Udemy.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import part4Udemy.Service.CustomerService;
import part4Udemy.Service.CustomerServiceImpl;
import part4Udemy.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String showList(Model theModel) {
		
		// get customers from our customer service
		List<Customer> listCustomers = customerService.getCustomers();
		listCustomers.sort(Comparator.comparing(Customer::getLastName));
		
		// search bar
		
		CustomerService search = new CustomerServiceImpl();
		
		theModel.addAttribute("search", search);
			
		
		// add customers to the model
		theModel.addAttribute("customers", listCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormAdd")
	public String addForm(Model theModel) {
		
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		
		return "add-customers";
	}
	
	@PostMapping("/processData")
	public String processData(@ModelAttribute("customer") Customer theCustomer) {
		 
		// save the customer using service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String updateForm(@RequestParam("customerId") int theId, Model theModel) {
		
		// get customer from data base
		
		Customer customer = customerService.getCustomer(theId);
		
		// add to the model and pre-populate form
		
		theModel.addAttribute("customer", customer);
		
		// send it to the form
		
		return "add-customers";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("string") String str, Model theModel) {
		
			List<Customer> customers = customerService.search(str);
			customers.sort(Comparator.comparing(Customer::getLastName));
			theModel.addAttribute("customers", customers);
			System.out.println(str);
			return "list-customers";
		
	}
	

}
