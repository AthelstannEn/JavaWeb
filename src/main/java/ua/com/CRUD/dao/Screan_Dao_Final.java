package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;




import ua.com.entity.Screan;

public interface Screan_Dao_Final  extends JpaRepository<Screan, Integer>, JpaSpecificationExecutor<Screan>  {

	

	Screan findByType(String typeName);
	
	@Query("select i from Screan i join i.goodModels m where m.id=?1")
	List<Screan> findByModelId(int id);
	
	
	
}
