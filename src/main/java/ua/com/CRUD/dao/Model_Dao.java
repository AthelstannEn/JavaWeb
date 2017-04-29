package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.dto.filter.ModelFilter;
import ua.com.entity.Model;
import ua.com.specifications.GoodModelSpecifications;

public interface Model_Dao extends JpaRepository<Model, Integer >, JpaSpecificationExecutor<Model> {

	Model findBymodelName(String modelName);
	
	
	
	@Query("select i from Good_Models i  where i.goodType.id=?1")
	List<Model> findByTypeId(int id);
	
	@Query("select i from Good_Models i  where i.good.id=?1")
	List<Model> findByGoodId(int id);


	@Query("select a from Good_Models a"
			+ " LEFT JOIN FETCH a.goodType "
			+ "LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH "
			+ "a.memoryType LEFT JOIN FETCH   "
			+ " a.nvidiaType LEFT JOIN FETCH"
			+ " a.screanType LEFT JOIN FETCH "
			+ "a.proccType LEFT JOIN FETCH "
			+ "a.ramType LEFT JOIN FETCH a.good")
	List<Model> findAll();
	

	@Query("select a from Good_Models a"
			+ " LEFT JOIN FETCH a.goodType "
			+ "LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH "
			+ "a.memoryType LEFT JOIN FETCH    "
			+ "a.nvidiaType LEFT JOIN FETCH "
			+ "a.screanType LEFT JOIN FETCH "
			+ "a.proccType LEFT JOIN FETCH "
			+ "a.ramType LEFT JOIN FETCH a.good where a.id=?1")
	Model findOne(int id);
	
	@Query("SELECT a FROM Good_Models a WHERE a.modelName=?1 "
			+ "and a.price=?2 "
			+ "and a.good.id=?3 "
			+ "and a.goodType.id=?4"
			+ " and a.gpuType.id=?5"
			+ " and a.memoryType.id=?6  "
			+ "and a.nvidiaType.id=?7"
			+ " and a.screanType.id=?8"
			+ "and a.proccType.id=?9"
			+ " and a.ramType.id=?10")
	Model findUnique(String modelName, 
			int price, 
			int goodId,
			int goodTypeId
			,int gpuTypeId,
			int memoryTypeId,
			int nvidiaTypeId,
			int screanTypeId,
			int proccTypeId, 
			int ramTypeId);
	

	
}
