

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * - 주몽의 명령 -
 * : 투 포인터 알고리즘 활용 -> 정렬 알고리즘 -> O(nlogn) 시간 복잡도 알고리즘 사용 
 * 
 * <예시>
 * 6 // 재료 개수
 * 9 // 갑옷이 될 재료 고유 번호들(2개씩)의 합 -> ex) 숫자 2개를 선택했을 때 두 숫자의 합이 9가 되는 모든 경우의 수
 * 2 7 4 1 5 3
 * 결과 : 2(count)
 * */

public class Jumon_Command1940 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buf.readLine()); // 재료의 개수
		int M = Integer.parseInt(buf.readLine()); // 갑옷이 될 고유 번호들(2개씩)의 합
		int[] A = new int[N]; // 재료 번호들 담기는 배열
		int count = 0; // 최종 경우의 수
		int i = 0; // Min 포인터
		int j = N-1; // Max 포인터
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		for(int a = 0;a < N;a++) {
			A[a] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 오름차순 정렬
		
		while(i < j) {
			if(A[i] + A[j] < M) i++;
			else if(A[i] + A[j] > M) j--;
			else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);

	}

}
