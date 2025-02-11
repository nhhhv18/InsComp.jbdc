package dao.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.Claim;

public interface IClaimDAO extends IBaseDAO<Claim> {
    @Select(
            "select * from mydb.claims where claim_id = #{index}")
    @Results(value = {
    		@Result(property="claimId", column = "claim_id"),
            @Result(property="policyId", column = "policy_id"),
            @Result(property="claimDate", column = "claim_date"),
            @Result(property="claimAmount", column = "claim_amount"),
            @Result(property="claimStatusId", column = "claim_status_id"),
            @Result(property="description", column = "description"),
    })

	@Override
	Claim getEntityById(int id);
	@Override
	List<Claim> getEntities();
	@Override
	void insert(Claim claim);
	@Override
	void update (int id, Claim claim);
	@Override
	void delete (int id);

}
