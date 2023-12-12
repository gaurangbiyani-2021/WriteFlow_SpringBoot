package com.project.blog.payloads;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message = "Username must of min 4 characters")
	private String name;
	@Email(message = "not valid email address")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message = "min 3 char max 10 char password is allowed")
	private String password;
	@NotEmpty
	private String about;
}
