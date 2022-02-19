package home;

import modal.AddressModel;
import modal.StudentModel;
import service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class HomeTest {

  static Logger log = Logger.getLogger(HomeTest.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
       //
        StudentService studentService = new StudentService();

        //scannerString object to read String value
        Scanner scannerString =new Scanner(System.in);

        //scannerInt object to read Int value
        Scanner scannerInt =new Scanner(System.in);

        int ch=0;
        //Do While loop for Select Option
        do {
            System.out.println("1.Insert");
            System.out.println("2.Search By Roll No.");
            System.out.println("3.Delete");
            System.out.println("4.Update");
            System.out.print("Enter Your Choice: ");

            ch = scannerInt.nextInt();
            //Switch Statement to Check Entered Choice
            switch (ch) {
                case 1:
                    //Enter Student Name
                    System.out.print("Enter Student Name :");
                    String stuName = scannerString.nextLine();

                    //Enter Roll No.
                    System.out.print("Enter Roll No. :");
                    int roll = scannerInt.nextInt();

                    //Enter Student Age
                    System.out.print("Enter Age :");
                    int age = scannerInt.nextInt();

                    //Enter Student Class
                    System.out.print("Enter Class :");
                    String classNa = scannerString.nextLine();

                    //Enter Student Email
                    System.out.print("Enter Student Email :");
                    String stuEmail = scannerString.nextLine();

                    //Enter Student Phone
                    System.out.print("Enter Student Phone :");
                    String stuPhone = scannerString.nextLine();

                    //Enter Student Street
                    System.out.print("Enter Student Street :");
                    String stuStreet = scannerString.nextLine();

                    //Enter Pin No.
                    System.out.print("Enter Student Pin :");
                    String stuPin = scannerString.nextLine();

                    //Enter Student City
                    System.out.print("Enter Student City :");
                    String stuCity = scannerString.nextLine();

                    //Passed Student Address Data to Address Model Class
                    AddressModel ad = new AddressModel( stuEmail,stuPhone,stuStreet,stuPin,stuCity);

                    //Passed Student Data And Address Model Data to Student Model Class
                    StudentModel studentModel = new StudentModel( stuName,roll,age,classNa,ad);

                    //Call Student Service Method and Passed Value to it
                    int status = studentService.saveStudent(studentModel);
                    if(status>0) {
                        //Display Success Method
                        log.info("Record has been Saved");
                   } else {
                        //Display Failure Method
                        log.info("Record has been not Saved");
                   }
                    break;
                case 2: System.out.print("Enter Roll No.");
                        int stuRoll = scannerInt.nextInt();
                    ArrayList list1 = studentService.searchRoll(stuRoll);
//                    for(int i=0;i<list1.size();i++){
//                        System.out.println(list1.get(i).toString());
//                    }
                    //Lamda Expression for Display Student Data
                    list1.forEach((n)-> System.out.println(n));
                    break;
                case 3:
                    System.out.println("Enter Roll No.");
                    int stuRollNo = scannerString.nextInt();

                    //Passed Roll No to deleteByRoll Method In Service Class
                    int deleteStatus = studentService.deleteByRoll(stuRollNo);

                    if(deleteStatus>0) {
                        // Display Success Method After Deletion of Student By Roll No.
                        log.info("Record has been Deleted");
                    } else {
                        // Display Failure Message
                        log.info("Record has been not Deleted");
                    }
                    break;
                case 4:
                    //Enter Student Roll No. for Update Record
                    System.out.print("Enter Roll No for Update :");
                    int stRoll = scannerString.nextInt();

                    //Enter Student New Name for Update
                    System.out.print("Enter Student New Name :");
                    String stuNa = scannerString.nextLine();

                    //Enter Student Age for Update
                    System.out.print("Enter Student New Age :");
                    int sage = scannerInt.nextInt();

                    //Enter Student New Class for Change
                    System.out.print("Enter Student New Class :");
                    classNa = scannerString.nextLine();

                    //Enter Student New Email for Update
                    System.out.print("Enter Student New Email :");
                    stuEmail = scannerString.nextLine();

                    //Enter Student New Phone for Update
                    System.out.print("Enter Student New Phone :");
                    stuPhone = scannerString.nextLine();

                    //Enter Student New Street for Update
                    System.out.print("Enter Student New Street :");
                    stuStreet = scannerString.nextLine();

                    //Enter Student New Pin for Update
                    System.out.print("Enter Student New Pin :");
                    stuPin = scannerString.nextLine();

                    //Enter Student New Phone for Update
                    System.out.print("Enter Student New City :");
                    stuCity = scannerString.nextLine();

                    //Passed Student Address to Address Model
                     ad = new AddressModel(stuEmail,stuPhone,stuStreet,stuPin,stuCity);

                     //Passed Student and Address Data to Student Model
                     studentModel = new StudentModel(stuNa,stRoll,sage,classNa,ad);

                     //Passed Value to update Method in Service Class
                     status = studentService.update(studentModel);

                     if (status>0) {
                         //Display Return Success Method
                         log.info("Record has been updated");
                     } else {
                         //Display Failure Method
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
