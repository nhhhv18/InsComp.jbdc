package dao;
import java.util.List;

import model.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer> {

	@Override
	Customer getEntityById(int id);
	@Override
	List<Customer> getEntities();
	@Override
	void insert(Customer customer);
	@Override
	void update (int id, Customer customer);
	@Override
	void delete (int id);
}
