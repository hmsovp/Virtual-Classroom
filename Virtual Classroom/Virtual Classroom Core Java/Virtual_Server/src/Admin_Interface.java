import java.rmi.*;
import java.util.Vector;
public interface Admin_Interface extends Remote
{
 public boolean authUser(String admin_id,String passwd)throws RemoteException;
 //public Vector getFacultyName()throws RemoteException;
 public Vector getFacultyId()throws RemoteException;
 public boolean submit(String Faculty_id,String  Time)throws RemoteException;
 public boolean submit1(String Course,String Branch,String Year,String Semester,String Time)throws RemoteException;
 public int user(String Faculty_id,String Faculty_name,String Course,String Branch ,String Year,String Semester,String Subject,String Time,String Duration)throws RemoteException;
 public Vector[] search() throws RemoteException ;
 public int delete(String Course,String Branch,String Year,String Semester,String Subject,String Time)throws RemoteException ;
 public int update(String selfac_id,String selfac_name,String selcourse,String selbranch,String selyear,String selsem,String selsub,String seltime,String selduration) throws RemoteException ;
 public String getFacultyname(String id)throws RemoteException;
 public void insertQuestion(String type1,String Qus,String op1,String op2,String op3 ,String op4,String Ans)throws RemoteException;
 public void updateQuestion(String type1,String QusId,String Qus,String op1,String op2,String op3 ,String op4,String Ans)throws RemoteException;
 public Vector[] searchQuestion(String type1)throws RemoteException;
}