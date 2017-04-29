package ua.com.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.com.entity.GPU_Type;
import ua.com.entity.Type;
import ua.com.entity.Colors;
import ua.com.entity.Memory;
import ua.com.entity.Nvidia;
import ua.com.entity.Procc_Type;
import ua.com.entity.Ram_Type;
import ua.com.entity.Screan;

public class Good_Model_Form {

	private int id;

	private int version;

	private MultipartFile file;

	private String modelName;

	private String price;

	private Colors good;

	private Type goodType;

	private GPU_Type gpuType;

	private Memory memoryType;
	
	private Nvidia nvidiaType;

	private Screan screanType;

	private Procc_Type proccType;

	private Ram_Type ramType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Colors getGood() {
		return good;
	}

	public void setGood(Colors good) {
		this.good = good;
	}

	public Type getGoodType() {
		return goodType;
	}

	public void setGoodType(Type goodType) {
		this.goodType = goodType;
	}

	public GPU_Type getGpuType() {
		return gpuType;
	}

	public void setGpuType(GPU_Type gpuType) {
		this.gpuType = gpuType;
	}

	public Memory getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(Memory memoryType) {
		this.memoryType = memoryType;
	}

	public Nvidia getNvidiaType() {
		return nvidiaType;
	}

	public void setNvidiaType(Nvidia nvidiaType) {
		this.nvidiaType = nvidiaType;
	}

	public Screan getScreanType() {
		return screanType;
	}

	public void setScreanType(Screan screanType) {
		this.screanType = screanType;
	}

	public Procc_Type getProccType() {
		return proccType;
	}

	public void setProccType(Procc_Type proccType) {
		this.proccType = proccType;
	}

	public Ram_Type getRamType() {
		return ramType;
	}

	public void setRamType(Ram_Type ramType) {
		this.ramType = ramType;
	}


}
