import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Dados obtidos no dia 25/02/24
public class ConversorServer extends UnicastRemoteObject implements Conversor {

    public ConversorServer() throws RemoteException {
        super();
    }

    double convert(double currency, double multiplier){
        return currency * multiplier;
    }

    @Override
    public double EuroToReal(double currency) throws RemoteException {
        return convert(currency, 5.41);
    };

    @Override
    public double RealToEuro(double currency) throws RemoteException {
        return convert(currency, 0.18);
    };

    @Override
    public double DollarToReal(double currency) throws RemoteException {
        return convert(currency, 5.00);
    };

    @Override
    public double RealToDollar(double currency) throws RemoteException {
        return convert(currency, 0.2);
    };

    public static void main(String[] args) {
        try {
            //RMIServer server = new RMIServer();
            System.out.println("RMI Server is running...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", new ConversorServer());
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
