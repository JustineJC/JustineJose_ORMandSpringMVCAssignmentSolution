package spring.gl.CRM_CRUD.service;

import java.util.List;

import spring.gl.CRM_CRUD.entity.Customer;

public interface CustomerServiceInterface {

	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer fetchCustomer(Long customerIdL);

	public void deleteCustomer(Long customerIdL);

	

	

}
