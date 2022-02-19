package dao;

import connection.MySqlConnection;
import modal.AddressModel;
import modal.StudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class StudentDao {

    public StudentDao() {

    }

    //Save Student Data to Database
    public static int saveStudent(StudentModel st) {
        int status =0;

        try {
            Connection con = MySqlConnection.sqlConnect();
            PreparedStatement ps = con.prepareStatement("insert into student(studentName,rollNo,age,className,email,phone,street,postalCode,city)values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, st.getStudentName());
            ps.setInt(2, st.getRollNo());
            ps.setInt(3, st.getAge());
            ps.setString(4, st.getClassName());
            ps.setString(5, st.getAddModel().getEmail());
            ps.setString(6, st.getAddModel().getPhone());
            ps.setString(7, st.getAddModel().getStreet());
            ps.setString(8, st.getAddModel().getPin());
            ps.setString(9, st.getAddModel().getCity());
            status =  ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    //Search Student Data By Roll No
    public static ArrayList<StudentModel> searchN(int roll) {
        ArrayList<StudentModel> list = new ArrayList<>();

        try {

            Connection con = MySqlConnection.sqlConnect();
            PreparedStatement ps = con.prepareStatement("select * from student where rollNo=?");
            ps.setInt(1,roll);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {

                AddressModel ad = new AddressModel();
                StudentModel sm = new StudentModel();

                sm.setId(rs.getInt("id"));
                sm.setStudentName(rs.getString("studentName"));
                sm.setRollNo(rs.getInt("rollNo"));
                sm.setAge(rs.getInt("age"));
                sm.setClassName(rs.getString("className"));
                ad.setEmail(rs.getString("email"));
                ad.setPhone(rs.getString("phone"));
                ad.setStreet(rs.getString("street"));
                ad.setPin(rs.getString("postalCode"));
                ad.setCity(rs.getString("city"));
                sm.setAddModel(ad);
                list.add(sm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
// Delete Student Data By Roll No.
    public static int deleteStudent(int roll) {
        int status = 0;
        try {
            Connection con = MySqlConnection.sqlConnect();
            PreparedStatement ps = con.prepareStatement("delete from student where rollNo=?");
            ps.setInt(1,roll);
            status =  ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    //Update Student Data By Roll No.
    public static int updateStudent(StudentModel sm) {
        int status = 0;
        try {
            Connection con = MySqlConnection.sqlConnect();
            PreparedStatement ps = con.prepareStatement("update student set studentName=?,age=?,className=?,email=?,phone=?,street=?,postalCode=?,city=? where rollNo=?");
            ps.setString(1,sm.getStudentName());
            ps.setInt(2,sm.getAge());
            ps.setString(3,sm.getClassName());
            ps.setString(4,sm.getAddModel().getEmail());
            ps.setString(5,sm.getAddModel().getPhone());
            ps.setString(6,sm.getAddModel().getStreet());
            ps.setString(7,sm.getAddModel().getPin());
            ps.setString(8,sm.getAddModel().getCity());
            ps.setInt(9,sm.getRollNo());
            status =  ps.executeUpdate();
            con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
