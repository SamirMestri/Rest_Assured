package JavaBasics;

public class PrimeNumber {

    public static void main(String[] args) {

        int n = 10;

        if (n <= 1) {
            System.out.println("not prime");
            return;
        }

        for (int j = 2; j < n; j++) {

            if (n % j == 0) {
                System.out.println("not prime");
                return;
            }
        }
        System.out.println("prime");
    }}






