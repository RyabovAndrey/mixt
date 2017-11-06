import java.util.Arrays;

public class matrixMultiplication {
    /* УМНОЖЕНИЕ КВАДРАТНЫХ МАТРИЦ
        Значение [i][j]-го элемента новой матрицы получается как сумма произведений элементов
        i-ой строки матрицы А на соответствующие элементы j-ого столбца матрицы В
     */
    public static void main(String[] args) {
        int size=3;
        int[] [] a=initiateMatrix(size);
        int[] [] b=initiateMatrix(size);
        int[] [] c=multiplication(a,b);

        printMatrix(a);
        System.out.println();
        printMatrix(b);
        System.out.println();
        printMatrix(c);
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                System.out.print("["+matrix [i][j]+"] ");
            }
            System.out.println();
        }
    }
    public static int[][] initiateMatrix(int x) {
        int [][] result=new int[x][x];
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <x ; j++) {
                result[i][j]=(int) (Math.random()*10);
            }
        }
        return result;
    }
    public static int[][] multiplication(int[][] m,int[][] n) {
        int[][] result=new int[m.length][m.length];
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j <m.length ; j++) {
                for (int k = 0; k <m.length ; k++) {
                    result [i][j]+=m[i][k]*n[k][j];
                }
            }
        }
        return result;
    }
}
