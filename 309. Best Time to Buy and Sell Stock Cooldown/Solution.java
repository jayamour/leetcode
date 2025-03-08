public class Solution {

	public int maxProfit(int[] prices) {

		if ( prices == null || prices.length <= 1 ) {
			return 0;
		}

		int buy = - prices[0];
		int buy1 = buy;

		int sell2 = 0, sell1 = 0, sell = 0;

		for ( int i = 1; i < prices.length; i++ ) {
			buy = Math.max(buy1, sell2 - prices[i]);
			sell = Math.max(sell1, buy1 + prices[i]);
			buy1 = buy;
			sell2 = sell1;
			sell1 = sell;
		}

		return sell1;
	}

	public static void main(String[] args) {

		int[] prices = {1,2,3,0,2};

		Solution s = new Solution();
		System.out.println(s.maxProfit(prices));
	}
}
