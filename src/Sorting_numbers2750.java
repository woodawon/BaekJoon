
/*
 * - 수 정렬하기 -
 * 시간 복잡도 : 빅 오메가(최상 : 1), 빅 세타(보통 : N/2), 빅 오(최악 : N) -> 최악의 상황을 고려하기
 * N(= 데이터)의 최댓값이 얼마나 되느냐에 따라 구현한 코드에서의 연산 횟수가 정해짐. 
 * 
 * <중요 사항>
 * 1. 어떤 알고리즘을 사용해야 가장 연산 횟수가 적고 효율적인 코드를 만들 수 있을까
 * 2. 작성한 코드 내용 중에서 비효율적인 부분이 있지 않은지? 
 * -> ex) 1초당 1억번의 데이터 연산을 수행하는 게 기본적인 수행 시간인데, 혹시나
 * 비효율적인 알고리즘이나 로직을 적용해서 N(데이터)의 개수에 따른 연산 횟수가 시간 제한에 해당하는 시간만큼의
 * 연산 횟수를 초과하여 시간 초과가 발생하진 않을지? 
 * 
 * ++ 빅 오 표기법 :  O(logn), O(nlogn), O(n), O(n^2), O(2^n), O(n!)
 * ++ 알고리즘이나 로직을 어떤 것으로 선택해서 코드를 구현하느냐에 따라, 빅 오 표기법이 다름.
 * 그러므로 로직이나 알고리즘 유형마다 계산할 수 있는 빅 오 표기법을 잘 숙지하여 
 * 다양한 코딩 테스트 문제의 주제에 적합한 알고리즘 및 로직을 주어진 데이터 양에 따른 빅 오 표기법의  
 * 시간 복잡도 연산 횟수 계산 결과를 반영하여 직접 선택하여 코드 작성을 할 수 있으면 좋음.
 * */

public class Sorting_numbers2750 {

	public static void main(String[] args) {
		
		int N = 1000000;
		int cnt = 0;
		
		for (int i = 0;i < N;i++) { // N 연산 횟수 : O(n) - 2N, 3N 등의 상수는 중요하지 X
			System.out.println("연산 횟수 : " + cnt++);
		}
		
		for(int i = 0;i < N;i++) { // N^2 연산 횟수 : O(n^2)
			for(int j = 0;j < N;j++) {
				System.out.println("연산 횟수 : " + cnt++);
			}
		}
		

	}

}