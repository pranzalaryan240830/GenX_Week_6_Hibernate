package com.genx.hibernate.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println(".......... Hibernate Works!!");
		System.out.println("Successfully Connected!");

		// Create operation in DB
		Products p1 = new Products(0, "Brown Bread", "20");
		insertProd(p1);
		Products p2 = new Products(1, "Biscuit", "50");
		insertProd(p2);
		Products p3 = new Products(2, "Cake", "200");
		insertProd(p3);

		// Update
		UpdateProductPrice(0, "25");

		// Delete operation in DB
		deleteProduct(1);

		// Read or Show operation in DB
		System.out.println("Fetching all data from Store Table !");
		getAllProducts();
	}

// Insert a Product
	public static void insertProd(Products newP) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(newP);
		System.out.println("Successfully Saved!");
		tx.commit();
		factory.close();

	}

// Update operation in DB
	public static void UpdateProductPrice(int id, String newPrice) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Products prod = session.get(Products.class, id);
		prod.setPrice(newPrice);
		session.saveOrUpdate(prod);
		session.close();
		tx.commit();
		factory.close();
	}

// Read operation in DB
	public static void getAllProducts() {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		List<Products> allProd = session.createQuery("from Store", Products.class).list();
		allProd.forEach(pr -> System.out
				.println("Product " + pr.getId() + " - " + pr.getProduct_Name() + " - " + pr.getPrice()));
		session.close();
		factory.close();
	}

// Read operation in DB
	public static void deleteProduct(int id) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Products prod = new Products();
		prod.setId(id);
		session.remove(prod);
		System.out.println("Product " + id + " is deleted");
		session.close();
		tx.commit();
		factory.close();
	}
}