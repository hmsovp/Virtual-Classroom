import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
public class ServerApp extends UnicastRemoteObject implements ServerRemote
{
    Vector v1=new Vector(1,1);
    Vector v2=new Vector(1,1);
    public ServerApp()throws RemoteException
    {
        super();
    }
    
    public static void main(String a[])
    {
        try{
           ServerApp ser=new ServerApp();
           Naming.rebind("server",ser);
           System.out.println("Server Registered");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void registerUser(String userid, ClientRemote cr) throws RemoteException 
    {
        v1.addElement(userid);
        v2.addElement(cr);
        for(int i=0;i<v2.size();i++)
        {
            try{
            ClientRemote cr1=(ClientRemote)v2.elementAt(i);
            cr1.refreshList(v1);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public void sendMsg(String to,String from, String msg) throws RemoteException 
    {
        System.out.println("Server Hello1");
        for(int i=0;i<v1.size();i++)
        {
            if((v1.elementAt(i).toString()).equals(to))
            {
                  System.out.println("Server Hello2");
                  ClientRemote cr=(ClientRemote)v2.elementAt(i);
                  System.out.println(cr+" Hello");
                  cr.setMessage(msg,from);
                  break;
            }
        }
    }
    
}
