package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Friend;
import model.dao.FriendDAO;
import util.AuthUtil;

public class AdminDelFriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDAO friendDAO;

	public AdminDelFriendsController() {
		super();
		friendDAO = new FriendDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}

		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/index.jsp?error=1");
			rd.forward(request, response);
			return;
		}
		Friend friend = friendDAO.getItemByID(id);
		if (friend == null) {
			response.sendRedirect(request.getContextPath() + "/admin/friends?error=1");
			return;
		}

		if (friendDAO.delItem(friend) > 0) {
			// Xóa thành công
			response.sendRedirect(request.getContextPath() + "/admin/friends?msg=2");
			return;
		} else {
			// Xóa thất bại
			response.sendRedirect(request.getContextPath() + "/admin/friends?err=2");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
