import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RMIServer extends UnicastRemoteObject implements Server {
    ArrayList<String> msgs = new ArrayList<String>();

    public RMIServer() throws RemoteException {
        super();
    }

    //- Armazenar uma string na lista;
    @Override
    public void store_msg(String msg) throws RemoteException {
        msgs.add(msg);
    }

    // Recuperar lista de mensagens;
    @Override
    public ArrayList<String> get_msgs() throws RemoteException {
        return msgs;
    }

    // Retornar o IP do servidor;
    @Override
    public String get_IP_add() throws RemoteException {
        return "127.0.0.1";
    }

    // Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM*/
    @Override
    public String get_datetime() throws RemoteException {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static void main(String[] args) {
        try {
            //RMIServer server = new RMIServer();
            System.out.println("RMI Server is running...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", new RMIServer());
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

}