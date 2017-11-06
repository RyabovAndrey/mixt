package Threads;

public class RabbitAttack {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <100 ; i++) {
            String spaces=spaces(i);
            Runnable printer=new PrintRunnable(spaces+i,100);
            Thread thread=new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }
    private static String spaces(int count) {
        String result="";
        for (int i = 0; i <count ; i++) {
            result+=" ";
        }
        return result;
    }
}
