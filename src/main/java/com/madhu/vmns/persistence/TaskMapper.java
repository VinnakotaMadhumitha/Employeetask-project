package com.madhu.vmns.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.madhu.vmns.model.Task;
/**
 * TaskMapper class used to fetch Task data from database.
 * @author MadhumithaVinnakota
 */
public class TaskMapper implements ResultSetMapper<Task> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Task map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Task
       */
    return new Task(rs.getInt("TASK_ID"), rs.getString("TASK_STATUS"),rs.getString("TASK_DETAILS"),rs.getString("TASK_MCOMMENT"),rs.getInt("TAsK_PID"));
  }
}
