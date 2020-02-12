package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.AddItemForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

/**
 * itemsテーブルに商品情報を追加するコントローラークラス.
 * 
 * @author hiraokayuri
 */
@Controller
@RequestMapping("/add")
public class AddItemController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ItemService itemService;

	/**
	 * エラーチェック用.
	 * 
	 * @return 空のAddItemFormオブジェクト
	 * ModelAttribute formの名前を小文字にした値がhtmlに届くのでth:objectは小文字始まりで記入. 
	 */
	@ModelAttribute
	private AddItemForm setUpAddItemForm() {
		return new AddItemForm();
	}

	/**
	 * 商品追加画面を表示するメソッド.
	 * 
	 * @return add.html.
	 */
	@RequestMapping("/showAddForm")
	public String showAddForm(Model model) {
		List<Category> categoryList;
		categoryList = categoryService.seachParent();
		model.addAttribute("categoryList", categoryList);
		return "add";

	}

	/**
	 * 商品情報を追加するメソッド.
	 * 
	 * @param form   リクエストパラメーター
	 * @param result 商品情報一覧画面.
	 * @return
	 */
	@RequestMapping("/addItem")
	public String addItem(@Validated AddItemForm form, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return showAddForm(model);
		}
		Item item = new Item();
		item.setName(form.getName());
		item.setItemConditionId(form.getItemConditionId());
		item.setCategoryId(form.getCategoryId());
		item.setBrandName(form.getBrandName());
		item.setPrice(Integer.parseInt(form.getPrice()));
		item.setItemDescription(form.getItemDescription());
		itemService.InsertItemDate(item);
		return "redirect:/";
	}

}
