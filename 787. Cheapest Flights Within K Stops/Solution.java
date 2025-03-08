import java.util.*;

public class Solution {

	static class Node {
		int cost;
		int city;
		int stops;

		public Node(int cost, int city, int stops) {
			this.cost = cost;
			this.city = city;
			this.stops = stops;
		}

		@Override
		public String toString() {
			return "cost: " + cost + "\tcity: " + city + ", " + stops;
		}
	}

	Map<Integer, List<int[]>> graph = new HashMap<>();
	int K;

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		K = k;

		// 그래프 생성
		for ( int[] flight : flights ) {
			int from = flight[0];
			int to = flight[1];
			int cost = flight[2];
			graph.computeIfAbsent(from, v -> new ArrayList<>()).add(new int[]{to, cost});
		}

		// visited[city][stops]: city에 stops번 비행으로 도달한 최소 비용
		int[][] visited = new int[n][K + 2]; // stops가 0부터 K+1까지
		for ( int i = 0; i < n; i++ ) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
		pq.add(new Node(0, src, 0)); // 시작: 비용 0, 출발지, 비행 0
		visited[src][0] = 0;

		int ans = Integer.MAX_VALUE;

		while ( !pq.isEmpty() ) {
			Node node = pq.poll();
			int cost = node.cost;
			int city = node.city;
			int stops = node.stops;

			// 목적지에 도달하면 최소 비용 갱신
			if ( city == dst ) {
				ans = Math.min(ans, cost);
				continue;
			}

			// 비행 횟수가 K+1을 초과하면 스킵
			if ( stops > K + 1 ) {
				continue;
			}

			// 이미 더 낮은 비용으로 방문한 경우 스킵
			if ( visited[city][stops] < cost ) {
				continue;
			}

			// 다음 도시 탐색
			if ( graph.containsKey(city) ) {
				for ( int[] neighbor : graph.get(city) ) {
					int nextCity = neighbor[0];
					int nextCost = neighbor[1];
					int newCost = cost + nextCost;
					int newStops = stops + 1; // 비행 횟수 증가

					if ( (newStops <= (K + 1)) && newCost < visited[nextCity][newStops] ) {
						visited[nextCity][newStops] = newCost;
						pq.add(new Node(newCost, nextCity, newStops));
					}
				}
			}
		}

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 4;
		int[][] f = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
		int src = 0;
		int dst = 3;
		int k = 1;
		System.out.println(s.findCheapestPrice(n, f, src, dst, k)); // 출력: 6
	}
}