package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;
import util.AuthUtil;
import util.StringLibrary;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public AdminEditUserController() {
		super();
		userDAO = new UserDAO();
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
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		
		if (("admin".equals(userDAO.getItem(userLogin.getId()).getUsername())) || (id == userLogin.getId())) {
			User user = userDAO.getItem(id);
			if (user == null) {
				response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
				return;
			}
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/users/edit.jsp");
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=4");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");

		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}

		if (password == null) {
			password = userDAO.getItemByUsername(username).getPassword();
		} else {
			password = StringLibrary.md5(password);
		}

		User user = new User(id, username, password, fullname);

		if (userDAO.editItem(user) > 0) {
			// Thêm thành công
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=2");
			return;
		} else {
			// Thêm thất bại
			response.sendRedirect(request.getContextPath() + "/admin/users?err=2");
			return;
		}

	}

}
