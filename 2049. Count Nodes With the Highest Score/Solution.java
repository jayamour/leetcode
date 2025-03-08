import java.util.*;

public class Solution {
	public static long[] iterativeDFS(List<List<Integer>> tree, int n) {
		long[] subtreeSize = new long[n]; // 각 노드의 서브트리 크기 저장
		long[] score = new long[n]; // 각 노드의 점수 저장
		Deque<Integer> stack = new ArrayDeque<>(); // DFS용 스택
		Map<Integer, Long> tempProduct = new HashMap<>(); // 각 노드의 서브트리 크기 곱 저장
		Set<Integer> visited = new HashSet<>(); // 방문 체크

		// DFS 탐색을 위한 스택 초기화 (루트 노드부터 시작)
		stack.push(0);

		// **1차 DFS 탐색 (탐색 순서 저장)**
		List<Integer> order = new ArrayList<>();
		while ( !stack.isEmpty() ) {
			int node = stack.pop();
			order.add(node);
			visited.add(node);
			tempProduct.put(node, 1L); // 기본 곱 값 설정 (1)

			// 자식 노드를 스택에 넣기
			for ( int child : tree.get(node) ) {
				if ( !visited.contains(child) ) {
					stack.push(child);
				}
			}
		}

		// **2차 DFS (역순으로 서브트리 크기 계산)**
		Collections.reverse(order); // 후위 순회 방식 적용

		for ( int node : order ) {
			long prod = 1, sum = 1; // 서브트리 크기의 곱, 현재 노드 포함 크기

			for ( int child : tree.get(node) ) {
				
				long childSize = subtreeSize[child];
				prod *= childSize;
				sum += childSize;
			}

			subtreeSize[node] = sum;
			score[node] = prod * Math.max(1, n - sum); // 노드 제거 후 남은 서브트리 크기 반영
		}

		return score; // 각 노드의 점수 반환
	}

	public static int countHighestScoreNodes(int[] parents) {
		int n = parents.length;
		List<List<Integer>> tree = new ArrayList<>();
		for ( int i = 0; i < n; ++i ) tree.add(new ArrayList<>()); // 빈 리스트 초기화

		for ( int i = 1; i < n; ++i ) tree.get(parents[i]).add(i); // 부모-자식 관계 설정

		long[] scores = iterativeDFS(tree, n); // 반복문 DFS 수행
		long maxScore = Arrays.stream(scores).max().getAsLong(); // 최고 점수 찾기
		return (int) Arrays.stream(scores).filter(v -> v == maxScore).count(); // 최고 점수를 가진 노드 개수 반환
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		int[] nums = {-1, 2, 0, 2, 0};
//		int[] nums = {-1, 2, 0};

		System.out.println(s.countHighestScoreNodes(nums));
	}
}
