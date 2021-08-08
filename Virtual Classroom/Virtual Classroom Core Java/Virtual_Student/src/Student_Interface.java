import java.rmi.*;
import java.util.Vector;
public interface Student_Interface extends Remote
{
    public boolean stuUser(String stu_id,String pass)throws RemoteException;
    public boolean submit(String s_id,String s_email_id,String s_passwd,String s_name,String s_dob,String s_gender,String s_phone,String s_address,String s_course,String s_branch,String s_year,String s_sem,String s_status)throws RemoteException;
    public String getStudentId(String email_id, String pass)throws RemoteException;
    public String getName1(String studentId)throws RemoteException;
    public Vector[] mySearch1(String stu_id) throws RemoteException;
    public Vector download() throws RemoteException;
    public String get_Gender(String StudentId) throws RemoteException;
    public String getFacultyURL(String fac_id)throws RemoteException;
    public String getFacultyAudioURL(String fac_id)throws RemoteException;
    public int update_stu(String selstu_id,String selstu_email_id,String selstu_passwd,String selstu_name,String selstu_dob,String selstu_gender,String selstu_phone,String selstu_address,String selcourse,String selbranch,String selyear,String selsem,String selstatus) throws RemoteException ;
    public Vector[] Search_class(String course,String branch,String year,String sem) throws RemoteException;
    public Vector getFullStudentDetails(String stu_id) throws RemoteException;
    public byte[] download(String file_name) throws RemoteException;
    public void registerUser(String stuName,ClientRemote cr)throws RemoteException;
    public void sendMsg(String to,String from,String msg)throws RemoteException;
    public boolean getOnline(String stu_id)throws RemoteException;
    public boolean getOffline(String stu_id)throws RemoteException;
    public String[][] qusOth(String type) throws RemoteException;
    public String[][] qus() throws RemoteException;
    public boolean SubmitOth(int ans, String QusId,String type) throws RemoteException;
    public boolean Submit(int ans, String QusId) throws RemoteException;
    public void ResultSave(String stu_id,String result)throws RemoteException;
}