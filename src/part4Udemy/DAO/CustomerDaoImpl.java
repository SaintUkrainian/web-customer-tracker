package part4Udemy.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import part4Udemy.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomers() {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query and execute 
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		
		// get result list from database
		List<Customer> customers = query.getResultList();
		
		// return the list
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(session.get(Customer.class, id));
		
	}

	@Override
	public List<Customer> search(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;
		if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
			
		
		List<Customer> cust = theQuery.getResultList();
		
		return cust;
	}

}
