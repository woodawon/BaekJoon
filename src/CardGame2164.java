import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * - 카드게임 -
 * : 큐(Queue) 자료구조 기본 개념
 * : FIFO - 선입선출 -> poll() = 버리기 / add() = 추가하기
 * 
 * <예시>
 * 6
 * 결과 : 4
 * */

public class CardGame2164 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 개수 (1~N)
		
		Queue<Integer> myQueue = new LinkedList<>();
		for(int i = 1;i <= N;i++) {
			myQueue.add(i);
		}
		
		while(myQueue.size() > 1) { // Queue에 카드가 1개 남으면 바로 빠져나옴
			myQueue.poll(); // 첫 번째로 맨 앞의 카드 버림
			myQueue.add(myQueue.poll()); // 두 번째로 맨 앞의 카드를 버릴 땐, 버린 카드를 큐에 추가
		}
		
		System.out.println(myQueue.poll());
		sc.close();
	}

}
