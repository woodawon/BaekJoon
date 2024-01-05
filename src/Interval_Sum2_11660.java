

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * - 구간 합2 -
 * 
 * <예시>
 * 4 3 (2차원 배열 크기, 질문 개수)
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 4 5 6 7
 * 2 2 3 4 (구간 합 (x1, y1), (x2, y2)에 대한 1번째 질문)
 * 3 4 3 4 (구간 합 (x1, y1), (x2, y2)에 대한 2번째 질문)
 * 1 1 4 4 (구간 합 (x1, y1), (x2, y2)에 대한 3번째 질문)
 * */

public class Interval_Sum2_11660 {

	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 2차원 배열 크기
		int M = Integer.parseInt(st.nextToken()); // 질문 개수
		
		int O[][] = new int[N+1][N+1]; // 원본 배열
		for(int i = 1;i <= N;i++) {
			st = new StringTokenizer(buf.readLine());
			for(int j = 1;j <= N;j++) {
				O[i][j] = Integer.parseInt(st.nextToken()); // 원본 배열 값 입력
			}
		}
		
		int D[][] = new int[N+1][N+1]; // 구간 합 배열
		for (int i = 1;i <= N;i++) {
			for(int j = 1;j <= N;j++)  {
				D[i][j] = D[i][j-1] + D[i-1][j] -D[i-1][j-1] + O[i][j]; // 구간 합 배열 생성해주기(구간 합 공식 적용)
			}
		}
		
		for(int i = 0;i < M;i++) {
			st = new StringTokenizer(buf.readLine());
			// (x1, y1) ~ (x2, y2) 까지인 범위의 2차원 배열의 구간 합 
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]; // 구간 합 질의 응답(2차원 구간 합 배열 질의 응답 공식 적용)
			System.out.println(result);
		}
		
	}

}
