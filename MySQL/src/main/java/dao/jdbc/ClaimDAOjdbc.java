package dao.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import dao.interfaces.IClaimDAO;
import model.BasicConnectionPool;
import model.Claim;

public class ClaimDAOjdbc implements IClaimDAO {
	
	static BasicConnectionPool connectionPool = BasicConnectionPool.create();
	@Override
	public Claim getEntityById(int id) {
		Claim claim = new Claim();
		String sql = "SELECT * FROM mydb.claims where claim_id = ?";
	Connection connection = connectionPool.getConnection();
		try	{
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1,  id);
	ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			claim.setClaimId(resultSet.getInt("claim_id"));	
			claim.setPolicyId(resultSet.getInt("policy_id"));	
			claim.setClaimDate(resultSet.getString("claim_date"));
			claim.setClaimAmount(resultSet.getInt("claim_amount"));
			claim.setClaimStatusId(resultSet.getInt("claim_status_id"));
			claim.setDescription(resultSet.getString("description"));
			}
			
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	return claim;
	}
	
;
	
	
	@Override
	public List<Claim> getEntities(){
		List<Claim> list = new ArrayList<>();
	
		String sql = "SELECT * FROM mydb.claims";
		Connection connection = connectionPool.getConnection();
		try	{		
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			Claim claim = new Claim();
			claim.setClaimId(resultSet.getInt("claim_id"));	
			claim.setPolicyId(resultSet.getInt("policy_id"));	
			claim.setClaimDate(resultSet.getString("claim_date"));
			claim.setClaimAmount(resultSet.getInt("claim_amount"));
			claim.setClaimStatusId(resultSet.getInt("claim_status_id"));
			claim.setDescription(resultSet.getString("description"));
			list.add(claim);
			}
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
	return list;
	}
	
	
	@Override
	public void insert(Claim claim) {

		String sql = "INSERT INTO `mydb`.`claims`(`POLICY_ID`, `CLAIM_DATE`, `CLAIM_AMOUNT`, `CLAIM_STATUS_ID`, `DESCRIPTION`) VALUES (?,?,?,?,?)";
		Connection connection = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setInt(1, claim.getPolicyId());
	preparedStatement.setString(2, claim.getClaimDate());
	preparedStatement.setInt(3, claim.getClaimAmount());
	preparedStatement.setInt(4, claim.getClaimStatusId());
	preparedStatement.setString(5, claim.getDescription());
	preparedStatement.execute();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}

	};
	
	
	
	
	@Override
	public void update (int id, Claim claim) {
		String sql = "UPDATE `mydb`.`claims`\r\n"
				+ "SET\r\n"
				+ "`DESCRIPTION` = ?\r\n"
				+ "WHERE `CLAIM_ID` = ?";
		Connection connection = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	//preparedStatement.setInt(1, claim.getPolicyId());
	//preparedStatement.setString(2, claim.getClaimDate());
	//preparedStatement.setInt(3, claim.getClaimAmount());
	//preparedStatement.setInt(4, claim.getClaimStatusId());
	preparedStatement.setString(1, claim.getDescription());
	preparedStatement.setInt(2,  id);
	preparedStatement.executeUpdate();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(connection);}
		
	
	
	
	};
	@Override
	public void delete (int id) {

		String sql = "DELETE FROM `mydb`.`claims`\r\n"
				+ "WHERE claim_id = ?";
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
