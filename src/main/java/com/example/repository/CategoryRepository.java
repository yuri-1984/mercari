package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;

/**
 * categoryテーブルの情報を操作するリポジトリクラス.
 * 
 * @author hiraokayuri
 */
@Repository
public class CategoryRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Category> CATEGORY_ROW_MAPPER = (rs, i) -> {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		category.setParentId(rs.getInt("parent_Id"));
		category.setNameAll(rs.getString("name_all"));
		return category;
	};

	/**
	 * カテゴリ情報を全権検索.
	 * 
	 * @return categoryList カテゴリリスト
	 */
	public List<Category> findAll() {
		String sql = "select id,name,parent_id,name_all from category order by id";
		List<Category> categoryList = template.query(sql, CATEGORY_ROW_MAPPER);
		return categoryList;
	}

	/**
	 * parentIdが空のカテゴリを検索(親カテゴリ).
	 * 
	 * @param
	 * @return parentCategoryIdList 親カテゴリリスト
	 */
	public List<Category> findById() {
		String sql = "select id,name,parent_id,name_all from category where parent_id is null";
		List<Category> parentCategoryIdList = template.query(sql, CATEGORY_ROW_MAPPER);
		return parentCategoryIdList;
	}

	/**
	 * parentIdが親カテゴリを検索(子カテゴリ).
	 * 
	 * @param id
	 * @return childCategoryList 子カテゴリリスト
	 */
	public List<Category> findChildById(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		String sql = "select id,name,parent_id,name_all from category where parent_id=:id";
		List<Category> childCategoryList = template.query(sql, param, CATEGORY_ROW_MAPPER);
		return childCategoryList;
	}

	/**
	 * parentIdが子カテゴリを検索(孫カテゴリ).
	 * 
	 * @param count 親カテゴリのカウント件数から最低値を出力
	 * @return grandChildCategoryList 孫カテゴリリスト
	 */
	public List<Category> findGrandChild(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		String sql = "select id,name,parent_id,name_all from category where parent_id =:id";
		List<Category> grandChilldCategoryList = template.query(sql, param, CATEGORY_ROW_MAPPER);
		return grandChilldCategoryList;
	}

}
