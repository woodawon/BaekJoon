import java.util.ArrayList;

/*
 * 재귀함수 공부 - 피보나치 수열, 팩토리얼 메서드
 * */
public class Recursive_Study {
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println("fibonacci : " + fibonacci(4));
		System.out.println("factorial : " + factorial(3));
		for(int i = 0; i < list.size(); i++) {
			System.out.println("list : ");
		}

	}
	
	public static int fibonacci(int num) {
		// 피보나치 수열 메서드
		
		Recursive_Study.list.add(num);
		if(num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		return fibonacci(num-1) + fibonacci(num-2);
		
	}
	
	public static int factorial(int num) {
		// 팩토리얼 메서드
		// 5->5*4*3*2*1=120
		if(num == 1) {
			return 1;
		}
		return num * factorial(num-1);
	}

}
