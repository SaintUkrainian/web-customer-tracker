package part4Udemy.Service;

import java.util.List;

import part4Udemy.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int id);
	
	List<Customer> search(String str);

}
