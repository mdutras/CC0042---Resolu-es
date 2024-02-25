import java.rmi.Naming;

public class RMIClient {
    private static Server server = null;

    public static void main(String[] args) {
        try {
            server = (Server) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            server.store_msg("pamonha");
            server.store_msg("cocada");
            server.store_msg("pé de moleque");
            server.store_msg("bolo de milho");
            System.out.println(server.get_msgs());
            System.out.println(server.get_IP_add());
            System.out.println(server.get_datetime());
        }
        catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}