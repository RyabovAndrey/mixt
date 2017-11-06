package Threads;

public class Rabbit {
    public static void main(String[] args) {
        new Thread(new RabbitPrinter()).start();
    }
}
