
public class ThreadSafeTransactions {

    public static void main(String[] args) throws InterruptedException {

        final int operationsPerTransaction = 100;
        final int transactions = 100;

        Account account = new Account();

        Runnable task = () -> {
            for (int i = 0; i < operationsPerTransaction; i++) {
                account.deposit(1);
                Thread.yield();
            }
        };

        Thread[] threads = new Thread[transactions];
        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(account.balance);
    }
}
