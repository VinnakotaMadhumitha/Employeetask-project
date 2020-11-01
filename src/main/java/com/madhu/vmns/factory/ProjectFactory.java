package com.madhu.vmns.factory;
import com.madhu.vmns.persistence.ProjectDAO;
import com.madhu.vmns.persistence.DbConnection;
import java.util.List;

import com.madhu.vmns.model.Project;
/**
 * ProjectFactory class used to fetch Project data from database.
 * @author MadhumithaVinnakota
 */
public class ProjectFactory {
  /**
   *  Protected constructor.
   */
  protected ProjectFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static ProjectDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(ProjectDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Project object.
   */
  public static Project[] showProject() {
    List<Project> Project = dao().show();
    return Project.toArray(new Project[Project.size()]);
  }
/**
* @param pname Pro_Name
* @param eid Pro_EID
* @param pstatus Pro_Status
* @return inserted values
*/
public static int insertProject(String pname, int eid, String pstatus) {
  int i = dao().insertProject(pname, eid, pstatus);
  return i;
  }
   /**
   * @param proId gets the Project ID
   * @return project
   */
  public static Project  Prodetails (final int ProId) {
    Project project = dao().getProdetails(ProId);
    return project ;
  }
}