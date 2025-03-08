import java.util.Stack;

class Rectangle {
	public int index;
	public int height;

	public Rectangle(int index, int height) {
		this.index = index;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "i: " + this.index + ", h: " + this.height;
	}
}

public class Solution {

	public int largestRectangleArea(int[] heights) {

		int maxArea = 0;

//		print(heights);

		Stack<Rectangle> stack = new Stack<>();

		Rectangle rec = new Rectangle(0, heights[0]);

		stack.push(rec);

		for ( int i = 1; i < heights.length; i++ ) {

			Rectangle temp = stack.peek();
			Rectangle newRec = new Rectangle(i, heights[i]);

			if ( temp.height <= heights[i] ) {

				stack.push(newRec);

			} else {

				int newIndex = 0;

//				System.out.println("stack.peek().index = " + stack.peek().index);
//				System.out.println("stack.peek().height = " + stack.peek().height);
//				System.out.println("heights[i] = " + heights[i]);

				//	{3, 6}:				  6 > 2
				//	{2, 5}:				  5 > 2
				while ( !stack.isEmpty() && stack.peek().height > heights[i] ) {

					Rectangle pop = stack.pop();

					newIndex = pop.index;

					//	(4 - 3) * 6;
					//	(4 - 2) * 5;
					int tempArea = (i - pop.index) * pop.height;

					if ( tempArea > maxArea ) {
						maxArea = tempArea;
					}
				}

				newRec.index = newIndex;
				stack.push(newRec);
			}
		}

//		System.out.println("stack.size() = " + stack.size());

		while ( !stack.isEmpty() ) {
			Rectangle restRec = stack.pop();
//			System.out.println("restRec = " + restRec);

			int tempArea = (heights.length - restRec.index) * restRec.height;
//			System.out.println("tempArea = " + tempArea);

			if ( tempArea > maxArea ) {
				maxArea = tempArea;
			}
		}

		// 100,000 x 10,000

		return maxArea;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		int[] h = { 2, 1, 5, 6, 2, 3 };

		System.out.println(solution.largestRectangleArea(h));

	}

	public void print(int [] heights) {

		for ( int i = 0; i < heights.length; i++ ) {
			System.out.print(heights[i] + " ");
		}
		System.out.println();
	}
}
