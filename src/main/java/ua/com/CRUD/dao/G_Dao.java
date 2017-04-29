package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.entity.Model;
import ua.com.entity.Colors;

public interface G_Dao extends JpaRepository<Colors, Integer> , JpaSpecificationExecutor<Colors>{

	Colors findByMadeCountry(String madeCountry);

	
	@Query("select i from Goods i join i.goodModels m where m.id=?1")
	List<Colors> findByModelId(int id);
	


	
}
