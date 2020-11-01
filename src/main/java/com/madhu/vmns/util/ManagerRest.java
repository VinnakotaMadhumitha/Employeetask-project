package com.madhu.vmns.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import  com.madhu.vmns.factory.ManagerFactory;
import  com.madhu.vmns.model.Manager;
/**
 * This class provides a REST interface for the master entity.
 */
@Path("/Manager")
public class ManagerRest {
  /**
   * Returns Manager details.
   * @return the Manager details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Manager[] listManager() {
    final Manager[] Manager = ManagerFactory.showManager();
    return Manager;
  }
    /**
   * @param newManager is for newManager
   *  @return returns
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addManager")
  public final String insertManager(final Manager newManager) {
    String comment = "";
    final int ManagerIns = ManagerFactory.insertManager(newManager.getmName(),newManager.getmPhno(),newManager.getmEmail(),newManager.getmPwd(),newManager.getmEid());
    if (ManagerIns > 0) {
      comment = "{\" value \" : \"  added successfully \"}";
    } else {
      comment = "{\" value \" : \"  not added  \"}";
    }
    return comment;
  }
 /**
   *
   * @return Manager
   * @param empPhno is the Manager phno
   * @param empPwd is the Manager password
   */

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/manAuth/{manPhno}/{manPwd}")
  public final Manager empAuth(@PathParam("manPhno")final String manPhno, @PathParam("manPwd")final String manPwd) {

    final Manager i = ManagerFactory.manAuth(manPhno,manPwd);
    return i;
  }
    /**
   * @param manId is for manager id.
   * @return returns
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showManager/{id}")
  public final Manager Mandetails(@PathParam("id") final int manId) {
    final Manager Manager = ManagerFactory.Mandetails(manId);
    return Manager;
  }
}


