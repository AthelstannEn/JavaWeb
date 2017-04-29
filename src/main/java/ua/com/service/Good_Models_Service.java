package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.method.annotation.ModelFactory;

import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.dto.form.Good_Model_Form;
import ua.com.entity.GPU_Type;
import ua.com.entity.Model;
import ua.com.entity.Type;
import ua.com.entity.Colors;
import ua.com.entity.Memory;
import ua.com.entity.Nvidia;
import ua.com.entity.Procc_Type;
import ua.com.entity.Ram_Type;
import ua.com.entity.Screan;

public interface Good_Models_Service {

	void save (Good_Model_Form form);
	List<Model> findAll();
	Model findOne(int id);
	void delete(int id);
	
	Model findBymodelName(String modelName);
	
	
	List<Model> findByTypeId(int id);
	
	List<Model> findByGoodId(int id);

	
	Good_Model_Form findForm(int id);
	
/*	Good_Models findUnique(String modelName, String price, Goods good, Good_Type goodType
			,GPU_Type gpuType, Memory memoryType,   Nvidia nvidiaType, Screan screanType, Procc_Type proccType, Ram_Type ramType);
	
	
	*/
	Model findUnique(String modelName, 
			String price, 
			Colors  good,
			Type goodType
			,GPU_Type gpuType,
			Memory memoryType,
			Nvidia nvidiaType,
			Screan screanType,
			Procc_Type proccType, 
			Ram_Type ramType);
	
	
	
	
	
	Page<Model> findAll(Pageable pageable, ModelFilter filter);
	

	
	Page<Model> findAll(TypeFilter filter, Pageable pageable);
	

	

	
}
