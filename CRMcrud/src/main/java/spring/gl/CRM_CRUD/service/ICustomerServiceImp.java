package spring.gl.CRM_CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.gl.CRM_CRUD.entity.Customer;
import spring.gl.CRM_CRUD.repository.CustomerCrudRepository;

@Service
public class ICustomerServiceImp implements ICustomerServiceInterface {

	@Autowired
	private CustomerCrudRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer saveCustomer = customerRepository.save(customer);
		return saveCustomer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub

		return customerRepository.findAll();
	}

	@Override
	public Customer fetchCustomer(Long customerIdL) {
		return customerRepository.findById(customerIdL).get();

	}

	@Override
	public void deleteCustomer(Long customerIdL) {
		customerRepository.deleteById(customerIdL);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer, Long id) {
		customerRepository.save(customer);
		
	}

}
