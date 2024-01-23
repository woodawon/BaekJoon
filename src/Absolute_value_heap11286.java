import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Absolute_value_heap11286 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 질의 요청 개수
		
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
			
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			
			if(first_abs == second_abs) { // 절댓값이 같다면 음수 우선순위 정렬
				return o1 > o2 ? 1 : -1;
			} else {
				return first_abs - second_abs; // 절댓값이 다를 때 더 작은 절댓값 기준으로 우선순위 정렬
			}
			
		});
		
		// ** 람다식으로 변형하기 전의 기본 익명클래스 사용 예시
		PriorityQueue<Integer> myQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int first_abs = Math.abs(o1);
				int second_abs = Math.abs(o2);
				
				if(first_abs == second_abs) { // 절댓값이 같다면 음수 우선순위 정렬
					return o1 > o2 ? 1 : -1;
				} else {
					return first_abs - second_abs; // 절댓값이 다를 때 더 작은 절댓값 기준으로 우선순위 정렬
				}
			}
		});
		
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(myQueue.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(myQueue.poll());
				}
			} else {
				myQueue.add(request);
			}
		}
		br.close();
	}

}
