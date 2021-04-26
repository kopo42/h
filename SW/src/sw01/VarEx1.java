package sw01;

import java.util.Scanner;

public class VarEx1 { //클래스 선언

	public static void main(String[] args) { //프로그램을 시작할 메인 함수
		// TODO Auto-generated method stub 
		//kp42_VarEx1();
		//kp42_VarEx2();
		//kp42_StringEX();
		//p42_SpecialCharEx();
		//kp42_ScanneEx();
		//kp42_PrintEx1();
		//kp42_PrintfEX2();
		kp42_OverFlowEx();
	}
	
	public static void kp42_VarEx1() {
		int kp42_year = 0; //정수형 변수를 선언하고 0으로 초기화
		int kp42_age = 14; //정수형 변수를 선언하고 14로 초기화
		
		System.out.println("Result 1:" + kp42_year); //위에서 선언한 변수들을 출력
		System.out.println("Result 2: " + kp42_age);
		
		kp42_year = kp42_age + 2000; //age에 2000만큼 더한 값을 year에 저장
		kp42_age = kp42_age + 1; //저장된 값을 1 증가
		
		System.out.println("Result 3: " + kp42_year); //변화된 변수 값 출력
		System.out.println("Result 4: " + kp42_age);
	}
	
	public static void kp42_VarEx2() {
		//정수형 변수들을 선언하고 초기화
		int x = 10;
		int y = 20;
		int tmp = 0;
		
		System.out.println("x: " + x + " y: " + y); //처음 초기화된 값을 출력
		
		tmp = x;
		x = y;
		y = tmp;
		//x, y값을 교환하기 위해 tmp라는 변수를 추가로 선언했다
		System.out.println("x: " + y + " y: " + y); //교환된 값을 출력
	}
	
	public static void kp42_StringEX() {
		String name = "Ja" + "va"; //"Java" 출력
		String str = name + 8.0; //8.0은 그대로 String 값으로
		
		System.out.println(name); //"Java"
		System.out.println(str); //"Java8.0"
		System.out.println(7 + " "); //7 + 한칸 출력
		System.out.println(" " + 7); //한칸 + 7
		System.out.println(7 + ""); //7 + 공백
		System.out.println("" + 7); //공백 + 7
		System.out.println("" + ""); //공백 + 공백
		System.out.println(7 + 7+ ""); //7 + 7 = 14, + 공백
		System.out.println("" + 7 + 7); //공백, 7, 7 출력
	}
	public static void kp42_SpecialCharEx() {
		System.out.println('\''); //'나 "를 출력하고 싶을 때
		System.out.println("abc/t123/b456"); // /b에 의해 3은 지워짐
		System.out.println("\n"); //줄바꿈 출력
		System.out.println("\"Hello\""); //"출력하기
		System.out.println("C: \\"); // \한개생략
	}
	public static void kp42_ScanneEx() {
		Scanner scan = new Scanner(System.in); //scanner 객체 만들기
		System.out.print("두자리 정수를 하나 입력하세요 .> "); //쉬운 사용을 위한 문장
		
		String input = scan.nextLine(); //string input은 다음에 입력받는 값
		int num = Integer.parseInt(input); //입력받은 string값을 정수형으로 변환
		
		System.out.println("입력 내용: " + input); //입력받은 값 출력
		System.out.printf("num = %d%n", num); //정수형 출력
	}
	public static void kp42_PrintEx1() {
		byte b = 1; //byte형 선언
		short s = 2; //short형 선언
		char c = 'A'; //char형 선언
		
		int finger = 10; //int형 선언
		long big = 100000000000L; //long형 선언
		long hex = 0xFFFFFFFFFFFFFFFFL;
		
		int octNum = 010; //8진수 10, 10진수 8
		int hexNum = 0x10; //16진수 10, 10진수 16
		int binNum = 0b10; //2진수 10, 10진수 2
		
		System.out.printf("b = %d%n", b);
		System.out.printf("s = %d%n", s);
		System.out.printf("c = %c, %d%n", c, (int)c);
		
		System.out.printf("1. finger = [%5d]%n", finger);
		System.out.printf("2. finger = [%-5d]%n", finger);
		System.out.printf("3. finger = [%05d]%n", finger);
		
		System.out.printf("big = %d%n", big);
		System.out.printf("hex = %#x%n", hex);
		System.out.printf("octNum = %o, %d%n", octNum, octNum);
		System.out.printf("hexNum = %x, %d%n", hexNum, hexNum);
		System.out.printf("binNum = %s, %d%n", Integer.toBinaryString(binNum), binNum);
	}
	public static void kp42_PrintfEX2() {
		String url = "www.codechobo.com"; //영문, 기호가 섞인 String값
		
		float f1 = .10f; //float형 선언
		float f2 = 1e1f;
		float f3 = 3.14e4f;
		double d = 1.23456789; //double형 선언
		
		System.out.printf("f1 = %f, %e, %g%n", f1, f1, f1); //출력 형태 확인하기
		System.out.printf("f2 = %f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3 = %f, %e, %g%n", f3, f3, f3);
		
		System.out.printf("d = %f%n", d); //출력 형태 확인하기 
		System.out.printf("d = %14.10f%n", d); //소수점 14자리 중 10자리 출력
		
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("1. url = [%s]%n", url);
		System.out.printf("2. url = [%20s]%n", url);
		System.out.printf("3. url = [%-20s]%n", url); //오른쪽 정렬
		System.out.printf("4. url = [%.8s]%n", url); //왼쪽에서 8글자만 출력
	}
	public static void kp42_OverFlowEx() {
		short sMin = -32768; //short형 선언
		short sMax = 32767;
		char cMin = 0; //char형 선언
		char cMax = 65535;
		//출력 형태 비교
		System.out.println("sMin     = " + sMin);
		System.out.println("sMin - 1 = " + (short)(sMin - 1)); //short형으로 변환 출력
		System.out.println("sMax     = " + sMax);
		System.out.println("sMax + 1 = " + (short)(sMax + 1)); 
		System.out.println("cMin     = " + (int)(cMin)); //int형으로 변환 출력
		System.out.println("cMin - 1 = " + (int)--cMin);
		System.out.println("cMax     = " + (int)cMax);
		System.out.println("cMax + 1 = " + (int)++cMax);
		}
}

















