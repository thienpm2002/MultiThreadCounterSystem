import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Final count: " + counter.getCount());
    }
}
