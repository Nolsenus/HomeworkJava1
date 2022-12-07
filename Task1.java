import java.util.Scanner;

public class Task1 {

    static int getNthTriangleNum(int n) {
        if (n < 0) {
            return -1;
        }
        return n * (n + 1) / 2;
    }

    static int getNFactorial(int n) {
        int result = 1;
        int start = 1;
        int end = n;
        if (n < 0) {
            start = n;
            end = -1;
        }
        for (int i = start; i <= end; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите целое число n: ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                int trNum = getNthTriangleNum(n);
                if (trNum == -1) {
                    System.out.println("Не существует отрицательных треугольных чисел.");
                } else {
                    System.out.printf("n-ое треугольное число: %d\n", trNum);
                }
                System.out.printf("n факториал: %d\n", getNFactorial(n));
                break;
            } else {
                System.out.println("Вы ввели не целое число.");
            }
        }
    }
}
