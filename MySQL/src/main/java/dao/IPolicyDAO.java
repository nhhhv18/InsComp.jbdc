package dao;

import java.util.List;

import model.Policy;

public interface IPolicyDAO extends IBaseDAO<Policy> {

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
