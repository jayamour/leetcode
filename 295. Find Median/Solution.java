public class Solution {

	public static void main(String[] args) {

		MedianFinder obj = new MedianFinder();
		obj.addNum(11);
		obj.addNum(3);
		obj.addNum(7);
		obj.addNum(9);
		obj.addNum(1);
		obj.addNum(8);

		//	1, 3 || 4, 5, 7

		System.out.println("obj.maxHeap.size(): " + obj.maxHeap.size());

		while ( !obj.maxHeap.isEmpty() ) {
			System.out.print(obj.maxHeap.poll() + " ");
		}
		System.out.println();

		while ( !obj.minHeap.isEmpty() ) {
			System.out.print(obj.minHeap.poll() + " ");
		}
		System.out.println();

		System.out.println("obj.minHeap.size(): " + obj.minHeap.size());

		System.out.println(obj.findMedian());
	}
}
