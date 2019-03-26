package epam;
/**
 * Glowingbulbs
 * @author Priyanka Desamsetty
 *
 */
import java.util.*;

public class Glowingbulbs {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();

		while (T-- > 0) {
			sc.nextLine();
			String input = sc.nextLine();

			long k = sc.nextLong();
			long result = findthesolution(k, input);
			System.out.println(result);
		}
		sc.close();
	}

	public static long findthesolution(long k, String input) {
		ArrayList<Integer> switches = new ArrayList<>();
	
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '1') {

				switches.add(i + 1);
			}
		}
		long res = 0;
		long low = 1;
		long high = 1000000000000000L;
		long mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (getMultiples(mid, switches) >= k) {
				res = mid;
				high = mid - 1;

			} else
				low = mid + 1;
		}

		return res;

	}

	public static long getMultiples(long mid, ArrayList<Integer> switches) {
		long ans = 0;
		for (long i = 1; i < (1 << switches.size()); i++) {
			long t = 1;
			long sign = -1;
			for (int j = 0; j < switches.size(); j++) {
				if (((i >> j) & 1) == 1) {
					t *= switches.get(j);
					sign *= -1;
				}
			}

			ans += (mid / t) * sign;
		}
		return ans;
	}
}
