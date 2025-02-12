package dao.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    try (SqlSession session = sqlSessionFactory.openSession()) {
        return session.selectList("dao.interfaces.IPolicyDAO.getEntities");
    }
}

@Override
public void insert(Policy policy) {
    try (SqlSession session = sqlSessionFactory.openSession(true)) { // Auto-commit enabled
        session.insert("dao.interfaces.IPolicyDAO.insert", policy);
    }
}

@Override
public void update(int id, Policy policy) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("policy", policy);
        
        session.update("dao.interfaces.IPolicyDAO.update", params);
        session.commit();
    }
}

@Override
public void delete(int id) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
        session.delete("dao.interfaces.IPolicyDAO.delete", id);
        session.commit();
    }
}
}
