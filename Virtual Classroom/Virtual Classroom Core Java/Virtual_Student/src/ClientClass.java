import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JTextArea;
public class ClientClass extends UnicastRemoteObject implements ClientRemote
{
    JList l;
    JTextArea t;
    public ClientClass(JList l)throws RemoteException
    {
        super();
        this.l=l;
    }

    public void refreshList(Vector v) throws RemoteException 
    {
        l.setListData(v);
    }

    public void setTextArea(JTextArea t) throws RemoteException 
    {
        this.t=t;
    }

    public void setMessage(String msg, String sender) throws RemoteException 
    {
        t.append(sender+": "+msg+"\n");
    }
}
