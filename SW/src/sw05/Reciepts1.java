package sw05;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reciepts1 {
	public static void main(String[] args) {
		printer1();
	}
	public static void printer1() {
		String k42_PORT = "2AB2722"; //�ܸ��� ��ȣ
		String k42_printNUM = "041224"; //��ǥ��ȣ
		
		String k42_STORE = "�� ����"; //��ȣ��
		String line = "--------------------------------";
		
		String k42_locat = "���� ����� �����13�� 43"; //�ּ�
		String[] split = k42_locat.split(" ");
		String k42_NAME = "��â��"; //��ǥ�ڸ�
		String k42_IDNUM = "752-53-00558"; //����ڹ�ȣ
		int k42_TEL = 7055695; //��ȭ��ȣ

		System.out.println(" �� �� �� ��"); //header
		System.out.printf("�ܸ��� : %s", k42_PORT); //�ܸ��� ��ȣ ���
		System.out.printf("��ǥ��ȣ : %s\n", k42_printNUM); //��ǥ��ȣ ���
		System.out.printf("������ : %s\n", k42_STORE); //��ȣ�� ���
		
		System.out.printf("��   �� : %s\n", k42_locat); //�ּ� ���
		
		System.out.printf("��ǥ�� : %s\n", k42_NAME); //��ǥ�ڸ� ���
		System.out.printf("����� : %s", k42_IDNUM); //����ڹ�ȣ ���
		System.out.printf("        TEL : %d\n", k42_TEL); //��ȭ��ȣ ���
		System.out.println("--------------------------------"); //���м�
		
		int k42_PRICE = 4800; //���� ���� ����
		double k42_TAX = 0.1; //���� ���� ����
		int k42_TAXPRICE = (int)(k42_PRICE * k42_TAX); //�ΰ��� = ���� * ����
		int k42_NETPRICE = k42_PRICE + k42_TAXPRICE; //�հ� (�Һ��ڰ�)
		//�ݾ� ���� õ���� �޸� ���� ����
		String k42_priceWcomma = NumberFormat.getInstance().format(k42_PRICE); 
		
		//õ���� ��ǥ ����� ���� ���� ������ ���������� printf %s�� �ѹ��� ����ϴ� ���� �� ��������
		
		String k42_taxpriceWcomma = NumberFormat.getInstance().format(k42_TAXPRICE);
		String k42_netpriceWcomma = NumberFormat.getInstance().format(k42_NETPRICE);
		//���� ������ �ݾ�, �ΰ���, �հ� ���
		System.out.printf("%s%4s", "��", "��");
		System.out.printf("%44s", k42_priceWcomma);
		System.out.print(" ��\n"); //������ ���Ǹ� ���� �� ���� ���
		System.out.print("�ΰ���");
		System.out.printf("%44s", k42_taxpriceWcomma);
		System.out.print(" ��\n");
		System.out.printf("%s%4s", "��", "��" );
		System.out.printf("%44s", k42_netpriceWcomma);
		System.out.print(" ��\n");
		System.out.println("--------------------------------"); //���м�
		
		String k42_CARDNUM = "5387-20**-****-4613(S)"; //ī���ȣ
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy / MM / dd / HH:mm:ss"); //date format ����
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //�ð� ���� ȹ��
		System.out.println("�츮ī��");
		System.out.printf("ī���ȣ : %s %4s", k42_CARDNUM, "�Ͻú�\n"); //ī���ȣ ���
		System.out.printf("�ŷ��Ͻ� : %s\n", k42_TIME); //�ŷ� �Ͻ� ���
		System.out.println("���ι�ȣ : 70404427"); //���ι�ȣ ���
		System.out.println("�ŷ���ȣ : 357734873739"); //�ŷ���ȣ ���
		System.out.println("���� : ��ī���     ���� : 720068568"); //ī��� ���� ���
		System.out.println("�� �� : EDC����ǥ");
		System.out.println("���� : TEL) 1544-4700");
		System.out.println("--------------------------------"); //���м�
		System.out.println("                  * �����մϴ� *");
		System.out.println("                    ǥ��V2. 08_20200212");
	}
}
