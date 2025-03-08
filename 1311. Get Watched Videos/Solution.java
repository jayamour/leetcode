import java.util.*;

public class Solution {

	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

		//	int[][] to List graph
		Map<Integer, List<Integer>> map = getArrayToGraph(friends);

		List<Integer> ids = new ArrayList<>();
		boolean[] visited = new boolean[friends.length];

		bfs(id, level, map, visited, ids);

		List<String> answer = new ArrayList<>();

		Map<String, Integer> count = new HashMap<>();

		answer = countVideos(ids, watchedVideos, count, answer);

		return answer;
	}

	private List<String> countVideos(List<Integer> ids, List<List<String>> watchedVideos, Map<String, Integer> count, List<String> answer) {

		for ( Integer id : ids ) {
			for ( String s : watchedVideos.get(id) ) {
				count.put(s, count.getOrDefault(s, 0) + 1);
			}
		}

		// Streams를 활용한 정렬 로직
		return count.entrySet().stream()
				.sorted((a, b) -> {
					int freqCompare = Integer.compare(a.getValue(), b.getValue()); // 빈도 기준 정렬
					if (freqCompare != 0) {
						return freqCompare;
					}
					return a.getKey().compareTo(b.getKey()); // 알파벳 기준 정렬
				})
				.map(Map.Entry::getKey) // 정렬된 키만 수집
				.toList(); // 리스트 형태로 변환

	}

	private void bfs(int id, int level, Map<Integer, List<Integer>> map, boolean[] visited, List<Integer> ids) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(id);
		visited[id] = true; // 시작 지점 방문 처리

		int step = 0;

		while ( !q.isEmpty() ) {

			if ( step == level ) {
				break;
			}

			int k = q.size();

			for ( int i = 0; i < k; i++ ) {

				int cur = q.poll();

				for ( Integer friend : map.get(cur) ) {

					if ( !visited[friend] ) {
						visited[friend] = true; // 큐에 넣기 전에 방문 처리

						q.offer(friend);
					}
				}
			}

			step++;
		}

		while ( !q.isEmpty() ) {
			ids.add(q.poll());
		}
	}

	private Map<Integer, List<Integer>> getArrayToGraph(int[][] friends) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for ( int i = 0; i < friends.length; i++ ) {
			List<Integer> list = new ArrayList<>();
			for ( int j = 0; j < friends[i].length; j++ ) {
				list.add(friends[i][j]);
			}
			map.put(i, list);
		}

		return map;
	}

	public static void main(String[] args) {

		List<List<String>> watchedVideos = new ArrayList<List<String>>();
		List<String> list1 = Arrays.asList("A", "B");
		List<String> list2 = List.of("C");
		List<String> list3 = Arrays.asList("B", "C");
		List<String> list4 = List.of("D");

		watchedVideos.add(list1);
		watchedVideos.add(list2);
		watchedVideos.add(list3);
		watchedVideos.add(list4);

		int[][] f = new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}};

		Solution s = new Solution();
		System.out.println(s.watchedVideosByFriends(watchedVideos, f, 0, 2));
	}
}
