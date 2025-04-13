public class Solution {

	static int evenIdx = 5;
	static int oddIdx = 4;
	static final long MOD = (int) (1e9 + 7);

	public int countGoodNumbers(long n) {

		if ( n == 1 ) return evenIdx;

		long evenCount = (n + 1) / 2;
		long oddCount = n / 2;

		long evenPart = modPow(evenIdx, evenCount);
		long oddPart = modPow(oddIdx, oddCount);

		long res = (evenPart * oddPart) % MOD;

		return (int) res;
	}

	private long modPow(long base, long exp) {
		long res = 1;

		/**
		 * 2^10
		 * 10 % 2 == 0
		 * 2^10 = ((2)^2)^5
		 * = ( 2 * 2 )^5
		 * 5 % 2 == 1
		 * ( 2 * 2 ) * ( 2 * 2 )^4
		 * => res = (res * 4)
		 * ( 2 * 2 )^4 = (( 2 * 2 )^2)^2
		 * = 16^2
		 * = 16 * 16 = 256
		 * => 256^1
		 * => res = 4 * 256 = 1024
		 */

		while ( exp > 0 ) {
			if ( (exp & 1) == 1 ) {
				//	exp가 홀수
				res = (res * base) % MOD;
			}
			base = (base * base) % MOD;
			exp >>= 1;	//	 exp = exp / 2;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countGoodNumbers(50));
	}
}
