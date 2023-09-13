package com.dnb.devconnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_seq")
	@GenericGenerator(name = "education_seq", type = CustomIdGenerator.class, parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "EDU_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String educationId;
	@NotBlank(message = "School name must be provided")
	private String school;
	@NotBlank(message = "Degree must be provided")
	private String degree;
	private String fieldOfStudy;
	private String fromDate;
	private String toDate;
	private String programDescription;

	public Education(String school, String degree, String fieldOfStudy, String fromDate, String toDate,
			String programDescription) {
		super();
		this.school = school;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.programDescription = programDescription;
	}

}
