import java.util.Scanner;

/*
 * - 수 정렬하기 -
 * -> 버블정렬 알고리즘(오름차순)
 * 
 * <예시>
 * 5 // 개수
 * 5
 * 2
 * 3
 * 4
 * 1
 * 결과 : 
 * 1
 * 2
 * 3
 * 4
 * 5
 * 
 * */

public class Sorting_numbers_2750 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1-i; j++) { // 정렬 안된 인접한 데이터 비교
				if(arr[j] > arr[j+1]) { // 앞 > 뒤 -> Swap 조건에 해당된다면
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int a = 0; a < n; a++) {
			System.out.println(arr[a]);
		}
		
		sc.close();

	}

}






