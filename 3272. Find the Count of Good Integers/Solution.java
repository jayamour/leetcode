import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	long ans = 0;

	public long countGoodIntegers(int n, int k) {

		long[] fact = new long[11];
		fact[0] = 1;

		for ( int i = 1; i <= 10; i++ ) {
			fact[i] = fact[i - 1] * i;
		}

		Set<String> seen = new HashSet<>();
		StringBuilder leftHalf = new StringBuilder();
		int L = n / 2;

		generateHalf(0, L, leftHalf, n, k, seen ,fact);

		return ans;
	}

	private void generateHalf(int idx, int L, StringBuilder leftHalf, int n, int k, Set<String> seen, long[] fact) {
		if ( idx == L ) {
			String left = leftHalf.toString();
			String rev = new StringBuilder(left).reverse().toString();

			//	짝수 자릿
			if ( n % 2 == 0 ) {

				String palidromeStr = left + rev;
				processPalindrome(palidromeStr, n, k, seen, fact);
				
			} else {

				for ( int mid = 0; mid <= 9; mid++ ) {
					String palidromeStr = left + mid + rev;
//					System.out.println("test1");
					processPalindrome(palidromeStr, n, k, seen, fact);
				}
			}

			return;
		}

		//	first digit: 1 ~ 9
		//	others: 0 ~ 9
		int start = (idx == 0) ? 1 : 0;

		for ( int x = start; x <= 9; x++ ) {
			leftHalf.append(x);
			generateHalf(idx + 1, L, leftHalf, n, k, seen, fact);
			leftHalf.deleteCharAt(leftHalf.length() - 1);
		}
	}

	private void processPalindrome(String palStr, int n, int k, Set<String> seen, long[] fact) {
		long palNum = Long.parseLong(palStr);
		if ( palNum % k != 0 ) return;

		//	자릿수 빈도 계산
		int[] freq = new int[10];
		for ( char c : palStr.toCharArray() ) {
			freq[c - '0']++;
		}

		StringBuilder keyBuilder = new StringBuilder();
		for ( int f : freq ) {
			keyBuilder.append(f).append("-");
		}

		String key = keyBuilder.toString();

		if ( seen.contains(key) ) return;
		seen.add(key);

		long count = computePermutations(freq, fact, n);
		ans += count;
	}

	private long computePermutations(int[] freq, long[] fact, int n) {

		long total = fact[n];
		for ( int i = 0; i < 10; i++ ) {
			if ( freq[i] != 0 ) {
				total /= fact[freq[i]];
			}
		}

		long invalid = 0L;

		//	자릿수 중 0이 한 번 이상 등장하는 경우
		if ( freq[0] > 0 ) {
			//	첫 자리가 0인 경우: 하나를 사용한 후 나머지를 순열로 배열
			//	첫 자리를 0으로 고정
			//	나머지 자릿수: n - 1
			invalid = fact[n - 1];

			for ( int i = 0; i < 10; i++ ) {
				if ( i == 0 ) {
					//	첫 자리를 0으로 사용했으므로 0의 사용 횟수 1 감소
					invalid /= fact[freq[0] - 1];
				} else {
					invalid /= fact[freq[i]];
				}
			}
		}

		return total - invalid;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countGoodIntegers(3, 5));
	}
}
