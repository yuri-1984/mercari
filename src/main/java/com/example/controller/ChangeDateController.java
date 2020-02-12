package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.EditForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

/**
 * 商品情報の変更を操作するコントローラークラス.
 * 
 * @author hiraokayuri
 *
 */
@Controller
@RequestMapping("/date")
public class ChangeDateController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private CategoryService categoryService;

	/**
	 * 商品情報を書き換えるページを表示させる.
	 * 
	 * @param model リクエストパラメーター
	 * @return edit.html
	 */
	@RequestMapping("/showEditForm")
	public String showEditForm(EditForm form, Integer id, Integer page, Model model) {
		List<Category> categoryList;
		categoryList = categoryService.seachParent();
		Item item = itemService.showDetail(id);
		form.setName(String.valueOf((item.getName())));
		form.setPrice(String.valueOf((item.getPrice())));
		form.setBrandName(item.getBrandName());
		form.setItemConditionId(item.getItemConditionId());
		form.setItemDescription(item.getItemDescription());
		model.addAttribute("EditForm", form);
		model.addAttribute("itemId", item.getId());
		model.addAttribute("page", page);
		model.addAttribute("categoryList", categoryList);
		return "edit";
	}

	/**
	 * 一件検索した商品情報を更新する.
	 * 
	 * @param form
	 * @param model
	 * @return list.hrmlにもどる
	 */
	@RequestMapping("/changeItemDate")
	public String changeItemDate(EditForm form, Model model, Integer page, Integer id) {
		int toPage = page;
		Item item = new Item();
		item.setId(Integer.parseInt(form.getId()));
		item.setName(form.getName());
		item.setPrice(Integer.parseInt(form.getPrice()));
		item.setItemConditionId(form.getItemConditionId());
		item.setItemDescription(form.getItemDescription());
		item.setBrandName(form.getBrandName());
		item.setCategoryId(form.getCategoryId());
		itemService.UpdateItemDate(item);
		model.addAttribute("itemId", item.getId());
		model.addAttribute("page", toPage);

		return showDetail(id, toPage, model);

	}

	/**
	 * 
	 * 商品詳細ページを表示させる.
	 * 
	 * @param id   商品ID
	 * @param mode リクエストパラメーター
	 * @return detail.html
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Integer page, Model model) {
		Item item;
		item = itemService.showDetail(id);
		int nowPage = page;
		model.addAttribute("page", nowPage);
		model.addAttribute("item", item);
		return "detail";
	}

}
