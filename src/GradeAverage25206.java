import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 사용자의 전공평점을 계산해주는 프로그램 코드 짜보기
 * 전공평점 = (전공과목별 (학점 * 과목평점)을 한 값들의 합) / 학점 총합
 * BufferedReader, StringTokenizer 클래스를 효율적으로 잘 사용할 수 있었다.
 * */

/* 입력 예시 (과목명, 학점, 등급(= 과목 평점))
ObjectOrientedProgramming1 3.0 A+
IntroductiontoComputerEngineering 3.0 A+
ObjectOrientedProgramming2 3.0 A0
CreativeComputerEngineeringDesign 3.0 A+
AssemblyLanguage 3.0 A+
InternetProgramming 3.0 B0
ApplicationProgramminginJava 3.0 A0
SystemProgramming 3.0 B0
OperatingSystem 3.0 B0
WirelessCommunicationsandNetworking 3.0 C+
LogicCircuits 3.0 B0
DataStructure 4.0 A+
MicroprocessorApplication 3.0 B+
EmbeddedSoftware 3.0 C0
ComputerSecurity 3.0 D+
Database 3.0 C+
Algorithm 3.0 B0
CapstoneDesigninCSE 3.0 B+
CompilerDesign 3.0 D0
ProblemSolving 4.0 P
*/

public class GradeAverage25206 {
    public static void main(String[] args) throws IOException { // BufferedReader를 사용할 때, buffer.readLine() 이나 buffer.close() 를 사용하게 되면 발생할 수 있는 예외 처리들을 관리해주기 위해 IOException을 던져줘야 한다.
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader : Scanner 와 같은 기능을 제공해 사용자의 입력값을 받아와 처리하지만,
        // buffer 단에서 처리하기 때문에 메모리 사용 측면, 소요 시간 측면 등에서 Scanner 보다 더욱 효율적이다.

        String str[] = new String[20]; // 사용자의 입력값들을 받을 배열
        double gradeSum = 0; // 전공과목별 등급별 (학점 * 과목평점) 을 한 값들의 합 
        double scoreSum = 0; // 학점 총합
        String gList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"}; // 등급 배열
        double gScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0}; // 과목평점 배열

        for (int i = 0; i < 20; i++) {
            str[i] = bfr.readLine(); // sc.nextLine() 과 같은 개념이다.
            StringTokenizer st = new StringTokenizer(str[i], " "); // str[] 배열의 i번째에 위치한 값을 " " 공백을 기준으로 구분해 토큰한다는 의미이다.
            st.nextToken(); // 전공 과목명
            double score = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급 --> 과목 평점

            for (int j = 0; j < 10; j++) { // gList와 gSocre를 훑으면서 gradeSum과 scoreSum을 구한다.
                if (grade.equals(gList[j])) {
                    gradeSum += score * gScore[j];
                    if (j != 9) { // 9번째 배열 값이 등급 P의 경우인데, P 등급의 점수는 계산에서 제외시켜야 하므로 '9번째 배열이 아니라면' 을 조건으로 적어준다.
                        scoreSum += score;
                    }
                }
            }
        }

        double average = gradeSum / scoreSum; 
        System.out.printf("%.6f", average); // 소수점 6자리까지만 출력시켜야 한다.

        bfr.close();
    }
}
