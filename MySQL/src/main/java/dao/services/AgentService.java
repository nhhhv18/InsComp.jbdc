package dao.services;


import dao.interfaces.IAgentDAO;
import dao.jdbc.AgentDAOjdbc;
import dao.mybatis.AgentDAO;

import java.util.ResourceBundle;

public class AgentService {

    public static IAgentDAO getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new AgentDAOjdbc();
        } else {
            return new AgentDAO();
        }
    }

}
