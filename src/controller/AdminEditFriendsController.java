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
import util.AuthUtil;

@MultipartConfig
public class AdminEditFriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDAO friendDAO;
	private CategoryDAO categoryDAO;

	public AdminEditFriendsController() {
		super();
		friendDAO = new FriendDAO();
		categoryDAO = new CategoryDAO();
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

		ArrayList<Category> categories = categoryDAO.getItems();
		if (categories.size() == 0) {
			response.sendRedirect(request.getContextPath() + "/admin/friends");
			return;
		}
		request.setAttribute("friend", friend);
		request.setAttribute("categories", categories);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/edit.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.CheckLogin(request, response)) {
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		int catId = 0;
		try {
			catId = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			// Trả về id của cat không hợp lệ
			response.sendRedirect(request.getContextPath() + "/admin/news/edit?error=1");
			return;
		}

		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");

		// validate
		if (name.isEmpty() || preview.isEmpty() || detail.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/news/edit.jsp?err=1");
			rd.forward(request, response);
			return;
		}

		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/news?error=1");
			return;
		}

		// upload ảnh
		final Part part = request.getPart("picture");
		String fileName = getFileName(part);
		String dirPath = request.getServletContext().getRealPath("/files");

		String filePath = "";
		if (!"".equals(fileName)) {

			// tạo đường dẫn thư mục chứa file

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
				// Có sửa hình ảnh
				if (!"".equals(friendDAO.getItemByID(id).getPicture())) {
					// Xóa hình ảnh cũ, xóa file
					String urlFileDel = dirPath + File.separator + friendDAO.getItemByID(id).getPicture();
					File delFilr = new File(urlFileDel);
					if (delFilr.exists()) {
						delFilr.delete();
					}
				}

				long time = System.currentTimeMillis();
				fileName = "files" + "_" + Long.toString(time) + "." + arr[arr.length - 1];

				filePath = dirPath + File.separator + fileName;
				System.out.println(filePath);
				part.write(filePath);

			} else {
				Friend friend = friendDAO.getItemByID(id);
				if (friend == null) {
					response.sendRedirect(request.getContextPath() + "/admin/friends?error=1");
					return;
				}

				ArrayList<Category> categories = categoryDAO.getItems();
				if (categories.size() == 0) {
					response.sendRedirect(request.getContextPath() + "/admin/friends");
					return;
				}

				request.setAttribute("friend", friend);
				request.setAttribute("categories", categories);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/friends/edit.jsp?err=2");
				rd.forward(request, response);
				return;
			}
		} else {
			fileName = friendDAO.getItemByID(id).getPicture();
		}

		Friend friend = new Friend(id, name, preview, detail, null, 0, fileName, new Category(catId, null));
		if (friendDAO.editItem(friend) > 0) {
			// part.write(filePath);
			response.sendRedirect(request.getContextPath() + "/admin/friends?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/friends?err=3");
			return;
		}
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : partHeader.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
