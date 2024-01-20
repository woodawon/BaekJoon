import java.util.Scanner;
import java.util.Stack;

public class Stack_sequence1874 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N]; // 수열 값 배열
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num = 1; // 오름차순 수
		boolean result = true;
		
		for(int i = 0;i < N;i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0;i < A.length;i++) {
			int su = A[i]; // 수열 값
			if (su >= num) {
				while(su >= num) {
					stack.push(num++); // 오름차순 수를 +1 해주면서 stack 안에 오름차순 값을 넣어줌
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			} else {
				int n = stack.pop();
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
