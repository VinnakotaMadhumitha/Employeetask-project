package com.madhu.vmns.model;
import java.util.Objects;

import java.util.Date;

/**
 * Employee class used to display Employee information.
 * 
 * @author VinnakotaMadhumitha
 */

public class Employee {

    /**
     * empId to store empId.
     */
    
      private int empId;
      private String empName;
      private String empPhno;
      private String empEmail;
      private Date empDoj;
      private String empPwd;
      private int mId;
    
    /**.
     * public constructor
     */
    
      public Employee() {
      }
      /**.
 * @param argempId to inialize employee id
 * @param argempName to initialize employee name
 * @param argempPhno to initialize employee phone number
 * @param argempEmail to initialize employee email
 * @param argempDoj to initialize employee date of joining
 * @param argempPwd to initialize employee password
 *  @param armId to inialize employee manager id
 * parameterised constructor
 */
  public Employee(final int argempId, final String argempName, final String argempPhno, final String argempEmail, final Date argempDoj,
  final String argempPwd,final int argmId) {
this.empId = argempId;
this.empName = argempName;
this.empPhno = argempPhno;
this.empEmail = argempEmail;
this.empDoj = argempDoj;
this.empPwd = argempPwd;
this.mId = argmId;
}

public int getEmpId() {
    return empId;
}

public void setEmpId(int empId) {
    this.empId = empId;
}

public String getEmpName() {
    return empName;
}

public void setEmpName(String empName) {
    this.empName = empName;
}

public String getEmpPhno() {
    return empPhno;
}

public void setEmpPhno(String empPhno) {
    this.empPhno = empPhno;
}

public String getEmpEmail() {
    return empEmail;
}

public void setEmpEmail(String empEmail) {
    this.empEmail = empEmail;
}

public Date getEmpDoj() {
    return empDoj;
}

public void setEmpDoj(Date empDoj) {
    this.empDoj = empDoj;
}

public String getEmpPwd() {
    return empPwd;
}

public void setEmpPwd(String empPwd) {
    this.empPwd = empPwd;
}

public int getmId() {
    return mId;
}

public void setmId(int mId) {
    this.mId = mId;
}


/**.
 * Employee hash code .
 */
@Override
public final int hashCode() {
  return Objects.hash(empId, empName,empPhno, empEmail, empDoj, empPwd,mId);
}

@Override
public final boolean equals(final Object obj) {
  if (obj == null) {
    return false;
  }
  if (getClass() != obj.getClass()) {
    return false;
  }
  Employee Employee = (Employee) obj;
  if (Objects.equals(empId, Employee.empId) || Objects.equals(empName, Employee.empName)
      || Objects.equals(empPhno, Employee.empPhno)
       || Objects.equals(empEmail, Employee.empEmail)
        || Objects.equals(empDoj, Employee.empDoj)
         || Objects.equals(empPwd, Employee.empPwd)
          || Objects.equals(mId, Employee.mId)) {
    return true;
  }
  return false;
}
}

    