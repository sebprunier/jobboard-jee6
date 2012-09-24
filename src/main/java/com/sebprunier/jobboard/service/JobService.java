package com.sebprunier.jobboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.sebprunier.jobboard.model.Job;

@Stateless
public class JobService {

	public List<Job> getAllJobs() {
		Job job1 = new Job();
		job1.setId(1L);
		job1.setTitle("Job 1");
		Job job2 = new Job();
		job2.setId(2L);
		job2.setTitle("Job 2");

		List<Job> jobs = new ArrayList<Job>();
		jobs.add(job1);
		jobs.add(job2);

		return jobs;
	}

	public Job getJob(Long id) {
		if (id <= 0) {
			return null;
		}

		Job job = new Job();
		job.setId(id);
		job.setTitle("This is the job number " + id);

		return job;
	}

}
