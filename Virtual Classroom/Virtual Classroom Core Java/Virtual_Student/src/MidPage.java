
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author varargs
 */
public interface MidPage extends Remote {
    public void AddNew(String name, String Date) throws RemoteException;
    public String[][] qusOth(String type) throws RemoteException;
    public String[][] qus() throws RemoteException;
    public boolean SubmitOth(int ans, String QusId,String type) throws RemoteException;
    public boolean Submit(int ans, String QusId) throws RemoteException;
}
