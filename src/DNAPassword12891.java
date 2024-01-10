

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * - DNA 비밀번호 -
 * : 비밀번호 유효성 검사 (슬라이딩 윈도우 알고리즘) 
 * -> 2개의 포인터로 배열의 특정 범위를 지정했을 때, 다음 범위(window)를 유지한 채로 이동(sliding)하며 처리하는 것
 * 
 * <예시>
 * 9 8 // DNA 문자열 길이, 부분 문자열(비교 문자열) 길이
 * CCTGGATTG // DNA 문자열
 * 2 0 1 1 // 비교 문자열에 포함되어야 할 {A, C, G, T} 문자들의 최소 개수
 * 결과 : 0
 * */

public class DNAPassword12891 {

	static int checkArr[]; // 비밀번호 체크 배열
	static int myArr[]; // 현재 상태 배열
	static int checkSecret; // 비밀번호 유효성 체크 개수(4)

	public static void main(String[] args) throws IOException {

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buf.readLine());

		int S = Integer.parseInt(st.nextToken()); // S 배열 크기(= 문자열 크기)
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 크기
		int result = 0;
		checkSecret = 0;

		char A[] = new char[S]; // 문자열 데이터
		checkArr = new int[4]; 
		myArr = new int[4]; 

		A = buf.readLine().toCharArray();
		st = new StringTokenizer(buf.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			// 부분 문자열에 포함돼야 할 해당 문자열의 최소 개수가 0이라면
			// 해당 문자열은 비밀번호 유효성 검사를 할 필요가 없다는 것을 의미하기 때문에 +1 해줌
			if (checkArr[i] == 0)
				checkSecret++;
		}
		for (int i = 0; i < P; i++) { // 맨 처음 부분 문자열 셋팅
			Add(A[i]); 
		}
		
		if(checkSecret == 4) {
			result++;
		}
		
		for(int i = P;i < S;i++) { // 슬라이딩 윈도우 처리
			int j = i - P; // 양끝 투 포인터(j, i)의 범위를 유지하면서 처리할 수 있게 됨
			// 슬라이딩 윈도우를 해서 넘어온 n+1번째 부분 문자열 범위에서, 
			// 이미 처음 부분 문자열 셋팅 과정에서 했던 내용은 해줄 필요 없이 
			// 추가된 부분 밀번호 유효성 검사를 더욱 효율적으로 할 수 있게 됨. 
			// 따라서 A[i]문자열만 처리해준다면 비번째 내용만 Add 함수에 넣어줌.
			Add(A[i]); 
			// n번째 비교에서 n+1번째 비교로 넘어갈 때, 해당 부분 문자열에 해당하지 않는 
			// 바로 전의 문자(A[j])열 값을 Remove해주는 과정이 필요함
			Remove(A[j]); 
			if (checkSecret == 4) result++;
		}
		System.out.println(result);
		buf.close();

	}

	static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0])
				checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3])
				checkSecret++;
			break;
		}
	}
	
	static void Remove(char c) {
		switch (c) {
		case 'A':
			if (myArr[0] == checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}
	}

}
