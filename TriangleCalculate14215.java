import java.util.Scanner;

/*
 * <삼각형 길이 공식>
 *(가장 긴 변의 길이) < (나머지 변 1의 길이 + 나머지 변2의 길이)
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String say = sc.nextLine(); // 값 받아오기
		sc.close();
		String[] said = say.split(" "); // 쪼개기
		int[] judged = judge(Integer.parseInt(said[0]), Integer.parseInt(said[1]), Integer.parseInt(said[2])); // 정렬시켜서
																												// int
																												// 배열에
																												// 담기
		int[] checked = check(judged[0], judged[1], judged[2]); // 삼각형 공식에 맞게 수정한 숫자들을 담은 배열
		System.out.println(checked[0] + checked[1] + checked[2]);
		
	}

	// 세 개의 숫자들이 작은 순서대로 배치되었는지 검증하는 메소드
	public static int[] judge(int a, int b, int c) {
		int[] arr = { a, b, c }; // length = 3
		// 버블정렬 사용
		for (int i = 1; i < arr.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}

		return arr; // 버블정렬된 배열 리턴
	}

	// 삼각형 변의 공식에 맞는 수로 구성되었는지 검증하는 메소드
	public static int[] check(int a, int b, int c) { // c2 < a2 + b2 인지 검증
		boolean bol = true;
		while (bol) {
			if (c < a + b) {
				bol = false;
			} else {
				c -= 1;
				bol = true;
			}
		}
		int[] arr = { a, b, c };

		return arr;
	}

}
