import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	public long putMarbles(int[] weights, int k) {

		if ( k == 0 ) return 0;

		int N = weights.length;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for ( int i = 0; i < ( N - 1 ); i++ ) {
			minHeap.add(weights[i] + weights[i + 1]);
			maxHeap.add(weights[i] + weights[i + 1]);
		}

		long maxSum = 0;
		long minSum = 0;

		for ( int i = 0; i < ( k - 1 ); i++ ) {
			maxSum += maxHeap.poll();
			minSum += minHeap.poll();
		}

		return maxSum - minSum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] w = {1, 3, 5, 1};
		int k = 2;

		System.out.println(solution.putMarbles(w, k));
	}
}
