
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * - 구간 합 -
 * 
 * <예시>
 * 5 3 (5개 데이터 입력, 질문 3번)
 * 5 4 3 2 1
 * 1 3 (1부터 3번째까지의 배열의 구간 합)
 * 2 4
 * 5 5
 * 결과 : 12, 9, 1
 * */

public class Interval_Sum11659 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strToken = new StringTokenizer(buf.readLine());
		
		int numNo = Integer.parseInt(strToken.nextToken()); // 숫자 개수
		int quizNo = Integer.parseInt(strToken.nextToken()); // 질문 개수
		
		long[] S = new long[numNo + 1]; // 구간합 배열
		strToken = new StringTokenizer(buf.readLine()); // 숫자, 질문 개수 값 받아오기 과정이 끝났음 -> 토큰 초기화 작업 해주기
		
		for (int i = 1;i <= numNo;i++) {
			S[i] = S[i-1] + Integer.parseInt(strToken.nextToken());
		}
		
		for (int a = 0;a < quizNo; a++) {
			strToken = new StringTokenizer(buf.readLine()); // 질문들 또한 토큰으로 받아올거기 때문에 반복문 안에 토큰 비워내기 작업 넣어주기
			int i = Integer.parseInt(strToken.nextToken());
			int j = Integer.parseInt(strToken.nextToken());
			System.out.println(S[j] - S[i - 1]); 
		}
	}

}