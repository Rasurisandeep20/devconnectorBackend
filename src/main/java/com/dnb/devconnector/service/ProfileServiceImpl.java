package com.dnb.devconnector.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exception.ProfileNotFoundException;
import com.dnb.devconnector.repo.ProfileRepository;
@Service("ProfileServiceImpl")
public class ProfileServiceImpl implements ProfileService {
	@Autowired // type, name
	private ProfileRepository profileRepository;
	@Override
	public Profile createProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileRepository.save(profile);
		
	}

	@Override
	public Optional<Profile> getProfileById(String profileId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(profileId);
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		return profileRepository.findAll();
		// TODO Auto-generated method stub
	}

	@Override
	public boolean deleteProfileByID(String profileId) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		boolean isPresent = profileRepository.existsById(profileId);
		if(isPresent) {
			profileRepository.deleteById(profileId);
			
		}else {

			throw new ProfileNotFoundException("profile not Found");
		}

		if(profileRepository.existsById(profileId))

			return false;

		else

			return true;		

	}
	@Override
	public String profileIdGenerator() {
		Random rand = new Random();
		// 10-Character Unique ProfileId
		int length = 10;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String profileId = "";
		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(chars.length());
			profileId += chars.charAt(index);
		}
		return profileId;
	}

}
