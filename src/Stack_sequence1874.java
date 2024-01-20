import java.util.Scanner;
import java.util.Stack;

/*
 * - 스택 수열 -
 * : push(데이터 삽입), pop(데이터 삭제), peak(맨위 데이터 확인), top(맨위)
 * -> push(+) & pop(-) 연산을 어떤 순서로 처리해줘야 수열을 스택에 넣었다가 출력할 때 
 *    오름차순 수열의 개념을 사용해 해당 수열을 문제 없이 출력할 수 있게 되는지 알아낼 수 있는 프로그램 
 * 
 * <예시>				<결과>
 * 8			 	+
 * 4			 	+
 * 3             	+
 * 6             	+
 * 8             	-
 * 7             	-
 * 5             	+
 * 2             	+
 * 1             	-
 * 					+					
 * 					+
 * 					-
 * 					-
 * 					-
 * 					-
 * 					-
 * */

public class Stack_sequence1874 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열 배열 길이
		int[] A = new int[N]; // 수열 값 배열
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer(); // 연산 순서 내용을 담을 stringBuffer
		int num = 1; // 오름차순 수
		boolean result = true; // 오름차순 배열을 만들 수 있는지 없는지
		
		for(int i = 0;i < N;i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0;i < A.length;i++) {
			int su = A[i]; // 수열 값
			if (su >= num) { // stack에 값을 추가해줘야 하는지 아닌지 판단
				while(su >= num) { // stack에 추가해줘야 하는 숫자의 개수만큼 반복
					stack.push(num++); // 오름차순 수를 +1 해주면서 stack 안에 값을 push
					bf.append("+\n");
				}
				stack.pop(); // su값을 stack에서 pop 
				bf.append("-\n");
			} else {
				int n = stack.pop(); // su의 값이 오름차순 값보다 작을 경우 stack에서 pop 
				if (n > su) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		if (result) System.out.println(bf.toString());

	}

}
