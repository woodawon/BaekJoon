package baekjoon;

import java.util.Scanner;

public class step1 {

	public static void main(String[] args) {
		Float[] grade_arr = new Float[20];
		float division = 0; // 학점 총합
		float add = 0; // 과목평점 총합
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 20;i++) {
			String say = sc.nextLine();
			String[] num_arr = say.split(" "); // 과목명, 학점, 과목평점(title, score, grade)
			if(num_arr[2] != "P") {
				float switchedNum = Float.parseFloat(str(num_arr[2])); // 4.5 -> A+
				float score = Float.parseFloat(num_arr[1]); // 3.0
				division += score;
				float multiply = score * switchedNum;
				grade_arr[i] = multiply;
			}
		}
		sc.close();
		for(int i = 0;i < 20;i++) {
			add += grade_arr[i];
		}
		float result = (add / division) + (add % division);
		System.out.println(result);

	}
	
	public static String str(String s) {
		if(s.equals("A+")) {
			s = "4.5";
		}
		if(s.equals("A0")) {
			s = "4.0";
		}
		if(s.equals("B+")) {
			s = "3.5";
		}
		if(s.equals("B0")) {
			s = "3.0";
		}
		if(s.equals("C+")) {
			s = "2.5";
		}
		if(s.equals("C0")) {
			s = "2.0";
		}
		if(s.equals("D+")) {
			s = "1.5";
		}
		if(s.equals("D0")) {
			s = "1.0";
		}
		if(s.equals("F")) {
			s = "0.0";
		} 
		return s;
	}

}
