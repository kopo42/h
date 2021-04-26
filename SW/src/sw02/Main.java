package sw02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variation4();
		//SpecialCharEx1();
		//ScaanerEX();
		//Print2();
		//OverFlowEx();
		CastingEx4();
	}
	public static void Variation1() { //함수로 나누어 실행
		int k42_year = 0; //정수형 변수를 0으로 초기화한다 
		int k42_age = 14; //정수형 변수를 14로 초기화한다
		
		System.out.println("결과1 : " + k42_year);
		System.out.println("결과2 : " + k42_age);
		
		k42_year = k42_age + 2000; //변수를 다른 값으로 초기화한다
		k42_age = k42_age + 1; //변수에 1을 더한다
		
		System.out.println("결과3 : " + k42_year);
		System.out.println("결과4 : " + k42_age);
	}
	public static void Variation2() {
		int k42_year = 0; //정수형 변수를 0으로 초기화한다 
		int k42_age = 14; //정수형 변수를 14로 초기화한다
		
		System.out.println("결과1 : " + k42_year);
		System.out.println("결과2 : " + k42_age);
		
		k42_year = k42_age + 2000; //변수에 임의의 값을 더하여 저장한다
		k42_age = k42_age + 1; //변수에 현재 저장된 값을 1만큼 증가시킨다
		
		System.out.println("결과3 : " + k42_year);
		System.out.println("결과4 : " + k42_age);
	}
	public static void Variation3() {
		int k42_x = 10; //변수 값 초기화
		int k42_y = 20;
		int k42_tmp = 0;
		
		System.out.println("x: " + k42_x + "\ny: " + k42_y); 
		// "+"를 이용해 문자 부분과 변수 부분을 함께 출력할 수 있다
		
		k42_tmp = k42_x; //tmp = 다른 두 변수의 값을 교환하기 위한 변수
		k42_x = k42_y; //x에 y의 값을 저장 (기존 x 값은 tmp에 저장되어 있다)
		k42_y = k42_tmp; //기존 x의 값을 y에 저장
		
		System.out.println("x: " + k42_x + "\ny: " + k42_y);
	}
	public static void Variation4() {
		//문자열 변수 선언하기
		String k42_name = "Ja" + "Va"; //"+"로 이어붙여 저장할 수 있다
		String k42_str = k42_name + 8.0; //문제 없이 저장되나 추후 에러의 요인이 될 수 있음
		
		System.out.println(k42_name); //괄호 안에 문자열 변수의 명칭을 그대로 넣어 출력할 수 있음
		System.out.println(k42_str);
		
		System.out.println(7 + " "); //뒤에 space 출력
		System.out.println(" " + 7); //앞에 space 출력
		System.out.println(7 + ""); //뒤에 공백 출력
		System.out.println("" + 7);  //앞에 공백 출력
		System.out.println("" + ""); //공백만 출력
		System.out.println(7 + 7 + ""); //7과 7을 더한 값인 14가 출력
		System.out.println("" + 7 + 7); //앞에 공백 ""이 존재하기 때문에 숫자도 각각 출력됨
	}
	public static void SpecialCharEx1() {
		System.out.println('\''); //" ' "를 출력하기 위해서는 앞에 \를 함께 입력한다
		System.out.println("abc\t123\b456"); // \t = tab, \b = 문자를 지우는 기능 수행
		System.out.println('\n'); //개행
		System.out.println("\"Hello\""); //위와 같이 큰따옴표를 출력하는 경우
		System.out.println("c:\\"); //특히 파일, 디렉토리 경로를 따옴표 안에 입력하는 경우
	}
	public static void ScaanerEX() {
		Scanner k42_scan = new Scanner(System.in); //사용자 입력 값을 받기 위한 scanner 객체 생성
		System.out.println("두 자리 정수를 하나 입력해주세요.>");
		String k42_input = k42_scan.nextLine(); //빈칸, 개행이 포함될 시 nextLine 사용
		
		int k42_num = Integer.parseInt(k42_input); //입력받은 String을 정수형으로 변환
		
		System.out.println("입력 내용 : " + k42_input);
		System.out.printf("num = %d%n", k42_num);
	}
	public static void Print1() {
		byte k42_b = 1;
		short k42_s = 2;
		char k42_c = 'A';
		
		int k42_finger = 10;
		long k42_big = 10000000000L;
		long k42_hex = 0xFFFFFFFFFFFFFFL;
		
		int k42_octNum = 010;
		int k42_hexNum = 0x10;
		int k42_binNum = 0b10;
		
		System.out.printf("b = %d%n", k42_b);  //printf로 텍스트와 변수를 혼용하여 출력할 수 있다
		System.out.printf("s = %s%n", k42_s);
		System.out.printf("c = %c, %d %n", k42_c, (int)k42_c); //char 값과 ASCII코드 값 출력
		
		System.out.printf("finger = [%5d]%n", k42_finger); //오른쪽 정렬
		System.out.printf("finger = [%-5d]%n", k42_finger); //왼쪽 정렬
		System.out.printf("finger = [%05d]%n", k42_finger); //공백에 0 출력
		
		System.out.printf("big = %d%n", k42_big);
		System.out.printf("hex = %#x%n", k42_hex);
		System.out.printf("octNum = %o, %d%n", k42_octNum, k42_octNum); //정수로 받아 출력 시: 8
		System.out.printf("hexNum = %x, %d%n", k42_hexNum, k42_hexNum); //정수로 받아 출력 시: 16
		System.out.printf("bigNum = %s, %d%n", Integer.toBinaryString(k42_binNum), k42_binNum);
		// 정수로 받아 출력 시: 2
	}
	public static void Print2() {
		String k42_url = "www.codechobo.com"; //영문, 기호가 섞인 String값
		
		float k42_f1 = .10f; //float형 선언
		float k42_f2 = 1e1f;
		float k42_f3 = 3.14e4f;
		double k42_d = 1.23456789; //double형 선언
		
		System.out.printf("f1 = %f, %e, %g%n", k42_f1, k42_f1, k42_f1); //출력 형태 확인하기
		System.out.printf("f2 = %f, %e, %g%n", k42_f2, k42_f2, k42_f2);
		System.out.printf("f3 = %f, %e, %g%n", k42_f3, k42_f3, k42_f3);
		
		System.out.printf("d = %f%n", k42_d); //출력 형태 확인하기 
		System.out.printf("d = %14.10f%n", k42_d); //소수점 14자리 중 10자리 출력
		
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("1. url = [%s]%n", k42_url);
		System.out.printf("2. url = [%20s]%n", k42_url);
		System.out.printf("3. url = [%-20s]%n", k42_url); //오른쪽 정렬
		System.out.printf("4. url = [%.8s]%n", k42_url); //왼쪽에서 8글자만 출력
	}
	public static void OverFlowEx() {
		short k42_sMin = -32768; //short형 선언
		short k42_sMax = 32767;
		char k42_cMin = 0; //char형 선언
		char k42_cMax = 65535;
		//출력 형태 비교
		System.out.println("sMin     = " + k42_sMin);
		System.out.println("sMin - 1 = " + (short)(k42_sMin - 1)); //short형으로 변환 출력
		//양수로 변환되어 출력된다
		System.out.println("sMax     = " + k42_sMax);
		System.out.println("sMax + 1 = " + (short)(k42_sMax + 1)); 
		//음수로 변환되어 출력된다
		System.out.println("cMin     = " + (int)(k42_cMin)); //int형으로 변환 출력
		System.out.println("cMin - 1 = " + (int)--k42_cMin);
		System.out.println("cMax     = " + (int)k42_cMax);
		System.out.println("cMax + 1 = " + (int)++k42_cMax);
		}
	public static void CastingEx1 () {
		double kp42_d = 85.4; //double값 선언
		int kp42_score = (int)kp42_d; //int값 선언 = d의 정수형
		//출력하여 결과 확인하기
		System.out.println("score = " + kp42_score);
		System.out.println("d = " + kp42_d);
	}
	public static void CastingEx2 () {
		int kp42_i = 10; //int형 선언
		byte kp42_b = (byte)kp42_i; //byte형 선언 = i의 byte형
		System.out.printf("[int -> byte] i = %d -> b = %d%n", kp42_i, kp42_b); //출력하여 확인
		
		kp42_i = 300; //int형 선언
		kp42_b = (byte)kp42_i; //byte형 선언 = i의 byte형
		System.out.printf("[int -> byte] i = %d -> b = %d%n", kp42_i, kp42_b); //출력하여 확인
		
		kp42_b = 10; //byte형 선언
		kp42_i = (int)kp42_b; //int형 선언 = b의 int형
		System.out.printf("[byte -> int] b = %d -> i = %d%n", kp42_b, kp42_i); //출력하여 확인
		
		kp42_b = -2; //byte형 선언
		kp42_i = (int)kp42_b; //int형 선언 = b의 int형
		System.out.printf("[byte -> int] b = %d -> i = %d%n", kp42_b, kp42_i); //출력하여 확인
		
		System.out.println("i = " + Integer.toBinaryString(kp42_i));
	}
	public static void CastingEx3() {
		float kp42_f = 9.1234567f; //float형 선언
		double kp42_d = 9.1234567; //double형 선언
		double kp42_d2 = (double)kp42_f;
		//소수점 자리수 지정하여 출력하기
		System.out.printf("f = %20.18f\n", kp42_f);
		System.out.printf("d = %20.18f\n", kp42_d);
		System.out.printf("d2 = %20.18f\n", kp42_d2);
	}
	public static void CastingEx4() {
		int kp42_i = 12345678; //8자리의 10진수
		float kp42_f= (float)kp42_i; //int to float
		int kp42_i2 = (int)kp42_f; //float to int
		
		double kp42_d = (double)kp42_i; //int to double
		int kp42_i3 = (int)kp42_d; //double to int
		
		float kp42_f2 = 1.666f; 
		int kp42_i4 = (int)kp42_f2; //flaot to int
		//출력하여 확인하기
		System.out.printf("i = %d\n", kp42_i);
		System.out.printf("f = %f, i2 = %d\n", kp42_f, kp42_i2);
		System.out.printf("d = %f, i3 = %d\n", kp42_d, kp42_i3);
		System.out.printf("(int)%f = %d\n", kp42_f2, kp42_i4);
	}
}














