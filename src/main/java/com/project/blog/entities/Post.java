package com.project.blog.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@NoArgsConstructor
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name="post_title",nullable=false,length=100)
	private String title;
	
	@Column(length=1000)
	private String content;
	
	private String imageName;
	
	private Date addedDate;
}
