package com.madhu.vmns.model;

//import java.util.Objects;


/**
 * Project class used to display Project information.
 * @author VinnakotaMadhumitha
 */

public class Project {

    /**
     * mId to store mId.
     */
    
      private int pId;
      private String pName;
      private int empId;
      private String proStatus;
    
    /**.
     * public constructor
     */
    
      public Project() {
      }
      /**.
 * @param argpId to inialize Project id
 * @param argpName to initialize Project name
 * @param argempId to inialize employee id
 * @param argproStatus to initialize project Status
 * parameterised constructor
 */
  public Project(final int argpId, final String argpName, final int argempId, final String argproStatus) {
this.pId = argpId;
this.pName = argpName;
this.empId = argempId;
this.proStatus = argproStatus;
}

public int getpId() {
    return pId;
}

public void setpId(int pId) {
    this.pId = pId;
}

public String getpName() {
    return pName;
}

public void setpName(String pName) {
    this.pName = pName;
}

public int getEmpId() {
    return empId;
}

public void setEmpId(int empId) {
    this.empId = empId;
}

public String getProStatus() {
    return proStatus;
}

public void setProStatus(String proStatus) {
    this.proStatus = proStatus;
}

}