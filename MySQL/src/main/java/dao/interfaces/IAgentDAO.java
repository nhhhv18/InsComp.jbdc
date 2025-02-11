package dao.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.Agent;

public interface IAgentDAO extends IBaseDAO<Agent> {
    @Select(
            "select * from mydb.agents where agent_id = #{index}")
    @Results(value = {
    		@Result(property="agentId", column = "agent_id"),
            @Result(property="agentName", column = "agent_desc"),
    })

	@Override
		Agent getEntityById(int id);
	@Override
		List<Agent> getEntities();
	@Override
		void insert(Agent t);
	@Override
		void update (int id, Agent t);
	@Override
		void delete (int id);


}
