package sw01;

public class KOPO42_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//kp42_CastingEx1();
		//kp42_CastingEx2();
		//kp42_CastingEx3();
		kp42_CastingEx4();
	}
	public static void kp42_CastingEx1 () {
		double d = 85.4; //double값 선언
		int score = (int)d; //int값 선언 = d의 정수형
		//출력하여 결과 확인하기
		System.out.println("score = " + score);
		System.out.println("d = " + d);
	}
	public static void kp42_CastingEx2 () {
		int i = 10; //int형 선언
		byte b = (byte)i; //byte형 선언 = i의 byte형
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b); //출력하여 확인
		
		i = 300; //int형 선언
		b = (byte)i; //byte형 선언 = i의 byte형
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b); //출력하여 확인
		
		b = 10; //byte형 선언
		i = (int)b; //int형 선언 = b의 int형
		System.out.printf("[byte -> int] b = %d -> i = %d%n", b, i); //출력하여 확인
		
		b = -2; //byte형 선언
		i = (int)b; //int형 선언 = b의 int형
		System.out.printf("[byte -> int] b = %d -> i = %d%n", b, i); //출력하여 확인
		
		System.out.println("i = " + Integer.toBinaryString(i));
	}
	public static void kp42_CastingEx3() {
		float f = 9.1234567f; //float형 선언
		double d = 9.1234567; //double형 선언
		double d2 = (double)f;
		//소수점 자리수 지정하여 출력하기
		System.out.printf("f = %20.18f\n", f);
		System.out.printf("d = %20.18f\n", d);
		System.out.printf("d2 = %20.18f\n", d2);
	}
	public static void kp42_CastingEx4() {
		int i = 12345678; //8자리의 10진수
		float f= (float)i; //int to float
		int i2 = (int)f; //float to int
		
		double d = (double)i; //int to double
		int i3 = (int)d; //double to int
		
		float f2 = 1.666f; 
		int i4 = (int)f2; //flaot to int
		//출력하여 확인하기
		System.out.printf("i = %d\n", i);
		System.out.printf("f = %f, i2 = %d\n", f, i2);
		System.out.printf("d = %f, i3 = %d\n", d, i3);
		System.out.printf("(int)%f = %d\n", f2, i4);
	}
}



















