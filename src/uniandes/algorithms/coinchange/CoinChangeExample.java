package uniandes.algorithms.coinchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main class for the coin change problem.
 * 
 * @author Jorge Duitama
 *
 */
public class CoinChangeExample {

	/**
	 * Main method for the coin change example. It requires three parameters:
	 * args[0]: Algorithm to run. It can be Greedy, Recursive or DynamicProgramming
	 * args[1]: Total value to break in coins args[2]: Comma-separated list of
	 * denominations
	 * 
	 * @param args Array with the arguments described above throws Exception If any
	 *             denomination appears twice
	 * @throws Exception If the algorithm class can not be loaded
	 */
	public static void main(String[] args) throws Exception {

		// Load algorithm class
		String algorithmClassName = CoinChangeExample.class.getPackage().getName() + "." + args[0]
				+ "CoinChangeAlgorithm";
		CoinChangeAlgorithm calculator = (CoinChangeAlgorithm) Class.forName(algorithmClassName).newInstance();
		// Load input data
		int totalValue = Integer.parseInt(args[1]);
		String[] strDenominations = args[2].split(",");
		List<Integer> denominationsList = new ArrayList<>();
		for (int i = 0; i < strDenominations.length; i++)
			denominationsList.add(Integer.parseInt(strDenominations[i]));
		Collections.sort(denominationsList);
		// Add denomination 1 if not present
		if (denominationsList.get(0) != 1)
			denominationsList.add(0, 1);
		int[] denominations = new int[denominationsList.size()];
		for (int i = 0; i < denominations.length; i++) {
			if (i < denominations.length - 1 && denominationsList.get(i) == denominationsList.get(i + 1))
				throw new Exception("All denominations must be different. Denomination " + denominationsList.get(i)
						+ " appears twice");
			denominations[i] = denominationsList.get(i);
		}

		// Run the coin change algorithm
		long startTime = System.currentTimeMillis();
		int[] numCoins = calculator.calculateOptimalChange(totalValue, denominations);
		long endTime = System.currentTimeMillis();

		// Output results
		int calculatedTotal = 0;
		int totalCoins = 0;
		System.out.println("Coin\tNumber");
		for (int i = 0; i < numCoins.length; i++) {
			System.out.println("" + denominations[i] + "\t" + numCoins[i]);
			calculatedTotal += denominations[i] * numCoins[i];
			totalCoins += numCoins[i];
		}
		System.out.println("Total coins:\t" + totalCoins);
		System.out.println("Total value:\t" + calculatedTotal);
		System.out.println("Total time spent (milliseconds): " + (endTime - startTime));
		if (calculatedTotal != totalValue)
			throw new RuntimeException("ERROR: The total of the solution: " + calculatedTotal
					+ " does not coincide with the expected total: " + totalValue);
	}
}
