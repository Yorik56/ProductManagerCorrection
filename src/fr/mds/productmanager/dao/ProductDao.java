package fr.mds.productmanager.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.mds.productmanager.model.Product;

public class ProductDao {

	private static List<Product> products = new ArrayList<>();
	private static long counter = 0;
	
	public static List<Product> getAllProducts() {
		return products;
	}
	
	public static void addProduct(Product p) {
		p.setId(counter++);
		products.add(p);
	}
	
	public static Product findProduct(Long id) { 
		for(Product p : products) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public static void removeProduct(Long id) {
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			Product p = it.next();
			if (p.getId() == id) {
				it.remove();
			}
		}
	}

}
