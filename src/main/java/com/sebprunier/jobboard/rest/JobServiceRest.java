package com.sebprunier.jobboard.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sebprunier.jobboard.model.Job;

@Path("/job")
public class JobServiceRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllJobs() {
		// Create mocks
		Job[] jobs = new Job[2];
		Job job1 = new Job();
		job1.setId(1L);
		job1.setTitle("Job 1");
		Job job2 = new Job();
		job2.setId(2L);
		job2.setTitle("Job 2");
		jobs[0] = job1;
		jobs[1] = job2;

		// Return mocks
		return Response.ok(jobs).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJob(@PathParam("id") String id) {
		// Create mocks
		Job job = new Job();
		job.setId(Long.valueOf(id));
		job.setTitle("This is the job number " + id);

		// Return mocks
		return Response.ok(job).build();
	}

}
