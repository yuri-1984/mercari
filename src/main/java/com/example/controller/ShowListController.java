 package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.service.CategoryService;
import com.example.service.ItemService;

/**
 * 商品リストページに関連するコントローラークラス.
 * 
 * @author hiraokayuri
 *
 */
@Controller
@RequestMapping("")
public class ShowListController {
	@Autowired
	private ItemService service;
	@Autowired
	private CategoryService categoryService;

	/**
	 * 商品一覧を表示させる.
	 * 
	 * @param page  ページ数
	 * @param model リクエストパラメーター
	 * @return list.html
	 */
	@RequestMapping("/")
	public String ShowList(Integer page, Model model) {
		List<Item> itemList;
		List<Category> categoryList;
		if (page == null) {
			// ページ指定がない場合は１ページ目を表示させる
			page = 0;
		}
		itemList = service.showList(page);
		categoryList = categoryService.seachParent();
		if (itemList == null) {
			model.addAttribute("message", "データがありません");
		}
		model.addAttribute("itemList", itemList);
		model.addAttribute("page", page);
		model.addAttribute("categoryList", categoryList);
		return "list";
	}

	/**
	 * 子カテゴリのデータをjsonで送る.
	 * @param id
	 * @return 
	 */
	@RequestMapping("/category")
	@ResponseBody
	public List<Category> getCategory(Integer id) {
		List<Category> childCategory = categoryService.serchChild(id);
		return childCategory;
	}
	
	/**
	 * 孫カテゴリのデータをjsonで送る.
	 * @param id
	 * @return grandChildCategory
	 */
	@RequestMapping("/category2")
	@ResponseBody
	public List<Category> getCategoryById(Integer id){
		List<Category> grandChildCategory = categoryService.serchGrandChild(id);
		return grandChildCategory;
	}



}
