package com.madhu.vmns.factory;

import com.madhu.vmns.persistence.EmployeeDAO;
import com.madhu.vmns.persistence.DbConnection;

import java.util.Date;
import java.util.List;

import com.madhu.vmns.model.Employee;
/**
 * EmployeeFactory class used to fetch Employee data from database.
 * @author MadhumithaVinnakota
 */
public class EmployeeFactory {
  /**
   *  Protected constructor.
   */
  protected EmployeeFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Employee object.
   */
  public static Employee[] showEmployee() {
    List<Employee> Employee = dao().show();
    return Employee.toArray(new Employee[Employee.size()]);
  }
  /**
   * @param empPhno  employee Phnoe number.
   * @param empPwd  employee Password.
   * @return the array of  employee object.
   */
public static Employee empAuth(String empPhno, String empPwd) {
  Employee employee = dao().checkemployee(empPhno, empPwd);
  return employee;
}

/**
* @param empName Emp_NAME
* @param empPhno Emp_PHNO
* @param empEmail Emp_Email
* @param empDoj Emp_Dateof joining
* @param empPwd Emp_PWD
* @return inserted values
*/
public static int insertEmployee(String empName, String empPhno, String empEmail, Date empDoj, String empPwd,
		int empMid) {
int i = dao().insertEmployee(empName, empPhno, empEmail,empDoj, empPwd,empMid);
return i;
}
 /**
   * @param EmpId gets the Employee ID
   * @return employee
   */
  public static Employee Empdetails (final int EmpId) {
    Employee employee = dao().getEmpdetails(EmpId);
    return employee;
  }

}