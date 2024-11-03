package com.example.servlet;

import com.example.dao.PostDao;
import com.example.model.Post;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PostServlet extends HttpServlet {
    private PostDao postDao = new PostDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<Post> posts = postDao.getAllPosts();
            req.setAttribute("posts", posts);
            req.getRequestDispatcher("/posts.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        try {
            postDao.addPost(post);
            resp.sendRedirect("posts");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
