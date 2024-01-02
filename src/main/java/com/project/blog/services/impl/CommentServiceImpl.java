package com.project.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.entities.Comment;
import com.project.blog.entities.Post;
import com.project.blog.payloads.CommentDto;
import com.project.blog.repositories.CommentRepo;
import com.project.blog.repositories.PostRepo;
import com.project.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepo.findById(postId).orElseThrow(IllegalArgumentException::new);
		Comment comment = this.modelMapper.map(commentDto,Comment.class);
		
		comment.setPost(post);
		Comment savedcomment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedcomment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub

		Comment com = this.commentRepo.findById(commentId).orElseThrow(IllegalArgumentException::new);
		this.commentRepo.delete(com);
	}

}
