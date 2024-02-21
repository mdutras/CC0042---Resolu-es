import java.rmi.Naming;

class Client {
    private static Server server = null;

    public static void main(String[] args) {
        try {
            server = (Server) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            System.out.println(server.get_IP_add());
        }
        catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}