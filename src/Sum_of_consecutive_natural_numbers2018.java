

import java.util.Scanner;

/*
 * - 연속된 자연수의 합 -
 * : 15의 연속된 자연수의 합을 나타내는 가짓수를 구하는 방법 
 * -> 15, 7 + 8, 6 + 4 + 5, 1 + 2 + 3 + 4 + 5 등으로 경우의 수를 구하기
 * 
 * + 핵심 포인트 = end_index와 start_index를 sum에 더하고 빼고, sum과 N의 값을 서로 계속해서 비교하면서 모든
 * 경우의 수(count)를 구하는 과정
 * 
 * <예시>
 * 15
 * 결과 : 4
 * */

/*
 * - 투 포인터란? -
 * : 2개의 포인터로 알고리즘 시간 복잡도를 O(nlogn)이 아닌 O(n)의 시간 복잡도로 최적화하여 사용할 수 있는 알고리즘
 * */

public class Sum_of_consecutive_natural_numbers2018 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;

		while (N != end_index) {
			if (sum == N) {
				count++;
				end_index++;
				sum += end_index;
			} else if (sum > N) {
				sum -= start_index;
				start_index++;
			} else if (sum < N) {
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);

	}

}
