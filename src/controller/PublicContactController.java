package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import util.EmailValidator;
import util.LengthNumberValidator;

public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;

	public PublicContactController() {
		super();
		contactDAO = new ContactDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/lien-he.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		long phone = 0;
		try {
			phone = Long.parseLong(request.getParameter("phone"));
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/lien-he.jsp?msg=1");
			rd.forward(request, response);
			return;
		}
		// Validate
		EmailValidator emailValidator = new EmailValidator();
		if ("".equals(name) || !emailValidator.isEmailValid(email) || !LengthNumberValidator.RangeValue(9, 13, phone)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/lien-he.jsp?msg=1");
			rd.forward(request, response);
			return;
		}

		Contact contact = new Contact(0, name, email, phone, message);
		if (contactDAO.addItem(contact) > 0) {
			response.sendRedirect(request.getContextPath() + "/contact?msg=2");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/public/lien-he.jsp?msg=1");
			rd.forward(request, response);
			return;
		}

	}
}
