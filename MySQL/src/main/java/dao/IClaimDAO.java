package dao;

import java.util.List;

import model.Claim;

public interface IClaimDAO extends IBaseDAO<Claim> {

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
