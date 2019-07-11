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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("GET request received " + request.getParameter("bookName"));
		List<Book> bookList = search(request.getParameter("bookName"));
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/SearchPage.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("POST request received " + request.getParameter("bookName"));
	}

	public void init() {
		// 1. Load JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Book> search(String name) {
		
		//Sap%' OR '1'='1'; -- 
		String url = "jdbc:mysql://localhost:3306/hackmedb";
		String dbUsername = "root";
		String dbPassword = "root";
		String query = "SELECT * FROM books where NAME LIKE '%" + name + "%'";
		
		List<Book> bookList = new ArrayList<Book>();

		try {

			// 2. Create a connection
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

			// 3. Create a statement
			Statement st = con.createStatement();

			// 4. Create a ResultSet
			ResultSet rs = st.executeQuery(query);
			
			System.out.println(query);

			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3));
				bookList.add(book);
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}

			// 5. Close all connections
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return bookList;
	}
}
