import java.util.Map;
import java.util.TreeMap;

public class Solution {

	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

		Map<Integer, Integer> map = new TreeMap<>();

		for ( int i = 0; i < nums1.length; i++ ) {
			map.putIfAbsent( nums1[i][0], nums1[i][1] );
		}

		for ( int i = 0; i < nums2.length; i++ ) {
			if ( map.containsKey(nums2[i][0]) ) {
				map.put( nums2[i][0], map.get(nums2[i][0]) + nums2[i][1]);
			} else {
				map.put( nums2[i][0], nums2[i][1] );
			}
		}

		int[][] nums = new int[map.size()][2];

		int i = 0;

		for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
			nums[i][0] = entry.getKey();
			nums[i][1] = entry.getValue();
			i++;
		}

		return nums;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
		int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
		s.mergeArrays(nums1, nums2);
	}
}
