package service;

import dao.StudentDao;
import modal.StudentModel;

import java.util.ArrayList;
import java.util.LinkedList;

public class StudentService {

    public StudentService() {

    }
//  Save Method for pass Student Data to StudentDao
    public static int saveStudent(StudentModel st) {

        StudentDao studentDao = new StudentDao();
        int status = studentDao.saveStudent(st);
        return status;

    }

    //Search Method for Search Student By Roll No.
    public static ArrayList<StudentModel> searchRoll(int roll) {

        ArrayList<StudentModel> list = new ArrayList<>();
        StudentDao studentDao = new StudentDao();
        return list =  studentDao.searchN(roll);

    }

    //Delete Method for Delete Student Data By Roll No.
    public static int deleteByRoll(int roll) {

        StudentDao studentDao = new StudentDao();
        int status = studentDao.deleteStudent(roll);
        return status;

    }

    //Update Method for Update Student Data By Roll No.
    public static int update(StudentModel sm) {

        StudentDao studentDao = new StudentDao();
        int status = studentDao.updateStudent(sm);
        return status;

    }

}
