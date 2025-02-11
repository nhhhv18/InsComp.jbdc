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
import dao.interfaces.IPolicyDAO;
import model.BasicConnectionPool;
import model.MyBatisConf;
import model.Policy;

public class PolicyDAO implements IPolicyDAO{
	  static SqlSessionFactory sqlSessionFactory
      = MyBatisConf.buildqlSessionFactory();

@Override
public Policy getEntityById(int index) {
  //Interface
  try(SqlSession session = sqlSessionFactory.openSession()) {
      Policy policy = session.selectOne("dao.interfaces.IPolicyDAO.getEntityById", index);
      return policy;
  }

  //XML
//  try(SqlSession session = sqlSessionFactory.openSession()) {
//      Policy policy = session.selectOne("PolicyMapper.getEntityById", index);
//      return policy;
//  }
}

@Override
public List<Policy> getEntities() {
  return null;
}

@Override
public void insert(Policy policy) {

}

@Override
public void delete(int index) {

}

@Override
public void update(int index, Policy policy) {

}
}
