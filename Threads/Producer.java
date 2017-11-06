package Threads;

public class Producer implements Runnable{
    /* Producer в бесконечном цикле добавляет значение(увеличивая с каждым шагом на 1) в буфер
    buffer и спит заданный интервал времени period. Т.е. мы имитируем время работы производителя
    на изготовление этого значения*/
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;

    public Producer(int startValue, int period, SingleElementBuffer buffer) {
        this.startValue = startValue;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue+" produced");
                buffer.put(startValue++); // метод put здесь блокирующий, т.к. синхронизированный
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                return;
            }
        }
    }
}
