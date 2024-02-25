import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conversor extends Remote {
    public double EuroToReal(double currency) throws RemoteException;
    public double RealToEuro(double currency) throws RemoteException;
    public double DollarToReal(double currency) throws RemoteException;
    public double RealToDollar(double currency) throws RemoteException;
}