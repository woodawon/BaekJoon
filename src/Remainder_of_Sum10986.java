

import java.util.Scanner;

/*
 * - 나머지 합 -
 * 
 * <예시>
 * 5 3
 * 1 2 3 1 2
 * 결과 : 7
 * */

public class Remainder_of_Sum10986 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열의 개수
		int M = sc.nextInt(); // 나누어떨어저야 하는 수
		
		long[] S = new long[N]; // 합 배열
		long[] C = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열
		long answer = 0; // M으로 나누어떨어지는 경우의 수
		
		S[0] = sc.nextInt(); // 배열의 0번째 인덱스 값 입력
		
		for(int i = 1;i < N;i++) {
			S[i] = S[i-1] + sc.nextInt(); // 합 배열 값 생성
		}
		
		for(int i = 0;i < N;i++) {
			int remainder = (int)S[i] % M; // % 연산으로 나머지 값 구하기
			// %M 연산을 했을 때 값이 0이라면 이미 원본 배열의 구간 합이 M으로 나누어 떨어지는 수라는 것이기 때문에, 
			// 원소 값이 0인 경우의 개수를 세어서 answer에 더해준다.
			if (remainder == 0) answer++; 
			C[remainder]++; // ex) C[0] = 3, C[1] = 1  ->  나머지 값이 0인 인덱스 개수 카운팅 : 3 / 나머지 값이 1인 인덱스 개수 카운팅 : 1
		}
		
		for(int i = 0;i < M;i++) {
			// 나머지 값이 같은, 즉 원소 값이 같은 인덱스의 개수를 C배열에 담았으니, 
			// 이제 해당 원소값들 중에서 각각 2개씩만 뽑는 모든 경우의 수를 구해줘야 한다.
			answer += (C[i] * (C[i] - 1) / 2);
		}
		

	}

}
