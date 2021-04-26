package sw05;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//console font = consolas normal 11
public class Reciepts2 {
	public static void main(String[] args) throws ParseException {
		printer1();
	}
	public static void printer1() throws ParseException {
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy.MM.d HH:mm:ss"); //date format ����
		//�� date format ��ü�� ���� �ŷ��ð�, ��ȯ/ȯ�� ������ ��¿� ����
		DateFormat k42_df = new SimpleDateFormat("MM/dd");
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //date information from SimpleDateFormat
		String k42_TIME2 = k42_df.format(k42_cal.getTime()); //date information from DateFormat
		//to get a refundable date
		Date date = k42_df.parse(k42_TIME2); //�ð� ������ ��� ���ڿ��� parse�ؼ� �����
		k42_cal.setTime(date);
		k42_cal.add(Calendar.DATE, 14); //��ȯ/ȯ���� 14�� �̳� �����ϴ�
		String refundDATE = k42_df.format(k42_cal.getTime());
		
		String HEADER = "               \"���ΰ���, ���̼�\""; //���
		String k42_STORE = "(��)�Ƽ����̼�_�д缭����"; //��ȣ��
		String k42_TEL = "031-702-6016"; //��ȭ��ȣ
		String HQ = "���� ������ ���μ�ȯ�� 2748 (���)";
		String k42_NAME = "������, ��ȣ�� 213-81-52063"; //��ǥ�ڸ�
		String k42_LOCAT = "��⵵ ������ �д籸 �д��53���� 11 (������)"; //�ּ�
		
		System.out.printf("    %s\n", HEADER);
		System.out.printf("%s\n", k42_STORE); //��ȣ�� ���
		System.out.printf("��ȭ: %s\n", k42_TEL); //��ȭ��ȣ ���
		System.out.printf("����: %s\n", HQ);
		System.out.printf("��ǥ : %s\n", k42_NAME); //��ǥ�ڸ� ���
		System.out.printf("����: %s\n", k42_LOCAT); //�ּ� ���
		
		System.out.println("======================================="); //���м�
		System.out.println("        �Һ��� �߽ɰ濵(CCM) �������");
		System.out.println("       ISO 9001 ǰ���濵�ý��� �������");
		System.out.println("======================================="); //���м�
		
		System.out.printf("         ��ȯ/ȯ�� 14��(%s)�̳�,\n", refundDATE); //���� dateformat���� ���� ����
		System.out.println(" (����)������, ����ī�� ���� �� ���Ը��忡�� ����");
		System.out.println("      ����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�");
		System.out.println("        üũī�� ��� �� �ִ� 7�� �ҿ�");
		System.out.println("======================================="); //���м�
		String k42_POS = "1058231"; //�ܸ��� ��ȣ
		System.out.printf("[POS  %s]     %s\n", k42_POS, k42_TIME); //�ܸ��� ��ȣ, ó�� �ð�
		System.out.println("======================================="); //���м�
		
		String item1 = "������� �߶󾲴� ���� ����Ŀ��(4M)";
		int itemNUM1 = 1231231;
		//item1 = item1.substring(0, 14); //���� ���� ���� ����� ���� substring�� ��������� printf�� �̿��� ������ �� ȿ�����̾���
		int k42_price1 = 1000;
		int ea1 = 1;
		int k42_subtotal1 = k42_price1 * ea1; //�Ұ�: ǰ�� �ܰ� * ����
		
		String item2 = "�Ҵ� WF-H800 ������� �̾��� ��ǰ";
		int itemNUM2 = 1004261;
		//item2 = item2.substring(0, 14);
		int k42_price2 = 4000;
		int ea2 = 2;
		int k42_subtotal2 = k42_price2 * ea2;
		
		String item3 = "FUN/��Ƽ ����_��Ƽ��ǰ 107��";
		int itemNUM3 = 1345675;
		//item3 = item3.substring(0, 14);
		int k42_price3 = 3000;
		int ea3 = 1;
		int k42_subtotal3 = k42_price3 * ea3;

		System.out.printf("%-5.14s\t%s %d  %5s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				item1, NumberFormat.getInstance().format(k42_price1),
				ea1, NumberFormat.getInstance().format(k42_subtotal1));
		//õ���� ��ǥ ���� �� ���� ������ �������� �ʰ� �ٷ� printf �ڸ��� ��ġ���� �����
		System.out.printf("[%d]\n", itemNUM1); //ǰ���ȣ
		
		System.out.printf("%-10.14s\t%s %d  %5s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				item2, NumberFormat.getInstance().format(k42_price2),
				ea2, NumberFormat.getInstance().format(k42_subtotal2));
		System.out.printf("[%d]\n", itemNUM2);
		
		System.out.printf("%-10.14s\t%s %d  %5s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				item3, NumberFormat.getInstance().format(k42_price3),
				ea3, NumberFormat.getInstance().format(k42_subtotal3));
		System.out.printf("[%d]\n", itemNUM3);
		
		int sum = k42_subtotal1 + k42_subtotal2 + k42_subtotal3; //�հ� = �Ұ�1 + �Ұ�2 + �Ұ�3
		
		double k42_TAX = 0.1; //���� ���� ���� (10%)
		int netprice = (int) (sum / (1 + k42_TAX)); //����
		int totalTAX = sum - netprice; //�ΰ��� = �հ� - ����
		
		System.out.printf("%15s%34s\n", "�����հ�", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(netprice));
		System.out.printf("%15s%37s\n", "�ΰ���", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(totalTAX));
		System.out.println("---------------------------------------"); //���м�
		System.out.printf("�Ǹ��հ�\t %40s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(sum));
		System.out.println("======================================="); //���м�
		System.out.printf("�ſ�ī��\t %40s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(sum));
		System.out.println("---------------------------------------"); //���м�
		System.out.println("�츮ī��               538720**********");
		System.out.printf("���ι�ȣ 77982843(0)     ���αݾ� %s\n", 
				NumberFormat.getInstance().format(sum));
		System.out.println("======================================="); //���м�
		System.out.printf("%30s �д缭����\n", k42_TIME);
		System.out.println("��ǰ �� ��Ÿ ���� : 1522-4400");
		System.out.println("����� �� �����̼� ���� ���� : 1599-2211");
		
		//���ڵ�
		
		System.out.println("---------------------------------------"); //���м�
		System.out.println("�� ���̼� ����� �� �Ǵ� Ȩ�������� �����ϼż� "
				+ "ȸ������ �� �پ��� ������ ����������! ��");
	}
}
