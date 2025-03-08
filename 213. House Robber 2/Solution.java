import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {

	int idx;
	int sum;

	public Node(int idx, int sum) {
		this.idx = idx;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "idx: " + this.idx + ", sum: " + this.sum;
	}
}

public class Solution {

	ArrayList<ArrayList<Integer>> nodelist;
	ArrayList<ArrayList<Integer>> list;

	Node[] nodeArr;

	public int rob(int[] nums) {

		int[] arr1 = Arrays.copyOf(nums, nums.length - 1);
		int[] arr2 = Arrays.copyOfRange(nums, 1, nums.length);

		return Math.max(Math.max(nums[0], calc(arr1)), calc(arr2));
	}

	public int calc(int[] nums) {

		int rob1 = 0, rob2 = 0;
		int temp = 0;

		for ( int i = 0; i < nums.length; i++ ) {
			temp = Math.max(rob1 + nums[i], rob2);
			rob1 = rob2;
			rob2 = temp;
		}

		return temp;
	}

	public void bfs(int start, int[] nums) {

		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();
		q.offer(start);

		int i = 1;

		while ( !q.isEmpty() ) {

			int here = q.poll();
			sb.append(here + " => ");

			for ( Integer to : list.get(here) ) {
				System.out.println("i = " + i + ", to: " + to);

				int parentNodeIdx;

				if ( i % 2 == 0 ) {
					parentNodeIdx = i/2 - 1;
				} else {
					parentNodeIdx = i/2;
				}

//				System.out.println("parentNode: " + parentNodeIdx + ", nodeArr[parentNodeIdx].sum: " + nodeArr[parentNodeIdx].sum);

//				nodeArr[i] = new Node(to, nodeArr[parentNodeIdx].sum + nums[to]);
				q.offer(to);
				i++;
			}
		}

		System.out.println(sb);
	}

	public void printGraph(ArrayList<ArrayList<Integer>> graph) {

		for ( int i = 0; i < graph.size(); i++ ) {

			if ( graph.get(i).size() > 0 ) {
				System.out.print(i + " => ");

				for (Integer k : graph.get(i)) {
					System.out.print(k + ", ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		int [] nums = {1,4,6,3,7,9,10,2,6,5};
//		int [] nums = {1,2,3,8,5,6,9,1};
//		int [] nums = {1,3,1,3,100};

		Solution s = new Solution();
		System.out.println(s.rob(nums));
	}
}
