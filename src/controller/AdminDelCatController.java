package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	
    public AdminDelCatController() {
        super();
        categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=2");
			return;
		}
		
		Category category = categoryDAO.getItem(id);
		if (category == null) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=2");
			return;
		}
		if (categoryDAO.delItem(category) > 0) {
			// Xóa thành công
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=3");
			return;
		} else {
			// Xóa thất bại
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=4");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
