
public class Account {

    public long balance;

    synchronized void deposit(int amount) {

        balance = balance + amount;
    }
}
