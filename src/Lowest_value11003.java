import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * - 최솟값 찾기 - (고급 슬라이딩 윈도우 기법(정렬이 아닌 탐색의 경우 : O(n) 시간 복잡도))
 * 
 * N의 최대범위가 5,000,000 등으로 큰 경우엔 nlog(n)의 시간 복잡도를 가지는 정렬을 사용할 수 없음.
 * 하지만 슬라이딩 윈도우에서 마치 정렬 알고리즘을 사용한 듯한 정렬 효과를 사용할 수 있는 방법이 있음.
 * 양 끝에서 데이터를 삽입하거나 삭제(addFirst, removeFirst, addLast, removeLast)할 수 있는
 * 자료구조를 의미하는 '덱(deque)'을 이용해 정렬 알고리즘을 사용하지 않고도 정렬할 수 있음.
 * 
 * <예시>
 * 12 3
 * 1 5 2 3 6 2 3 7 3 5 2 6
 * 결과 : 1 1 1 2 2 2 2 2 3 3 2 2 
 * */

public class Lowest_value11003 {
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 데이터 개수
		int L = Integer.parseInt(st.nextToken()); // 최솟값을 구하는 윈도우 슬라이딩 범위
		st = new StringTokenizer(br.readLine());

		Deque<Node> mydeque = new LinkedList<>(); // 데이터를 담을 덱 자료구조

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			// ex) (2,5) <- (3,2) 노드의 Last Value(= 숫자) 비교 : 5 > 2 비교 : 5가 더 크므로 (2,5) 노드를 덱에서 제거
			while (!mydeque.isEmpty() && mydeque.getLast().value > now) { 
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i)); // while의 조건 내용을 처리했다면, 이제 (3,2)노드 추가
			if(i - L >= mydeque.getFirst().index) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " ");
		}
		bw.flush(); // ** flush 란? : stream에 남아있는 데이터를 강제로 내보내는 역할을 함. (저장된 데이터를 빼내는, 즉 출력하는 역할)
		bw.close();

	}

	static class Node {
		public int value; // 숫자
		public int index; // 인덱스

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
