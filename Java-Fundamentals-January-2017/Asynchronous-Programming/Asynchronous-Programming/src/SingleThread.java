
public class SingleThread {

    public static void main(String[] args) {

        Runnable task = () -> {
            while (true){}
        };

        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
