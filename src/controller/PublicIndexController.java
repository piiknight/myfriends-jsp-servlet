package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Define;
import model.bean.Friend;
import model.dao.FriendDAO;


public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDAO friendDAO;

	public PublicIndexController() {
		super();
		friendDAO = new FriendDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sumFriend = friendDAO.countFriend();
		int sumPage = (int) Math.ceil((float) sumFriend / Define.ROW_PAGINATION_FRIEND);
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/index?err=2");
				return;
			}
		}
		if (currentPage < 1 || currentPage > sumPage) {
			response.sendRedirect(request.getContextPath() + "/index?err=2");
			return;
		}
		int offset = (currentPage - 1) * Define.ROW_PAGINATION_FRIEND;
		ArrayList<Friend> friends = friendDAO.getItemsPagination(offset);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("friends", friends);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/index.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
