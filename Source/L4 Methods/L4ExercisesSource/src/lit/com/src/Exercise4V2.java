package lit.com.src;

/**
 * This solution uses recursion
 */

public class Exercise4V2 {
    private static final int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

    /*
      Memo is short for memorisation, which is a technique used to remember
      previously computed results so you don’t repeat work.
      Think of memo as a notebook where you write down answers to
      tricky maths problems. The next time the same problem shows up, you just
      look it up instead of solving it again.
    */
    private static int[][] memo;

    public static void main(String[] args) {
        int target = 200;
        memo = new int[target + 1][coins.length];

        //Init with -1 to indicate "not computed"
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                memo[i][j] = -1;
            }
        }

        int result = findPoss(target, 0);
        System.out.println(result);
    }

    private static int findPoss(int money, int maxcoin) {
        if (maxcoin == coins.length - 1) {
            return 1; //Only one way to use 1cent coins
        }

        if (memo[money][maxcoin] != -1) {
            return memo[money][maxcoin]; //Return cached result
        }

        int sum = 0;
        for (int i = maxcoin; i < coins.length; i++) {
            if (money - coins[i] == 0) {
                sum += 1;
            } else if (money - coins[i] > 0) {
                sum += findPoss(money - coins[i], i);
            }
        }

        memo[money][maxcoin] = sum; // Cache the result
        return sum;
    }
}
