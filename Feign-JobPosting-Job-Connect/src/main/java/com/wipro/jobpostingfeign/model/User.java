package com.wipro.jobpostingfeign.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "users")
public class User {
    
	  private Long userId;
	    
	    @NotBlank(message = "Username is required")
	    private String username;
	    
	    @NotBlank(message = "Email is required")
	    @Email(message = "Email is invalid")
	    private String email;
	    
	    @NotBlank(message = "First name is required")
	    @Size(min = 3, max = 20, message = "First name should be between 3 and 20 characters")
	    private String firstName;
	    
	    @NotBlank(message = "Last name is required")
	    @Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
	    private String lastName;
	    
	    private String profilePicture;
	    
	    @NotBlank(message = "User type is required")
	    private String userType;

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getProfilePicture() {
	        return profilePicture;
	    }

	    public void setProfilePicture(String profilePicture) {
	        this.profilePicture = profilePicture;
	    }

	    public String getUserType() {
	        return userType;
	    }

	    public void setUserType(String userType) {
	        this.userType = userType;
	    }
	}

