package com.madhu.vmns.model;

import com.madhu.vmns.factory.ProjectFactory;

import com.madhu.vmns.persistence.ProjectDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;


/**.
 * Test class for Project
 * @author MadhumithaVinnakota
 */
@RunWith(JMockit.class)
public class ProjectTest {
    
  /**.
     * setup method
     */
    @Before
    public void initInput() {
  
    }
    /**.
     * Tests the equals/hashcode methods of the Project class
     */
    @Test
    public final void testProject() {
      final Project p1 = new Project(1,"EmployeeManagement",1,"Current");
      assertNotEquals(p1, null);
      assertEquals(p1.getpId(),
      new Project(1,"EmployeeManagement",1,"Current").getpId());
    }
  /**.
   * tests that mty Project list is handled correctlty
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllmty(@Mocked final ProjectDAO dao) {
      new Expectations() {
        {
          dao.show(); result = new ArrayList<Project>();
        }
      };
      new MockUp<ProjectFactory>() {
        @Mock
      ProjectDAO dao() {
          return dao;
        }
      };
      Project[] cu = ProjectFactory.showProject();
      assertEquals(0, cu.length);
    }
  /**.
   * Tests that a list with some Project is handled correctly
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllSome(@Mocked final ProjectDAO dao) {
        final Project p1 = new Project(1,"EmployeeManagement",1,"Current");
      final ArrayList<Project> m = new ArrayList<Project>();
      new Expectations() {
        {
          m.add(p1);
          dao.show(); result = m;
        }
      };
      new MockUp<ProjectFactory>() {
        @Mock
        ProjectDAO dao() {
          return dao;
        }
      };
      Project[] p11 = ProjectFactory.showProject();
      assertEquals(1, p11.length);
      assertEquals(new Project(1,"EmployeeManagement",1,"Current").getpId(),
          p11[0].getpId());
    }
    /**.
   * tests the default constructor
   */
    @Test
    public final void testProjectDefaultConstructor() {
      Project newProject = new Project();
      assertNotEquals(newProject.hashCode(), new Project().hashCode());
      final Project Project = new Project(1,"EmployeeManagement",1,"Current");
      assertNotEquals(Project.getpId(), new Project().getpId());
    }
  /**.
   * tests the getters and setters of Project id
   */
    @Test
    public final void testProjectId() {
      final Project newProject = new Project(1,"EmployeeManagement",1,"Current");
      newProject.setpId(1);
      assertEquals(1, newProject.getpId());
    }
  /**.
   * tests the getters and setters of Project name
   */
    @Test
    public final void testProjectName() {
      final Project newProject = new Project(1,"EmployeeManagement",1,"Current");
      newProject.setpName("EmployeeManagement");
      assertEquals("EmployeeManagement", newProject.getpName());
    }
    /**.
   * tests the getters and setters of Project Employee ID
   */
    @Test
    public final void testProjectEmployeeID() {
      final Project newProject = new Project(1,"EmployeeManagement",1,"Current");
      newProject.setEmpId(1);
      assertEquals(1, newProject.getEmpId());
    }
      /**.
   * tests the getters and setters of Project status
   */
    @Test
    public final void testProjectStatus() {
      final Project newProject = new Project(1,"EmployeeManagement",1,"Current");
      newProject.setProStatus("Current");
      assertEquals("Current", newProject.getProStatus());
    }
   
    /**.
     * tests the parameterized constructor
     */
    @Test
    public final void testParameterizedConstructor() {
      final Project newProject = new Project(1,"EmployeeManagement",1,"Current");
      assertEquals(1,newProject.getpId());
      assertEquals("EmployeeManagement", newProject.getpName());
      assertEquals(1, newProject.getEmpId());
      assertEquals("Current", newProject.getProStatus());
    }
  }
  
  





  