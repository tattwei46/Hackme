package com.davidcheah.hackme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davidcheah.hackme.model.Book;
import com.davidcheah.hackme.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Get request received ");
		request.getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(
				"POST request received " + request.getParameter("username") + request.getParameter("password"));
		User user = new User(request.getParameter("username"), request.getParameter("password"));
		if (authenticate(user)) {
			request.getRequestDispatcher("/SearchPage.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/LoginPage.jsp").forward(request, response);
		}
	}

	public void init() {
		// 1. Load JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean authenticate(User user) {

		String url = "jdbc:mysql://localhost:3306/hackmedb";
		String dbUsername = "root";
		String dbPassword = "root";
		String query = "SELECT * FROM users WHERE username='" + user.getUsername() + "' AND password='"
				+ user.getPassword() + "'";

		try {

			// 2. Create a connection
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

			// 3. Create a statement
			Statement st = con.createStatement();

			// 4. Create a ResultSet
			ResultSet rs = st.executeQuery(query);

			System.out.println(query);

			if (rs.next()) {
				// 5. Close all connections
				rs.close();
				st.close();
				con.close();

				return true;
			}

			// 5. Close all connections
			rs.close();
			st.close();
			con.close();

			return false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
}
