package com.madhu.vmns.model;

import com.madhu.vmns.factory.EmployeeFactory;
import com.madhu.vmns.persistence.EmployeeDAO;

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
import java.util.Date;


/**.
 * Test class for Employee
 * @author MadhumithaVinnakota
 */
@RunWith(JMockit.class)
public class EmployeeTest {
    
  /**.
     * setup method
     */
    @Before
    public void initInput() {
  
    }
    /**.
     * Tests the equals/hashcode methods of the Employee class
     */
    @Test
    public final void testEmployee() {
      Date d =new Date();
      final Employee e1 = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      assertNotEquals(e1, null);
      assertEquals(e1.getEmpId(),
      new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1).getEmpId());
    }
  /**.
   * tests that empty Employee list is handled correctlty
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
      new Expectations() {
        {
          dao.show(); result = new ArrayList<Employee>();
        }
      };
      new MockUp<EmployeeFactory>() {
        @Mock
      EmployeeDAO dao() {
          return dao;
        }
      };
      Employee[] cu = EmployeeFactory.showEmployee();
      assertEquals(0, cu.length);
    }
  /**.
   * Tests that a list with some Employee is handled correctly
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllSome(@Mocked final EmployeeDAO dao) {
        Date d = new Date();
        final Employee e1 = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      final ArrayList<Employee> Emp = new ArrayList<Employee>();
      new Expectations() {
        {
          Emp.add(e1);
          dao.show(); result = Emp;
        }
      };
      new MockUp<EmployeeFactory>() {
        @Mock
        EmployeeDAO dao() {
          return dao;
        }
      };
      Employee[] Emp1 = EmployeeFactory.showEmployee();
      assertEquals(1, Emp1.length);
      assertEquals(new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1).getEmpId(),
          Emp1[0].getEmpId());
    }
    /**.
   * tests the default constructor
   */
    @Test
    public final void testEmployeeDefaultConstructor() {
      Employee newEmployee = new Employee();
      assertEquals(newEmployee.hashCode(), new Employee().hashCode());
      Date d =new Date();
      final Employee Employee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      assertNotEquals(Employee.getEmpId(), new Employee().getEmpId());
    }
  /**.
   * tests the getters and setters of Employee id
   */
    @Test
    public final void testEmployeeId() {
         Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setEmpId(6);
      assertEquals(6, newEmployee.getEmpId());
    }
  /**.
   * tests the getters and setters of Employee name
   */
    @Test
    public final void testEmployeeName() {
         Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setEmpName("Madhumitha");
      assertEquals("Madhumitha", newEmployee.getEmpName());
    }
    /**.
   * tests the getters and setters of Employee phone number
   */
    @Test
    public final void testEmployeePhoneNumber() {
         Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setEmpPhno("7989933656");
      assertEquals("7989933656", newEmployee.getEmpPhno());
    }
      /**.
   * tests the getters and setters of Employee email
   */
    @Test
    public final void testEmployeeEmail() {
         Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setEmpEmail("madhumitha@gmail.com");
      assertEquals("madhumitha@gmail.com", newEmployee.getEmpEmail());
    }
        /**.
   * tests the getters and setters of Employee doj
   */
    @Test
    public final void testEmployeeDob() {
         Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setEmpDoj( d);
      assertEquals( d, newEmployee.getEmpDoj());
    }
          /**.
   * tests the getters and setters of Employee password
   */
    @Test
    public final void testEmployeePassword() {
         Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setEmpPwd("M@dhu");
      assertEquals("M@dhu", newEmployee.getEmpPwd());
    }
    /**.
   * tests the getters and setters of Employee manager ID
   */
    @Test
    public final void testEmployeeWalletBalance() {
       Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      newEmployee.setmId(1);
      assertEquals(1, newEmployee.getmId());
    }
    /**.
     * tests the parameterized constructor
     */
    @Test
    public final void testParameterizedConstructor() {
        Date d =new Date();
      final Employee newEmployee = new Employee(1,"Madhumitha","7989933656","madhumitha@gmail.com",d,"M@dhu",1);
      assertEquals(1,newEmployee.getEmpId());
      assertEquals("Madhumitha", newEmployee.getEmpName());
      assertEquals("7989933656", newEmployee.getEmpPhno());
      assertEquals("madhumitha@gmail.com", newEmployee.getEmpEmail());
      assertEquals(d, newEmployee.getEmpDoj());
      assertEquals("M@dhu", newEmployee.getEmpPwd());
      assertEquals(1, newEmployee.getmId());
    }
  }
  
  
    





  