package ua.com.service;

import java.util.List;










import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.entity.Type;
import ua.com.entity.Colors;

public interface Goods_Service {

	void save (Colors colors);
	List<Colors> findAll();
	Colors findOne(int id);
	void delete(int id);
	
	Colors findByMadeCountry(String madeCountry);
	
	List<Colors> findByModelId(int id);


	Page<Colors> findAll(TypeFilter filter, Pageable pageable);

	
}
