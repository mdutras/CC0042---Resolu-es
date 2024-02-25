import java.rmi.*;

import java.util.ArrayList;

public interface Server extends Remote {
    //- Armazenar uma string na lista;
    public void store_msg(String msg) throws RemoteException;

    // Recuperar lista de mensagens;
    public ArrayList<String> get_msgs() throws RemoteException;

    // Retornar o IP do servidor;
    public String get_IP_add() throws RemoteException;

    // Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM*/
    public String get_datetime() throws RemoteException;
}