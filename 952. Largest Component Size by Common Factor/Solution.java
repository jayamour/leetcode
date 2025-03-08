import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	int[] parent;
	int[] rank;

	public int largestComponentSize(int[] nums) {

		int maxNum = Arrays.stream(nums).max().getAsInt();

		parent = new int[maxNum + 1];
		rank = new int[maxNum + 1];

		for ( int i = 0; i < maxNum + 1; i++ ) {
			parent[i] = i;
			rank[i] = 0;
		}

		for ( int num : nums ) {
			for ( int i = 2; i * i <= num; i++ ) {
				if ( num % i == 0 ) {
					union(num, i);
					union(num, num / i);
				}
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		int maxSize = Integer.MIN_VALUE;

		for ( int num : nums ) {
			int root = find(num);
			map.merge(root, 1, Integer::sum);
			maxSize = Math.max(maxSize, map.get(root));
		}

		return maxSize;
	}

	private void union(int p, int q) {

		int rootP = find(p);
		int rootQ = find(q);

		if ( rootP != rootQ ) {
			if ( rank[rootP] < rank[rootQ] ) {
				parent[rootP] = rootQ;
			} else if ( rank[rootQ] < rank[rootP] ) {
				parent[rootQ] = rootP;
			} else {
				parent[rootP] = rootQ;
				rank[rootQ]++;
			}
		}
	}

	private int find(int x) {
		if ( parent[x] != x ) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.largestComponentSize(new int[]{4, 6, 15, 35}));
	}
}
