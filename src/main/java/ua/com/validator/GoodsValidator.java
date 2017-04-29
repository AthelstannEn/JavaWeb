package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.entity.Colors;
import ua.com.service.Goods_Service;

public class GoodsValidator implements Validator {

	private final Goods_Service goodService;
	
	public GoodsValidator(Goods_Service goodService) {
		super();
		this.goodService = goodService;
	}
	

	public boolean supports(Class<?> clazz) {
		return Colors.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Colors colors = (Colors) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "madeCountry", "", "Can not be empty");
		
		if(goodService.findByMadeCountry(colors.getMadeCountry())!=null){
			errors.rejectValue("madeCountry", "", "Already exists");
		}
	}

	
	
}
