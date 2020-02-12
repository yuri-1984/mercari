package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品情報を操作するサービスクラス.
 * 
 * @author hiraokayuri
 *
 */
@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	// １ページに表示する商品情報は30件
	private static final int VIEW_SIZE = 30;
	
	/** 
	 * 30件の商品情報を出力する.
	 * 
	 * @param page　ページ数
	 * @return itemList 商品情報
	 */
	public List<Item> showList(Integer page) {
		List<Item> itemList;
		int count = itemRepository.seachCount();
		// 商品総数を表示したい件数で割って最大ページ数を計算する.
		int maxPage = (int) (count / VIEW_SIZE);
		//もしカウント数が割り切れなかった場合はmaxPageに1＋することで余った商品情報を出力する.
		if((count%30)!=0) {
		maxPage ++;
		}
		if(page == 0) {
			itemList = itemRepository.findThirty(0);
		}
		// もし最大件数よりも下か、同じだったら商品情報を検索する.
		else if (page <= maxPage && page!=0) {
		// 検索開始番号がページ数＊30＋１でoffsetの値を決める.
			int number = 30 * page ;
			itemList = itemRepository.findThirty(number);

		}else {
			itemList = null;
		}
		return itemList;

	}
	
	/**
	 * 商品情報を一件取得する.
	 * @param id　商品ID
	 * @return item 商品詳細情報
	 */
	public Item showDetail(Integer id) {
		Item item;
		return item = itemRepository.findById(id);
	}
	
	/**
	 * 1件の商品情報を更新する.
	 * @param item 商品情報
	 */
	public void UpdateItemDate (Item item) {
		itemRepository.ItemUpdate(item);
	}
	
	/**
	 * 1件の商品情報を登録する.
	 * 
	 * @param item 商品情報
	 */
	public void InsertItemDate(Item item) {
		itemRepository.ItemInsert(item);
	}
	

}
