

import java.util.Scanner;

/*
 * - 숫자의 합 - 
 * 
 * <예시>
 * 5
 * 54321
 * 결과 : 15
 */

public class Sum_of_Numbers11720 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		
		int sum = 0;
		for (int i = 0;i < N;i++) {
			sum += cNum[i] - '0'; // cNum 배열의 값들을 정수형으로 바꿔주면서 sum에 더해줄 수 있는 간단한 방법임.
		}
		System.out.println(sum);
		sc.close();
	}
}
