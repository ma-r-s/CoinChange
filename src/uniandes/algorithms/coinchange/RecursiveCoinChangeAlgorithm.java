package uniandes.algorithms.coinchange;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm {

    public int[] calculateOptimalChange(int totalValue, int[] denominations) {
        int[] sol = new int[denominations.length];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = 0;
        }
        for (int i = 0; i < sol.length; i++) {
            if (denominations[i] <= totalValue) {
                int[] temp = calculateOptimalChange(totalValue - denominations[i], denominations).clone();
                temp[i]++;
                if (sum(temp) < sum(sol) || sum(sol) == 0) {
                    sol = temp;
                }
            }
        }
        return sol;
    }

    private int sum(int[] temp) {
        int res = 0;
        for (int value : temp) {
            res += value;
        }
        return res;
    }
}
