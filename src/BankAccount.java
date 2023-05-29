import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {

    BigDecimal withdraw(BigDecimal value) throws RemoteException;
    BigDecimal deposit(BigDecimal value) throws RemoteException;
    BigDecimal getBalance() throws RemoteException;
}
