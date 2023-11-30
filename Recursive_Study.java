/*
 * 재귀함수 공부 - 피보나치 수열, 팩토리얼
 * */
public class Recursive_Study {

	public static void main(String[] args) {
		
		System.out.println("fibonacci : " + fibonacci(4));
		System.out.println("factorial : " + factorial(3));

	}
	
	public static int fibonacci(int num) {
		// 피보나치 수열 메서드
		// 0 + 1 + 2 + 3 + 4 + 5... -> 0+1 = 1, 1+2=3, 3+3=6, 6+4=10
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
		// 3 -> 3*2*1=6, 5->5*4*3*2*1=120
		if(num == 1) {
			return 1;
		}
		return num * factorial(num-1);
	}

}
