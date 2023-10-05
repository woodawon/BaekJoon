package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 구간 합 구하기 */

public class one {

	public static void main(String[] args) throws IOException {
		// throws IOException을 main함수에 붙여주는 이유 
		// : stringtokenizer를 사용하면,nextToken()을 계속 호출해 문자열을 토큰으로 분리하게 되는데,
		// 더이상 불러올 문자가 없는 경우에 nextToken()이 호출되는 경우가 발생하게 되면, nosuchelementException이
		// 발생하게 됨. 이러한 예외적인 상황을 대비해 throws IOException을 붙여줘야 함.
		
		BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringtokenizer = new StringTokenizer(bufferedreader.readLine());
		
		int suNum = Integer.parseInt(stringtokenizer.nextToken());
		int quNum = Integer.parseInt(stringtokenizer.nextToken());
		
		long[] S = new long[suNum + 1];
		stringtokenizer = new StringTokenizer(bufferedreader.readLine());
		// stringtokenizer = new ~~ 를 한 번 더 작성하는 이유
		// : strongtokenizer 객체는 사용할 때마다 양동이에 가득 찬 물을 비워내고 다시 새 물을 받아 사용하는 것처럼
		// 이전에 파싱한 토큰들을 비워내줘야 유지보수와 가독성에 좋기 때문에 새로 다시 선언해주는 것임.
		
		for(int i = 1;i <= suNum;i++) { // i ~ i+n 번째 까지의 수들의 합을 차례대로 S에 넣음 
			S[i] = S[i-1] + Integer.parseInt(stringtokenizer.nextToken());
		}
		
		for(int q = 0;q < quNum;q++) { // 몇 번째 부터 몇 번째 까지 더한 값을 출력시킬건지 값을 입력받고, 결과 출력
			stringtokenizer = new StringTokenizer(bufferedreader.readLine());
			int i = Integer.parseInt(stringtokenizer.nextToken());
			int j = Integer.parseInt(stringtokenizer.nextToken());
			System.out.println(S[j] - S[i-1]);
		}

	}

}
