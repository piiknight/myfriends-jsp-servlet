package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserDAO;

public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public AdminDelUserController() {
		super();
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}

		User user = userDAO.getItem(id);

		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}

		if ("admin".equals(user.getUsername())) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=2");
			return;
		}

		if (userDAO.delItem(id) > 0) {
			// Xóa thành công
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=3");
			return;
		} else {
			// Xóa thất bại
			response.sendRedirect(request.getContextPath() + "/admin/users?err=3");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
