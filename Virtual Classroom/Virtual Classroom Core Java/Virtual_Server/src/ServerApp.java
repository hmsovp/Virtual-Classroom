
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerApp extends UnicastRemoteObject implements Admin_Interface, Student_Interface, Faculity_Interface {

    public ServerApp() throws RemoteException {
        super();
    }

    @Override
    /*
     * Admin
     */
    public boolean authUser(String admin_id, String passwd) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admin_table where admin_id='" + admin_id + "' and passwd='" + passwd + "'");

            if (rs.next()) {
                b = true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }
    Vector v;

    @Override
    /*
     * public Vector getFacultyName()throws RemoteException { try{ v=new
     * Vector(1,1); Class.forName("com.mysql.jdbc.Driver"); Connection
     * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db",
     * "root", "123"); Statement st=con.createStatement(); ResultSet
     * rs=st.executeQuery("select Faculty_name from faculty_table");
     * while(rs.next()) { v.addElement(rs.getString(1)); } }catch(Exception e)
     * {} return v; }
     */
    public String getFacultyname(String id) throws RemoteException {
        String s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Faculty_name from faculty_table where Faculty_id='" + id + "'");
            while (rs.next()) {
                s = rs.getString("Faculty_name");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public Vector getFacultyId() throws RemoteException {
        try {
            v = new Vector(1, 1);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Faculty_id from faculty_table");
            while (rs.next()) {
                v.addElement(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return v;
    }

    @Override
    public boolean submit(String Faculty_id, String Time) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from schedule_table where Faculty_id='" + Faculty_id + "' and Time='" + Time + "'");
            if (rs.next()) {
                b = true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    @Override
    public boolean submit1(String Course, String Branch, String Year, String Semester, String Time) throws RemoteException {
        boolean b1 = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from schedule_table where Course='" + Course + "' and Branch='" + Branch + "' and Year='" + Year + "' and  Semester='" + Semester + "'");
            if (rs.next()) {
                b1 = true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b1;
    }

    @Override
    public int user(String Faculty_id, String Faculty_name, String Course, String Branch, String Year, String Semester, String Subject, String Time, String Duration) throws RemoteException {
        int num = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            num = st.executeUpdate("insert into schedule_table values('" + Faculty_id + "','" + Faculty_name + "','" + Course + "','" + Branch + "','" + Year + "','" + Semester + "','" + Subject + "','" + Time + "','" + Duration + "')");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }

    @Override
    public Vector[] search() throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from schedule_table");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                v[index].addElement(rs.getString(8));
                v[index].addElement(rs.getString(9));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public int delete(String Course, String Branch, String Year, String Semester, String Subject, String Time) throws RemoteException {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            i = st.executeUpdate("delete from schedule_table where Course='" + Course + "'and Branch='" + Branch + "'and Year='" + Year + "'and Semester='" + Semester + "'and Subject='" + Subject + "'and Time='" + Time + "'");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    @Override
    public int update(String selfac_id, String selfac_name, String selcourse, String selbranch, String selyear, String selsem, String selsub, String seltime, String selduration) throws RemoteException {
        //Vector v[]=null;
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            i = st.executeUpdate("update schedule_table set Course='" + selcourse + "',Branch='" + selbranch + "',Year='" + selyear + "',Semester='" + selsem + "',Subject='" + selsub + "',Time='" + seltime + "',Duration='" + selduration + "' where Faculty_id='" + selfac_id + "' and Faculty_name='" + selfac_name + "'");
//            System.out.println("update schedule_table set Course='" + selcourse + "',Branch='" + selbranch + "',Year='" + selyear + "',Semester='" + selsem + "', Subject='" + selsub + "'  Time='" + seltime + "',Duration='" + selduration + "' where Faculty_id='" + selfac_id + "' and Faculty_name='" + selfac_name + "'");
            //rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }
    /*
     * Admin
     */

    /*
     * Student
     */
    @Override
    public Vector[] mySearch1(String stu_id) throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_table where Student_id='" + stu_id + "'");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                v[index].addElement(rs.getString(8));
                v[index].addElement(rs.getString(9));
                v[index].addElement(rs.getString(10));
                v[index].addElement(rs.getString(11));
                v[index].addElement(rs.getString(12));
                v[index].addElement(rs.getString(13));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public boolean stuUser(String stu_id, String pass) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_table where Student_email_id='" + stu_id + "' and Student_passwd='" + pass + "'");
            if (rs.next()) {
                b = true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    @Override
    public boolean submit(String s_id, String s_email_id, String s_passwd, String s_name, String s_dob, String s_gender, String s_phone, String s_address, String s_course, String s_branch, String s_year, String s_sem, String s_status) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            int num = st.executeUpdate("insert into student_table values('" + s_id + "','" + s_email_id + "','" + s_passwd + "','" + s_name + "','" + s_dob + "','" + s_gender + "','" + s_phone + "','" + s_address + "','" + s_course + "','" + s_branch + "','" + s_year + "','" + s_sem + "','" + s_status + "')");
            if (num > 0) {
                b = true;
            }
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(b);
        return b;
    }

    @Override
    public String getStudentId(String email_id, String pass) throws RemoteException {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_table where Student_email_id='" + email_id + "' and Student_passwd='" + pass + "'");
            if (rs.next()) {
                s = rs.getString("Student_id");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public String getName1(String studentId) throws RemoteException {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Student_name from student_table where Student_id='" + studentId + "'");
            if (rs.next()) {
                s = rs.getString("Student_name");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public Vector getFullStudentDetails(String stu_id) throws RemoteException {
        Vector v = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Student_course,Student_branch,Student_year,Student_sem from student_table where Student_id='" + stu_id + "'");
            int row = 0;
            rs.next();
            v = new Vector(1, 1);
            v.addElement(rs.getString(1));
            v.addElement(rs.getString(2));
            v.addElement(rs.getString(3));
            v.addElement(rs.getString(4));
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public Vector[] Search_class(String course, String branch, String year, String sem) throws RemoteException {
        Vector v[] = null;
        System.out.println(course + " " + branch + " " + year + " " + sem);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from schedule_table where Course='" + course + "' and Branch='" + branch + "' and Year='" + year + "' and Semester='" + sem + "'");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                v[index].addElement(rs.getString(8));
                v[index].addElement(rs.getString(9));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public String get_Gender(String StudentId) throws RemoteException {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Student_gender from student_table where Student_id='" + StudentId + "'");
            if (rs.next()) {
                s = rs.getString("Student_gender");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }
    /*
     * public boolean downloadAssignment(String file_name,byte b[]) throws
     * RemoteException { boolean b1=false; try { FileOutputStream fout=new
     * FileOutputStream("Uploaded Assignment/"+file_name); fout.write(b);
     * fout.close(); b1=true; }catch(Exception e) { System.out.println(e); }
     * return b1; }
     */

    @Override
    public Vector download() throws RemoteException {
        Vector v1 = null;
        try {
            File f = new File("Assignment");
            String[] name = f.list();
            v1 = new Vector(1, 1);
            for (String temp : name) {
                System.out.println(temp);
                v1.addElement(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return v1;
    }

    /*
     * Student
     */
    /*
     * Faculty
     */
    @Override
    public boolean facUser(String email_id, String pass) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from faculty_table where Faculty_email_id='" + email_id + "' and Faculty_passwd='" + pass + "'");
            if (rs.next()) {
                b = true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    @Override
    public String getFacultyId(String email_id, String pass) throws RemoteException {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from faculty_table where Faculty_email_id='" + email_id + "' and Faculty_passwd='" + pass + "'");
            if (rs.next()) {
                s = rs.getString("Faculty_id");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public boolean submit(String f_id, String f_email_id, String f_passwd, String f_name, String f_dob, String f_gender, String f_phone, String f_address, String f_joining, String f_qual, String f_spec, String f_desi) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            int num = st.executeUpdate("insert into faculty_table values('" + f_id + "','" + f_email_id + "','" + f_passwd + "','" + f_name + "','" + f_dob + "','" + f_gender + "','" + f_phone + "','" + f_address + "','" + f_joining + "','" + f_qual + "','" + f_spec + "','" + f_desi + "')");
            if (num > 0) {
                b = true;
            }
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(b);
        return b;
    }

    @Override
    public String getName(String facultyId) throws RemoteException {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Faculty_name from faculty_table where Faculty_id='" + facultyId + "'");
            if (rs.next()) {
                s = rs.getString("Faculty_name");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public Vector[] search(String s1) throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from schedule_table where Faculty_name='" + s1 + "'");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                v[index].addElement(rs.getString(8));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public Vector[] mySearch(String f_id) throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from schedule_table where Faculty_id='" + f_id + "'");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                v[index].addElement(rs.getString(8));
                v[index].addElement(rs.getString(9));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public Vector[] getStudentDetail() throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_table");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                v[index].addElement(rs.getString(8));
                v[index].addElement(rs.getString(9));
                v[index].addElement(rs.getString(10));
                v[index].addElement(rs.getString(11));
                v[index].addElement(rs.getString(12));
                v[index].addElement(rs.getString(13));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public String getGender(String facultyId) throws RemoteException {
        String s = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Faculty_gender from faculty_table where Faculty_id='" + facultyId + "'");
            if (rs.next()) {
                s = rs.getString("Faculty_gender");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public boolean uploadAssignment(String file_name, byte b[]) throws RemoteException {
        boolean b1 = false;
        try {
            FileOutputStream fout = new FileOutputStream("Assignment/" + file_name);
            fout.write(b);
            fout.close();
            b1 = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return b1;
    }
    /*
     * Faculty
     */

    public static void main(String a[]) {
        try {
            ServerApp ser = new ServerApp();
            Naming.rebind("virtual", ser);
            System.out.println("Server Registered!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public int update_stu(String selstu_id, String selstu_email_id, String selstu_passwd, String selstu_name, String selstu_dob, String selstu_gender, String selstu_phone, String selstu_address, String selcourse, String selbranch, String selyear, String selsem, String selstatus) throws RemoteException {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            i = st.executeUpdate("update student_table set Student_email_id='" + selstu_email_id + "',Student_passwd='" + selstu_passwd + "',Student_name='" + selstu_name + "',Student_dob='" + selstu_dob + "',Student_gender='" + selstu_gender + "',Student_phone='" + selstu_phone + "',Student_address='" + selstu_address + "',Student_course='" + selcourse + "',Student_branch='" + selbranch + "',Student_year='" + selyear + "',Student_sem='" + selsem + "',Student_status='" + selstatus + "' where Student_id='" + selstu_id + "'");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }
    Vector v1 = new Vector(1, 1);
    Vector v2 = new Vector(1, 1);
    Vector v5 = new Vector(1, 1);

    @Override
    public void registerFaculty(String url, String fac_id, String url1) throws RemoteException {
        v1.addElement(url);
        v2.addElement(fac_id);
        v5.addElement(url1);
    }

    @Override
    public String getFacultyURL(String fac_id) throws RemoteException {
        int i;
        for (i = 0; i < v2.size(); i++) {
            if ((v2.elementAt(i).toString()).equals(fac_id)) {
                break;
            }
        }
        return v1.elementAt(i).toString();
    }

    @Override
    public boolean getOnline(String stu_id) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            st.executeUpdate("update student_table set Student_status='true' where Student_id='" + stu_id + "'");
            b = true;
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    @Override
    public boolean getOffline(String stu_id) throws RemoteException {
        boolean b = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_db", "root", "123");
            Statement st = con.createStatement();
            st.executeUpdate("update student_table set Student_status='false' where Student_id='" + stu_id + "'");
            b = true;
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }
    Vector v3 = new Vector(1, 1);
    Vector v4 = new Vector(1, 1);

    @Override
    public void registerUser(String stuName, ClientRemote cr) throws RemoteException {
        v3.addElement(stuName);
        v4.addElement(cr);
        for (int i = 0; i < v4.size(); i++) {
            try {
                ClientRemote cr1 = (ClientRemote) v4.elementAt(i);
                cr1.refreshList(v3);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void sendMsg(String to, String from, String msg) throws RemoteException {
        System.out.println("Server Hello1");
        for (int i = 0; i < v3.size(); i++) {
            if ((v3.elementAt(i).toString()).equals(to)) {
                System.out.println("Server Hello2");
                ClientRemote cr = (ClientRemote) v4.elementAt(i);
                System.out.println(cr + " Hello");
                cr.setMessage(msg, from);
                break;
            }
        }
    }

    @Override
    public byte[] download(String file_name) throws RemoteException {
        byte b[] = null;
        try {
            FileInputStream fin = new FileInputStream("Assignment/" + file_name);
            b = new byte[fin.available()];
            fin.read(b);
        } catch (Exception e) {
        }
        return b;
    }

    @Override
    public String getFacultyAudioURL(String fac_id) throws RemoteException {
        int i;
        for (i = 0; i < v2.size(); i++) {
            if ((v2.elementAt(i).toString()).equals(fac_id)) {
                break;
            }
        }
        return v5.elementAt(i).toString();
    }

    @Override
    public void insertQuestion(String type1, String Qus, String op1, String op2, String op3, String op4, String Ans) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            st.executeUpdate("insert into exampaper" + type1 + " values(0, '" + Qus + "', '" + op1 + "', '" + op2 + "', '" + op3 + "', '" + op4 + "', " + Ans + ")");
            st.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void updateQuestion(String type1, String QusId, String Qus, String op1, String op2, String op3, String op4, String Ans) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            st.executeUpdate("update exampaper" + type1 + " set qus='" + Qus + "', op1='" + op1 + "', op2='" + op2 + "', op3='" + op3 + "', op4='" + op4 + "', ans=" + Ans + " where qusId='" + QusId + "' ");
            st.close();
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public Vector[] searchQuestion(String type1) throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from exampaper" + type1);
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                v[index].addElement(rs.getString(4));
                v[index].addElement(rs.getString(5));
                v[index].addElement(rs.getString(6));
                v[index].addElement(rs.getString(7));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }

    @Override
    public String[][] qusOth(String type) throws RemoteException {
        String qus1[][] = new String[15][6];
        String type1 = "";
        if (type.equals(".NET")) {
            type1 = "net";
        } else if (type.equals("Java")) {
            type1 = "java";
        } else if (type.equals("C++")) {
            type1 = "cpp";
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from exampaper" + type1 + " ORDER BY RAND() LIMIT 15");
            int i = 0;
            while (rs.next()) {
                qus1[i][0] = rs.getString(1);
                qus1[i][1] = rs.getString(2);
                qus1[i][2] = rs.getString(3);
                qus1[i][3] = rs.getString(4);
                qus1[i][4] = rs.getString(5);
                qus1[i][5] = rs.getString(6);
                i++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return qus1;
    }

    @Override
    public String[][] qus() throws RemoteException {
        String qus1[][] = new String[15][6];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from exampaperC ORDER BY RAND() LIMIT 15");
            int i = 0;
            while (rs.next()) {
                qus1[i][0] = rs.getString(1);
                qus1[i][1] = rs.getString(2);
                qus1[i][2] = rs.getString(3);
                qus1[i][3] = rs.getString(4);
                qus1[i][4] = rs.getString(5);
                qus1[i][5] = rs.getString(6);
                i++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return qus1;
    }

    @Override
    public boolean SubmitOth(int ans, String qusId, String type) throws RemoteException {
        String type1 = "";
        boolean bool = false;
        if (type.equals(".NET")) {
            type1 = "net";
        } else if (type.equals("Java")) {
            type1 = "java";
        } else if (type.equals("C++")) {
            type1 = "cpp";
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from exampaper" + type1 + " where qusId='" + qusId + "'");
            if (rs.next()) {
                if (rs.getString(7).equals("" + ans)) {
                    bool = true;
                }
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return bool;

    }

    @Override
    public boolean Submit(int ans, String QusId) throws RemoteException {
        boolean bool = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from exampaperC where qusId='" + QusId + "'");
            if (rs.next()) {
                if (rs.getString(7).equals("" + ans)) {
                    bool = true;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return bool;
    }

    @Override
    public void ResultSave(String stu_id, String result) throws RemoteException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            String name = getName1(stu_id);
            st.executeUpdate("insert into result values ('" + stu_id + "','" + name + "','" + result + "') ");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @Override
    public Vector[] getResult() throws RemoteException {
        Vector v[] = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from result");
            int row = 0;
            while (rs.next()) {
                row++;
            }
            v = new Vector[row];
            int index = 0;
            rs.beforeFirst();
            while (rs.next()) {
                v[index] = new Vector(1, 1);
                v[index].addElement(rs.getString(1));
                v[index].addElement(rs.getString(2));
                v[index].addElement(rs.getString(3));
                index++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return v;
    }
}
