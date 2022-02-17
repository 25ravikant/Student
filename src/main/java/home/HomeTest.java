package home;

import modal.AddressModel;
import modal.StudentModel;
import service.StudentService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class HomeTest {

  static Logger log = Logger.getLogger(HomeTest.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();

        StudentService studentService = new StudentService();

        Scanner s1 =new Scanner(System.in);
        Scanner s2 =new Scanner(System.in);

        int ch=0;
        do {
            System.out.println("1.Insert");
            System.out.println("2.Search By Roll No.");
            System.out.println("3.Delete");
            System.out.println("4.Update");
            System.out.print("Enter Your Choice: ");

            ch = s2.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Student Name :");
                    String stuName = s1.nextLine();

                    System.out.print("Enter Roll No. :");
                    int roll = s2.nextInt();

                    System.out.print("Enter Age :");
                    int age = s2.nextInt();

                    System.out.print("Enter Class :");
                    String classNa = s1.nextLine();

                    System.out.print("Enter Student New Email :");
                    String stuEmail = s1.nextLine();

                    System.out.print("Enter Student New Phone :");
                    String stuPhone = s1.nextLine();

                    System.out.print("Enter Student New Street :");
                    String stuStreet = s1.nextLine();

                    System.out.print("Enter Student New Pin :");
                    String stuPin = s1.nextLine();

                    System.out.print("Enter Student New City :");
                    String stuCity = s1.nextLine();

                    AddressModel ad = new AddressModel( stuEmail,stuPhone,stuStreet,stuPin,stuCity);
                    StudentModel studentModel = new StudentModel( stuName,roll,age,classNa,ad);

                    int status = studentService.saveStudent(studentModel);
                    if(status>0) {
                        log.info("Record has been Saved");
                   } else {
                        log.info("Record has been not Saved");
                   }
                    break;
                case 2: System.out.print("Enter Roll No.");
                        int stuRoll = s1.nextInt();
                    ArrayList list1 = studentService.searchRoll(stuRoll);
//                    for(int i=0;i<list1.size();i++){
//                        System.out.println(list1.get(i).toString());
//                    }
                    list1.forEach((n)-> System.out.println(n));
                    break;
                case 3:
                    System.out.println("Enter Roll No.");
                    int stuRollNo = s1.nextInt();
                    int deleteStatus = studentService.deleteByRoll(stuRollNo);

                    if(deleteStatus>0) {
                        log.info("Record has been Deleted");
                    } else {
                        log.info("Record has been not Deleted");
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll No for Update :");
                    int stRoll = s2.nextInt();
                    System.out.print("Enter Student New Name :");
                    String stuNa = s1.nextLine();
                    System.out.print("Enter Student New Age :");
                    int sage = s2.nextInt();
                    System.out.print("Enter Student New Class :");
                    classNa = s1.nextLine();
                    System.out.print("Enter Student New Email :");
                    stuEmail = s1.nextLine();
                    System.out.print("Enter Student New Phone :");
                    stuPhone = s1.nextLine();
                    System.out.print("Enter Student New Street :");
                    stuStreet = s1.nextLine();
                    System.out.print("Enter Student New Pin :");
                    stuPin = s1.nextLine();
                    System.out.print("Enter Student New City :");
                    stuCity = s1.nextLine();

                     ad = new AddressModel(stuEmail,stuPhone,stuStreet,stuPin,stuCity);
                     studentModel = new StudentModel(stuNa,stRoll,sage,classNa,ad);
                     status = studentService.update(studentModel);

                     if (status>0) {
                         log.info("Record has been updated");
                     } else {
                         log.info("Record has been not updated");
                     }
                    break;
                default:
                    System.out.println("");
                    break;
            }
        } while(ch!=0);
    }
}
