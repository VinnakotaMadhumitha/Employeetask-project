package com.madhu.vmns.factory;
import com.madhu.vmns.persistence.TaskDAO;
import com.madhu.vmns.persistence.DbConnection;
import java.util.List;

import com.madhu.vmns.model.Task;
/**
 * TaskFactory class used to fetch Task data from database.
 * @author MadhumithaVinnakota
 */
public class TaskFactory {
  /**
   *  Protected constructor.
   */
  protected TaskFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static TaskDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(TaskDAO.class);
  }
    /**
   * Call the data base connection.
   * @return the array of Task object.
   */
  public static Task[] showTask1() {
    List<Task> Task = dao().show1();
    return Task.toArray(new Task[Task.size()]);
  }
  /**
   * Call the data base connection.
   * @param pid  Task_pId
   * @return the array of Task object.
   */
  public static Task[] showTask(final int pid) {
    List<Task> Task = dao().show(pid);
    return Task.toArray(new Task[Task.size()]);
  }
/**
* @param tstatus Task_status
* @param tdetails Task_Details
* @param mComment Task_mComment
* @param pId  Task_pId
* @return inserted values
*/
public static int insertTask(String tstatus, String tdetails, String mComment, int pId) {
  int i = dao().insertTask(tstatus, tdetails, mComment, pId);
  return i;
  }
   /**
   * @param tId gets the Task ID
   * @return task
   */
  public static Task TaskInfo (final int tId) {
    Task task = dao().getTaskdetails(tId);
    return task;
  }
    /**
     * @return message.
     * @param  tId for updating task.
     * @param  mcomment for manager comments upadte.
     * */
  public static int updateComment( final String mcomment,final int tid ) {
  int i = dao().managerupdate(mcomment,tid);
  return i;
}
}