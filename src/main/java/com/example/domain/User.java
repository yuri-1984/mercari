package com.example.domain;

/**
 * ユーザー情報のエンティティクラス.
 * @author hiraokayuri
 *
 */
public class User {
	
	/** ID*/
	private Integer id;
	/** メールアドレス*/
	private String mailaddres;
	/** パスワード*/
	private String pass;
	/** 氏名*/
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMailaddres() {
		return mailaddres;
	}
	public void setMailaddres(String mailaddres) {
		this.mailaddres = mailaddres;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", mailaddres=" + mailaddres + ", pass=" + pass + ", name=" + name + "]";
	}
	
	
}
