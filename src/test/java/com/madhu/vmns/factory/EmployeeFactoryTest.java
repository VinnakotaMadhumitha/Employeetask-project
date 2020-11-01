package com.madhu.vmns.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;

import com.madhu.vmns.model.Employee;

import com.madhu.vmns.persistence.EmployeeDAO;

import org.junit.Test;


import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for EmployeeFactory.
 */
public class EmployeeFactoryTest {

  /**
  * Tests the equals/hashcode methods of the employee class.
  @param dao for mocking the dao class
   */
  @Test
  public final void showEmployee(@Mocked final EmployeeDAO dao) {
    Date d =new Date();
    final Employee e1 = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
    final ArrayList<Employee> empList = new ArrayList<Employee>();
    new Expectations() {
      {
        empList.add(e1);
        dao.show();
        result = empList;
      }
    };
    new MockUp<EmployeeFactory>() {
      @Mock
    EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] empList1 = EmployeeFactory.showEmployee();
    assertEquals(e1, (empList1[0]));
  }
 /**
  * Tests the equals/hashcode methods of the employee class.
  @param dao for mocking the dao class
   */
 /*  @Test
  public final void insertEmployee(@Mocked final EmployeeDAO dao) {
    final int expectedS = 1;
    Date d =new Date();
    new Expectations() {
      {
        dao.insertEmployee("Madhumitha","7989933656","madhumitha@gmail.com",new Date(),"M@dhu",1);       
         result = expectedS;
      }
    };
    new MockUp<EmployeeFactory>() {
      @Mock
    EmployeeDAO dao() {
        return dao;
      }
    };
    int actualS = EmployeeFactory.insertEmployee("Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1); 
    assertNotEquals(expectedS, actualS);
  } */
 
/**.
 * tests that Employee login is handled correctly
 * @param dao mocking the dao class
 */
@Test
public final void testLogin(@Mocked final EmployeeDAO dao) {
    Date d = new Date();
  final Employee validate = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
  new Expectations() {
    {
      System.out.println("mocked get Employee login");
      dao.checkemployee("7989933656", "M@dhu");
      result = validate;
    }
  };
  new MockUp<EmployeeFactory>() {
    @Mock
    EmployeeDAO dao() {
      System.out.println("Mocked Employee Dao");
      return dao;
    }
  };
  Employee ec = EmployeeFactory.empAuth("7989933656", "M@dhu");
  assertEquals(validate, ec);
}
 /**
  * Tests the equals/hashcode methods of the employee class.
  @param dao for mocking the dao class
   */
  @Test
  public final void Empdetails(@Mocked final EmployeeDAO dao) {
    Date d =new Date();
    final Employee expectedS = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
    new Expectations() {
      {
        dao.getEmpdetails(1);
        result = expectedS;
      }
    };
    new MockUp<EmployeeFactory>() {
      @Mock
    EmployeeDAO dao() {
        return dao;
      }
    };
    Employee actualS = EmployeeFactory.Empdetails(1);
    assertEquals(expectedS, actualS);
  }
   /**
   * tests that employee details is handled correctly.
   */
  @Test
  public final void testDefaultConstructor() {
    EmployeeFactory me = new EmployeeFactory();
    EmployeeFactory m1 = new EmployeeFactory();
    assertNotEquals(me, m1);
  }
}
