package com.project.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.project.blog.entities.Category;
import com.project.blog.entities.Comment;
import com.project.blog.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private Integer postId;
	private String title;
	private String 	content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
}
