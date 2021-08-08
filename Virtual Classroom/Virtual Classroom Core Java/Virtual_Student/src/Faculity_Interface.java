/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha
 */
import java.rmi.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public interface Faculity_Interface extends Remote
{
    public boolean facUser(String email_id,String pass)throws RemoteException;
    public String getFacultyId(String email_id, String pass)throws RemoteException;
    public boolean submit(String f_id,String f_email_id,String f_passwd,String f_name,String f_dob,String f_gender,String f_phone,String f_address,String f_joining,String f_qual,String f_spec,String f_desi)throws RemoteException;
    public Vector[] search(String s)throws RemoteException;
    public Vector[] mySearch(String f_id)throws RemoteException;
    public String getName(String facultyId)throws RemoteException;
    public String getGender(String facultyId)throws RemoteException;
    public Vector[] getStudentDetail()throws RemoteException;
    public boolean uploadAssignment(String file_name,byte b[])throws RemoteException;
    public void registerFaculty(String url,String fac_id,String url1)throws RemoteException;
    public Vector[] getResult()throws RemoteException;
}