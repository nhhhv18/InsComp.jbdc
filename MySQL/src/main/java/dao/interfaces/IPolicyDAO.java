package dao.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("SELECT * FROM mydb.policies")
    @Results({
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
	List<Policy> getEntities();

    @Insert("INSERT INTO mydb.policies (policy_id, policy_type_id, customer_id, start_date, end_date, coverage_amount, premium_amount, agent_id) " +
        "VALUES (#{policyId}, #{policyTypeId}, #{customerId}, #{startDate}, #{endDate}, #{coverageAmount}, #{premiumAmount}, #{agentId})")
    @Override
	void insert(Policy policy);
    @Update("UPDATE mydb.policies SET policy_type_id=#{policy.policyTypeId}, customer_id=#{policy.customerId}, " +
            "start_date=#{policy.startDate}, end_date=#{policy.endDate}, coverage_amount=#{policy.coverageAmount}, " +
            "premium_amount=#{policy.premiumAmount}, agent_id=#{policy.agentId} WHERE policy_id=#{id}")
    @Override
	void update (int id, Policy policy);
    @Delete("DELETE FROM mydb.policies WHERE policy_id=#{id}")
    @Override
	void delete (int id);

}
