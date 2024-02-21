/*- Armazenar uma string na lista;

- Recuperar lista de mensagens;

- Retornar o IP do servidor;

- Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Server extends UnicastRemoteObject {
    public Server() throws RemoteException {
        super();
    }

    ArrayList msgs = new ArrayList<String>();

    //- Armazenar uma string na lista;
    public void store_msg(String msg){
        msgs.add(msg);
    }

    // Recuperar lista de mensagens;
    public ArrayList<String> gets_msgs(){
        return msgs;
    }

    // Retornar o IP do servidor;
    public String get_IP_add(){
        return "127.0.0.1";
    }

    // Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM*/
    public String get_datetime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            System.out.println("Server is running...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", new Server());
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

}