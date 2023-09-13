package com.dnb.devconnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq")
	@GenericGenerator(name = "experience_seq", type = CustomIdGenerator.class, parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "EX_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String experienceId;

	@NotNull(message = "Job Title must be filled")
	private String jobTitle;
	@NotNull(message = "Company must be filled")
	private String company;
	private String fromDate;
	private boolean currentJob;
	private String toDate;
	private String jobDescription;

	public Experience(@NotNull(message = "Job Title must be filled") String jobTitle,
			@NotNull(message = "Company must be filled") String company, String fromDate, boolean currentJob,
			String toDate, String jobDescription) {
		super();
		this.jobTitle = jobTitle;
		this.company = company;
		this.fromDate = fromDate;
		this.currentJob = currentJob;
		this.toDate = toDate;
		this.jobDescription = jobDescription;
	}

}
