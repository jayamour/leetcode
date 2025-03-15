import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public boolean checkIfExist(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		for ( int i = 0; i < arr.length; i++ ) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for ( int key : map.keySet() ) {

			if ( key == 0 ) {
				if ( map.get(key) > 1 ) {
					return true;
				}
			} else {
				if ( map.containsKey(key * 2) ) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {10, 2, 5, 3};
		System.out.println(solution.checkIfExist(arr));
	}
}
