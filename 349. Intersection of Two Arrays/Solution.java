import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int[] intersection(int[] nums1, int[] nums2) {

		if ( nums1.length > nums2.length ) {
			return intersection(nums2, nums1);
		}

		Set<Integer> set = new HashSet<>();
		Arrays.stream(nums2).forEach(num -> set.add(num));

		Set<Integer> intersection = new HashSet<>();

		for ( int i = 0; i < nums1.length; i++ ) {
			if ( set.contains(nums1[i]) ) {
				set.remove(nums1[i]);
				intersection.add(nums1[i]);
			}
		}

		return intersection.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] num1 = {1, 2, 2, 1};
		int[] num2 = {2, 2};

		int[] ans = solution.intersection(num1, num2);
	}
}
