package lit.com.src;

public class Exercise4V1 {

    public static void main(String[] args) {
        int target = 200;
        int coins[] = {200, 100, 50, 20, 10, 5, 2, 1};

        //creates an array where each index i represents the
        //number of ways to make the amount i using the available coins.
        int ways[] = new int[target + 1];

        /*
         * Initialise the base case.
         * There is exactly 1 way to make a total of 0: by selecting no coins at all.
         * This value acts as the starting point for building all larger amounts.
         */
        ways[0] = 1;

        //For each coin, update the ways to make amounts up to target
        for (int coin : coins) {
            for (int amount = coin; amount <= target; amount++) {
                ways[amount] += ways[amount - coin];
            }
        }
        System.out.println(ways[target]);
    }
}