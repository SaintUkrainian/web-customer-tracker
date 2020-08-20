package part4Udemy.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import part4Udemy.DAO.CustomerDao;
import part4Udemy.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	
	@Transactional
	public List<Customer> getCustomers() {
		
		List<Customer> customers = customerDao.getCustomers();
		
		
		return customers;
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDao.saveCustomer(theCustomer);
	}

	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDao.getCustomer(theId);
	}

	@Transactional
	public void deleteCustomer(int id) {
		
		customerDao.deleteCustomer(id);
	}

	@Transactional
	public List<Customer> search(String str) {
		
		return customerDao.search(str);
	}
	
	


}
