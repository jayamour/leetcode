import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

	public PriorityQueue<Integer> maxHeap;
	public PriorityQueue<Integer> minHeap;

	public MedianFinder() {

		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {

		if ( maxHeap.size() == 0 && minHeap.size() == 0 ) {
			minHeap.add(num);
			return;
		}

		//				0	<	1
		if ( maxHeap.size() < minHeap.size() ) {

			maxHeap.add(num);

			if ( maxHeap.peek() > minHeap.peek() ) {
				swap();
			}
		} else {

			minHeap.add(num);

			if ( maxHeap.peek() > minHeap.peek() ) {
				swap();
			}
		}
	}

	public void swap() {

		int max = maxHeap.poll();
		int min = minHeap.poll();

		maxHeap.add(min);
		minHeap.add(max);
	}

	public double findMedian() {

		return 0.0;
	}
}
