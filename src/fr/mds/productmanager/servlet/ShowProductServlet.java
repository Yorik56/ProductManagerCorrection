package fr.mds.productmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mds.productmanager.dao.ProductDao;
import fr.mds.productmanager.model.Product;

@SuppressWarnings("serial")
public class ShowProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		
		PrintWriter out = resp.getWriter();
		
		if (idStr == null) {
			//request parameter named "id" not found
			out.println("Missing 'id' parameter");
			return; //stop execution
		}
		
		Long idLong = null;
		
		try {
			idLong = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			out.println("Parameter 'id' is not a long");
			return; //stop execution
		}

		Product p = ProductDao.findProduct(idLong);
		
		out.println("Product: " + p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getDescription());
	}
	
	
}
