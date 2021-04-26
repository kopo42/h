package sw01;

import java.util.Scanner;

public class VarEx1 { //Ŭ���� ����

	public static void main(String[] args) { //���α׷��� ������ ���� �Լ�
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
		int kp42_year = 0; //������ ������ �����ϰ� 0���� �ʱ�ȭ
		int kp42_age = 14; //������ ������ �����ϰ� 14�� �ʱ�ȭ
		
		System.out.println("Result 1:" + kp42_year); //������ ������ �������� ���
		System.out.println("Result 2: " + kp42_age);
		
		kp42_year = kp42_age + 2000; //age�� 2000��ŭ ���� ���� year�� ����
		kp42_age = kp42_age + 1; //����� ���� 1 ����
		
		System.out.println("Result 3: " + kp42_year); //��ȭ�� ���� �� ���
		System.out.println("Result 4: " + kp42_age);
	}
	
	public static void kp42_VarEx2() {
		//������ �������� �����ϰ� �ʱ�ȭ
		int x = 10;
		int y = 20;
		int tmp = 0;
		
		System.out.println("x: " + x + " y: " + y); //ó�� �ʱ�ȭ�� ���� ���
		
		tmp = x;
		x = y;
		y = tmp;
		//x, y���� ��ȯ�ϱ� ���� tmp��� ������ �߰��� �����ߴ�
		System.out.println("x: " + y + " y: " + y); //��ȯ�� ���� ���
	}
	
	public static void kp42_StringEX() {
		String name = "Ja" + "va"; //"Java" ���
		String str = name + 8.0; //8.0�� �״�� String ������
		
		System.out.println(name); //"Java"
		System.out.println(str); //"Java8.0"
		System.out.println(7 + " "); //7 + ��ĭ ���
		System.out.println(" " + 7); //��ĭ + 7
		System.out.println(7 + ""); //7 + ����
		System.out.println("" + 7); //���� + 7
		System.out.println("" + ""); //���� + ����
		System.out.println(7 + 7+ ""); //7 + 7 = 14, + ����
		System.out.println("" + 7 + 7); //����, 7, 7 ���
	}
	public static void kp42_SpecialCharEx() {
		System.out.println('\''); //'�� "�� ����ϰ� ���� ��
		System.out.println("abc/t123/b456"); // /b�� ���� 3�� ������
		System.out.println("\n"); //�ٹٲ� ���
		System.out.println("\"Hello\""); //"����ϱ�
		System.out.println("C: \\"); // \�Ѱ�����
	}
	public static void kp42_ScanneEx() {
		Scanner scan = new Scanner(System.in); //scanner ��ü �����
		System.out.print("���ڸ� ������ �ϳ� �Է��ϼ��� .> "); //���� ����� ���� ����
		
		String input = scan.nextLine(); //string input�� ������ �Է¹޴� ��
		int num = Integer.parseInt(input); //�Է¹��� string���� ���������� ��ȯ
		
		System.out.println("�Է� ����: " + input); //�Է¹��� �� ���
		System.out.printf("num = %d%n", num); //������ ���
	}
	public static void kp42_PrintEx1() {
		byte b = 1; //byte�� ����
		short s = 2; //short�� ����
		char c = 'A'; //char�� ����
		
		int finger = 10; //int�� ����
		long big = 100000000000L; //long�� ����
		long hex = 0xFFFFFFFFFFFFFFFFL;
		
		int octNum = 010; //8���� 10, 10���� 8
		int hexNum = 0x10; //16���� 10, 10���� 16
		int binNum = 0b10; //2���� 10, 10���� 2
		
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
		String url = "www.codechobo.com"; //����, ��ȣ�� ���� String��
		
		float f1 = .10f; //float�� ����
		float f2 = 1e1f;
		float f3 = 3.14e4f;
		double d = 1.23456789; //double�� ����
		
		System.out.printf("f1 = %f, %e, %g%n", f1, f1, f1); //��� ���� Ȯ���ϱ�
		System.out.printf("f2 = %f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3 = %f, %e, %g%n", f3, f3, f3);
		
		System.out.printf("d = %f%n", d); //��� ���� Ȯ���ϱ� 
		System.out.printf("d = %14.10f%n", d); //�Ҽ��� 14�ڸ� �� 10�ڸ� ���
		
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("1. url = [%s]%n", url);
		System.out.printf("2. url = [%20s]%n", url);
		System.out.printf("3. url = [%-20s]%n", url); //������ ����
		System.out.printf("4. url = [%.8s]%n", url); //���ʿ��� 8���ڸ� ���
	}
	public static void kp42_OverFlowEx() {
		short sMin = -32768; //short�� ����
		short sMax = 32767;
		char cMin = 0; //char�� ����
		char cMax = 65535;
		//��� ���� ��
		System.out.println("sMin     = " + sMin);
		System.out.println("sMin - 1 = " + (short)(sMin - 1)); //short������ ��ȯ ���
		System.out.println("sMax     = " + sMax);
		System.out.println("sMax + 1 = " + (short)(sMax + 1)); 
		System.out.println("cMin     = " + (int)(cMin)); //int������ ��ȯ ���
		System.out.println("cMin - 1 = " + (int)--cMin);
		System.out.println("cMax     = " + (int)cMax);
		System.out.println("cMax + 1 = " + (int)++cMax);
		}
}

















