package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.IAgentDAO;
import model.Agent;
import model.BasicConnectionPool;

public class AgentDAOjdbc implements IAgentDAO{
	
	static BasicConnectionPool connectionPool = BasicConnectionPool.create();
	
	@Override
	public Agent getEntityById(int id) {
		Agent agent = new Agent();
		String sql = "SELECT * FROM mydb.agents where agent_id = ?";
		Connection conn = connectionPool.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				agent.setAgentId(resultSet.getInt("agent_id"));
				agent.setAgentName(resultSet.getString("agent_desc"));
			}
		}
		catch (SQLException e) {
			System.out.println("Error");
		}finally{connectionPool.releaseConnection(conn);
		}
		return agent;
	};
	
	
	@Override
	public List<Agent> getEntities(){
		List<Agent> list = new ArrayList<>();
		String sql = "SELECT * FROM mydb.agents";
		Connection conn = connectionPool.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Agent agent = new Agent();
				agent.setAgentId(resultSet.getInt("agent_id"));
				agent.setAgentName(resultSet.getString("agent_desc"));
				list.add(agent);
				
			}
		}
	catch (SQLException e) {
		System.out.println("Error");
	}finally{connectionPool.releaseConnection(conn);
	}
	return list;
		
	};
	
	
	@Override
	public void insert (Agent agent) {
		String sql = "INSERT INTO `mydb`.`agents`(`AGENT_ID`, `AGENT_DESC`) VALUES (?,?)";
		Connection conn = connectionPool.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1,  agent.getAgentId());
			preparedStatement.setString(2, agent.getAgentName());
			preparedStatement.execute();
		}
		catch (SQLException e) {
			System.out.println("Error");
			} finally {connectionPool.releaseConnection(conn);}

	};
	
	
	@Override
	public void update(int id, Agent agent) {
		String sql = "UPDATE `mydb`.`agents`\r\n"
				+ "SET\r\n"
				+ "`AGENT_DESC` = ?\r\n"
				+ "WHERE `AGENT_ID` = ?";
		Connection conn = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setString(1, agent.getAgentName());
	preparedStatement.setInt(2,  id);;
	preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
		System.out.println("Error");
		} finally {connectionPool.releaseConnection(conn);}
				
	};
	@Override
	public void delete (int id) {
		String sql = "DELETE FROM `mydb`.`agents`\r\n"
				+ "WHERE agent_id = ?";
		Connection conn = connectionPool.getConnection();
		try {
	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1,  id);
	preparedStatement.execute();
	} 
	catch (SQLException e) {
	System.out.println("Error");
	} finally {connectionPool.releaseConnection(conn);}

	};
}
