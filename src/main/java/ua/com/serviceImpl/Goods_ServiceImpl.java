package ua.com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Model_Dao;
import ua.com.CRUD.dao.G_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.entity.Colors;
import ua.com.service.Goods_Service;

@Service
public class Goods_ServiceImpl implements Goods_Service {

	@Autowired
	private G_Dao goodDao;
	@Autowired
	private Model_Dao modelDao;

	public void save(Colors colors) {
		goodDao.save(colors);
	}

	
	public List<Colors> findAll() {
		return goodDao.findAll();
	}

	
	public Colors findOne(int id) {
		return goodDao.findOne(id);
	}

	
	public void delete(int id) {
		modelDao.save(modelDao.findByGoodId(id).stream().peek(e->e.setGood(null)).collect(Collectors.toList()));
		goodDao.delete(id);
		
	}


	public List<Colors> findByModelId(int id) {
		return goodDao.findByModelId(id);
	}


	public Colors findByMadeCountry(String madeCountry) {
		return goodDao.findByMadeCountry(madeCountry);
	}


	@Override
	public Page<Colors> findAll(TypeFilter filter, Pageable pageable) {
		return goodDao.findAll(findByTypeLike(filter), pageable);
	}

	private Specification<Colors> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("madeCountry")), filter.getSearch().toLowerCase()+"%");
		};
	}



	
	










}
