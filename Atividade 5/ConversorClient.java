import java.rmi.Naming;

public class ConversorClient {
    private static Conversor server = null;

    public static void main(String[] args) {
        try {
            server = (Conversor) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            System.out.println(server.EuroToReal(10.0));
            System.out.println(server.RealToEuro(10.0));
            System.out.println(server.DollarToReal(10.0));
            System.out.println(server.RealToDollar(10.0));
        }
        catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}