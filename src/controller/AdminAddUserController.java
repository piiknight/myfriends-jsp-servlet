package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserDAO;
import util.StringLibrary;

public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public AdminAddUserController() {
		super();
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/users/add.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = StringLibrary.md5(request.getParameter("password"));
		String fullname = request.getParameter("fullname");

		User user = new User(0, username, password, fullname);

		if (userDAO.getItemByUsername(username) != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/users/add.jsp?err=1");
			rd.forward(request, response);
			return;
		} else {
			if (userDAO.addItem(user) > 0) {
				// Thêm thành công
				response.sendRedirect(request.getContextPath() + "/admin/users?msg=1");
				return;
			} else {
				// Thêm thất bại
				response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
				return;
			}
		}

	}

}
