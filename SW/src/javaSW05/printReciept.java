package javaSW05;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class printReciept {
	public static void main(String[] args) {
		printer1();
	}
	public static void printer1() {
		String k42_PORT = "2AB2722"; //�ܸ��� ��ȣ
		String k42_printNUM = "041224"; //��ǥ��ȣ
		
		String k42_STORE = "�� ����"; //��ȣ��
		
		String k42_locat = "���� ����� �����13�� 43"; //�ּ�
		String k42_NAME = "��â��"; //��ǥ�ڸ�
		String k42_IDNUM = "752-53-00558"; //����ڹ�ȣ
		int k42_TEL = 70556915; //��ȭ��ȣ

		System.out.println("�� �� �� ��"); //header
		System.out.printf("�ܸ��� : %s", k42_PORT); //�ܸ��� ��ȣ ���
		System.out.printf("         ��ǥ��ȣ : %s\n", k42_printNUM); //��ǥ��ȣ ���
		System.out.printf("������ : %s\n", k42_STORE); //��ȣ�� ���
		
		System.out.printf("��  �� : %s\n", k42_locat); //�ּ� ���
		
		System.out.printf("��ǥ�� : %s\n", k42_NAME); //��ǥ�ڸ� ���
		System.out.printf("����� : %s", k42_IDNUM); //����ڹ�ȣ ���
		System.out.printf("%13s%5d\n", "TEL :", k42_TEL); //��ȭ��ȣ ���
		System.out.println("------------------------------------------"); //���м�
		
		int k42_PRICE = 4800; //���� ���� ����
		double k42_TAX = 0.1; //���� ���� ����
		int k42_netprice = (int) (k42_PRICE / (1 + k42_TAX)); //���� = (������ ��ȯ) �հ� / (1 + ����) = �հ� + �հ�*����
		int k42_totalTAX = k42_PRICE - k42_netprice; //�ΰ��� = �հ� - ����
		
		//���� ������ �ݾ�, �ΰ���, �հ� ���
		System.out.printf("%s%5s", "��", "��");
		System.out.printf("%31s", NumberFormat.getInstance().format(k42_netprice)); //���� ���
		System.out.print(" ��\n"); //������ ���Ǹ� ���� "��" ���� ���
		
		System.out.printf("%s%2s%2s", "��", "��", "��");
		System.out.printf("%31s",
				NumberFormat.getInstance().format(k42_totalTAX)); //�ΰ��� ���
		System.out.print(" ��\n");
		
		System.out.printf("%s%5s", "��", "��" );
		System.out.printf("%31s", 
				NumberFormat.getInstance().format(k42_PRICE)); //�հ踸 ����
		System.out.print(" ��\n");
		System.out.println("------------------------------------------"); //���м�
		
		String k42_CARDNUM = "5387-20**-****-4613(S)"; //ī���ȣ
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //date format ����
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //�ð� ���� ȹ��
		System.out.println("�츮ī��"); //���� ����
		System.out.printf("ī���ȣ : %s%7s", k42_CARDNUM, "�Ͻú�\n"); //ī���ȣ ���
		System.out.printf("�ŷ��Ͻ� : %s\n", k42_TIME); //�ŷ� �Ͻ� ���
		System.out.println("���ι�ȣ : 70404427"); //���ι�ȣ ���
		System.out.println("�ŷ���ȣ : 357734873739"); //�ŷ���ȣ ���
		System.out.printf("%s%20s\n", "���� : ��ī���", "���� : 720068568"); //ī��� ���� ���
		System.out.println("�˸� : EDC����ǥ");
		System.out.println("���� : TEL)1544-4700");
		System.out.println("------------------------------------------"); //���м�
		System.out.printf("%24s\n", "* �����մϴ� *");
		System.out.printf("%40s\n", "ǥ��V2. 08_20200212");
	}
}
