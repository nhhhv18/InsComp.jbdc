package dao.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.Policy;

public interface IPolicyDAO extends IBaseDAO<Policy> {
    @Select(
            "select * from mydb.policies where policy_id = #{index}")
    @Results(value = {
    		@Result(property="policyId", column = "policy_id"),
    		@Result(property="policyTypeId", column = "policy_type_id"),
            @Result(property="customerId", column = "customer_id"),
            @Result(property="startDate", column = "start_date"),
            @Result(property="endDate", column = "end_date"),
            @Result(property="coverageAmount", column = "coverage_amount"),
            @Result(property="premiumAmount", column = "premium_amount"),
            @Result(property="agentId", column = "agent_id"),
    })

	@Override
	Policy getEntityById(int id);
	@Override
	List<Policy> getEntities();
	@Override
	void insert(Policy policy);
	@Override
	void update (int id, Policy policy);
	@Override
	void delete (int id);

}
