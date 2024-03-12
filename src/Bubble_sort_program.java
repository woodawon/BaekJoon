import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * - 버블정렬 알고리즘 심화 -
 * 
 * (설명) : 
 * 정렬 전 index => 1 3 4 2 0
 * 정렬 후 index => 0 1 2 3 4
 * 결과값 => 0 2 2 -1 -4 => 이 배열에서 최댓값 + 1 => 2 + 1 = 3(result)
 * -> 버블정렬 프로세스가 종료가 되려면, swap(앞뒤 교체)이 한번도 일어나지 않는 루프가 한번 존재하기 때문에
 * 이 상황을 감안해서 최댓값 + 1을 해줘야 한다.
 * */

public class Bubble_sort_program {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); // 데이터 개수
		
		mData[] A = new mData[num]; // mData 클래스들을 담고 있는 배열
		for(int i = 0; i < num; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i); // value, index
		}
		
		// 최초 입력 value : 10 1 5 2 3    --> index : (0 1 2 3 4)
		// 오름차순 정렬 후 value :  1 2 3 5 10
		// 정렬 전 index : 1 3 4 2 0
		// 정렬 후 index : 0 1 2 3 4
		
		Arrays.sort(A); // 오름차순 정렬
		int max = 0; // 최댓값
		for(int i = 0; i < num; i++) { // for문이 반복된 총 횟수!!!
			if(max < A[i].index - i) { // (정렬 전 index) - (정렬 후 index)
				max = A[i].index - i;
			}
		}
		System.out.println(max + 1);
		
		
	}

}

class mData implements Comparable<mData> {
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(mData m) {
		return this.value - m.value;
	}
}



