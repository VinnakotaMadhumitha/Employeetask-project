package com.madhu.vmns.model;

import com.madhu.vmns.factory.TaskFactory;
//import vmns.main.java.model.Task;
import com.madhu.vmns.persistence.TaskDAO;

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
 * Test class for Task
 * @author MadhumithaVinnakota
 */
@RunWith(JMockit.class)
public class TaskTest {
    
  /**.
     * setup method
     */
    @Before
    public void initInput() {
  
    }
    /**.
     * Tests the equals/hashcode methods of the Task class
     */
    @Test
    public final void testTask() {
      final Task t1 = new Task(1,"Database","Waiting for approval","No Comments",1);
      assertNotEquals(t1, null);
      assertEquals(t1.gettId(),
      new Task(1,"Database","Waiting for approval","No Comments",1).gettId());
    }
  /**.
   * tests that mty Task list is handled correctlty
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllmty(@Mocked final TaskDAO dao) {
      new Expectations() {
        {
          dao.show1(); result = new ArrayList<Task>();
        }
      };
      new MockUp<TaskFactory>() {
        @Mock
      TaskDAO dao() {
          return dao;
        }
      };
      Task[] cu = TaskFactory.showTask1();
      assertEquals(0, cu.length);
    }
  /**.
   * Tests that a list with some Task is handled correctly
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllSome(@Mocked final TaskDAO dao) {
        final Task e1 = new Task(1,"Database","Waiting for approval","No Comments",1);
      final ArrayList<Task> m = new ArrayList<Task>();
      new Expectations() {
        {
          m.add(e1);
          dao.show1(); result = m;
        }
      };
      new MockUp<TaskFactory>() {
        @Mock
        TaskDAO dao() {
          return dao;
        }
      };
      Task[] m1 = TaskFactory.showTask1();
      assertEquals(1, m1.length);
      assertEquals(new Task(1,"Database","Waiting for approval","No Comments",1).gettId(),
          m1[0].gettId());
    }
    /**.
   * tests the default constructor
   */
    @Test
    public final void testTaskDefaultConstructor() {
      Task newTask = new Task();
      assertNotEquals(newTask.hashCode(), new Task().hashCode());
      final Task Task = new Task(1,"Database","Waiting for approval","No Comments",1);
      assertNotEquals(Task.gettId(), new Task().gettId());
    }
  /**.
   * tests the getters and setters of Task id
   */
    @Test
    public final void testTaskId() {
      final Task newTask = new Task(1,"Database","Waiting for approval","No Comments",1);
      newTask.settId(1);
      assertEquals(1, newTask.gettId());
    }
  /**.
   * tests the getters and setters of Task Details
   */
    @Test
    public final void testTaskDetails() {
      final Task newTask = new Task(1,"Database","Waiting for approval","No Comments",1);
      newTask.settDetails("Database");
      assertEquals("Database", newTask.gettDetails());
    }
    /**.
   * tests the getters and setters of Task Status
   */
    @Test
    public final void testTaskPhoneNumber() {
      final Task newTask = new Task(1,"Database","Waiting for approval","No Comments",1);
      newTask.settStatus("Waiting for approval");
      assertEquals("Waiting for approval", newTask.gettStatus());
    }
      /**.
   * tests the getters and setters of Task mComment
   */
    @Test
    public final void testTaskMComment() {
      final Task newTask = new Task(1,"Database","Waiting for approval","No Comments",1);
      newTask.setmComment("No Comments");
      assertEquals("No Comments", newTask.getmComment());
    }
          /**.
   * tests the getters and setters of Task project ID
   */
    @Test
    public final void testTaskPId() {
      final Task newTask = new Task(1,"Database","Waiting for approval","No Comments",1);
      newTask.setpId(1);
      assertEquals(1, newTask.getpId());
    }
    /**.
     * tests the parameterized constructor
     */
    @Test
    public final void testParameterizedConstructor() {
      final Task newTask = new Task(1,"Waiting for approval","Database","No Comments",1);
      assertEquals(1,newTask.gettId());
      assertEquals("Database", newTask.gettDetails());
      assertEquals("Waiting for approval", newTask.gettStatus());
      assertEquals("No Comments", newTask.getmComment());
      assertEquals(1, newTask.getpId());
    }
  }
  
  





  