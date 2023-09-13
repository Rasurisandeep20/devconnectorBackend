package com.dnb.devconnector.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
	@Id
	private String profileId;
	private String professionalStatus;
	private String companyName;
	private String website;
	private String location;
	private String skills;
	private String githubUserName;
	private String bio;
	private String twitterUrl;
	private String facebookUrl;
	private String youtubeUrl;
	private String linkedinUrl;
	private String instagramUrl;
}

 