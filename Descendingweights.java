package epam;
/**
 * Bucket sort DescendingWeights
 * @author Priyanka Desamsetty
 *
 */

import java.util.*;
class Descendingweights {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = sc.nextInt();
		int result[] = new int[n];
		bucketsort(array, n, k, result);
		for (int i = 0; i < n; i++)
			System.out.println(result[i]);
sc.close();
	}

	static void bucketsort(int array[], int n, int k, int result[]) {
		ArrayList<ArrayList<Integer>> weight = new ArrayList<ArrayList<Integer>>(k);
		for (int i = 0; i < k; i++)
			weight.add(new ArrayList<Integer>());
		for (int i = 0; i < n; i++)
			weight.get(array[i]%k).add(array[i]);
		int ind = 0;
		for (int j = k - 1; j >= 0; j--) {
			Collections.sort(weight.get(j));
              for (int i = 0; i < weight.get(j).size(); i++)
				result[ind++] = weight.get(j).get(i);

		}

	}

}
