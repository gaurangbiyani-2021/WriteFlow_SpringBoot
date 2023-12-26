package com.project.blog.payloads;

import java.util.Date;

import com.project.blog.entities.Category;
import com.project.blog.entities.User;

public class PostDto {
	private String title;
	private String 	content;
	private String imageName;
	private Date addedDate;
	private Category category;
	private User user;
}
