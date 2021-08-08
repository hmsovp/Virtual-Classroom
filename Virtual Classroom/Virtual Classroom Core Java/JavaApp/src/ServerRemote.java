//Student_Interface
import java.rmi.*;
public interface ServerRemote extends Remote
{
    public void registerUser(String userid,ClientRemote cr)throws RemoteException;
    public void sendMsg(String to,String from,String msg)throws RemoteException;
}
