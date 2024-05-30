
public class CoinChange {
    public static int[] calculateDenominations(int amount, int[] denominations) {
        int[] counts = new int[denominations.length]; // Array to store the count of each denomination

        // Loop through each denomination
        for (int i = 0; i < denominations.length; i++) {
            counts[i] = amount / denominations[i]; // Calculate the count of the current denomination
            amount %= denominations[i]; // Update the amount to the remaining amount
        }

        return counts; // Return the array with counts of each denomination
    }

    // Method to print the denominations used
    public static void printDenominations(int amount, int[] denominations, int[] counts) {
        System.out.println("Denominations for Rs. " + amount + ":");
        for (int i = 0; i < denominations.length; i++) {
            if (counts[i] > 0) {
                System.out.println("Rs."+ denominations[i]+ " > " + counts[i] ); // Print the count and denomination
            }
        }
    }

    public static void main(String[] args) {
        int amount = 1988; // Amount to be changed
        int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1}; // Available denominations
        System.out.println("Amount is: " + amount);

        int[] counts = calculateDenominations(amount, denominations); // Calculate the denominations
        printDenominations(amount, denominations, counts); // Print the denominations
    }
}
