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
import dao.interfaces.ICustomerDAO;
import model.BasicConnectionPool;
import model.MyBatisConf;
import model.Customer;

public class CustomerDAO implements ICustomerDAO {
    static SqlSessionFactory sqlSessionFactory
    = MyBatisConf.buildqlSessionFactory();

@Override
public Customer getEntityById(int index) {
//Interface
try(SqlSession session = sqlSessionFactory.openSession()) {
    Customer customer = session.selectOne("dao.interfaces.ICustomerDAO.getEntityById", index);
    return customer;
}

//XML
//try(SqlSession session = sqlSessionFactory.openSession()) {
//    Student student = session.selectOne("StudentMapper.getEntityById", index);
//    return student;
//}
}


@Override
public List<Customer> getEntities() {
    return null;
}

@Override
public void insert(Customer claim) {

}

@Override
public void delete(int index) {

}

@Override
public void update(int index, Customer claim) {

}
}
