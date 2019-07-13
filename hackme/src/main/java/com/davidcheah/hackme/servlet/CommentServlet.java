package com.davidcheah.hackme.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davidcheah.hackme.model.Comment;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

	// <script>alert(\'hello\')</script>
	//<script type="text/javascript">window.location.href = "http://localhost:8080/hackme"</script>

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("GET request received");
		List<Comment> commentList = fetchAllComments();
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/CommentPage.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("POST request received " + request.getParameter("comment"));
		addComment(new Comment(request.getParameter("comment"), 1));
		response.sendRedirect("/hackme/comment");
	}

	public void init() {
		// 1. Load JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addComment(Comment comment) {
		String timeZoneOption = "?useTimezone=true&serverTimezone=UTC";
		String url = "jdbc:mysql://localhost:3306/hackmedb" + timeZoneOption;
		String dbUsername = "root";
		String dbPassword = "root";
		String query = "INSERT INTO comments(comment, authorid) VALUES ('" + comment.getComment() + "', "
				+ comment.getAuthorid() + ")";

		try {

			// 2. Create a connection
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

			// 3. Create a statement
			Statement st = con.createStatement();

			System.out.println(query);

			// 4. Execute Update
			st.executeUpdate(query);

			// 5. Close all connections
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public List<Comment> fetchAllComments() {
		String timeZoneOption = "?useTimezone=true&serverTimezone=UTC";
		String url = "jdbc:mysql://localhost:3306/hackmedb" + timeZoneOption;
		String dbUsername = "root";
		String dbPassword = "root";
		String query = "SELECT * FROM comments";

		List<Comment> commentList = new ArrayList<Comment>();

		try {

			// 2. Create a connection
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

			// 3. Create a statement
			Statement st = con.createStatement();

			// 4. Create a ResultSet
			ResultSet rs = st.executeQuery(query);

			System.out.println(query);

			while (rs.next()) {
				Comment comment = new Comment(rs.getString(2), rs.getInt(3));
				commentList.add(comment);
				System.out.println(rs.getString(2) + "  " + rs.getInt(3));
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

		return commentList;
	}
}
