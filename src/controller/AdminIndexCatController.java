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
import util.AuthUtil;

public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
       
    public AdminIndexCatController() {
        super();
        categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}
		
		int sumCat = categoryDAO.countCat();
		int sumPage = (int) Math.ceil((float) sumCat / Define.ROW_PAGINATION_CAT);
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/admin/cats?error=1");
				return;
			}
		}
		int offset = (currentPage - 1) * Define.ROW_PAGINATION_CAT;
		ArrayList<Category> categories = categoryDAO.getItemsPagination(offset);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/cat/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
