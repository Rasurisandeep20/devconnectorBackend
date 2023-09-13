package com.dnb.devconnector.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//implicitly it creates args constructor
@NoArgsConstructor  //implicitly it creates default constructor
@Entity
public class User {
	@Column(nullable=true)
	private String UserName;
	@Id
	private String EmailAddress;
	private String Password;
}
