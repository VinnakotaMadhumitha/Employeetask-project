package com.madhu.vmns.persistence;

import java.util.List;
import com.madhu.vmns.model.Project;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
 * ProjectDAO class used to fetch data from data base.
 * @author MadhumithaVinnakota
 */
public interface ProjectDAO {
    /**
     * @return the all the Project record.
     */
  @SqlQuery("Select * from Project")
    @Mapper(ProjectMapper.class)
    List<Project> show();
/**
* @param pname Pro_Name
* @param eid Pro_EID
* @param pstatus Pro_Status
* @return inserted values
*/   
 @SqlUpdate("INSERT INTO Project (PRO_NAME,PRO_EID,PRO_STATUS)"
+ " values (:pname, :eid, :pstatus)")
int insertProject(@Bind("pname") String pname,@Bind("eid") int eid, @Bind("pstatus") String pstatus);

 /**
     * @param proId to return project Id
     * @return the project.
     */
    @SqlQuery("Select * from Project where PRO_ID = :proId")
    @Mapper(ProjectMapper.class)
    Project getProdetails(@Bind("proId") int proId);
}