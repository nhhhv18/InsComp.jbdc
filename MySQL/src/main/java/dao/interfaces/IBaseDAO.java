package dao.interfaces;
import java.util.List;

public interface IBaseDAO<T> {
	
	T getEntityById(int id);
	
	List<T> getEntities();
	
	void insert(T t);
	
	void update (int id, T t);
	
	void delete (int id);

}
