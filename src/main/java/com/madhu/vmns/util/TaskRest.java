package com.madhu.vmns.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import  com.madhu.vmns.factory.TaskFactory;
import com.madhu.vmns.model.Task;
/**
 * This class provides a REST interface for the master entity.
 */
@Path("/Task")
public class TaskRest {
  /**
   * Returns Task details.
   * @return the Task details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Task[] listTask() {
    final Task[] Task = TaskFactory.showTask1();
    return Task;
  }
    /**
   * @param newTask is for newTask
   *  @return returns
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addTask")
  public final String insertTask(final Task newTask) {
    String comment = "";
    final int TaskIns = TaskFactory.insertTask(newTask.gettStatus(),newTask.gettDetails(),newTask.getmComment(),newTask.getpId());
    if (TaskIns > 0) {
      comment = "{\" value \" : \"  added successfully \"}";
    } else {
      comment = "{\" value \" : \"  not added  \"}";
    }
    return comment;
  }

    /**
   * @param taskId is for Task id.
   * @return returns
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showTask/{id}")
  public final Task Taskdetails(@PathParam("id") final int taskId) {
    final Task Task = TaskFactory.TaskInfo(taskId);
    return Task;
  }
  
    /**
   * @param newCustomer is for newCustomer
   * @return returns
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatemComment")
  public final String updatemComment(final Task newTask) {
    String comment = "";
    final int updatemComment = TaskFactory.updateComment(newTask.getmComment(),newTask.gettId());
    if (updatemComment > 0) {
      comment = "{\" value \" : \" updated successfully \"}";
    } else {
      comment = "{\" value \" : \"  not updated  \"}";
    }

    return comment;
  }
}


