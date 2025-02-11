package dao.interfaces;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer> {
    @Select(
            "select * from mydb.customers where customer_id = #{index}")
    @Results(value = {
    		@Result(property="customerId", column = "customer_id"),
            @Result(property="firstName", column = "first_name"),
            @Result(property="lastName", column = "last_name"),
            @Result(property="dateOfBirth", column = "date_of_birth"),
            @Result(property="email", column = "email"),
            @Result(property="phone", column = "phone"),
            @Result(property="postalCode", column = "postal_code"),
            @Result(property="city", column = "city"),
            @Result(property="street", column = "street"),
    })

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
