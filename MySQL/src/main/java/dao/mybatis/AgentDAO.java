package dao.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.interfaces.IAgentDAO;
import model.Agent;
import model.BasicConnectionPool;
import model.MyBatisConf;

public class AgentDAO implements IAgentDAO{
    static SqlSessionFactory sqlSessionFactory
    = MyBatisConf.buildqlSessionFactory();

@Override
public Agent getEntityById(int index) {
//Interface
try(SqlSession session = sqlSessionFactory.openSession()) {
    Agent agent = session.selectOne("dao.interfaces.IAgentDAO.getEntityById", index);
    return agent;
}

//XML
//try(SqlSession session = sqlSessionFactory.openSession()) {
//    Agent agent = session.selectOne("AgentMapper.getEntityById", index);
//    return agent;
//}
}

@Override
public List<Agent> getEntities() {
return null;
}

@Override
public void insert(Agent agent) {

}

@Override
public void delete(int index) {

}

@Override
public void update(int index, Agent agent) {

}
}
