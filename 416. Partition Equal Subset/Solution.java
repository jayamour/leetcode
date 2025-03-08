public class Solution {

	public boolean canPartition(int[] nums) {

		int sum = 0;

		for ( int i : nums ) {
			sum += i;
		}

		if ( (sum % 2) == 1 ) {
			return false;
		}

		int target = sum / 2;

		boolean [] dp = new boolean[target + 1];
		dp[0] = true;

		for ( int i = 0; i < nums.length; i++ ) {

			System.out.println("nums[" + i + "]: " + nums[i]);
			if ( nums[i] > target ) {
				return false;
			}

			for ( int j = target; j >= nums[i]; j-- ) {
				System.out.println("j: " + j);
//				printArr(dp);
				dp[j] = dp[j] || dp[j - nums[i]];
				if ( dp[target] ) {
					return true;
				}
//				printArr(dp);
			}
		}

		return dp[target];
	}

	public void printArr(boolean[] arr) {
		for ( boolean i : arr ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public boolean canPartition2(int[] nums) {

		boolean answer = false;

//		int n = nums.length;

		//	00001
		//	10000

		//	1111
		//	0000
		int all = (1<< nums.length) - 1;
//		System.out.println("all = " + all);
//		System.out.println("~all = " + ~all);

		int subset = 0;
		int subsetSum = 0;

		int b = 0;
		int bSum = 0;

		String str = "";

		for ( int i = 0; i < (1<< nums.length); i++ ) {

			subset = 0;
			subsetSum = 0;
			bSum = 0;

			for ( int j = 0; j < nums.length; j++ ) {

				//	0000
				//	0001
				//	0010
				//	0011
				if ( (i & (1<<j)) != 0 ) {
//					System.out.print(nums[j] + " ");
					subsetSum += nums[j];
					subset = subset | (1<<j);
				}
			}

			b = all & (~subset);

//			System.out.println("subsetSum = " + subsetSum);
//			System.out.println("subset = " + subset + ", binaryStr: " + Integer.toBinaryString(subset));
//			System.out.println("all & (~subset): " + Integer.toBinaryString(b));
//			System.out.println("b = " + b);

			str = Integer.toBinaryString(b);


			if ( Integer.toBinaryString(subset).length() != str.length() ) {

				int cnt = Integer.toBinaryString(subset).length() - str.length();

				for ( int z = 0; z < cnt; z++ ) {
					str = "0" + str;
				}
			}

			for ( int k = 0; k < str.length(); k++ ) {

				if ( str.charAt(k) == '1' ) {
//					System.out.print(nums[nums.length - 1 - k] + " ");
					bSum += nums[nums.length - 1 - k];
				}
			}

//			System.out.println("\nbSum = " + bSum);

			if ( subsetSum == bSum ) {
//				System.out.println("!!!!!!!");
				answer = true;
				break;
			}

//			System.out.println("\n" + i + " === partition set ===");
		}

		return answer;
	}

	public static void main(String[] args) {

		int [] nums = {1,5,11,5};
//		int [] nums = {10,10,10,10,10,10,10,10,10};

		Solution s = new Solution();
		System.out.println(s.canPartition(nums));
	}
}
