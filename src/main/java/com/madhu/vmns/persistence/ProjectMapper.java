package com.madhu.vmns.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.madhu.vmns.model.Project;
/**
 * ProjectMapper class used to fetch Project data from database.
 * @author MadhumithaVinnakota
 */
public class ProjectMapper implements ResultSetMapper<Project> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Project map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Project
       */
    return new Project(rs.getInt("PRO_ID"), rs.getString("PRO_NAME"),rs.getInt("PRO_EID"), rs.getString("PRO_STATUS"));
  }
}
