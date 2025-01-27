package dao.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import model.BasicConnectionPool;
import model.Policy;

public class PolicyDAO implements IPolicyDAO{
	static BasicConnectionPool connectionPool = BasicConnectionPool.create();
	@Override
	public Policy getEntityById(int id) {
		Policy policy = new Policy();
		String sql = "SELECT * FROM mydb.policies where policy_id = ?";
		Connection connection = connectionPool.getConnection();
		try {	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1,  id);
	ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			policy.setPolicyId(resultSet.getInt("policy_id"));	
			policy.setPolicyTypeId(resultSet.getInt("policy_type_id"));
			policy.setCustomerId(resultSet.getInt("customer_id"));
			policy.setStartDate(resultSet.getString("start_date"));
			policy.setEndDate(resultSet.getString("end_date"));
			policy.setCoverageAmount(resultSet.getInt("coverage_amount"));
			policy.setPremiumAmount(resultSet.getInt("premium_amount"));
			policy.setAgentId(resultSet.getInt("agent_id"));
			}
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	return policy;
	}
	
;
	
	
	@Override
	public List<Policy> getEntities(){
		List<Policy> list = new ArrayList<>();
	
		String sql = "SELECT * FROM mydb.policies";
		Connection connection = connectionPool.getConnection();
		try {	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			Policy policy = new Policy();
			policy.setPolicyId(resultSet.getInt("policy_id"));
			policy.setPolicyTypeId(resultSet.getInt("policy_type_id"));
			policy.setCustomerId(resultSet.getInt("customer_id"));
			policy.setStartDate(resultSet.getString("start_date"));
			policy.setEndDate(resultSet.getString("end_date"));
			policy.setCoverageAmount(resultSet.getInt("coverage_amount"));
			policy.setPremiumAmount(resultSet.getInt("premium_amount"));
			policy.setAgentId(resultSet.getInt("agent_id"));
			list.add(policy);
			}
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	return list;
	}
	
	
	@Override
	public void insert(Policy policy) {

		String sql = "INSERT INTO `mydb`.`policies` (`POLICY_TYPE_ID`, `CUSTOMER_ID`, `START_DATE`, `END_DATE`, `COVERAGE_AMOUNT`, `PREMIUM_AMOUNT`, `AGENT_ID`) VALUES (?,?,?,?,?,?,?)";
		
		Connection connection = connectionPool.getConnection();
		try {	
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1, policy.getPolicyTypeId());
	preparedStatement.setInt(2, policy.getCustomerId());
	preparedStatement.setString(3, policy.getStartDate());
	preparedStatement.setString(4, policy.getEndDate());
	preparedStatement.setInt(5, policy.getCoverageAmount());
	preparedStatement.setInt(6, policy.getPremiumAmount());
	preparedStatement.setInt(7, policy.getAgentId());
	//preparedStatement.setInt(1, policy.getAge());
	preparedStatement.execute();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}

	};
	
	
	
	
	@Override
	public void update (int id, Policy policy) {
		String sql = "UPDATE `mydb`.`policies` SET `AGENT_ID` =  ? WHERE `POLICY_ID` = ?";
		Connection connection = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	//preparedStatement.setInt(1, policy.getPolicyTypeId());
	//preparedStatement.setInt(2, policy.getCustomerId());
	//preparedStatement.setString(3, policy.getStartDate());
	//preparedStatement.setString(4, policy.getEndDate());
	//preparedStatement.setInt(5, policy.getCoverageAmount());
	//preparedStatement.setInt(6, policy.getPremiumAmount());
	preparedStatement.setInt(1, policy.getAgentId());
	preparedStatement.setInt(2,  id);
	preparedStatement.executeUpdate();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
		
	
	
	
	};
	@Override
	public void delete (int id) {

		String sql = "DELETE FROM `mydb`.`policies` WHERE policy_id = ?";
		Connection connection = connectionPool.getConnection();
		try {
	//try	(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "82568572.Yana")){
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1,  id);
	preparedStatement.execute();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
		
	};

}
