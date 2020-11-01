package com.madhu.vmns.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;


import com.madhu.vmns.model.Manager;

import com.madhu.vmns.persistence.ManagerDAO;

import org.junit.Test;


import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for ManagerFactory.
 */
public class ManagerFactoryTest {

  /**
  * Tests the equals/hashcode methods of the Manager class.
  @param dao for mocking the dao class
   */
  @Test
  public final void showManager(@Mocked final ManagerDAO dao) {
    final Manager m1 =new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
    final ArrayList<Manager> manList = new ArrayList<Manager>();
    new Expectations() {
      {
        manList.add(m1);
        dao.show();
        result = manList;
      }
    };
    new MockUp<ManagerFactory>() {
      @Mock
    ManagerDAO dao() {
        return dao;
      }
    };
    Manager[] manList1 = ManagerFactory.showManager();
    assertEquals(m1, (manList1[0]));
  }
 /**
  * Tests the equals/hashcode methods of the Manager class.
  @param dao for mocking the dao class
   */
  @Test
  public final void insertManager(@Mocked final ManagerDAO dao) {
    final int expectedS = 1;
    new Expectations() {
      {
        dao.insertmanager("Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);     
         result = expectedS;
      }
    };
    new MockUp<ManagerFactory>() {
      @Mock
    ManagerDAO dao() {
        return dao;
      }
    };
    int actualS = ManagerFactory.insertManager("Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
    assertEquals(expectedS, actualS);
  }
 
/**.
 * tests that Manager login is handled correctly
 * @param dao mocking the dao class
 */
@Test
public final void testLogin(@Mocked final ManagerDAO dao) {
  final Manager validate = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
  new Expectations() {
    {
      System.out.println("mocked get Manager login");
      dao.checkmanager("7989933656", "M@dhu");
      result = validate;
    }
  };
  new MockUp<ManagerFactory>() {
    @Mock
    ManagerDAO dao() {
      System.out.println("Mocked Manager Dao");
      return dao;
    }
  };
  Manager mc = ManagerFactory.manAuth("7989933656", "M@dhu");
  assertEquals(validate, mc);
}
 /**
  * Tests the equals/hashcode methods of the Manager class.
  @param dao for mocking the dao class
   */
  @Test
  public final void Mandetails(@Mocked final ManagerDAO dao) {
    
    final Manager expectedS = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);

    new Expectations() {
      {
        dao.getMandetails(1);
        result = expectedS;
      }
    };
    new MockUp<ManagerFactory>() {
      @Mock
    ManagerDAO dao() {
        return dao;
      }
    };
    Manager actualS = ManagerFactory.Mandetails(1);
    assertEquals(expectedS, actualS);
  }
   /**
   * tests that Manager details is handled correctly.
   */
  @Test
  public final void testDefaultConstructor() {
    ManagerFactory me = new ManagerFactory();
    ManagerFactory m1 = new ManagerFactory();
    assertNotEquals(me, m1);
  }
}
