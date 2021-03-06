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

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;

	public AdminAddCatController() {
		super();
		categoryDAO = new CategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/cat/add.jsp");
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

		Category category = new Category(0, name);

		if (categoryDAO.getItemByName(name) != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/cat/add.jsp?err=1");
			rd.forward(request, response);
			return;
		} else {
			if (categoryDAO.addItem(category) > 0) {
				// Thêm thành công
				response.sendRedirect(request.getContextPath() + "/admin/cats?msg=1");
				return;
			} else {
				// Thêm thất bạ
				response.sendRedirect(request.getContextPath() + "/admin/cats?err=1");
				return;
			}
		}

	}

}
