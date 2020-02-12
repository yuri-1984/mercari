package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;

/**
 * categoryテーブルの情報を操作するサービスクラス.
 * 
 * @author hiraokayuri
 */
@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	/**
	 * カテゴリテーブルの情報を全件検索(Json形式で値を変換するため)
	 * 
	 * @return categoryList
	 */
	public List<Category> serchChild(Integer id) {

		return repository.findChildById(id);

	}

	/**
	 * カテゴリーテーブルの親カテゴリーを全件検索する
	 * 
	 * @return categoryList
	 */
	public List<Category> seachParent() {
		return repository.findById();

	}

	/**
	 * カテゴリーテーブルの情報を検索する(JSON形式で値を変換するため)
	 * 
	 * @param id
	 * @return grandChildCategory
	 */
	public List<Category> serchGrandChild(Integer id) {
		return repository.findGrandChild(id);
	}

}
