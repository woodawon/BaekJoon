import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Large_numbers17298 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()); // 수열 개수
		int[] A = new int[N]; // 수열 배열
		int[] ans = new int[N]; // 정답 배열
		String[] str = bf.readLine().split(" "); // ** StringTokeniger로 받는 것도 가능하다.
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(str[i]);
		}

		Stack<Integer> myStack = new Stack<>(); // 정답 배열의 인덱스 값을 담는 스택
		myStack.push(0);
		
		for (int i = 1; i < N; i++) {
			while (!myStack.empty() && A[myStack.peek()] < A[i]) {
				// not null && 현재 수열 > top인덱스가 가리키는 수열
				// 스택에 담긴 top인덱스에 해당하는 ans 배열 칸에 현재 수열 값(A[i])을 넣어주어 오큰수 값을 ans배열에 저장한다.  
				ans[myStack.pop()] = A[i]; 
			}
			myStack.push(i);
		}
		while (!myStack.empty()) { 
			// 위의 for문을 돌았는데도 myStack에 값이 남아있다면, 
			// 수열 배열의 해당 인덱스 값은 오큰수가 없다는 것을 의미하므로
			// ans 배열의 해당 인덱스 값으로 -1을 넣어준다.
			ans[myStack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0;i < N;i++) {
			bw.write(ans[i] + " ");
		}
		bw.flush();
	}

}
