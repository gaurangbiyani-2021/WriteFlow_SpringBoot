package com.project.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.blog.entities.Post;
import com.project.blog.payloads.CommentDto;
import com.project.blog.repositories.CommentRepo;
import com.project.blog.repositories.PostRepo;
import com.project.blog.services.CommentService;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepo.findById(postId).orElseThrow(IllegalArgumentException::new);
		return null;
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub

	}

}
