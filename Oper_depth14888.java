import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 원하는 숫자들의 개수, 숫자, 연산자 별 개수를 입력하면 계산한 결과를 출력해주는 프로그램 코드 짜기
 * 재귀 호출(순차적으로 자신을 계속해서 호출)과 완전 탐색(모든 경우의 수 탐색)의 개념을 적용해 작성할 수 있다.
 * DFS(깊이 우선 탐색) : 그래프를 탐색 트리 형태로 하여 순차적으로 깊이 들어가며 탐색하고, 최상단 노드와 연결된 노드를 
 * 무조껀 깊은 순위로 모두 탐색한 후, 그 다음 방문을 하지 않은 노드 중에서의 최상단 노드로 가서 깊이 우선 탐색을 한다.
 * N개의 수와 N-1개의 연산자가 주어졌을 때, 이 수들과 연산자들로 할 수 있는 계산 중 최대값과 최소값을 구하면 된다.
 * */

/*
- 예시 - 
<입력> 
2
5 6
0 0 1 0
<출력>
30
30
<입력>
3
3 4 5
1 0 1 0
<출력>
35
17
*/

public class step1 {

	// 변수 선언 -> 지역 변수가 아니라 전역 변수이기 때문에
	// 전역 변수를 해당 클래스의 메서드 내에서 사용하려면 변수 선언 시 static 키워드를 자료형으로 사용해줘야 한다.
	public static int max = Integer.MIN_VALUE; // -214562~.
	public static int min = Integer.MAX_VALUE; // 214562~.
	public static int count;
	public static int[] operator = new int[4];
	public static int[] number;

	// main 함수
	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		count = Integer.parseInt(bfr.readLine());
		number = new int[count];

		StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");

		for (int i = 0; i < count; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bfr.readLine(), " ");
		for(int i = 0;i < 4;i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(number[0], 1); //  dfs 함수 최초 선언
		
		System.out.println(max);
		System.out.println(min);

	}

	// dfs 함수
	public static void dfs(int num, int idx) {
		if (idx == count) { 
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) { // 연산자 처리 반복문
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1); // dfs 함수 안에서 또다시 dfs 함수를 호출한다. => 재귀함수
					break;
				case 1:
					dfs(num - number[idx], idx + 1); // 뺄셈 재귀 함수
					break;
				case 2:
					dfs(num * number[idx], idx + 1); // 곱셈 재귀 함수
					break;
				case 3:
					dfs(num / number[idx], idx + 1); // 나눗셈 재귀 함수
					break;
				}
				operator[i]++;
			}
		}
	}

}
