import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

    private static final int BALANCE = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAW = 3;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        try {
            var bankAccount = (BankAccount) Naming.lookup("//localhost:1900/Bank");

            while (true) {
                System.out.println("\nInforme a operacao desejada: \n\t1 - Saldo \uD83C\uDFE6 \n\t2 - Depositar \uD83D\uDCB0 \n\t3 - Retirar \uD83D\uDCB8");

                switch (sc.nextInt()) {
                    case BALANCE -> System.out.println("\nSaldo atual: R$" + bankAccount.getBalance());
                    case DEPOSIT -> {
                        System.out.println("\nInforme o valor do deposito: ");
                        System.out.println("\nNovo saldo: R$" + bankAccount.deposit(sc.nextBigDecimal()));
                    }
                    case WITHDRAW -> {
                        System.out.println("\nInforme o valor da retirada: ");
                        System.out.println("\nNovo saldo: R$" + bankAccount.withdraw(sc.nextBigDecimal()));
                    }
                    default -> System.out.println("\nOperação inválida.");
                }
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
