package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;
import com.example.domain.Item;

/**
 * 商品一覧のためのリポジトリクラス.
 * 
 * @author hiraokayuri
 *
 */
@Repository
public class ItemRepository {
	/**
	 * ResultSetオブジェクトからitemオブジェクトに変換するためのクラス実装.
	 */
	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
		// データベース上の削除と追加のため、リストの中身を削除追加するわけではないので、ArrayListの方が好ましい。
		Item item = new Item();
		item.setId(rs.getInt("item_id"));
		item.setName(rs.getString("item_name"));
		item.setItemConditionId(rs.getInt("item_item_condition_id"));
		item.setCategoryId(rs.getInt("item_category_id"));
		item.setBrandName(rs.getString("item_brand_name"));
		item.setPrice(rs.getInt("item_price"));
		item.setShipping(rs.getString("item_shipping"));
		item.setItemDescription(rs.getString("item_item_description"));

		Category category = new Category();
		category.setId(rs.getInt("category_id"));
		category.setParentId(rs.getInt("category_parent_id"));
		category.setName(rs.getString("category_name"));
		category.setNameAll(rs.getString("category_name_all"));
		item.setCategory(category);
		return item;

	};

	/**
	 * 商品情報とそれに紐づくカテゴリー情報を全権検索する。
	 * 
	 * @return 商品情報
	 */
	public List<Item> findThirty(Integer number) {
		String sql = "select item.id item_id, item.name item_name,item.item_condition_id item_item_condition_id,item.category_id item_category_id,item.brand_name item_brand_name,item.price item_price,item.shipping item_shipping,item.item_description item_item_description,"
				+ "category.id category_id,category.name category_name,category.parent_id category_parent_id,category.name_all category_name_all From items as item INNER JOIN category as category on item.category_id = category.id ORDER BY item.id LIMIT 30 OFFSET :number";
		SqlParameterSource param = new MapSqlParameterSource().addValue("number", number);
		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
		return itemList;
	}

	/**
	 * itemsテーブルのcount件数を取得する.
	 * 
	 * @return 件数
	 */
	public Integer seachCount() {
		String sql = "select count(*) from items";
		int total = template.getJdbcTemplate().queryForObject(sql, Integer.class);
		return total;
	}

	/**
	 * itemsテーブルの商品情報を一件検索する.
	 * 
	 * @param id 商品ID
	 * @return Item 商品.
	 */
	public Item findById(Integer id) {
		String sql = "select item.id item_id, item.name item_name,item.item_condition_id item_item_condition_id,item.category_id item_category_id,item.brand_name item_brand_name,item.price item_price,item.shipping item_shipping,item.item_description item_item_description,"
				+ " category.id category_id,category.name category_name,category.parent_id category_parent_id,category.name_all category_name_all From items as item INNER JOIN category as category on item.category_id = category.id where item.id =:id ";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(sql, param, ITEM_ROW_MAPPER);
		return item;

	}

	/**
	 * itemsテーブルの商品情報を一件更新する.
	 * 
	 * @param item 商品
	 */
	public void ItemUpdate(Item item) {
		String sql = "UPDATE items SET name=:name, item_condition_id =:itemConditionId, brand_name=:brandName, price =:price, item_description=:itemDescription ,category_id=:categoryId where id=:id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		template.update(sql, param);
	}

	/**
	 * itemsテーブルに商品情報を一件登録する.
	 * 
	 * @param item 商品
	 */
	public void ItemInsert(Item item) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		String sql = "INSERT INTO items(name,item_condition_id,brand_name,price,item_description,category_id)VALUES(:name,:itemConditionId,:brandName,:price,:itemDescription,:categoryId)";
		template.update(sql, param);
	}
}