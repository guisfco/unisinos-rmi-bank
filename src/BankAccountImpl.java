import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankAccountImpl extends UnicastRemoteObject implements BankAccount {

    private BigDecimal value;

    protected BankAccountImpl() throws RemoteException {
        super();
        this.value = BigDecimal.ZERO;
    }

    @Override
    public synchronized BigDecimal withdraw(BigDecimal value) throws RemoteException {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RemoteException("Valor inválido.");
        }

        if (this.value.compareTo(value) < 0) {
            throw new RemoteException("Saldo insuficiente.");
        }

        this.value = this.value.subtract(value);
        return this.value;
    }

    @Override
    public synchronized BigDecimal deposit(BigDecimal value) throws RemoteException {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RemoteException("Valor inválido.");
        }

        this.value = this.value.add(value);
        return this.value;
    }

    @Override
    public synchronized BigDecimal getBalance() throws RemoteException {
        return this.value;
    }
}
