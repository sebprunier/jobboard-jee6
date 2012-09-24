package com.sebprunier.jobboard.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sebprunier.jobboard.model.Job;

@Stateless
public class JobService {

	@PersistenceContext(unitName = "jobboard-jee6")
	private EntityManager em;

	public List<Job> getAllJobs() {
		TypedQuery<Job> query = em.createNamedQuery("Job.all", Job.class);
		return query.getResultList();
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
