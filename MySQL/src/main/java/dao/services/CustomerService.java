package dao.services;


import dao.interfaces.ICustomerDAO;
import dao.jdbc.CustomerDAOjdbc;
import dao.mybatis.CustomerDAO;

import java.util.ResourceBundle;

public class CustomerService {

    public static ICustomerDAO getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new CustomerDAOjdbc();
        } else {
            return new CustomerDAO();
        }
    }

}
