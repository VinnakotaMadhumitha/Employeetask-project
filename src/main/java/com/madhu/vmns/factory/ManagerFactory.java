package com.madhu.vmns.factory;
import com.madhu.vmns.persistence.ManagerDAO;
import com.madhu.vmns.persistence.DbConnection;
import java.util.List;

import com.madhu.vmns.model.Manager;
/**
 * ManagerFactory class used to fetch Manager data from database.
 * @author MadhumithaVinnakota
 */
public class ManagerFactory {
  /**
   *  Protected constructor.
   */
  protected ManagerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static ManagerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(ManagerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Manager object.
   */
  public static Manager[] showManager() {
    List<Manager> Manager = dao().show();
    return Manager.toArray(new Manager[Manager.size()]);
  }
  public static Manager manAuth(String manPhno, String manPwd) {
    Manager manager = dao().checkmanager(manPhno, manPwd);
    return manager;
  }
/**
* @param manName man_NAME
* @param manPhno man_PHNO
* @param manEmail man_Email
* @param manPwd man_PWD
* @param EmpId man_eid
* @return inserted values
*/
public static int insertManager(String manName, String manPhno, String manEmail,String manPwd, int EmpId) {
int i = dao().insertmanager(manName, manPhno, manEmail, manPwd,EmpId);
return i;
}
 /**
   * @param ManId gets the manager ID
   * @return manager
   */
  public static Manager Mandetails (final int ManId) {
    Manager manager = dao().getMandetails(ManId);
    return manager;
  }
}