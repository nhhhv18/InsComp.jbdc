package dao.services;


import dao.interfaces.IClaimDAO;
import dao.jdbc.ClaimDAOjdbc;
import dao.mybatis.ClaimDAO;

import java.util.ResourceBundle;

public class ClaimService {

    public static IClaimDAO getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new ClaimDAOjdbc();
        } else {
            return new ClaimDAO();
        }
    }

}
