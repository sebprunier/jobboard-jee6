package com.sebprunier.jobboard.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sebprunier.jobboard.model.Job;
import com.sebprunier.jobboard.service.JobService;

@Path("/job")
public class JobServiceRest {

	@Inject
	private JobService jobService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllJobs() {
		Job[] jobs = jobService.getAllJobs().toArray(new Job[] {});
		return Response.ok(jobs).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJob(@PathParam("id") Long id) {
		Job job = jobService.getJob(id);

		if (job == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(job).build();
	}

}
