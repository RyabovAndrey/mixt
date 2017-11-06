package Threads;

public class InterruptExampleD {
    public static void main(String[] args) throws InterruptedException {
        /* Здесь мы видим, что interrupt прерывает уже запущенный sleep с
        помощью InterruptedException */

        Thread thread=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("Засыпаем");
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    System.out.println("Пробуждаемся прерыванием");
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        System.out.println("Пробуждаем!");
        thread.interrupt();
    }
}
