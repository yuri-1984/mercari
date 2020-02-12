package com.example.domain;

import java.io.Serializable;

/**
 * jsonの値を格納するdomainクラス.
 * 
 * @author hiraokayuri
 *
 */
public class Json implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String nameAll;
	private Integer parentId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameAll() {
		return nameAll;
	}
	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
