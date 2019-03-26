package epam;
/**
 CuttingRods problem
 * @author Priyanka Desamsetty
 *
 */
import java.util.*;

public class Cuttingrods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.println(find(n));

		}
sc.close();
	}

	static int find(int n) {
		int ans = 0;
		int temp = 3;

		while (temp <= n) {
			ans++;
			temp = temp * 2 + 1;
		}
		return ans;

	}

}
