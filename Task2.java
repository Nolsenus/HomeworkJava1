import java.util.LinkedList;
import java.util.List;

public class Task2 {

    static List<Integer> getPrimesUpTo(int max) {
        List<Integer> primes = new LinkedList<>();
        if (max < 2) {
            return primes;
        }
        primes.add(2);
        boolean isPrime;
        for (int i = 3; i <= max; ++i) {
            isPrime = true;
            for (int num : primes) {
                if (num > i / 2) {
                    break;
                }
                if (i % num == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    static void printIntList(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            System.out.printf("%d, ", list.get(i));
        }
        System.out.println(list.get(list.size() - 1));
    }

    public static void main(String[] args) {
        List<Integer> primes = getPrimesUpTo(1000);
        printIntList(primes);
    }
}
