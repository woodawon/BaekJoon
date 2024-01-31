// 재귀적인 패턴으로 별찍기
// 재귀를 통한 분할 정복 설계하기
import java.util.Scanner;
import java.io.*;

public class Main {
    static char arr[][] = null;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = sc.nextInt();
        arr = new char[N][N];
        
        // 별찍기 함수 객체 선언
        makeStar(0, 0, N, false);
        
        for(int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        
        
    }
    
    public static void makeStar(int x, int y, int N, boolean blank) {
         int size = N / 3; // 최종 별상자 ->  격자 쪼개기 시의 상자 개수 
        int count = 0; // N 패턴 별 상자 생성 시 * or ' ' 찍는 개수  
        
        if(blank) {// 별 상자에서 가운데 공백 부분을 입력해야 하는 경우 
            for(int i= x; i < x+N; i++) {
                for(int j = y; j < y+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        if(N == 1) {
			arr[x][y] = '*';
			return;
		}
        
        for(int i = x; i < x; i += size){
            for(int j = y; j < y; j += size){
                count++;
                if(count == 5){ // 다섯 번째 count 도달 시 공백 입력
                    makeStar(i, j, size, true);
                } else {
                    makeStar(i, j, size, false);
                }
            }
        }
    }
    
}

