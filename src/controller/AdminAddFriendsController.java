package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Friend;
import model.dao.CategoryDAO;
import model.dao.FriendDAO;

@MultipartConfig
public class AdminAddFriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	private FriendDAO friendDAO;
       
    public AdminAddFriendsController() {
        super();
        categoryDAO = new CategoryDAO();
        friendDAO = new FriendDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> categories = categoryDAO.getItems();
		request.setAttribute("categories",categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/add.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
		
		if (name.isEmpty() || preview.isEmpty() || detail.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/add.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		
		int catId = 0;
		try {
			catId = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			// Trả về id của cat không hợp lệ
			response.sendRedirect(request.getContextPath() + "/admin/friends/add.jsp?err=1");
			return;
		}
		
		// upload ảnh
		final Part part = request.getPart("picture");
		String fileName = getFileName(part);
		
		// upload anh
		String filePath = "";
		if (!"".equals(fileName)) {

			// tạo đường dẫn thư mục chứa file
			String dirPath = request.getServletContext().getRealPath("/files");

			File dirFile = new File(dirPath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			String temp = part.getContentType();
			String[] arr = temp.split("/");
			boolean check = false;
			if ("image".equals(arr[0])) {
				check = true;
			}
			if (check) {
				long time = System.currentTimeMillis();
				fileName = "files" + "_" + Long.toString(time) + "." + arr[arr.length - 1];

				filePath = dirPath + File.separator + fileName;

				System.out.println(filePath);
			} else {
				ArrayList<Category> categories = categoryDAO.getItems();
				if (categories.size() == 0) {
					response.sendRedirect(request.getContextPath() + "/admin/friends");
					return;
				}
				request.setAttribute("categories", categories);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/add.jsp?err=1");
				rd.forward(request, response);
				return;
			}
		} else {
			ArrayList<Category> categories = categoryDAO.getItems();
			if (categories.size() == 0) {
				response.sendRedirect(request.getContextPath() + "/admin/friends");
				return;
			}
			request.setAttribute("categories", categories);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/add.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		
		//
		
		Friend friend = new Friend(0, name, preview, detail, null, 10, fileName, new Category(catId, null));
		if (friendDAO.addItem(friend) > 0) {
			part.write(filePath);
			response.sendRedirect(request.getContextPath() + "/admin/friends?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/friends?err=1");
			return;
		}
				
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : partHeader.split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
