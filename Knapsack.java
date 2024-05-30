import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        // Input the maximum weight capacity of the knapsack
        System.out.print("Enter the maximum weight capacity: ");
        int w = scanner.nextInt();

        // Arrays to store weights and benefits of each item
        int[] weights = new int[n];
        int[] benefits = new int[n];

        // Input the weights and benefits of each item
        System.out.println("Enter the weights and benefits of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt(); // Input weight of the item
            System.out.print("Benefit of item " + (i + 1) + ": ");
            benefits[i] = scanner.nextInt(); // Input benefit of the item
        }

        // Dynamic programming to solve the knapsack problem
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weights[i - 1] <= j) {
                    // Include the item or skip it
                    dp[i][j] = Math.max(dp[i - 1][j], benefits[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    // Skip the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Display the dynamic programming table
        System.out.println("\nDynamic Programming Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // Trace back to find the items included in the optimal solution
        int i = n;
        int j = w;
        System.out.print("\nItems selected for maximum value: ");
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                // Item is included in the optimal solution
                System.out.print("(" + weights[i - 1] + ", " + benefits[i - 1] + ") ");
                j -= weights[i - 1]; // Update the remaining weight
            }
            i--;
        }

        scanner.close(); // Close the scanner
    }
}
