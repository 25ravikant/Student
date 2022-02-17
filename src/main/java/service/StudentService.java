package service;

import dao.StudentDao;
import modal.StudentModel;

import java.util.ArrayList;
import java.util.LinkedList;

public class StudentService {

    public StudentService() {

    }

    public static int saveStudent(StudentModel st) {

        StudentDao studentDao = new StudentDao();
        int status = studentDao.saveStudent(st);
        return status;

    }

    public static ArrayList<StudentModel> searchRoll(int roll) {

        ArrayList<StudentModel> list = new ArrayList<>();
        StudentDao studentDao = new StudentDao();
        return list =  studentDao.searchN(roll);

    }

    public static int deleteByRoll(int roll) {

        StudentDao studentDao = new StudentDao();
        int status = studentDao.deleteStudent(roll);
        return status;

    }

    public static int update(StudentModel sm) {

        StudentDao studentDao = new StudentDao();
        int status = studentDao.updateStudent(sm);
        return status;

    }

}
