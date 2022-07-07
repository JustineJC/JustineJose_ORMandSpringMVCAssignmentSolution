package spring.gl.CRM_CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.gl.CRM_CRUD.entity.Customer;
import spring.gl.CRM_CRUD.service.CustomerServiceInterface;

@RestController
@RequestMapping("/CRMapp")
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerServiceInterface;

//Post Mapping to save the information
	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerServiceInterface.addCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);

	}

	// displaying the information or to get view
	@GetMapping("/index")
	public ResponseEntity<List<Customer>> getAllCustomer() {

		List<Customer> listAllCustomer = customerServiceInterface.getAllCustomer();
		return new ResponseEntity<List<Customer>>(listAllCustomer, HttpStatus.OK);
	}

	// Fetch the customer by ID
	@GetMapping("/update/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Long customerIdL) {

		Customer fetchCustomer = customerServiceInterface.fetchCustomer(customerIdL);
		return new ResponseEntity<Customer>(fetchCustomer, HttpStatus.OK);
	}

	// Delete the customer with ID
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerIdL) {
		customerServiceInterface.deleteCustomer(customerIdL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/updating")
	public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer) {

		Customer putCustomerId = customerServiceInterface.addCustomer(customer);
		return new ResponseEntity<Customer>(putCustomerId, HttpStatus.CREATED);
	}
}
