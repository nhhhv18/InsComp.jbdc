package dao.mybatis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import dao.*;
import dao.interfaces.IClaimDAO;
import model.BasicConnectionPool;
import model.Claim;
import model.Customer;
import model.MyBatisConf;

public class ClaimDAO implements IClaimDAO {
	   static SqlSessionFactory sqlSessionFactory
	    = MyBatisConf.buildqlSessionFactory();

	@Override
	public Claim getEntityById(int index) {
	//Interface
	try(SqlSession session = sqlSessionFactory.openSession()) {
	    Claim claim = session.selectOne("dao.interfaces.IClaimDAO.getEntityById", index);
	    return claim;
	}

	//XML
	//try(SqlSession session = sqlSessionFactory.openSession()) {
//	    Student student = session.selectOne("StudentMapper.getEntityById", index);
//	    return student;
	//}
	}


	@Override
	public List<Claim> getEntities() {
	    return null;
	}

	@Override
	public void insert(Claim claim) {

	}

	@Override
	public void delete(int index) {

	}

	@Override
	public void update(int index, Claim claim) {

	}
}
