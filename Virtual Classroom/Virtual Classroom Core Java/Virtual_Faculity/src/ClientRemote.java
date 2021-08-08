import java.rmi.*;
import java.util.Vector;
import javax.swing.JTextArea;
public interface ClientRemote extends Remote
{
    public void refreshList(Vector v)throws RemoteException;
    public void setTextArea(JTextArea text)throws RemoteException;
    public void setMessage(String msg,String sender)throws RemoteException;
}
