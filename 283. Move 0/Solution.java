public class Solution {

	public void moveZeroes(int[] nums) {

		if ( nums.length == 1 ) {
			System.out.println(nums[0]);
		}

		int i = 0, j = 1;

		for ( int x = 0; x < nums.length; x++ ) {

			if ( 0 == nums[x] ) {
				i = x;
				j = x + 1;
				break;
			}
		}

		int temp;

		while ( j < nums.length ) {

			if ( nums[i] == 0 && nums[j] != 0 ) {
				temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
			}

			j++;
		}

		print(nums);
	}

	public void print(int[] arr) {

		for ( int i = 0; i < arr.length; i++ ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int [] nums = {0,1,0,3,12};
		Solution s = new Solution();
		s.moveZeroes(nums);
	}
}
