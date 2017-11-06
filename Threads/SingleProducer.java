package Threads;

public class SingleProducer {
    public static void main(String[] args) {
        /* В этом примере реализован буфер buffer с одной ячейкой. Это программа балансировщик,
        в которой Producer производит 1 число раз в 3 секунды, а Consumer потребляет это число
        как только оно появилось в buffer. Т.е. у Producer и Consumer разная скорость.
        И механизм буфера создан для того, чтобы мы не задумывались о том с какой скоростью
         мы производим элемент и с какой потребляем. У нас есть система которая, если пустая,
         блокируется тем кто потребляет, а если полная - тем кто производит*/
        SingleElementBuffer buffer= new SingleElementBuffer();
        new Thread(new Producer(1,3000,buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
