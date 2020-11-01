package com.madhu.vmns.model;
//import java.util.Objects;


/**
 * Task class used to display Task information.
 * @author VinnakotaMadhumitha
 */

public class Task {

    /**
     * tId to store tId.
     */
    
      private int tId;
      private String tStatus;
      private String tDetails;
      private String mComment;
      private int pId;
    
    /**.
     * public constructor
     */
    
      public Task() {
      }
      /**.
 * @param argtId to inialize Task id
 * @param argtStatus to initialize Task Status
 * @param argtDetails to initialize Task Details
 * @param argmComment to initialize manager comments about task
 *  @param arpId to inialize Project Id 
 * parameterised constructor
 */
  public Task(final int argtId, final String argtStatus, final String argtDetails, final String argmComment,final int argpId) {
this.tId = argtId;
this.tStatus = argtStatus;
this.tDetails = argtDetails;
this.mComment = argmComment;
this.pId = argpId;
}

public int gettId() {
    return tId;
}

public void settId(int tId) {
    this.tId = tId;
}

public String gettStatus() {
    return tStatus;
}

public void settStatus(String tStatus) {
    this.tStatus = tStatus;
}

public String gettDetails() {
    return tDetails;
}

public void settDetails(String tDetails) {
    this.tDetails = tDetails;
}

public String getmComment() {
    return mComment;
}

public void setmComment(String mComment) {
    this.mComment = mComment;
}

public int getpId() {
    return pId;
}

public void setpId(int pId) {
    this.pId = pId;
}

}