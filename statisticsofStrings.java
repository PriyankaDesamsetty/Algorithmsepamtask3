package epam;

/*
 * Statistics of Strings 

 */
import java.util.*;

public class statisticsofStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, a, m));
	}

	static int solve(int n, int a, int m) {
		d = new int[n];
		int s = 0;
		for (int k = 1; k < n; k++)
			for (int v = 2; v < 1 << n - k + 1; v += 2)
				s = (s + solveutil(k, v, n, a, m)) % m;
		return s;
	}

	static int solveutil(int k, int v, int n, int a, int m) {
		Arrays.fill(d, -1);
		int bcnt = 0, cnt = n;
		for (int i = 1; i < n; i++)
			if ((v & 1 << i) > 0) {
				for (int j = i; j < i + k; j++)
					if (combine(j, j - i))
						cnt--;
				bcnt++;
			}
		int sum = pow(a, cnt, m);
		return bcnt % 2 == 1 ? sum : (m - sum) % m;
	}

	static int pow(int a, int b, int m) {
		if (b == 0)
			return 1;
		int p = pow(a, b / 2, m);
		p = (int) ((long) p * p % m);
		if (b % 2 == 1)
			p = (int) ((long) p * a % m);
		return p;
	}

	static int[] d;

	static int find(int i) {
		return d[i] < 0 ? i : (d[i] = find(d[i]));
	}

	static boolean combine(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (d[i] > d[j])
			d[i] = j;
		else {
			if (d[i] == d[j])
				d[i]--;
			d[j] = i;
		}
		return true;
	}
}
