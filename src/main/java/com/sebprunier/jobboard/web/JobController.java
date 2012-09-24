package com.sebprunier.jobboard.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sebprunier.jobboard.model.Job;
import com.sebprunier.jobboard.service.JobService;

@Named
@RequestScoped
public class JobController implements Serializable {

	private static final long serialVersionUID = 2320018071478461755L;

	@Inject
	private JobService jobService;

	public List<Job> getJobs() {
		return jobService.getAllJobs();
	}
}
