

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNAPassword12891 {
	
	static int checkArr[]; // 비밀번호 체크 배열
	static int myArr[]; // 현재 상태 배열
	static int checkSecret; // 몇개의 문자 관련 개수를 충족했는지를 판단

	public static void main(String[] args) throws IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // S 배열 크기(= 문자열 크기)
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 크기
		int result = 0;
		
		char A[] = new char[S]; // 문자열 데이터
		checkArr = new int[4]; // 비밀번호 체크 배열
		myArr = new int[4]; // 현재 상태 배열
		
		

	}

}
