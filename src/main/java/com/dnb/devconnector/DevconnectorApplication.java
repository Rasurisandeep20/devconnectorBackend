package com.dnb.devconnector;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exception.EmailIdNotFoundException;
import com.dnb.devconnector.exception.IdNotFoundException;
import com.dnb.devconnector.service.EducationService;
import com.dnb.devconnector.service.ExperienceService;
//import com.dnb.devconnector.service.ProfileService;
//import com.dnb.devconnector.service.UserService;
import com.dnb.devconnector.service.UserService;

@SpringBootApplication
public class DevconnectorApplication {

	private static Scanner scan = new Scanner(System.in);

	private static UserService userService;

//	private static ProfileService profileService;

	public static void main(String[] args) throws IdNotFoundException, EmailIdNotFoundException {
		ApplicationContext applicationContext = SpringApplication.run(DevconnectorApplication.class, args);

		userService = applicationContext.getBean(UserService.class);
//		profileService = applicationContext.getBean(ProfileService.class);
		EducationService educationService = applicationContext.getBean(EducationService.class);
		Scanner scan = new Scanner(System.in);
		ExperienceService experienceService = applicationContext.getBean(ExperienceService.class);
		Experience experience = new Experience();
		experience.setJobTitle("dev");
		experience.setCompany("dnb");
		experienceService.createExperienceDetails(experience);
		System.exit(0);
		Education education = new Education();
		education.setSchool("ss");
		education.setDegree("ssss");
		educationService.createEducationDetails(education);
		System.exit(0);
		while (true) {
			System.out.println("1.CreateProfile\n2.Get Profile By Id\n3.Get All Profiles\n4.delete Profile\n5.exit");
			System.out.println("Enter option:");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				createUser();
				break;
			case 2:
				getUser();
				break;
			case 3:
				getAllUsers();
				break;
			case 4:
				deleteUser();
				break;
			case 5:
				scan.close();
				System.exit(0);
			default:
				System.out.println("Wrong choice");
				System.out.println("Choose again..");
				break;
			}
		}
	}



	private static void deleteUser() throws IdNotFoundException, EmailIdNotFoundException {

		System.out.println("Enter Email-Id to be deleted:");
		String id = scan.next();
		boolean result = userService.deleteUserByID(id);
		if (result)
			System.out.println("Account Deleted...");
		else
			System.out.println("Deletion Unsuccessful");
	}

	private static void getAllUsers() {
		Iterable<User> users = userService.getAllUsers();
		users.forEach(user -> System.out.println(user));
	}

	private static void getUser() {
		System.out.println("Enter User Email-Id:");
		String emailId = scan.next();
		Optional<User> returnedUser = userService.getUserById(emailId);
		if (returnedUser.isPresent())
			System.out.println(returnedUser.get());
		else
			System.out.println("User not found..");

	}

	private static void createUser() {
		System.out.println("Enter User details:");

		System.out.println("Enter Name:");
		String name = scan.next();

		System.out.println("Enter Email-Id:");
		String emailId = scan.next();

		System.out.println("Enter Password:");
		String password = scan.next();

		User user = new User(emailId, name, password);
		System.out.println(userService.createUser(user));

	}

//	private static void createProfile() {
//	System.out.println("Enter User details:");
//
//	System.out.println("Enter Professional Status :");
//	String professionalStatus = scan.next();
//
//	System.out.println("Enter Company Name:");
//	String companyName = scan.next();
//
//	System.out.println("Enter Website Url:");
//	String website = scan.next();
//
//	System.out.println("Enter Your Location:");
//	String location = scan.next();
//
//	System.out.println("Enter Your Skills, seperated by coma(,):");
//	String skills = scan.next();
//
//	System.out.println("Enter Github-Username:");
//	String githubUsername = scan.next();
//
//	System.out.println("Enter your bio (max 250 characters):");
//	String bio = scan.next();
//
//	System.out.println("Enter Twitter Url:");
//	String twitter = scan.next();
//	System.out.println("Enter Facebook Url:");
//	String facebook = scan.next();
//	System.out.println("Enter YoutTube Url:");
//	String youtube = scan.next();
//	System.out.println("Enter Linkedin Url:");
//	String linkedin = scan.next();
//	System.out.println("Enter Instagram Url:");
//	String instagram = scan.next();
////
////	UUID profileId = profileService.profileIdGenerator();
//
//	Profile profile = new Profile(professionalStatus, companyName, website, location, skills, githubUsername, bio,
//			twitter, facebook, youtube, linkedin, instagram);
//	System.out.println(profileService.createProfile(profile));
//
//}
//
//private static void deleteProfile(UUID profileId) {
//	System.out.println("Enter Profile-Id to be deleted: ");
////	UUID profileId = scan.nextUUID();
//
//	try {
//		boolean result = profileService.deleteProfileById(profileId);
//		if (result)
//			System.out.println("Profile with ProfileId: " + profileId + " is deleted");
//		else
//			System.out.println("Cannot Delete Profile..");
//	} catch (ProfileIdNotFoundException e) {
//		System.out.println(e.getMessage());
//	}
//}
//
//private static void getAllProfiles() {
//	Iterable<Profile> profiles = profileService.getAllProfiles();
//	profiles.forEach(profile -> System.out.println(profile));
//}
//
//private static void getProfile(UUID profileId) {
////	System.out.println("Enter Profile Id: ");
////	String profileId = scan.next();
//	Optional<Profile> returnedProfile = profileService.getProfileById(profileId);
//	if (returnedProfile.isPresent())
//		System.out.println(returnedProfile.get());
//	else
//		System.out.println("Profile Not Found");
//}
}
