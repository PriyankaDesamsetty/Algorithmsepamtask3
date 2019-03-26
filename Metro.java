package epam;
/**
 * Metro
 * @author Priyanka Desamsetty
 *
 */
import java.util.*;

public class Metro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfStations = sc.nextInt();
		int noOfSubWays = sc.nextInt();
		ArrayList<path> adj[] = new ArrayList[noOfStations];
		for (int i = 0; i < noOfStations; i++)
			adj[i] = new ArrayList<path>();

		for (int i = 0; i < noOfSubWays; i++) {

			long max = 0;
			int subStations = sc.nextInt();
			long max_time = sc.nextLong();
			int ar[] = new int[subStations];
			for (int j = 0; j < subStations; j++)
				ar[j] = sc.nextInt() - 1;
			max = max_time;
			for (int j = 1; j < subStations; j++) {
				long cur_time = sc.nextLong();
				adj[ar[j - 1]].add(new path(ar[j], cur_time, max));
				max += cur_time;

			}

		}

		int start = sc.nextInt() - 1;
		int end = sc.nextInt() - 1;
		System.out.println(solve(adj, start, end, noOfStations, noOfSubWays));

		sc.close();
	}

	static long solve(ArrayList<path> adj[], int start, int end, int n, int m) {
		long mintimetoreach[] = new long[n];
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return Long.compare(mintimetoreach[a], mintimetoreach[b]);
			}
		});

		Arrays.fill(mintimetoreach, Long.MAX_VALUE);
		mintimetoreach[start] = 0;
		p.add(start);
		while (!p.isEmpty()) {
			int out = p.poll();

			for (path edge : adj[out]) {
				int d = edge.dest;

				if (mintimetoreach[d] > mintimetoreach[out] + edge.time && mintimetoreach[out] <= edge.max_time) {
					mintimetoreach[d] = mintimetoreach[out] + edge.time;
					p.add(d);
				}
			}

		}
		if (mintimetoreach[end] != Long.MAX_VALUE)
			return mintimetoreach[end];
		else
			return -1;
	}

	static class path {
		int dest;
		long time;
		long max_time;

		path(int dest, long time, long max_time) {
			this.dest = dest;
			this.time = time;
			this.max_time = max_time;
		}

	}

}
