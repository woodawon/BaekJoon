import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * STACK 응용 - 괄호의 값 풀기
 * 괄호마다 규칙이 존재하고, 그 규칙대로 수학적 계산을 해서 최종값을 구하는 프로그램
 * 
 * <예시>
 * (()[[]])([])
 * 결과 : 28
 * 
 * [][]((])
 * 결과 : 0
*/

//‘()’ 인 괄호열의 값은 2이다.
//‘[]’ 인 괄호열의 값은 3이다.
//‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
//‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
//올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.

/// <괄호 규칙>
//  ‘()’ 인 괄호열의 값은 2이다.
//  ‘[]’ 인 괄호열의 값은 3이다.
//  ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
//  ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
//  올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.

public class Parenthesis_values2504 {
	
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Stack<Bracket> stack = new Stack<>();
        
        int result = 0;
        
        for(int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	
        	if(c == '(' || c == '[') { // 열린 괄호인지
        		stack.push(new Bracket(c, 0));
        	} else {
        		
        		if(stack.isEmpty() || 
        		(stack.peek().bt == '(' && c == ']') ||
        		 (stack.peek().bt == '[' && c == ')')) { // str 문자열의 괄호 문자들이 규칙에 따라 계산할 수 없진 않은지
        			result = 0;
        			break;
        		}
        		
        		Bracket bracket = stack.pop();
        		int mul = (c == ')' ? 2 : 3);
        		bracket.value = (bracket.value == 0 ? 1 : bracket.value);
        		
        		if(stack.isEmpty()) { // 괄호 계산이 끝났을 때
        			result += bracket.value * mul;
        		} else {
        			stack.peek().value += bracket.value * mul;
        		}
        		
        	}
        }
        
        System.out.println(result);
        bf.close();
    }
    
    static class Bracket {
    	char bt;
    	int value;
    	public Bracket(char bt, int value) {
			this.bt = bt;
			this.value = value;
		}
    }
}


