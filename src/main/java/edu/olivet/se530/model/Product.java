package edu.olivet.se530.model;

/**
 * 产品
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 14, 2015 10:12:08 AM
 * @version 1.0
 */
public class Product {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @see #isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	private String name;
	/**
	 * 产品ISBN，在亚马逊网站上面对应10位数字、字母组合
	 */
	private String isbn;
}
