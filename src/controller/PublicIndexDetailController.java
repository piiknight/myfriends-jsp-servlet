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


public class PublicIndexDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDAO friendDAO;

	public PublicIndexDetailController() {
		super();
		friendDAO = new FriendDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int fid = 0;
		try {
			fid = Integer.parseInt(request.getParameter("fid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		
		// Tăng lượt xem
		friendDAO.increaseView(fid);
				
		Friend friend = friendDAO.getItemByID(fid);
		if (friend == null) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		
		
		int sumFriend = friendDAO.countFriendByFlID(friend.getCategory().getFl_id()) - 1;
		int sumPage = (int) Math.ceil((float) sumFriend / Define.ROW_PAGINATION_FRIEND_INVOLVE);
		int currentPage = 1;
		int offset = (currentPage - 1) * Define.ROW_PAGINATION_FRIEND_INVOLVE;
		ArrayList<Friend> anotherFriends = friendDAO.getItemsPaginationInvolve(fid, friend.getCategory().getFl_id(), offset);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("anotherFriends", anotherFriends);
		
		request.setAttribute("friend", friend);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/chi-tiet.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idpage = 0;
		try {
			idpage = Integer.parseInt(request.getParameter("idpage"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		
		Friend friend = friendDAO.getItemByID(id);
		if (friend == null) {
			response.sendRedirect(request.getContextPath() + "/index?err=1");
			return;
		}
		int offset = (idpage - 1) * Define.ROW_PAGINATION_FRIEND_INVOLVE;
		
		ArrayList<Friend> listInvolve = friendDAO.getItemsPaginationInvolve(id, friend.getCategory().getFl_id(), offset);
		
		request.setAttribute("listInvolve", listInvolve);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/involve.jsp");
		rd.forward(request, response);
		return;
	}

}
