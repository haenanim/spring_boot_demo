package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.PostDTO;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {


  private PostService postService;
//  @Autowired
//  public PostController(PostService postService) {
//    this.postService = postService;
//  }

  @Autowired
  public void setPostService(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public List<Post> viewAllPosts() {
    List<Post> allPosts = postService.getAllPosts();
    return allPosts;
  }

  @PostMapping("/posts")
  public Post registPost(@RequestBody Post post) {
    System.out.println(post);
    postService.setPost(post);
    return post;
  }
  @PutMapping("/posts/{postId}")
public String updatePost(@PathVariable("postId") int postId, @RequestBody PostDTO postDTO) {
    postService.updatePost(postId,postDTO);
    return "업데이트 완료";
  }
  @GetMapping("/posts/{postId}")
  public Post selectPostById(@PathVariable("postId") int postId) {
    return postService.selectPostById(postId);
  }
  @DeleteMapping("/posts/{postId}")
  public void deletePost(@PathVariable("postId") int postId) {
    postService.deletePost(postId);
  }

}
