import java.util.*;

public class Solution {

	static class Node {

		int to;
		long time;

		Node(int to, long time) {
			this.to = to;
			this.time = time;
		}
	}

	static int MOD = (int) 1e9 + 7;
	static Map<Integer, List<Node>> graph;

	public int countPaths(int n, int[][] roads) {

		graph = new HashMap<>();

		for ( int[] r : roads ) {
			int from = r[0];
			int to = r[1];
			int time = r[2];

			graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to, time));
			graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Node(from, time));
		}

		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);

		int[] ways = new int[n];

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
		pq.add(new Node(0, 0));

		dist[0] = 0;
		ways[0] = 1;

		while ( !pq.isEmpty() ) {

			Node cur = pq.poll();

			int here = cur.to;
			long time = cur.time;

			if ( time > dist[here] ) {
				continue;
			}

			for ( Node next : graph.getOrDefault(here, new ArrayList<>()) ) {

				int to = next.to;
				long nextTime = time + next.time;

				if ( nextTime < dist[to] ) {
					dist[to] = nextTime;
					ways[to] = ways[here];
					pq.add(new Node(to, nextTime));
				} else if ( nextTime == dist[to] ) {
					ways[to] = ( ways[here] + ways[to] ) % MOD;
				}
			}
		}

		return ways[n - 1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int n = 7;
		int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};

		System.out.println(s.countPaths(n, roads));
	}
}
