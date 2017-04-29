package ua.com.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import ua.com.service.GPU_Type_Service;
import ua.com.service.Good_Models_Service;
import ua.com.service.Good_Type_Service;
import ua.com.service.Goods_Service;
import ua.com.service.Memory_Service;
import ua.com.service.Nvidia_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.service.Screan_Service;
import ua.com.service.User_Service;
import ua.com.serviceImpl.GPU_Type_ServiceImpl;
import ua.com.serviceImpl.Good_Models_ServiceImpl;
import ua.com.serviceImpl.Good_Type_ServiceImpl;
import ua.com.serviceImpl.Goods_ServiceImpl;
import ua.com.serviceImpl.Memory_ServiceImpl;
import ua.com.serviceImpl.Nvidia_ServiceImpl;
import ua.com.serviceImpl.Procc_Type_ServiceImpl;
import ua.com.serviceImpl.Ram_Type_ServiceImpl;
import ua.com.serviceImpl.Screan_ServiceImpl;
import ua.com.serviceImpl.User_ServiceImpl;

public class Controller {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
		
		Good_Models_Service goodModelService = (Good_Models_Service) context.getBean(Good_Models_ServiceImpl.class);
		
		Good_Type_Service goodTypeService = (Good_Type_Service) context.getBean(Good_Type_ServiceImpl.class);
		
		Goods_Service goodService = (Goods_Service) context.getBean(Goods_ServiceImpl.class);
		
		GPU_Type_Service gpuTypeService = (GPU_Type_Service) context.getBean(GPU_Type_ServiceImpl.class);
		
		Memory_Service memoryService = (Memory_Service) context.getBean(Memory_ServiceImpl.class);
		
		Procc_Type_Service proccTypeService = (Procc_Type_Service) context.getBean(Procc_Type_ServiceImpl.class);
		
		Nvidia_Service nvidiaService = (Nvidia_Service) context.getBean(Nvidia_ServiceImpl.class);
		
		Screan_Service screanService = (Screan_Service) context.getBean(Screan_ServiceImpl.class);
		
		Ram_Type_Service  ramTypeService = (Ram_Type_Service) context.getBean(Ram_Type_ServiceImpl.class);
		
		User_Service userService = (User_Service) context.getBean(User_ServiceImpl.class);
		
		
		System.out.println(userService.findByEmail("appleshopteam@gmail.com"));
		
		
		
		
		context.close();
		
		
	}

}
