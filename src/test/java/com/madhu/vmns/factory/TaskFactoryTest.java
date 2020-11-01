package com.madhu.vmns.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;


import com.madhu.vmns.model.Task;

import com.madhu.vmns.persistence.TaskDAO;

import org.junit.Test;


import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for TaskFactory.
 */
public class TaskFactoryTest {

  /**
  * Tests the equals/hashcode methods of the Task class.
  @param dao for mocking the dao class
   */
  @Test
  public final void showTask1(@Mocked final TaskDAO dao) {
    final Task t1 = new Task(1,"Database","Waiting for approval","No Comments",1);
    final ArrayList<Task> taskList = new ArrayList<Task>();
    new Expectations() {
      {
        taskList.add(t1);
        dao.show1();
        result = taskList;
      }
    };
    new MockUp<TaskFactory>() {
      @Mock
    TaskDAO dao() {
        return dao;
      }
    };
    Task[] taskList1 = TaskFactory.showTask1();
    assertEquals(t1, (taskList1[0]));
  }
 /**
  * Tests the equals/hashcode methods of the Task class.
  @param dao for mocking the dao class
   */
  @Test
  public final void insertTask(@Mocked final TaskDAO dao) {
    final int expectedS = 1;
    new Expectations() {
      {
        dao.insertTask("Database","Waiting for approval","No Comments",1);     
         result = expectedS;
      }
    };
    new MockUp<TaskFactory>() {
      @Mock
    TaskDAO dao() {
        return dao;
      }
    };
    int actualS = TaskFactory.insertTask("Database","Waiting for approval","No Comments",1);
    assertEquals(expectedS, actualS);
  }
 /**
  * Tests the equals/hashcode methods of the Task class.
  @param dao for mocking the dao class
   */
  @Test
  public final void  TaskInfo(@Mocked final TaskDAO dao) {
    
    final Task expectedS =  new Task(1,"Database","Waiting for approval","No Comments",1);

    new Expectations() {
      {
        dao.getTaskdetails(1);
        result = expectedS;
      }
    };
    new MockUp<TaskFactory>() {
      @Mock
    TaskDAO dao() {
        return dao;
      }
    };
    Task actualS = TaskFactory.TaskInfo(1);
    assertEquals(expectedS, actualS);
  }
  /**.
 * tests whether the task comment is updated
 * @param dao mocking the dao class
 */
@Test
public final void updateComment(@Mocked final TaskDAO dao) {
  final int expected = 1;
  new Expectations() {
    {
      dao.managerupdate("Approved",1);
      result = expected;
    }
  };

  new MockUp<TaskFactory>() {
    @Mock
    TaskDAO dao() {
      return dao;
    }
  };
  int actual = TaskFactory.updateComment("Approved",1);
  assertEquals(expected, actual);
}
   /**
   * tests that Task details is handled correctly.
   */
  @Test
  public final void testDefaultConstructor() {
    TaskFactory me = new TaskFactory();
    TaskFactory m1 = new TaskFactory();
    assertNotEquals(me, m1);
  }
}
