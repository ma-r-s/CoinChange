package uniandes.algorithms.coinchange;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {

    public int[] calculateOptimalChange(int totalValue, int[] denominations) {
        int[] sol = new int[denominations.length];
        int i = denominations.length - 1;
        while (totalValue > 0) {
            while (denominations[i] > totalValue) {
                i--;
            }
            totalValue -= denominations[i];
            sol[i]++;
        }
        return sol;
    }

}
