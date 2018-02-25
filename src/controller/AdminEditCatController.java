package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;
import util.AuthUtil;

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;

	public AdminEditCatController() {
		super();
		categoryDAO = new CategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}

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
		request.setAttribute("category", category);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/cat/edit.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=2");
			return;
		}

		Category category = new Category(id, name);

		if (categoryDAO.editItem(category) > 0) {
			// Sửa thành công
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=2");
			return;
		} else {
			// Sửa thất bại
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=3");
			return;
		}

	}

}
