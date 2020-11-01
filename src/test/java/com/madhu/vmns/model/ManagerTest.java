package com.madhu.vmns.model;

import com.madhu.vmns.factory.ManagerFactory;

import com.madhu.vmns.persistence.ManagerDAO;

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
 * Test class for Manager
 * @author MadhumithaVinnakota
 */
@RunWith(JMockit.class)
public class ManagerTest {
    
  /**.
     * setup method
     */
    @Before
    public void initInput() {
  
    }
    /**.
     * Tests the equals/hashcode methods of the Manager class
     */
    @Test
    public final void testManager() {
      final Manager m1 = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      assertNotEquals(m1, null);
      assertEquals(m1.getmId(),
      new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1).getmId());
    }
  /**.
   * tests that mty Manager list is handled correctlty
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllmty(@Mocked final ManagerDAO dao) {
      new Expectations() {
        {
          dao.show(); result = new ArrayList<Manager>();
        }
      };
      new MockUp<ManagerFactory>() {
        @Mock
      ManagerDAO dao() {
          return dao;
        }
      };
      Manager[] cu = ManagerFactory.showManager();
      assertEquals(0, cu.length);
    }
  /**.
   * Tests that a list with some Manager is handled correctly
   * @param dao mocking the dao class
   */
    @Test
    public final void testListAllSome(@Mocked final ManagerDAO dao) {
        final Manager e1 = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      final ArrayList<Manager> m = new ArrayList<Manager>();
      new Expectations() {
        {
          m.add(e1);
          dao.show(); result = m;
        }
      };
      new MockUp<ManagerFactory>() {
        @Mock
        ManagerDAO dao() {
          return dao;
        }
      };
      Manager[] m1 = ManagerFactory.showManager();
      assertEquals(1, m1.length);
      assertEquals(new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1).getmId(),
          m1[0].getmId());
    }
    /**.
   * tests the default constructor
   */
    @Test
    public final void testManagerDefaultConstructor() {
      Manager newManager = new Manager();
      assertNotEquals(newManager.hashCode(), new Manager().hashCode());
      final Manager Manager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      assertNotEquals(Manager.getmId(), new Manager().getmId());
    }
  /**.
   * tests the getters and setters of Manager id
   */
    @Test
    public final void testManagerId() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      newManager.setmId(1);
      assertEquals(1, newManager.getmId());
    }
  /**.
   * tests the getters and setters of Manager name
   */
    @Test
    public final void testManagerName() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      newManager.setmName("Madhumitha");
      assertEquals("Madhumitha", newManager.getmName());
    }
    /**.
   * tests the getters and setters of Manager phone number
   */
    @Test
    public final void testManagerPhoneNumber() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      newManager.setmPhno("7989933656");
      assertEquals("7989933656", newManager.getmPhno());
    }
      /**.
   * tests the getters and setters of Manager email
   */
    @Test
    public final void testManagerEmail() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      newManager.setmEmail("madhumitha@gmail.com");
      assertEquals("madhumitha@gmail.com", newManager.getmEmail());
    }
          /**.
   * tests the getters and setters of Manager password
   */
    @Test
    public final void testManagerPassword() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      newManager.setmPwd("M@dhu");
      assertEquals("M@dhu", newManager.getmPwd());
    }
    /**.
   * tests the getters and setters of Manager mloyeeID
   */
    @Test
    public final void testManagerWalletBalance() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      newManager.setmEid(1);
      assertEquals(1, newManager.getmEid());
    }
    /**.
     * tests the parameterized constructor
     */
    @Test
    public final void testParameterizedConstructor() {
      final Manager newManager = new Manager(1,"Madhumitha","7989933656","madhumitha@gmail.com","M@dhu",1);
      assertEquals(1,newManager.getmId());
      assertEquals("Madhumitha", newManager.getmName());
      assertEquals("7989933656", newManager.getmPhno());
      assertEquals("madhumitha@gmail.com", newManager.getmEmail());
      assertEquals("M@dhu", newManager.getmPwd());
      assertEquals(1, newManager.getmEid());
    }
  }
  
  





  