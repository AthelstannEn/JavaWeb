package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.Colors;
import ua.com.service.Goods_Service;

public class GoodsEditor extends PropertyEditorSupport {

	private final Goods_Service goodService;

	public GoodsEditor(Goods_Service goodService) {
		super();
		this.goodService = goodService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Colors good = goodService.findOne(Integer.valueOf(text));
		setValue(good);
	
	}
	
	
}
