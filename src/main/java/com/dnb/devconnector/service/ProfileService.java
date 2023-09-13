package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exception.ProfileNotFoundException;

public interface ProfileService {
	public Profile createProfile(Profile profile);

	public Optional<Profile> getProfileById(String profileId);

	public Iterable<Profile> getAllProfiles();

	public boolean deleteProfileByID(String profileId) throws ProfileNotFoundException;
	public String profileIdGenerator();
}
