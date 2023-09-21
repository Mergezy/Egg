public class Main {

    public static void main(String[] args) {
        Thread chickenThread = new Thread(new ChickenPrinter());
        Thread eggThread = new Thread(new EggPrinter());

        chickenThread.start();
        eggThread.start();

        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (chickenThread.isAlive()) {
            System.out.println("Курица");
        } else {
            System.out.println("Яйцо");
        }
    }

    static class ChickenPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                try {
                    Thread.sleep(100); // Пауза для имитации доли времени
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class EggPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                try {
                    Thread.sleep(100); // Пауза для имитации доли времени
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
