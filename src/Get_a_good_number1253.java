

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * - 좋은 수 구하기 -
 * : n개의 수에서 다른 두 수들의 합으로 표현될 수 있는 수라면 그 수를 '좋은 수'라고 하기로 했을 때, 좋은 수의 개수 구하기
 * 
 * <예시>
 * 10 // 수의 개수
 * 1 2 3 4 5 6 7 8 9 10
 * 결과 : 8
 * */

public class Get_a_good_number1253 {

	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buf.readLine());
		int count = 0;
		long[] A = new long[N];
		StringTokenizer st = new StringTokenizer(buf.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(A);
		buf.close();

		for (int k = 0; k < N; k++) {
			int i = 0;
			int j = N - 1;
			long find = A[k];

			while (i < j) {
				if (A[i] + A[j] == find) {
					if (i != k && j != k) {
						count++;
						break;
					} else if (i == k)
						i++;
					else if (j == k)
						j--;
				} else if (A[i] + A[j] < find)
					i++;
				else
					j--;
			}
		}
		System.out.println(count);

	}

}
