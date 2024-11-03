package com.example;

import com.example.dao.PostDao;
import com.example.model.Post;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostDaoTest {
    private PostDao postDao;

    @BeforeEach
    public void setUp() {
        postDao = new PostDao();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        // Удаляем пост после теста
        List<Post> posts = postDao.getAllPosts();
        for (Post post : posts) {
            if (post.getTitle().equals("Test Post")) {
                postDao.deletePost(post.getId()); // Нужно реализовать deletePost в PostDao
            }
        }
    }

    @Test
    public void testGetAllPosts() throws SQLException {
        List<Post> posts = postDao.getAllPosts();
        assertNotNull(posts);
        assertTrue(posts.size() >= 0);
    }

    @Test
    public void testAddPost() throws SQLException {
        Post post = new Post();
        post.setTitle("Test Post");
        post.setContent("This is a test post");
        post.setUserId(1);
        postDao.addPost(post);

        List<Post> posts = postDao.getAllPosts();
        assertTrue(posts.stream().anyMatch(p -> p.getTitle().equals("Test Post")));
    }
}
