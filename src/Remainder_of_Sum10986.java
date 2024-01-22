

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * - 나머지 합 -
 * 
 * <예시>
 * 5 3
 * 1 2 3 1 2
 * 결과 : 7
 * */

/*
 * 나머지 합 구하는 방법(result)
 * (연속된 부분의 합 = 구간 합이 M으로 나누어 떨어지는 (i,j)쌍의 개수를 구하는 것)
 * 1. 나머지가 0으로 나누어 떨어지는 경우의 수를 구하여 result에 더하기
 * 2. 나머지가 0인 경우 + 그 외의 0이 아닌 다른 나머지로 떨어지는 경우의 수를 각각 구하기
 * 3. 2에서 구한 개수들을 가지고 각각 수열의 특정 개수만큼 뽑기 공식을 사용해 수열 뽑기 경우의 수를 구한 다음, 그 값들을 result에 더하기
 *
 * <예시>
 * 5 3
 * 1 2 3 1 2
 * 결과 : 7
 *
 */

public class Remainder_of_Sum10986 {

	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수열의 개수
		int M = Integer.parseInt(st.nextToken()); // 나누어떨어저야 하는 수

		long[] S = new long[N]; // 합 배열
		long[] C = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열
		long answer = 0; // M으로 나누어떨어지는 경우의 수

		st = new StringTokenizer(buf.readLine());
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M); // % 연산으로 나머지 값 구하기
			// %M 연산을 했을 때 값이 0이라면 이미 원본 배열의 구간 합이 M으로 나누어 떨어지는 수라는 것이기 때문에,
			// 1. 원소 값이 0인 경우의 개수를 세어서 answer에 더해준다.
			if (remainder == 0)
				answer++;
			C[remainder]++;
			// ex) C[0] = 3, C[1] = 1 -> 2. 나머지 값이 0인 인덱스 개수 카운팅 : 3 / 나머지 값이 1인 인덱스 개수 카운팅: 1
		}

		for (int i = 0; i < M; i++) {
			// 나머지 값이 같은, 즉 원소 값이 같은 인덱스의 개수를 C배열에 담았으니,
			// 이제 해당 원소값들 중에서 각각 2개씩만 뽑는 모든 경우의 수를 구해줘야 한다.

			// ex) C[0] = 3, C[1] = 2 -> 나머지가 0인 경우 3번, 1인 경우 2번으로 개수가 카운트 됨.
			// -> 0 3개, 1 2개에서 0과 1의 경우에서 모두 각각 2개씩 뽑는 거임. -> 수열 - 구성 개념
			// -> 그러므로 3C2, 2C2 -> (3*2 / 2*1) , (2*1 / 2*1)

			// * 3. 수열 특정 개수(K)만큼 뽑기 공식 : (A[i] * A[i-1]) / K
			if(C[i] > 1) 
				answer += (C[i] * (C[i] - 1) / 2);
		}
		System.out.println(answer);
		buf.close();
	}

}
