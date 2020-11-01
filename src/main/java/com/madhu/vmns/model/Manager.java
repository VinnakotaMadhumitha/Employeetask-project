package com.madhu.vmns.model;

//import java.util.Objects;


/**
 * Manager class used to display Manager information.
 * @author VinnakotaMadhumitha
 */

public class Manager {

    /**
     * mId to store mId.
     */
    
      private int mId;
      private String mName;
      private String mPhno;
      private String mEmail;
      private String mPwd;
      private int mEid;
    
    /**.
     * public constructor
     */
    
      public Manager() {
      }
          /**.
 * @param argmId to inialize Manager id
 * @param argmName to initialize Manager name
 * @param argmPhno to initialize Manager phone number
 * @param argmEmail to initialize Manager email
 * @param argmPwd to initialize Manager password
 *  @param argmEid to inialize Manager employee id
 * parameterised constructor
 */
  public Manager(final int argmId, final String argmName, final String argmPhno, final String argmEmail,
  final String argmPwd, final int argmEid) {
this.mId = argmId;
this.mName = argmName;
this.mPhno = argmPhno;
this.mEmail = argmEmail;
this.mPwd = argmPwd;
this.mEid = argmEid;
}

public int getmId() {
    return mId;
}

public void setmId(int mId) {
    this.mId = mId;
}

public String getmName() {
    return mName;
}

public void setmName(String mName) {
    this.mName = mName;
}

public String getmPhno() {
    return mPhno;
}

public void setmPhno(String mPhno) {
    this.mPhno = mPhno;
}

public String getmEmail() {
    return mEmail;
}

public void setmEmail(String mEmail) {
    this.mEmail = mEmail;
}

public String getmPwd() {
    return mPwd;
}

public void setmPwd(String mPwd) {
    this.mPwd = mPwd;
}
public int getmEid() {
    return mEid;
}

public void setmEid(int mEid) {
    this.mEid = mEid;
}

}