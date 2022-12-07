import java.util.Scanner;

public class Task3 {

    static double enterDouble(String invitation, Scanner in) {
        double result;
        System.out.print(invitation);
        while (!in.hasNextDouble()) {
            in.nextLine();
            System.out.println("Вы ввели не число. Попробуйте снова.");
            System.out.print(invitation);
        }
        result = in.nextDouble();
        in.nextLine();
        return result;
    }

    static char enterSign(Scanner in) {
        char result;
        String test;
        while (true) {
            System.out.print("Введите знак операции: ");
            test = in.nextLine();
            if (test.equals("+") || test.equals("-") || test.equals("*") || test.equals("/")) {
                result = test.charAt(0);
                break;
            }
            System.out.println("Вы ввели что-то не то. Попробуйте снова.");
        }
        in.close();
        return result;
    }

    static double calc(double first, double second, char operator) {
        if (operator == '+') return first + second;
        if (operator == '-') return first - second;
        if (operator == '*') return first * second;
        return first / second;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double first = enterDouble("Введите первое число: ", in);
        double second = enterDouble("Введите второе число: ", in);
        char sign = enterSign(in);
        in.close();
        if (sign == '/' && second == 0) {
            System.out.println("Деление на ноль не поддерживается.");
        } else {
            System.out.printf("Результат: %f", calc(first, second, sign));
        }
    }
}
