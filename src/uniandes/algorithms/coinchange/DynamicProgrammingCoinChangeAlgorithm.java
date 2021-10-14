package uniandes.algorithms.coinchange;

import java.util.HashMap;

public class DynamicProgrammingCoinChangeAlgorithm implements CoinChangeAlgorithm {

    public int[] calculateOptimalChange(int totalValue, int[] denominations) {
        HashMap<Integer, int[]> solutions = new HashMap<>();
        return calculateOptimalRecur(totalValue, denominations, solutions);
    }

    private int[] calculateOptimalRecur(int value, int[] denominations, HashMap<Integer, int[]> solutions) {
        if (solutions.containsKey(value)) {
            return solutions.get(value);
        }
        int[] sol = new int[denominations.length];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = 0;
        }
        for (int i = 0; i < sol.length; i++) {
            if (denominations[i] <= value) {
                int[] temp = calculateOptimalRecur(value - denominations[i], denominations, solutions).clone();
                temp[i]++;
                if (sum(temp) < sum(sol) || sum(sol) == 0) {
                    sol = temp;
                }
            }
        }
        solutions.put(value, sol);
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
