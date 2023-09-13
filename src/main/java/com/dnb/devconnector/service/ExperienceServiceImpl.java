package com.dnb.devconnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.exception.IdNotFoundException;
import com.dnb.devconnector.repo.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	ExperienceRepository experienceRepository;

	@Override
	public Experience createExperienceDetails(Experience experience) {
		return experienceRepository.save(experience);
	}

	@Override
	public Optional<Experience> getExperienceDetailsById(String experienceId) {
		return experienceRepository.findById(experienceId);
	}

	@Override
	public boolean deleteExperienceDetailsById(String experienceId) throws IdNotFoundException {
		boolean isExists = experienceRepository.existsById(experienceId);
		if (!isExists) {
			throw new IdNotFoundException("Experience-Id Not Found..");
		}
		experienceRepository.deleteById(experienceId);

		if (experienceRepository.existsById(experienceId))
			return false;
		else
			return true;
	}

	@Override
	public Iterable<Experience> getAllExperienceDetails() {
		return experienceRepository.findAll();
	}

}
