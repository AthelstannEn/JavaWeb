package ua.com.controller.user;

import static ua.com.util.ParamBuilder.getParams;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.dto.form.Good_Model_Form;
import ua.com.editor.GPU_TypeEditor;
import ua.com.editor.GoodTypeEditor;
import ua.com.editor.GoodsEditor;
import ua.com.editor.MemoryEditor;
import ua.com.editor.ProccTypeEditor;
import ua.com.editor.RamTypeEditor;
import ua.com.entity.GPU_Type;
import ua.com.entity.Type;
import ua.com.entity.Colors;
import ua.com.entity.Items;
import ua.com.entity.Memory;
import ua.com.entity.Procc_Type;
import ua.com.entity.Ram_Type;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Good_Models_Service;
import ua.com.service.Good_Type_Service;
import ua.com.service.Goods_Service;
import ua.com.service.ItemsService;
import ua.com.service.Memory_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.service.User_Service;
import ua.com.util.ParamBuilder;
import ua.com.validator.GoodModelValidator;

@Controller
@RequestMapping("/user/searching")
@SessionAttributes("form")
public class SearchingController {

	
	
	@Autowired
	private ItemsService itemService;
	
	@Autowired
	private User_Service userService;
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		status.setComplete();
		return "redirect:/user/searching"+getParams(pageable, filter);
	}
	
	@Autowired
	private Good_Models_Service goodModelService;
	
	@Autowired
	private Goods_Service goodService;
	
	@Autowired
	private Good_Type_Service goodTypeService;
	
	@Autowired
	private GPU_Type_Service gpuTypeService;
	
	@Autowired
	private Memory_Service memoryService;
	
	@Autowired
	private Procc_Type_Service proccTypeService;
	
	@Autowired
	private Ram_Type_Service ramTypeService;
	
	

	@RequestMapping("/")
	public String goHome(){
		return "user-hustleMain";
	}
	
	@GetMapping("/cancel")

	
	@InitBinder("form")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Type.class, new GoodTypeEditor(goodTypeService));
		binder.registerCustomEditor(GPU_Type.class, new GPU_TypeEditor(gpuTypeService));
		binder.registerCustomEditor(Memory.class, new MemoryEditor(memoryService));
		binder.registerCustomEditor(Procc_Type.class, new ProccTypeEditor(proccTypeService));
		binder.registerCustomEditor(Ram_Type.class, new RamTypeEditor(ramTypeService));
		binder.registerCustomEditor(Colors.class, new GoodsEditor(goodService));
		binder.setValidator(new GoodModelValidator(goodModelService));
	}
	
	@ModelAttribute("filter")
	public ModelFilter getFilter(){
		return new ModelFilter();
	}
	
	@ModelAttribute("form")
	public Good_Model_Form getForm(){
		return new Good_Model_Form();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("model", goodModelService.findAll(pageable, filter));
		model.addAttribute("goods", goodService.findAll());
		model.addAttribute("goodTypes", goodTypeService.findAll());
		model.addAttribute("gpuTypes", gpuTypeService.findAll());
		model.addAttribute("memories", memoryService.findAll());
		model.addAttribute("proccs", proccTypeService.findAll());
		model.addAttribute("rams", ramTypeService.findAll());
		return "user-searching";
	}
	
	
	
	
/*	
	@PostMapping
	public String save(@ModelAttribute("form")@Valid Good_Model_Form goodModel ,BindingResult br, Model model,SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		goodModelService.save(goodModel);
		status.setComplete();
		return "redirect:/user/searching"+getParams(pageable, filter);
	}
	*/

	private String getParams(Pageable pageable, ModelFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if(!filter.getMax().isEmpty()){
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if(!filter.getMin().isEmpty()){
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		
		if(!filter.getGoodTypesId().isEmpty()){
			for(Integer id: filter.getGoodTypesId()){
				buffer.append("&goodTypesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getGoodsId().isEmpty()){
			for(Integer id: filter.getGoodsId()){
				buffer.append("&goodsId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getGpuTypesId().isEmpty()){
			for(Integer id: filter.getGpuTypesId()){
				buffer.append("&gpuTypesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getMemoriesId().isEmpty()){
			for(Integer id: filter.getMemoriesId()){
				buffer.append("&memoriesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getProccTypesId().isEmpty()){
			for(Integer id: filter.getProccTypesId()){
				buffer.append("&proccTypesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getRamTypesId().isEmpty()){
			for(Integer id: filter.getRamTypesId()){
				buffer.append("&ramTypesId=");
				buffer.append(id);
			}
		}
		
		return buffer.toString();
		
	}
	
	
	
	
	
	
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id,@ModelAttribute("cartAdd")Good_Model_Form goodModel, Model model, 
			Pageable pageable,@ModelAttribute("filter") ModelFilter filter,@ModelAttribute("form") Items item, Principal principal,
			SessionStatus status){
		if(principal!=null){
			System.out.println(principal.getName());
			item.setUserName(principal.getName());
			item.setGoodName(goodModelService.findOne(id).getModelName());
			item.setTotalPrice(goodModelService.findOne(id).getPrice()*item.getQuantity());
			item.setFullName(userService.findByEmail(principal.getName()).getFullName());
			item.setDeliveryAddressCountry(userService.findByEmail(principal.getName()).getDeliveryAddressCountry());
			item.setDeliveryAddressCity(userService.findByEmail(principal.getName()).getDeliveryAddressCity());
			item.setDeliveryHomeAddress(userService.findByEmail(principal.getName()).getDeliveryHomeAddress());
			itemService.save(item);
			status.setComplete();
		}
		return "redirect:/user/searching";
	}
	
	
	
	
}
