package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.exception.IdNotFoundException;

public interface ExperienceService {
	
	public Experience createExperienceDetails(Experience experience);

	public Optional<Experience> getExperienceDetailsById(String experienceId);

	public boolean deleteExperienceDetailsById(String experienceId) throws IdNotFoundException;

	public Iterable<Experience> getAllExperienceDetails();
}
