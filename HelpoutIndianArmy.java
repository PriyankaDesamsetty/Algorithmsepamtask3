package epam;
/*
 * Help out Indian army
 */
import java.util.*;

class pair implements Comparable<pair> {
	Long s, e;

	pair(Long s, Long e) {
		this.s = s;
		this.e = e;
	}

	public int compareTo(pair o) {
		return s.compareTo(o.s);
	}
}

class HelpoutIndianArmy {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Long startpos = sc.nextLong();
		Long endpos = sc.nextLong();
		pair p[] = new pair[n];
		for (int i = 0; i < n; i++) {
			Long x = sc.nextLong();
			Long y = sc.nextLong();
			p[i] = new pair(x - y, x + y);
		}
		System.out.println(solve(p, startpos, endpos, n));
		sc.close();
	}

	static long solve(pair p[], Long startpos, Long endpos, int n) {
		Arrays.sort(p);
		Long s = p[0].s;
		Long e = p[0].e;
		ArrayList<pair> a = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (p[i].s <= e) {
				e = Math.max(p[i].e, e);
			} else {
				a.add(new pair(s, e));
				s = p[i].s;
				e = p[i].e;

			}
		}
		a.add(new pair(s, e));
		long ans = 0;
		for (int i = 0; i < a.size(); i++) {
			if (startpos >= endpos) {
				startpos = endpos;
				break;

			}
			if (startpos >= a.get(i).s && startpos <= a.get(i).e) {
				startpos = a.get(i).e;
			} else if (startpos <= a.get(i).s && endpos >= a.get(i).e) {
				ans += a.get(i).s - startpos;
				startpos = a.get(i).e;
			} else if (startpos <= a.get(i).s && endpos >= a.get(i).s && endpos <= a.get(i).e) {
				ans += a.get(i).s - startpos;
				startpos = endpos;
			}

			else if (startpos <= a.get(i).s && endpos <= a.get(i).s) {
				ans += endpos - startpos;
				startpos = endpos;
			}

		}
		if (startpos < endpos) {
			ans += endpos - startpos;
		}
		return ans;
	}
}
