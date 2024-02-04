
// 재귀적인 패턴으로 별찍기
// 재귀를 통한 분할 정복 설계하기

/*
 *  N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 *  크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 *  ***
 *	* *
 *	***
 *  N이 3보다 클 경우, 크기 N의 패턴은 
 *  공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 
 * */

import java.util.Scanner;
import java.io.*;

public class Starring2447 {
	static char arr[][] = null;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = sc.nextInt();
		arr = new char[N][N];

		// 별찍기 함수 객체 선언
		makeStar(0, 0, N, false);

		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(arr[i][j]);
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		sc.close();
	}

	public static void makeStar(int x, int y, int N, boolean blank) {
		int size = N / 3; // 최종 별상자 -> 격자 쪼개기 시의 상자 개수
		int count = 0; // N 패턴 별 상자 생성 시 * or ' ' 찍는 개수

		if (blank) {// 별 상자에서 가운데 공백 부분을 입력해야 하는 경우
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 다섯 번째 count 도달 시 공백 입력
					makeStar(i, j, size, true);
				} else {
					makeStar(i, j, size, false);
				}
			}
		}
	}

}
