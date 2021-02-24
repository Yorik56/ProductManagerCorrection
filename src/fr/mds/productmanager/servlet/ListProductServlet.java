package fr.mds.productmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.productmanager.dao.ProductDao;
import fr.mds.productmanager.model.Product;

@SuppressWarnings("serial")
public class ListProductServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = ProductDao.getAllProducts();
		
		PrintWriter out = resp.getWriter();
		
		for(Product p : products) {
			out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
		}
	}
	
	
	

}
