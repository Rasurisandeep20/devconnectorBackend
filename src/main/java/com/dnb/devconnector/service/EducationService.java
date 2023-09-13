package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.exception.IdNotFoundException;

public interface EducationService {
	public Education createEducationDetails(Education education);

	public Optional<Education> getEducationDetailsById(String educationId);

	public boolean deleteEducationDetailsById(String educationId) throws IdNotFoundException;

	public Iterable<Education> getAllEducationDetails();
}
