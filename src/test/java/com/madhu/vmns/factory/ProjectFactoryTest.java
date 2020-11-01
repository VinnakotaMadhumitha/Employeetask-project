package com.madhu.vmns.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;


import com.madhu.vmns.model.Project;

import com.madhu.vmns.persistence.ProjectDAO;

import org.junit.Test;


import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for ProjectFactory.
 */
public class ProjectFactoryTest {

  /**
  * Tests the equals/hashcode methods of the Project class.
  @param dao for mocking the dao class
   */
  @Test
  public final void showProject(@Mocked final ProjectDAO dao) {
    final Project p1 =new Project(1,"EmployeeManagement",1,"Current");
    final ArrayList<Project> proList = new ArrayList<Project>();
    new Expectations() {
      {
        proList.add(p1);
        dao.show();
        result = proList;
      }
    };
    new MockUp<ProjectFactory>() {
      @Mock
    ProjectDAO dao() {
        return dao;
      }
    };
    Project[] proList1 = ProjectFactory.showProject();
    assertEquals(p1, (proList1[0]));
  }
 /**
  * Tests the equals/hashcode methods of the Project class.
  @param dao for mocking the dao class
   */
  @Test
  public final void insertProject(@Mocked final ProjectDAO dao) {
    final int expectedS = 1;
    new Expectations() {
      {
        dao.insertProject("EmployeeManagement",1,"Current");     
         result = expectedS;
      }
    };
    new MockUp<ProjectFactory>() {
      @Mock
    ProjectDAO dao() {
        return dao;
      }
    };
    int actualS = ProjectFactory.insertProject("EmployeeManagement",1,"Current");
    assertEquals(expectedS, actualS);
  }
 /**
  * Tests the equals/hashcode methods of the Project class.
  @param dao for mocking the dao class
   */
  @Test
  public final void Prodetails(@Mocked final ProjectDAO dao) {
    
    final Project expectedS = new Project(1,"EmployeeManagement",1,"Current");

    new Expectations() {
      {
        dao.getProdetails(1);
        result = expectedS;
      }
    };
    new MockUp<ProjectFactory>() {
      @Mock
    ProjectDAO dao() {
        return dao;
      }
    };
    Project actualS = ProjectFactory.Prodetails(1);
    assertEquals(expectedS, actualS);
  }
   /**
   * tests that Project details is handled correctly.
   */
  @Test
  public final void testDefaultConstructor() {
    ProjectFactory me = new ProjectFactory();
    ProjectFactory m1 = new ProjectFactory();
    assertNotEquals(me, m1);
  }
}
