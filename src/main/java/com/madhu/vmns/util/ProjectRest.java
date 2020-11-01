package com.madhu.vmns.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import  com.madhu.vmns.factory.ProjectFactory;
import com.madhu.vmns.model.Project;
/**
 * This class provides a REST interface for the master entity.
 */
@Path("/Project")
public class ProjectRest {
  /**
   * Returns Project details.
   * @return the Project details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Project[] listProject() {
    final Project[] Project = ProjectFactory.showProject();
    return Project;
  }
    /**
   * @param newProject is for newProject
   *  @return returns
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addProject")
  public final String insertProject(final Project newProject) {
    String comment = "";
    final int ProjectIns = ProjectFactory.insertProject(newProject.getpName(),newProject.getEmpId(),newProject.getProStatus());
    if (ProjectIns > 0) {
      comment = "{\" value \" : \"  added successfully \"}";
    } else {
      comment = "{\" value \" : \"  not added  \"}";
    }
    return comment;
  }
    /**
   * @param proId is for project id
   * @return returns
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showProject/{id}")
  public final Project Prodetails(@PathParam("id") final int proId) {
    final Project Project = ProjectFactory.Prodetails(proId);
    return Project;
  }
}


