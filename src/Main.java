
    import java.util.concurrent.Executors;
    import java.util.concurrent.ScheduledExecutorService;
    import java.util.concurrent.TimeUnit;

    public class Main {

        public static void main(String[] args) {
            final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            // first param -> number of threads to keep in the poool

            // thread that we want to repeat periodically
            Runnable runnable = new Runnable() {
                int countdown = 5;

                @Override
                public void run() {
                    System.out.println(countdown);
                    countdown--;

                    if (countdown < 0) {
                        System.out.println("Finished!");
                        scheduler.shutdown();
                    }
                }
            };

            scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
            // first param -> task that we want to do
            // second param -> delay for the first task, if 5 -> first task gets called after 5 seconds
            // third param -> period of tasks, if 1 -> 1 each time unit, if 2 -> 2 each time units etc.
            // fourth param -> a time unit, seconds, milliseconds, minutes...
        }
    }

