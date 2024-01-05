import java.util.Scanner;

/*
 * - 배열 -
 * 
 * <예시>
 * 3
 * 50 60 70
 * 결과 : 60.0
 * */

public class Average1546 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		
		for(int i = 0;i < N;i++) {
			A[i] = sc.nextInt();
		}
		
		long sum = 0;
		long max = 0;
		for (int i = 0; i < N;i++) {
			if (A[i] > max) max = A[i];
			sum += A[i];
		}
		System.out.println(sum * 100.0 / max / N); // 식 : 총합 * 100 / 최고점수 / 과목 개수 = 평균값 
		sc.close();
	}

}
