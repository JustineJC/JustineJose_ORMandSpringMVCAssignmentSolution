package spring.gl.CRM_CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import spring.gl.CRM_CRUD.entity.Customer;
import spring.gl.CRM_CRUD.service.ICustomerServiceInterface;

//@RestController
@Controller
@RequestMapping
public class CustomerController {

	@Autowired
	private ICustomerServiceInterface customerServiceInterface;
/*-----------------------View--Page--Of---CRM----------------------------------------------------------------------*/
	// Redirect to Registered Customer page
	@RequestMapping(path = "/list_customers", method = RequestMethod.GET)
	public ModelAndView viewCustomersRegistered(ModelAndView m) {
		List<Customer> listCustomers = customerServiceInterface.getAllCustomer();
		m.addObject("customers", listCustomers);
		m.setViewName("customer_list");
		return m;
	}

	@RequestMapping(path = "/customer_registeration_form", method = RequestMethod.GET)
	public String viewCustomerForm(Model m) {
		m.addAttribute("title", "Customer Registeration");
		return "customer_registeration_form";
	}
	// Customer persist handler view
	@RequestMapping(path = "/handle-registerCustomer", method = RequestMethod.POST)
	public String customerHandler(@ModelAttribute Customer customer) {
		customerServiceInterface.addCustomer(customer);
		return "redirect:/list_customers";
	}
	//Customer Delete handler View
	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String customerDelete(@RequestParam("id") Long id) {
		System.out.println("Customer Id for delete :" + id);
		customerServiceInterface.deleteCustomer(id);
		return "redirect:/list_customers";
	}
	
	//Customer update handler, get values and display on the CUSTOMER update form
	@RequestMapping(path="/updateForm",method = RequestMethod.GET)
	public String customerUpdateHandler(@RequestParam ("id") Long id,Model m) {
		Customer customer = new Customer();
		m.addAttribute("title", "Update Customer");
		customer=customerServiceInterface.fetchCustomer(id);
		m.addAttribute("customer", customer);
		return "update-form";
	}

	//CUSTOMER Updation Handler
	@RequestMapping(path="/handle-updateCustomer",method = RequestMethod.POST)
	public String customerUpdateHandler(@ModelAttribute Customer customer, @RequestParam("id") Long id) {
		customerServiceInterface.updateCustomer(customer, id);
		return "redirect:/list_customers";
	}
/*--------------------------------------End-Of-View------------------------------------------------------------*/	

/*-----------------------------------POSTMAN----OPERATIONS-------------------------------------------------------------------------------*/
	// Post Mapping to save the information Postman
	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerServiceInterface.addCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);

	}

	// displaying the information or to get view Postman
	@GetMapping("/index")
	public ResponseEntity<List<Customer>> getAllCustomer() {

		List<Customer> listAllCustomer = customerServiceInterface.getAllCustomer();

		return new ResponseEntity<List<Customer>>(listAllCustomer, HttpStatus.OK);
	}

	// Fetch the customer by ID Postman
	@GetMapping("/update/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Long customerIdL) {

		Customer fetchCustomer = customerServiceInterface.fetchCustomer(customerIdL);
		return new ResponseEntity<Customer>(fetchCustomer, HttpStatus.OK);
	}

	// Delete the customer with ID Postman
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerIdL) {
		customerServiceInterface.deleteCustomer(customerIdL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	// Updating the customer Postman
	@PutMapping("/updating")
	public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer) {

		Customer putCustomerId = customerServiceInterface.addCustomer(customer);
		return new ResponseEntity<Customer>(putCustomerId, HttpStatus.CREATED);
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
}
