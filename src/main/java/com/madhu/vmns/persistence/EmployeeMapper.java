package com.madhu.vmns.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.madhu.vmns.model.Employee;
/**
 * EmployeeMapper class used to fetch Employee data from database.
 * @author MadhumithaVinnakota
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Employee
       */
    return new Employee(rs.getInt("EMP_ID"), rs.getString("EMP_NAME"), rs.getString("EMP_PHNO"),rs.getString("EMP_EMAIL"),
     rs.getDate("EMP_DOJ"),rs.getString("EMP_PWD"), rs.getInt("EMP_MID"));
  }
}
