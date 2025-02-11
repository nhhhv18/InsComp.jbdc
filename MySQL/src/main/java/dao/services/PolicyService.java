package dao.services;


import dao.interfaces.IPolicyDAO;
import dao.jdbc.PolicyDAOjdbc;
import dao.mybatis.PolicyDAO;

import java.util.ResourceBundle;

public class PolicyService {

    public static IPolicyDAO getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new PolicyDAOjdbc();
        } else {
            return new PolicyDAO();
        }
    }

}
