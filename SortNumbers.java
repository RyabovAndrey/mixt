import java.util.Arrays;

public class SortNumbers {

    public static void main(String[] args) {
        int[] a=new int[]{7,3,8,2,1,6,5,9,4,0};
        int[] b=new int[]{5,9,4,0};
        int[] c=new int[]{7,3,8,2,1,6};
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(a));
        System.out.println("СОРТИРОВКА ПУЗЫРЬКОМ с декрементом");
        System.out.println(Arrays.toString(bubbleSortIncr(a)));
        a=new int[]{7,3,8,2,1,6,5,9,4,0};
        System.out.println("СОРТИРОВКА ПУЗЫРЬКОМ с инкрементом");
        System.out.println(Arrays.toString(bubbleSortDecr(a)));
        a=new int[]{7,3,8,2,1,6,5,9,4,0};
        System.out.println("СОРТИРОВКА ВЫБОРОМ");
        System.out.println(Arrays.toString(selectionSort(a)));
        a=new int[]{7,3,8,2,1,6,5,9,4,0};
        System.out.println("СОРТИРОВКА ВСТАВКОЙ");
        System.out.println(Arrays.toString(insertSort(a)));
        a=new int[]{7,3,8,2,1,6,5,9,4,0};
        System.out.println("СОРТИРОВКА ШЕЛЛА");
        System.out.println(Arrays.toString(shellSort(a)));
        System.out.println("Исходные массивы");
        System.out.println(Arrays.toString(bubbleSortIncr(c)));
        System.out.println(Arrays.toString(bubbleSortIncr(b)));
        System.out.println("Слияние отсортированных массивов");
        System.out.println(Arrays.toString(merge(c,b)));
        System.out.println("СОРТИРОВКА СЛИЯНИЕМ");
        a=new int[]{7,3,8,2,1,6,5,9,4,0};
        System.out.println(Arrays.toString( mergeSort(a, 0, a.length)));
        System.out.println("БЫСТРАЯ СОРТИРОВКА");
        a=new int[]{7,3,8,2,1,6,5,9,4,0};
        System.out.println(Arrays.toString(quickSort( a,0, a.length-1)));

    }

    public static int[] shellSort(int[] array) {
        /* СОРТИРОВКА ШЕЛЛА
        При сортировке Шелла сначала сравниваются и сортируются между собой значения,
        стоящие один от другого на некотором расстоянии d. Выбор d – как последовательность чисел Фибоначчи.
        После этого процедура повторяется для некоторых меньших значений d, а завершается сортировка Шелла
        упорядочиванием элементов при d=1 (то есть обычной сортировкой вставкой) */
        int h = 1;
        int n = array.length;
        while (h < n / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    int temp = array[j - h];
                    array[j - h]=array[j];
                    array[j] = temp;
                }
            }
            h = h / 3;
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        /* СОРТИРОВКА ВСТАВКОЙ
        На каждом шаге алгоритма мы выбираем один из элементов входных данных
        и вставляем его на нужную позицию в уже отсортированном списке до тех пор,
        пока набор входных данных не будет исчерпан.*/
        int key;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static int[] bubbleSortDecr(int[] array){
        /* СОРТИРОВКА ПУЗЫРЬКОМ
        Внешний цикл каждый раз сокращает фрагмент массива,
        так как внутренний цикл каждый раз ставит в конец фрагмента максимальный элемент.
        Сравниваем элементы попарно, если они имеют неправильный порядок, то меняем местами*/
        for(int i = array.length-1 ; i > 0 ; i--){
          for(int j = 0 ; j < i ; j++){
            if( array[j] > array[j+1] ){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
          }
        }
        return array;
    }
    public static int[] bubbleSortIncr(int[] array) {
        /* СОРТИРОВКА ПУЗЫРЬКОМ
        то же что и bubbleSort(int[] array), но с инкрементированием итератора внешнего цикла*/
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        /* СОРТИРОВКА ВЫБОРОМ (Selection sort)
      По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний,
      2-последний,...)
      Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным
      В оставшейся части подмножества ищем элемент, который меньше предположенного минимума
      Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами */
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i+1; j < array.length; j++) {
                //Если находим, запоминаем его индекс
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
        return array;
    }
    public static int[] merge(int[] n,int m[]) {
        /* СЛИЯНИЕ ОТСОРТИРОВАННЫХ МАССИВОВ
            сравниваем по одному элементу из каждого массива и наибольший
            помещаем в результирующий массив. Если в одном массиве элеметы закончились,
            то добавляем оставшиеся элементы из другого.
        */
        int[] result =new int[n.length+m.length];
        int i=0,j=0,k=0;
        while (true) {
            if (i<n.length && j<m.length) {
                if (n[i] < m[j]) {
                    result[k] = n[i];
                    i++;
                } else {
                    result[k] = m[j];
                    j++;
                }
            }
            else {
                if (i<n.length || j<m.length) {
                    if (i < n.length) {
                        result[k] = n[i];
                        i++;
                    }
                    if (j < m.length) {
                        result[k] = m[j];
                        j++;
                    }
                }
                else
                    break;
            }
            k++;
        }
        return result;
    }

    public static int[] mergeSort(int[] array, int from, int len) {
        /* СОРТИРОВКА СЛИЯНИЕМ (рекурсия)
         1. Имеем массив размерностью == 1. Он всегда отсортирован
         2. Имеем массив размерностью == 2. Чтобы его отсортировать нужна сравнить оба элемента
            и либо оставить их на своих местах, либо поменять местами.
         3. Массив из 3-элементов сортируем путем слияния двух отсортированных
            массивов размерностью 1 или 2 (метод merge())
         4. Рекурсивно решаем задачу для массивов большего размера по сформированному правилу.
          */
        if (len==0) return new int[0];
        else {
            if (len==1) return new int[]{array[from]};
            else {
                if (len==2) {
                    if (array[from]<array[from+1])
                        return new int[]{array[from],array[from+1]};
                    else
                        return new int[]{array[from+1],array[from]};
                }
                else {
                    int[] left=mergeSort(array,from,len/2);
                    int[] right=mergeSort(array,from+(len/2),len-(len/2));
                    return merge(left,right);
                }
            }
        }

    }
    public static int[] quickSort(int[] array, int low, int high) {

        /* БЫСТРАЯ СОРТИРОВКА (рекурсия)
        Находи опорный элемент(по середине массива или рандомно).
        Располагаем все элементы меньше от опорного слева, а большие справа.
        Повторяем рекурсивно с левой и правой частью.
        */

        int i = low, j = high;
            // Берем опорный элемент из середины массива
        int pivot = array[low + (high-low)/2];

            // Делим массив на правый и левый по значению опорного элемента
            while (i <= j) {
                // Если текущее значение из левого массива меньше опроного элемента,
                // мы берем следующий элемент из левого массива
                while (array[i] < pivot) {
                    i++;
                }
                // Если текущее значение в правом массиве больше опорного элемента,
                // мы берем следующий элемент из правого массива
                while (array[j] > pivot) {
                    j--;
                }
                // Если мы нашли в левом массиве значение больше, чем опорный элемент
                // и если мы нашли в правом массиве значение меньше чем опорный элемент,
                // то мы меняем их местами. После этого мы икременируем i и декременируем j
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            // Рекурсия
            if (low < j)
                quickSort(array,low, j);
            if (i < high)
                quickSort(array,i, high);
            return array;
    }
}
