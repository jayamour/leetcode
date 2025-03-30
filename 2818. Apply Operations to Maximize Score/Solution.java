import java.util.*;

class Solution {

	private final int mod = (int) 1e9 + 7;

	public int maximumScore(List<Integer> nums, int k) {

		int n = nums.size();
		int[][] primeScores = new int[n][0];

		for ( int i = 0; i < n; i++ ) {
			primeScores[i] = new int[]{i, primeFactors(nums.get(i)), nums.get(i)};
		}

		int[] left = new int[n];
		int[] right = new int[n];

		//	Monotonic stack
		Arrays.fill(left, -1);
		Arrays.fill(right, n);

		Deque<Integer> stack = new ArrayDeque<>();

		//	5, 4, 3, 5, 7, 7, 2
		for ( int[] arr : primeScores ) {
			int i = arr[0], s = arr[1];
			while ( !stack.isEmpty() && primeScores[stack.peek()][1] < s ) {
				int index = stack.pop();
				right[index] = i;
			}
			if ( !stack.isEmpty() ) {
				left[i] = stack.peek();
			}
			stack.push(i);
		}

		Arrays.sort(primeScores, (a, b) -> b[2] - a[2]);

		long ans = 1;

		for ( int[] arr : primeScores ) {

			int i = arr[0], x = arr[2];
			int l = left[i], r = right[i];

			long cnt = (long) (i - l) * (r - i);

			if ( cnt <= k ) {
				ans = ans * makePow(x, cnt) % mod;
				k -= cnt;
			} else {
				ans = ans * makePow(x, k) % mod;
				break;
			}
		}
		return (int) ans;
	}

	private int makePow(long a, long n) {

		long ans = 1;

		for ( ; n > 0; n >>= 1 ) {

			if ( (n & 1) == 1 ) {
				ans = ans * a % mod;
			}
			a = a * a % mod;
		}

		return (int) ans;
	}

	private int primeFactors(int n) {
		int i = 2;
		Set<Integer> ans = new HashSet<>();
		while ( i <= n / i ) {

			while ( n % i == 0 ) {
				ans.add(i);
				n /= i;
			}
			i++;
		}
		if ( n > 1 ) {
			ans.add(n);
		}
		return ans.size();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maximumScore(Arrays.asList(8,3,9,3,8), 2));
	}
}