package com.madhu.vmns.persistence;

import java.util.List;
import com.madhu.vmns.model.Manager;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
 * ManagerDAO class used to fetch data from data base.
 * @author MadhumithaVinnakota
 */
public interface ManagerDAO {
    /**
     * @return the all the Manager record.
     */
  @SqlQuery("Select * from Manager")
    @Mapper(ManagerMapper.class)
    List<Manager> show();

/**
     * @param manPhno to return manager phnoe number
     * @param manPwd to return password
     * @return the manager.
     */
    @SqlQuery("Select * from manager where man_PHNO = :manPhno and man_PWD = :manPwd")
    @Mapper(ManagerMapper.class)
    Manager checkmanager(@Bind("manPhno") String manPhno, @Bind("manPwd") String manPwd);

     /**
    * @param manname man_NAME
    * @param manPhno man_PHNO
    * @param manEmail man_Email
    * @param manPwd man_PWD
    * @param manEid man_Eid
    * @return inserted values
    */
    @SqlUpdate("INSERT INTO Manager (MAN_NAME, MAN_PHNO,MAN_EMAIL,MAN_PWD,MAN_EID)"
    + " values (:manName, :manPhno, :manEmail, :manPwd ,:manEid)")
      int insertmanager(@Bind("manName") String manName, @Bind("manPhno") String manPhno, @Bind("manEmail") String manEmail,
    @Bind("manPwd") String manPwd, @Bind("manEid") int manEid);

    
 /**
     * @param manId to return manager Id
     * @return the manager.
     */
    @SqlQuery("Select * from Manager where Man_id = :manId")
    @Mapper(ManagerMapper.class)
    Manager getMandetails(@Bind("manId") int manId);
}