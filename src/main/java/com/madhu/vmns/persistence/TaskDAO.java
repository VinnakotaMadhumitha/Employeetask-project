package com.madhu.vmns.persistence;

import java.util.List;
import com.madhu.vmns.model.Task;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
 * TaskDAO class used to fetch data from data base.
 * @author MadhumithaVinnakota
 */
public interface TaskDAO {
     /**
     * @return the all the Task record.
     */
    @SqlQuery("Select * from Task")
    @Mapper(TaskMapper.class)
    List<Task> show1();
    /**
     * @return the all the Task record.
     */
  @SqlQuery("Select * from Task  where  TASK_PID = :pid")
    @Mapper(TaskMapper.class)
    List<Task> show( @Bind("pid") int pid);

    /**
* @param tstatus Task_status
* @param tdetails Task_Details
* @param mComment Task_mComment
* @param pId  Task_pId
* @return inserted values
*/
    @SqlUpdate("INSERT INTO Task (TASK_STATUS, TASK_DETAILS,TASK_MCOMMENT,TASK_PID)"
    + " values (:tstatus, :tdetails, :mComment,:pId)")
      int insertTask(@Bind("tstatus") String tstatus, @Bind("tdetails") String tdetails, @Bind("mComment") String mComment,
   @Bind("pId") int pId);

   /**
   * @param tId gets the Task ID
   * @return task
   */
    @SqlQuery("Select * from Task where TASK_ID = :tId")
    @Mapper(TaskMapper.class)
    Task getTaskdetails(@Bind("tId") int tId);
    /**
     * @return message.
     * @param  tId for updating task.
     * @param  mcomment for manager comments upadte.
     * */
  @SqlUpdate("Update Task Set TASK_MCOMMENT = :mComment where TASK_ID = :tid")
  @Mapper(TaskMapper.class)
    int managerupdate(@Bind("mComment") String mComment, @Bind("tid") int tid);
}