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
		double d = 85.4; //double�� ����
		int score = (int)d; //int�� ���� = d�� ������
		//����Ͽ� ��� Ȯ���ϱ�
		System.out.println("score = " + score);
		System.out.println("d = " + d);
	}
	public static void kp42_CastingEx2 () {
		int i = 10; //int�� ����
		byte b = (byte)i; //byte�� ���� = i�� byte��
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b); //����Ͽ� Ȯ��
		
		i = 300; //int�� ����
		b = (byte)i; //byte�� ���� = i�� byte��
		System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b); //����Ͽ� Ȯ��
		
		b = 10; //byte�� ����
		i = (int)b; //int�� ���� = b�� int��
		System.out.printf("[byte -> int] b = %d -> i = %d%n", b, i); //����Ͽ� Ȯ��
		
		b = -2; //byte�� ����
		i = (int)b; //int�� ���� = b�� int��
		System.out.printf("[byte -> int] b = %d -> i = %d%n", b, i); //����Ͽ� Ȯ��
		
		System.out.println("i = " + Integer.toBinaryString(i));
	}
	public static void kp42_CastingEx3() {
		float f = 9.1234567f; //float�� ����
		double d = 9.1234567; //double�� ����
		double d2 = (double)f;
		//�Ҽ��� �ڸ��� �����Ͽ� ����ϱ�
		System.out.printf("f = %20.18f\n", f);
		System.out.printf("d = %20.18f\n", d);
		System.out.printf("d2 = %20.18f\n", d2);
	}
	public static void kp42_CastingEx4() {
		int i = 12345678; //8�ڸ��� 10����
		float f= (float)i; //int to float
		int i2 = (int)f; //float to int
		
		double d = (double)i; //int to double
		int i3 = (int)d; //double to int
		
		float f2 = 1.666f; 
		int i4 = (int)f2; //flaot to int
		//����Ͽ� Ȯ���ϱ�
		System.out.printf("i = %d\n", i);
		System.out.printf("f = %f, i2 = %d\n", f, i2);
		System.out.printf("d = %f, i3 = %d\n", d, i3);
		System.out.printf("(int)%f = %d\n", f2, i4);
	}
}



















