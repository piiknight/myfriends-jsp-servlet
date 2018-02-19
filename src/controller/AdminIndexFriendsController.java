package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Friend;
import model.dao.FriendDAO;

public class AdminIndexFriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDAO friendDAO;
       
    public AdminIndexFriendsController() {
        super();
        friendDAO = new FriendDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Friend> friends = friendDAO.getItems();
		request.setAttribute("friends", friends);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
