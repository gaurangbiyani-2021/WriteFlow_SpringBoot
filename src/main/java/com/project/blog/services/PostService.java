package com.project.blog.services;

import java.util.List;

import com.project.blog.entities.Post;
import com.project.blog.payloads.PostDto;

public interface PostService {
	
	//create posts 
	Post createPost(PostDto postDto);
	
	//update posts
	Post updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	// get all posts 
	List<Post> getAllPost();
	
	//get single post 
	Post getPostById(Integer postId);
	
	// get all posts by category 
	List<Post> getPostsByCategory(Integer categoryId);

	// get all posts by user
	List<Post> getPostsByUser(Integer userId);
	
	//search posts 
	List<Post>searchPosts(String keyword);
}
