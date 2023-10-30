package com.example.demo.repository;


import com.example.demo.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements PostRepository {
  private static Map<Integer, Post> posts = new HashMap<>();
  private static int seq = 0;
  @Override
  public List<Post> selectAllPost() {
    return new ArrayList<>(posts.values());
  }

  @Override
  public Post selectPostById(int postId) {
    return posts.get(postId);
  }

  @Override
  public void deletePost(int postId) {
    posts.remove(postId);
    System.out.println("포스트 삭제 완료");
  }

  @Override
  public int insertPost(Post post) {
    seq++;
    post.setPostid(seq);
    posts.put(seq, post);
    return post.getPostid();
  }

  @Override
  public void updatePost(Post post) {
    posts.put(post.getPostid(), post);
  }
}
