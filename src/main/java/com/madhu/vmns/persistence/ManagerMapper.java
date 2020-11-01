package com.madhu.vmns.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.madhu.vmns.model.Manager;
/**
 * ManagerMapper class used to fetch Manager data from database.
 * @author MadhumithaVinnakota
 */
public class ManagerMapper implements ResultSetMapper<Manager> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Manager map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Manager
       */
    return new Manager(rs.getInt("MAN_ID"), rs.getString("MAN_NAME"), rs.getString("MAN_PHNO"),rs.getString("MAN_EMAIL"),rs.getString("MAN_PWD"),rs.getInt("MAN_EID"));
  }
}
