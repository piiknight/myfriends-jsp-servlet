package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Define;
import model.bean.Category;
import model.bean.Friend;
import model.dao.CategoryDAO;
import model.dao.FriendDAO;


public class PublicIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDAO friendDAO;
	private CategoryDAO categoryDAO;

	public PublicIndexCatController() {
		super();
		friendDAO = new FriendDAO();
		categoryDAO = new CategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		
		Category objCat = categoryDAO.getItem(id);
		if (objCat == null) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		
		int sumFriend = friendDAO.countFriendByFlID(id);
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
		ArrayList<Friend> friends = friendDAO.getItemsPaginationByFlID(id, offset);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("friends", friends);
		request.setAttribute("objCat", objCat);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/danh-muc.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
