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
	public static void Variation1() { //�Լ��� ������ ����
		int k42_year = 0; //������ ������ 0���� �ʱ�ȭ�Ѵ� 
		int k42_age = 14; //������ ������ 14�� �ʱ�ȭ�Ѵ�
		
		System.out.println("���1 : " + k42_year);
		System.out.println("���2 : " + k42_age);
		
		k42_year = k42_age + 2000; //������ �ٸ� ������ �ʱ�ȭ�Ѵ�
		k42_age = k42_age + 1; //������ 1�� ���Ѵ�
		
		System.out.println("���3 : " + k42_year);
		System.out.println("���4 : " + k42_age);
	}
	public static void Variation2() {
		int k42_year = 0; //������ ������ 0���� �ʱ�ȭ�Ѵ� 
		int k42_age = 14; //������ ������ 14�� �ʱ�ȭ�Ѵ�
		
		System.out.println("���1 : " + k42_year);
		System.out.println("���2 : " + k42_age);
		
		k42_year = k42_age + 2000; //������ ������ ���� ���Ͽ� �����Ѵ�
		k42_age = k42_age + 1; //������ ���� ����� ���� 1��ŭ ������Ų��
		
		System.out.println("���3 : " + k42_year);
		System.out.println("���4 : " + k42_age);
	}
	public static void Variation3() {
		int k42_x = 10; //���� �� �ʱ�ȭ
		int k42_y = 20;
		int k42_tmp = 0;
		
		System.out.println("x: " + k42_x + "\ny: " + k42_y); 
		// "+"�� �̿��� ���� �κа� ���� �κ��� �Բ� ����� �� �ִ�
		
		k42_tmp = k42_x; //tmp = �ٸ� �� ������ ���� ��ȯ�ϱ� ���� ����
		k42_x = k42_y; //x�� y�� ���� ���� (���� x ���� tmp�� ����Ǿ� �ִ�)
		k42_y = k42_tmp; //���� x�� ���� y�� ����
		
		System.out.println("x: " + k42_x + "\ny: " + k42_y);
	}
	public static void Variation4() {
		//���ڿ� ���� �����ϱ�
		String k42_name = "Ja" + "Va"; //"+"�� �̾�ٿ� ������ �� �ִ�
		String k42_str = k42_name + 8.0; //���� ���� ����ǳ� ���� ������ ������ �� �� ����
		
		System.out.println(k42_name); //��ȣ �ȿ� ���ڿ� ������ ��Ī�� �״�� �־� ����� �� ����
		System.out.println(k42_str);
		
		System.out.println(7 + " "); //�ڿ� space ���
		System.out.println(" " + 7); //�տ� space ���
		System.out.println(7 + ""); //�ڿ� ���� ���
		System.out.println("" + 7);  //�տ� ���� ���
		System.out.println("" + ""); //���鸸 ���
		System.out.println(7 + 7 + ""); //7�� 7�� ���� ���� 14�� ���
		System.out.println("" + 7 + 7); //�տ� ���� ""�� �����ϱ� ������ ���ڵ� ���� ��µ�
	}
	public static void SpecialCharEx1() {
		System.out.println('\''); //" ' "�� ����ϱ� ���ؼ��� �տ� \�� �Բ� �Է��Ѵ�
		System.out.println("abc\t123\b456"); // \t = tab, \b = ���ڸ� ����� ��� ����
		System.out.println('\n'); //����
		System.out.println("\"Hello\""); //���� ���� ū����ǥ�� ����ϴ� ���
		System.out.println("c:\\"); //Ư�� ����, ���丮 ��θ� ����ǥ �ȿ� �Է��ϴ� ���
	}
	public static void ScaanerEX() {
		Scanner k42_scan = new Scanner(System.in); //����� �Է� ���� �ޱ� ���� scanner ��ü ����
		System.out.println("�� �ڸ� ������ �ϳ� �Է����ּ���.>");
		String k42_input = k42_scan.nextLine(); //��ĭ, ������ ���Ե� �� nextLine ���
		
		int k42_num = Integer.parseInt(k42_input); //�Է¹��� String�� ���������� ��ȯ
		
		System.out.println("�Է� ���� : " + k42_input);
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
		
		System.out.printf("b = %d%n", k42_b);  //printf�� �ؽ�Ʈ�� ������ ȥ���Ͽ� ����� �� �ִ�
		System.out.printf("s = %s%n", k42_s);
		System.out.printf("c = %c, %d %n", k42_c, (int)k42_c); //char ���� ASCII�ڵ� �� ���
		
		System.out.printf("finger = [%5d]%n", k42_finger); //������ ����
		System.out.printf("finger = [%-5d]%n", k42_finger); //���� ����
		System.out.printf("finger = [%05d]%n", k42_finger); //���鿡 0 ���
		
		System.out.printf("big = %d%n", k42_big);
		System.out.printf("hex = %#x%n", k42_hex);
		System.out.printf("octNum = %o, %d%n", k42_octNum, k42_octNum); //������ �޾� ��� ��: 8
		System.out.printf("hexNum = %x, %d%n", k42_hexNum, k42_hexNum); //������ �޾� ��� ��: 16
		System.out.printf("bigNum = %s, %d%n", Integer.toBinaryString(k42_binNum), k42_binNum);
		// ������ �޾� ��� ��: 2
	}
	public static void Print2() {
		String k42_url = "www.codechobo.com"; //����, ��ȣ�� ���� String��
		
		float k42_f1 = .10f; //float�� ����
		float k42_f2 = 1e1f;
		float k42_f3 = 3.14e4f;
		double k42_d = 1.23456789; //double�� ����
		
		System.out.printf("f1 = %f, %e, %g%n", k42_f1, k42_f1, k42_f1); //��� ���� Ȯ���ϱ�
		System.out.printf("f2 = %f, %e, %g%n", k42_f2, k42_f2, k42_f2);
		System.out.printf("f3 = %f, %e, %g%n", k42_f3, k42_f3, k42_f3);
		
		System.out.printf("d = %f%n", k42_d); //��� ���� Ȯ���ϱ� 
		System.out.printf("d = %14.10f%n", k42_d); //�Ҽ��� 14�ڸ� �� 10�ڸ� ���
		
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("1. url = [%s]%n", k42_url);
		System.out.printf("2. url = [%20s]%n", k42_url);
		System.out.printf("3. url = [%-20s]%n", k42_url); //������ ����
		System.out.printf("4. url = [%.8s]%n", k42_url); //���ʿ��� 8���ڸ� ���
	}
	public static void OverFlowEx() {
		short k42_sMin = -32768; //short�� ����
		short k42_sMax = 32767;
		char k42_cMin = 0; //char�� ����
		char k42_cMax = 65535;
		//��� ���� ��
		System.out.println("sMin     = " + k42_sMin);
		System.out.println("sMin - 1 = " + (short)(k42_sMin - 1)); //short������ ��ȯ ���
		//����� ��ȯ�Ǿ� ��µȴ�
		System.out.println("sMax     = " + k42_sMax);
		System.out.println("sMax + 1 = " + (short)(k42_sMax + 1)); 
		//������ ��ȯ�Ǿ� ��µȴ�
		System.out.println("cMin     = " + (int)(k42_cMin)); //int������ ��ȯ ���
		System.out.println("cMin - 1 = " + (int)--k42_cMin);
		System.out.println("cMax     = " + (int)k42_cMax);
		System.out.println("cMax + 1 = " + (int)++k42_cMax);
		}
	public static void CastingEx1 () {
		double kp42_d = 85.4; //double�� ����
		int kp42_score = (int)kp42_d; //int�� ���� = d�� ������
		//����Ͽ� ��� Ȯ���ϱ�
		System.out.println("score = " + kp42_score);
		System.out.println("d = " + kp42_d);
	}
	public static void CastingEx2 () {
		int kp42_i = 10; //int�� ����
		byte kp42_b = (byte)kp42_i; //byte�� ���� = i�� byte��
		System.out.printf("[int -> byte] i = %d -> b = %d%n", kp42_i, kp42_b); //����Ͽ� Ȯ��
		
		kp42_i = 300; //int�� ����
		kp42_b = (byte)kp42_i; //byte�� ���� = i�� byte��
		System.out.printf("[int -> byte] i = %d -> b = %d%n", kp42_i, kp42_b); //����Ͽ� Ȯ��
		
		kp42_b = 10; //byte�� ����
		kp42_i = (int)kp42_b; //int�� ���� = b�� int��
		System.out.printf("[byte -> int] b = %d -> i = %d%n", kp42_b, kp42_i); //����Ͽ� Ȯ��
		
		kp42_b = -2; //byte�� ����
		kp42_i = (int)kp42_b; //int�� ���� = b�� int��
		System.out.printf("[byte -> int] b = %d -> i = %d%n", kp42_b, kp42_i); //����Ͽ� Ȯ��
		
		System.out.println("i = " + Integer.toBinaryString(kp42_i));
	}
	public static void CastingEx3() {
		float kp42_f = 9.1234567f; //float�� ����
		double kp42_d = 9.1234567; //double�� ����
		double kp42_d2 = (double)kp42_f;
		//�Ҽ��� �ڸ��� �����Ͽ� ����ϱ�
		System.out.printf("f = %20.18f\n", kp42_f);
		System.out.printf("d = %20.18f\n", kp42_d);
		System.out.printf("d2 = %20.18f\n", kp42_d2);
	}
	public static void CastingEx4() {
		int kp42_i = 12345678; //8�ڸ��� 10����
		float kp42_f= (float)kp42_i; //int to float
		int kp42_i2 = (int)kp42_f; //float to int
		
		double kp42_d = (double)kp42_i; //int to double
		int kp42_i3 = (int)kp42_d; //double to int
		
		float kp42_f2 = 1.666f; 
		int kp42_i4 = (int)kp42_f2; //flaot to int
		//����Ͽ� Ȯ���ϱ�
		System.out.printf("i = %d\n", kp42_i);
		System.out.printf("f = %f, i2 = %d\n", kp42_f, kp42_i2);
		System.out.printf("d = %f, i3 = %d\n", kp42_d, kp42_i3);
		System.out.printf("(int)%f = %d\n", kp42_f2, kp42_i4);
	}
}














