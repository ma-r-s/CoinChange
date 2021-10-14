package uniandes.algorithms.coinchange;
/**
 * Common interface for algorithms solving the coin change problem
 * @author Jorge Duitama
 *
 */
public interface CoinChangeAlgorithm {

	/**
	 * Calculates the number of coins of each denomination such as the total number of coins is minimal
	 * and the total value adds to the given number
	 * PRE: The list must be sorted by denomination and the first denomination must be 1 
	 * @param totalValue Total value to give back
	 * @param denominations Possible denominations of each coin.
	 * @return int [] number of coins to give back
	 */
	public int [] calculateOptimalChange(int totalValue, int [] denominations);
}
