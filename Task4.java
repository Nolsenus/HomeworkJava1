import java.util.*;

public class Task4 {

    static boolean isValidExpr(String line) {
        int plusIndex = line.indexOf('+');
        if (plusIndex == -1) return false;
        int equalsIndex = line.indexOf('=');
        if (equalsIndex == -1) return false;
        if (equalsIndex < plusIndex ||
                plusIndex == 0 ||
                equalsIndex == plusIndex + 1 ||
                equalsIndex == line.length() - 1) return false;
        line = line.replaceAll("([+=])", "");
        for (char ch : line.toCharArray()) {
            if (!(Character.isDigit(ch) || ch == '?')) return false;
        }
        return true;
    }

    static int solve(String expr) {
        String first = expr.substring(0, expr.indexOf('+'));
        String second = expr.substring(expr.indexOf('+') + 1, expr.indexOf('='));
        String result = expr.substring(expr.indexOf('=') + 1);
        for (int i = 0; i <= 9; ++i) {
            int firstInt = Integer.parseInt(first.replaceAll("\\?", Integer.toString(i)));
            int secondInt = Integer.parseInt(second.replaceAll("\\?", Integer.toString(i)));
            int resultInt = Integer.parseInt(result.replaceAll("\\?", Integer.toString(i)));
            if (firstInt + secondInt == resultInt) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String line = in.nextLine().replaceAll("\\s+", "");
        in.close();
        if (isValidExpr(line)) {
            if (line.indexOf('?') == -1) {
                System.out.println("Вы не указали неизвестные цифры.");
            } else {
                int result = solve(line);
                if (result != -1) System.out.printf("Результат: %d", result);
                else System.out.println("Решений нет.");
            }
        } else {
            System.out.println("Вы ввели какое-то неправильное выражение.");
        }
    }
}
