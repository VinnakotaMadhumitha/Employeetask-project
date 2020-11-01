package com.madhu.vmns.util;


import java.util.Date;
import java.util.Scanner;

import  com.madhu.vmns.factory.EmployeeFactory;
import com.madhu.vmns.model.Employee;
import com.madhu.vmns.model.Manager;
import  com.madhu.vmns.factory.ManagerFactory;
import com.madhu.vmns.model.Project;
import  com.madhu.vmns.factory.ProjectFactory;
import com.madhu.vmns.model.Task;
 import com.madhu.vmns.factory.TaskFactory;

/**
 * CliMain used as Client interface for java coading.
 * 
 * @author MadhumithaVinnakota
 */
public class CliMain {
    private Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * . mainMenu used for Login and SignUp .
   */
  private void mainMenu() {
    System.out.println();
    System.out.println();
    System.out.println("-----    WELCOMES YOU TO PROJECT MANAGEMENT   ------");
    System.out.println("-------------------------");
    System.out.println("1.Employee");
    System.out.println("2.Manager");
    System.out.println("3.Exit");
    int mainOption = option.nextInt();
    switch (mainOption) {
      case 1:
       Employee();
        break;
      case 2:
       Manager();
        break;
      case 3:
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println(mainOption + "is not a valid option\nEnter a valid option");
        option.nextLine();
        mainMenu();
    }
  }
  private void Employee() {
    System.out.println();
    System.out.println();
    System.out.println("1.LogIn to account ");
    System.out.println("2.SignUp ");
    System.out.println("3.Exit");
    int mainOption = option.nextInt();
    switch (mainOption) {
      case 1:
        EsignIn();
        break;
      case 2:
        NewEmployee();
        break;
      case 3:
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println(mainOption + "is not a valid option\nEnter a valid option");
        mainMenu();
    }
  }

  private void NewEmployee() {
    System.out.println("Welcome..");
    System.out.println(" Enter the Employee name.");
    String EmpName = option.next();
    System.out.println(" Enter the Phone number");
    String EmpPhno = option.next();
    System.out.println(" Enter the Employee email");
    String EmpEmail = option.next();
    Date EmpDoj = new Date();
    System.out.println("Enter the password");
    String EmpPwd = option.next();
    System.out.println("Enter the Manager Id");
    int EmpMid = option.nextInt();
    int i = EmployeeFactory.insertEmployee(EmpName, EmpPhno, EmpEmail,EmpDoj, EmpPwd,EmpMid );
    if (i > 0) {
      System.out.println("Inserted Successfully");
      EsignIn();
    } else {
      System.out.println("Data could not be Inserted");
    }
  
  }

  private void EsignIn() {
   System.out.println("Enter the phoneno");
   String empPhno = option.next();
   System.out.println("Enter the password");
   String empPwd = option.next();
  Employee e = EmployeeFactory.empAuth(empPhno, empPwd);
   if (e.getEmpPhno() .equals(empPhno) && e.getEmpPwd().equals(empPwd))
 {
     System.out.println("Login Successfull");
     EmployeeDash();
   } else {
     System.out.println("Login Failed");
     mainMenu();
   }
  
  }

  private void EmployeeDash() {
    System.out.println();
    System.out.println();
    System.out.println("1.Details ");
    System.out.println("2.Current Project ");
    System.out.println("3.Task Update");
    System.out.println("4.Task History");
    System.out.println("5.Back");
    int mainOption = option.nextInt();
    switch (mainOption) {
      case 1:
        EmployeeDetails();
        break;
      case 2:
        ProjectInfo();
        break;
      case 3:
        UpdateTask();
        break; 
        case 4:
        TaskHistory();
        break; 
       case 5:
        mainMenu();
        break;
       case 6:
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println(mainOption + "is not a valid option\nEnter a valid option");
        mainMenu();
    }
  }

  private void TaskHistory() {
    System.out.println("please enter the project id");
    int pid = option.nextInt();
    Task[] task = TaskFactory.showTask(pid);
    System.out.format("%-15s %-20s %-20s", "TASK_DETAILS", "TASK_STATUS", "TASK_MCOMMENT");
    System.out.println();
    for (Task t : task ) {
      System.out.format("%-15s %-20s %-20s ",t.gettDetails(),t.gettStatus(),t.getmComment());
      System.out.println();
    }
    EmployeeDash();
  }

  private void UpdateTask() {
    // System.out.println("your in update task method");
    System.out.println("Please enter the ProjectId");
    int pId = option.nextInt();
    System.out.println("Please enter the task details");
    String tdetails = option.next();
    System.out.println("Please enter the task status");
    String tStatus = option.next();
    String mComment = "No Comments";
    int i = TaskFactory.insertTask(tStatus, tdetails, mComment,pId );
    if (i > 0) {
      System.out.println("Inserted Successfully");
    } else {
      System.out.println("Data could not be Inserted");
    } 
    EmployeeDash();
  }

  private void ProjectInfo() {
    System.out.println("Please enter your project Id");
    int ProId = option.nextInt();
    Project pro = ProjectFactory.Prodetails(ProId);
    System.out.printf("Name : " + pro.getpName() + "Status" + pro.getProStatus());
    EmployeeDash();
  }

  private void EmployeeDetails() {
   System.out.println("Please enter your Employee Id");
   int EmpId = option.nextInt();
   Employee emp = EmployeeFactory.Empdetails(EmpId);
   System.out.printf("Name : " + emp.getEmpName() + "Phno : " + emp.getEmpPhno() +  "ManagerId : " + emp.getmId());
   EmployeeDash();
  }

  private void Manager() {
    System.out.println("1.LogIn To account ");
    System.out.println("2.SignUp  ");
    System.out.println("3.Exit ");
    int mainOption = option.nextInt();
    switch (mainOption) {
      case 1:
        MsignIn();
        break;
      case 2:
        NewManager();
        break;
      case 3:
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println(mainOption + "is not a valid option\nEnter a valid option");
        mainMenu();
    }
  }

  private void NewManager() {
    System.out.println("Welcome..");
    System.out.println(" Enter the Employee Id");
    int EmpId = option.nextInt();
    Employee emp = EmployeeFactory.Empdetails(EmpId);
    String ManName = emp.getEmpName();
    String ManPhno = emp.getEmpPhno();
    String ManEmail = emp.getEmpEmail();
    String ManPwd = emp.getEmpPwd();
    int i = ManagerFactory.insertManager(ManName, ManPhno, ManEmail,ManPwd,EmpId );
    if (i > 0) {
      System.out.println("Inserted Successfully");
      MsignIn();
    } else {
      System.out.println("Data could not be Inserted");
    }
    
  }

  private void MsignIn() {
  System.out.println("Enter the phoneno");
   String manPhno = option.next();
   System.out.println("Enter the password");
   String manPwd = option.next();
 Manager m = ManagerFactory.manAuth(manPhno, manPwd);
if (m.getmPhno().equals(manPhno)  && m.getmPwd().equals(manPwd))
{
     System.out.println("Login Successfull");
     ManagerDash();
   } else {
     System.out.println("Login Failed");
     mainMenu();
   }
  
  
  }

  private void ManagerDash() {
    System.out.println();
    System.out.println();
    System.out.println("1.Details ");
    System.out.println("2.List of projects ");
    System.out.println("3.New Project");
    System.out.println("4.List of employees");
    System.out.println("5.Status of Project");
    System.out.println("6.Task Review");
    System.out.println("7.Back");
    int mainOption = option.nextInt();
    switch (mainOption) {
      case 1:
        ManagerDetails();
        break;
      case 2:
        ProjectList();
        break;
      case 3:
        NewProject();
        break; 
        case 4:
        EmployeeList();
        break; 
        case 5:
        ProjectStatus();
        break; 
        case 6:
        TaskReview();
        break;
       case 7:
        mainMenu();
        break;
       case 8:
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println(mainOption + "is not a valid option\nEnter a valid option");
        mainMenu();
    }

  }

  private void TaskReview() {
    System.out.println("Please enter the Task id");
    int tid = option.nextInt();
    Task t = TaskFactory.TaskInfo(tid);
    System.out.printf("Status : " + t.gettStatus() +  "Details : " +t.gettDetails());
    System.out.println("Please enter your Comments");
    String mcomment = option.next();
    int i = TaskFactory.updateComment(mcomment,tid);
    if (i > 0) {
      System.out.println("Inserted Successfully");
    } else {
      System.out.println("Data could not be Inserted");
    }
    ManagerDash();

  }

  private void ManagerDetails() {
  System.out.println("Please enter your Manager Id");
   int ManId = option.nextInt();
   Manager man = ManagerFactory.Mandetails(ManId);
   System.out.printf("Name : " + man.getmName() + "Phno : " + man.getmPhno() + "ManagerId : " + man.getmId());
    ManagerDash();
  }

  private void ProjectList() {
    Project[] pro = ProjectFactory.showProject();
    System.out.format("%-15s %-20s %-20s  %-20s", "PRO_Id", "PRO_Name", "PRO_EMPID" ,"PRO_STATUS");
    System.out.println();
    for (Project p : pro) {
      System.out.format("%-15s %-20s %-20s  %-20s ", p.getpId(),p.getpName(),p.getEmpId(),p.getProStatus());
      System.out.println();
    }
    ManagerDash();
  }

  private void NewProject() {
  System.out.println("Please enter the project name");
  String pname = option.next();
  System.out.println("Please enter the Employee Id");
  int eid = option.nextInt();
  String pstatus ="Current";
  int i = ProjectFactory.insertProject( pname,eid,pstatus);
    if (i > 0) {
      System.out.println("Inserted Successfully");
    } else {
      System.out.println("Data could not be Inserted");
    }
    ManagerDash();
  }

  private void EmployeeList() {
    Employee[] emp = EmployeeFactory.showEmployee();
    System.out.format("%-15s %-20s %-20s", "EMP_Id", "EMP_Name", "EMP_Phno");
    System.out.println();
    for (Employee e : emp) {
      System.out.format("%-15s %-20s %-20s ", e.getEmpId(),e.getEmpName(),e.getEmpPhno());
      System.out.println();
    }
    ManagerDash();
  }

  private void ProjectStatus() {
    System.out.println("please enter the project id");
    int pid = option.nextInt();
    Task[] task = TaskFactory.showTask(pid);
    System.out.format("%-15s %-20s %-20s", "TASK_DETAILS", "TASK_STATUS", "TASK_MCOMMENT");
    System.out.println();
    for (Task t : task ) {
      System.out.format("%-15s %-20s %-20s ",t.gettDetails(),t.gettStatus(),t.getmComment());
      System.out.println();
    }

    ManagerDash();
  }

  /**
   * main method is the basic entry point for the application.
   * 
   * @param args used to get the user input.
   */
public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
