package com.genx.hibernate.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Store")

public class Products {
	@Id
	private int id;
	private String Product_Name;
	private String price;

	public Products(int id, String product_Name, String price) {
		super();
		this.id = id;
		Product_Name = product_Name;
		this.price = price;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", Product_Name=" + Product_Name + ", price=" + price + "]";
	}

}
