package ua.com.serviceImpl;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;







import ua.com.CRUD.dao.Model_Dao;
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
import ua.com.service.FileWriter;
import ua.com.service.Good_Models_Service;
import ua.com.service.FileWriter.Folder;
import ua.com.specifications.GoodModelSpecifications;

@Service
public class Good_Models_ServiceImpl implements Good_Models_Service {
 

	
	@Autowired
	private Model_Dao goodModelDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public void save(Good_Model_Form form) {

		Model entity = new Model();
		
		entity.setId(form.getId());
		
		entity.setModelName(form.getModelName());
		
		entity.setPrice(new Integer(form.getPrice()));
		
		entity.setGood(form.getGood());
		
		entity.setGoodType(form.getGoodType());
		
		entity.setGpuType(form.getGpuType());
		
		entity.setMemoryType(form.getMemoryType());
		
		
		
		entity.setProccType(form.getProccType());
		
		entity.setRamType(form.getRamType());
		
		
entity.setNvidiaType(form.getNvidiaType());
		
		entity.setScreanType(form.getScreanType());
		
		goodModelDao.save(entity);
		
		entity = goodModelDao.saveAndFlush(entity);
		
	
		
		if(fileWriter.write(Folder.GoodModels, form.getFile(),entity.getId())){
			
			entity.setVersion(form.getVersion()+1);
			
			goodModelDao.save(entity);
		}


	}

	public List<Model> findAll() {
		return goodModelDao.findAll();
		
	}

	
	public Model findOne(int  id) {
		
		return goodModelDao.findOne(id);
		
	}

	
	public void delete(int id) {

		goodModelDao.delete(id);
		
	}

	public Model findBymodelName(String modelName) {
		return goodModelDao.findBymodelName(modelName);
	}

	public List<Model> findByTypeId(int id) {
		return goodModelDao.findByTypeId(id);
	}

	public List<Model> findByGoodId(int id) {
		return goodModelDao.findByGoodId(id);
	}

	public Good_Model_Form findForm(int id) {
		Model entity = findOne(id);
		
		Good_Model_Form form = new Good_Model_Form();
		
		form.setPrice(String.valueOf(entity.getPrice()));
		
		form.setId(entity.getId());
		
		form.setModelName(entity.getModelName());
		
		form.setGood(entity.getGood());
		
		form.setGoodType(entity.getGoodType());
		
		form.setGpuType(entity.getGpuType());
		
		form.setMemoryType(entity.getMemoryType());
		
		form.setNvidiaType(entity.getNvidiaType());
		
		form.setScreanType(entity.getScreanType());
		
		form.setProccType(entity.getProccType());
		
		form.setRamType(entity.getRamType());
		
		return form;
	}

	public Model findUnique(String modelName, String price, Colors good,
			Type goodType, GPU_Type gpuType, Memory memoryType, Nvidia nvidiaType, Screan screanType, 
			Procc_Type proccType, Ram_Type ramType) {
		return goodModelDao.findUnique(modelName, new Integer(price), good.getId(), goodType.getId(), gpuType.getId(), memoryType.getId(), nvidiaType.getId()  ,screanType.getId()  , proccType.getId(), ramType.getId());
	}

	@Override
	public Page<Model> findAll(Pageable pageable, ModelFilter filter) {
		return goodModelDao.findAll(new GoodModelSpecifications(filter), pageable);
	}

	@Override
	public Page<Model> findAll(TypeFilter filter, Pageable pageable) {
		return goodModelDao.findAll(findByModelNameLike(filter), pageable);
	}
	
	private Specification<Model> findByModelNameLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("modelName")), filter.getSearch().toLowerCase()+"%");
		};
	}

	
}
