import java.util.Scanner;

public static void main(String[] args)
{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int k = 1; k <= n; k++) {
            int left = 3 * k;
            int right = factorial(k);
            if (arr[k - 1] > left && arr[k - 1] < right) {
                count++;
            }
        }

        System.out.println(count);
}
    public static int factorial(int x) {
        int result = 1;
        for (int i = 2; i <= x; i++) result *= i;
        return result;
    }
