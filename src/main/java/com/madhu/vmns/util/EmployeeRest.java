package com.madhu.vmns.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import  com.madhu.vmns.factory.EmployeeFactory;
import com.madhu.vmns.model.Employee;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/Employee")
public class EmployeeRest {
  /**
   * Returns Employee details.
   * @return the Employee details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] listEmployee() {
    final Employee[] Employee = EmployeeFactory.showEmployee();
    return Employee;
  }
    /**
   * @param newEmployee is for newEmployee
   *  @return returns
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addEmployee")
  public final String insertEmployee(final Employee newEmployee) {
    String comment = "";
    final int EmployeeIns = EmployeeFactory.insertEmployee(newEmployee.getEmpName(),newEmployee.getEmpPhno(),newEmployee.getEmpEmail(),newEmployee.getEmpDoj(),newEmployee.getEmpPwd(),newEmployee.getmId());
    if (EmployeeIns > 0) {
      comment = "{\" value \" : \"  added successfully \"}";
    } else {
      comment = "{\" value \" : \"  not added  \"}";
    }
    return comment;
  }
 /**
   *
   * @return Employee
   * @param empPhno is the employee phno
   * @param empPwd is the employee password
   */

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/empAuth/{empPhno}/{empPwd}")
  public final Employee empAuth(@PathParam("empPhno")final String empPhno, @PathParam("empPwd")final String empPwd) {

    final Employee i = EmployeeFactory.empAuth(empPhno,empPwd);
    return i;
  }
    /**
   * @param empId is for empid
   * @return returns
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showEmployee/{id}")
  public final Employee Empdetails(@PathParam("id") final int empId) {
    final Employee Employee = EmployeeFactory.Empdetails(empId);
    return Employee;
  }
}


