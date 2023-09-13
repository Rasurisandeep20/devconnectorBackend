package com.dnb.devconnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.exception.IdNotFoundException;
import com.dnb.devconnector.repo.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	EducationRepository educationRepository;

	@Override
	public Education createEducationDetails(Education education) {
		return educationRepository.save(education);
	}

	@Override
	public Optional<Education> getEducationDetailsById(String educationId) {
		return educationRepository.findById(educationId);
	}

	@Override
	public boolean deleteEducationDetailsById(String educationId) throws IdNotFoundException {
		boolean isExists = educationRepository.existsById(educationId);
		if (!isExists) {
			throw new IdNotFoundException("Education-Id Not Found..");
		}
		educationRepository.deleteById(educationId);

		if (educationRepository.existsById(educationId))
			return false;
		else
			return true;
	}

	@Override
	public Iterable<Education> getAllEducationDetails() {
		return educationRepository.findAll();
	}

}
