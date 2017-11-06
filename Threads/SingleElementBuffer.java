package Threads;

public class SingleElementBuffer {
    /* Integer используем вместо int, т.к. это ссылочный тип и у него в дополнении к int
    есть еще значение null*/
    private Integer element=null;

    /* У буфера есть два метода put() и get(), Они оба синхронизированы по this. Это
     позволяет гарантировать то, что внутри одного из этих двух методов(но только в одном)
      может находиться не более одного потока*/

    public synchronized void put(Integer newElement) throws InterruptedException {
        /* Producer заходит в метод и проверяет есть ли значение в буфере. Если есть -
        засыпает и ждет когда буфер освободиться. Если пустой - записывает значение в
        буфер и извещает(notify) всех о том, что состояние буфера изменилось */
        while (element!=null) {
            this.wait();
        }
        this.element=newElement;
        this.notifyAll(); // по этой команде просыпаются ВСЕ потоки, заблокированные(не важно кем) по wait
    }

    /* у put и get противоположные условия, т.е один засыпает, когда элемент есть, а второй,
    когда нет*/

    public synchronized Integer get() throws InterruptedException {
        /* Consumer заходит в метод и проверяет есть ли значение в буфере. Если нет -
        засыпает и ждет когда буфер наполнится. Если полный - забирает значение,
        обнуляет буфер и извещает(notify) всех о том, что состояние буфера изменилось */
        while (element==null) {
            this.wait();
        }
        int result=this.element;
        this.element=null;
        this.notifyAll(); // по этой команде просыпаются ВСЕ потоки, заблокированные(не важно кем) по wait
        return result;
    }
}
