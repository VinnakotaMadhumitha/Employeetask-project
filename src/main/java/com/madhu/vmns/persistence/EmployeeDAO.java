package com.madhu.vmns.persistence;

import java.util.List;
import com.madhu.vmns.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
 * EmployeeDAO class used to fetch data from data base.
 * @author MadhumithaVinnakota
 */
public interface EmployeeDAO {
    /**
     * @return the all the Employee record.
     */
  @SqlQuery("Select * from Employee")
    @Mapper(EmployeeMapper.class)
    List<Employee> show();
    /**
     * @param empPhno to return employee phno
     * @param empPwd to return password
     * @return the employee.
     */
    @SqlQuery("Select * from Employee where emp_PHNO = :empPhno and emp_PWD = :empPwd")
    @Mapper(EmployeeMapper.class)
    Employee checkemployee(@Bind("empPhno") String empPhno, @Bind("empPwd") String empPwd);

      /**
    * @param empname emp_NAME
    * @param empPhno emp_PHNO
    * @param empEmail Emp_Email
    * @param empDoj Emp_Dateof joining
    * @param empPwd Emp_PWD
    * @param empMid Emp_MId
    * @return inserted values
    */
  @SqlUpdate("INSERT INTO Employee (EMP_NAME, EMP_PHNO,EMP_EMAIL,EMP_DOJ,EMP_PWD,EMP_MID)"
  + " values (:empName, :empPhno, :empEmail, :empDoj, :empPwd ,:empMid)")
    int insertEmployee(@Bind("empName") String empName, @Bind("empPhno") String empPhno, @Bind("empEmail") String empEmail,
    @Bind("empDoj") java.util.Date empDoj,@Bind("empPwd") String empPwd, @Bind("empMid") int empMid);

 /**
     * @param empId to return employee Id
     * @return the employee.
     */
    @SqlQuery("Select * from Employee where EMP_ID = :empId")
    @Mapper(EmployeeMapper.class)
    Employee getEmpdetails(@Bind("empId") int empId);

}