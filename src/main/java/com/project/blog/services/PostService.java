package com.project.blog.services;

import java.util.List;

import com.project.blog.entities.Post;
import com.project.blog.payloads.PostDto;

public interface PostService {
	
	//create posts 
	PostDto createPost(PostDto postDto , Integer userId, Integer catregoryId);
	
	//update posts
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	// get all posts 
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	
	//get single post 
	PostDto getPostById(Integer postId);
	
	// get all posts by category 
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts 
	List<Post>searchPosts(String keyword);
}