package dao.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import dao.interfaces.ICustomerDAO;
import model.BasicConnectionPool;
import model.Customer;

public class CustomerDAOjdbc implements ICustomerDAO {
	static BasicConnectionPool connectionPool = BasicConnectionPool.create();
	@Override
	public Customer getEntityById(int id) {
		Customer customer = new Customer();
		String sql = "SELECT * FROM mydb.customers where customer_id = ?";
		Connection connection = connectionPool.getConnection();
		try {	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1,  id);
	ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			customer.setCustomerId(resultSet.getInt("customer_id"));	
			customer.setFirstName(resultSet.getString("first_name"));
			customer.setLastName(resultSet.getString("last_name"));
			customer.setDateOfBirth(resultSet.getString("date_of_birth"));
			customer.setEmail(resultSet.getString("email"));
			customer.setPhone(resultSet.getString("phone"));
			customer.setCity(resultSet.getString("city"));
			customer.setPostalCode(resultSet.getString("postal_code"));
			customer.setStreet(resultSet.getString("street"));
			}
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	return customer;
	}
	
;
	
	
	@Override
	public List<Customer> getEntities(){
		List<Customer> list = new ArrayList<>();
	
		String sql = "SELECT * FROM mydb.customers";
		Connection connection = connectionPool.getConnection();
			try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(resultSet.getInt("customer_id"));
			customer.setFirstName(resultSet.getString("first_name"));
			customer.setLastName(resultSet.getString("last_name"));
			customer.setDateOfBirth(resultSet.getString("date_of_birth"));
			customer.setEmail(resultSet.getString("email"));
			customer.setPhone(resultSet.getString("phone"));
			customer.setCity(resultSet.getString("city"));
			customer.setPostalCode(resultSet.getString("postal_code"));
			customer.setStreet(resultSet.getString("street"));
			list.add(customer);
			}
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	return list;
	}
	
	
	@Override
	public void insert(Customer customer) {

		String sql = "INSERT INTO `mydb`.`customers`(`FIRST_NAME`,`LAST_NAME`,`DATE_OF_BIRTH`,`EMAIL`,`PHONE`,`CITY`,`POSTAL_CODE`,`STREET`)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		Connection connection = connectionPool.getConnection();
		try {	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setString(1, customer.getFirstName());
	preparedStatement.setString(2, customer.getLastName());
	preparedStatement.setString(3, customer.getDateOfBirth());
	preparedStatement.setString(4, customer.getEmail());
	preparedStatement.setString(5, customer.getPhone());
	preparedStatement.setString(6, customer.getCity());
	preparedStatement.setString(7, customer.getPostalCode());
	preparedStatement.setString(8, customer.getStreet());
	//preparedStatement.setInt(1, customer.getAge());
	preparedStatement.execute();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}

	};
	
	
	
	
	@Override
	public void update (int id, Customer customer) {
		String sql = "UPDATE `mydb`.`customers` SET `FIRST_NAME` = ? WHERE `CUSTOMER_ID` = ?";
		//String sql = "UPDATE `mydb`.`customers`\r\n"
		//		+ "SET `FIRST_NAME` = ?, `LAST_NAME` = ?, `DATE_OF_BIRTH` = ?, `EMAIL` = ?, `PHONE` = ?, `CITY` = ?, `POSTAL_CODE` = ?, `STREET` = ? WHERE `CUSTOMER_ID` = ?";
		Connection connection = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setString(1, customer.getFirstName());
	//preparedStatement.setString(2, customer.getLastName());
	//preparedStatement.setString(3, customer.getDateOfBirth());
	//preparedStatement.setString(4, customer.getEmail());
	//preparedStatement.setString(5, customer.getPhone());
	//preparedStatement.setString(6, customer.getCity());
	//preparedStatement.setString(7, customer.getPostalCode());
	//preparedStatement.setString(8, customer.getStreet());
	preparedStatement.setInt(2,  id);
	preparedStatement.executeUpdate();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	
	
	
	};
	@Override
	public void delete (int id) {

		String sql = "DELETE FROM `mydb`.`customers`\r\n"
				+ "WHERE customer_id = ?";
		Connection connection = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1,  id);
	preparedStatement.execute();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
		
	};

}
