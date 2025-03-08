public class Solution {

	public int[] sort(int[] arr) {

		int [] res = new int[arr.length];

		split(arr, 0, arr.length - 1, res);

		return arr;
	}

	public void split(int[] arr, int start, int end, int[] res) {

		if ( start >= end ) {
			return;
		}

		int mid = (start + end) / 2;

		System.out.println("1st => " + start + " : " + mid + " : " + end);

		split(arr, start, mid, res);
		System.out.println("2nd => " + start + " : " + mid + " : " + end);
		split(arr, mid + 1, end, res);
		System.out.println("    " + start + " : " + mid + " : " + end);
		merge(arr, start, mid, end, res);
	}

	private void merge(int[] arr, int start, int mid, int end, int[] res) {

		int k = start, i = start, j = mid + 1;

		System.out.println(" ==> k: " + k + ", i: " + i + ", j: " + j);

		//	0  1  2  3  4  5
		//	8, 1, 4, 3, 2, 4
		while ( i <= mid && j <= end ) {

			//		8	< 1
			System.out.println(arr[i] + " vs " + arr[j]);
			if ( arr[i] < arr[j] ) {
				res[k++] = arr[i++];
			} else {
				res[k++] = arr[j++];
			}
		}

		System.out.println("i: " + i + ", mid: " + mid);

		while ( i <= mid ) {
			System.out.println("  " + arr[i]);
			res[k++] = arr[i++];
		}

		System.out.println("j: " + j + ", end: " + end);
		while ( j <= end ) {
			res[k++] = arr[j++];
		}

		for ( i = start; i <= end; i++ ) {
			arr[i] = res[i];
		}

		System.out.println("============");
		for ( int x = 0; x < res.length; x++ ) {
			System.out.print(res[x] + " ");
		}
		System.out.println("\n============");

	}


	public static void main(String[] args) {

		int[] arr = {8, 1, 4, 3, 2, 4};

		Solution s = new Solution();
		int[] res = s.sort(arr);

		for ( int i : res ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
