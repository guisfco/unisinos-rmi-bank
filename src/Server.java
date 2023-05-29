import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando servidor RMI.");

            LocateRegistry.createRegistry(1900);

            Naming.rebind("//localhost:1900/Bank", new BankAccountImpl());

            System.out.println("Servidor RMI pronto.");
        } catch (MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
