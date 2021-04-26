package sw05;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//console font = consolas normal 11

public class Test {
	public static void main(String[] args) throws ParseException {
		printer1();
	}
	public static void printer1() throws ParseException {
		//��ǰ��, ���� ������ 30�� ���� �̻��̹Ƿ� ȿ������ ���� selenium, webdriver�� Ȱ���� ũ�Ѹ����� ������ ������
		String[] ITEM = {"�Ƿη� ��纣�� �� 235ml", "[�ȵ�] �Ƿη� ������ 220ml", 
				"����ũ �ݷҺ�� ��Ƽ��Ű�� �������� 1kg (Ȧ��)", "�������ڹߵ� ī��ƿ������ ����Ƽ", 
				"���� �ֹ漼�� ǻ�� 750ml ���ù�", "���� �ֹ漼�� ǻ�� 750ml ����������", 
				"������� ���� ���ǿ���Ÿ 40��", "������� ���� �̽�ƽ���� 40��"};
		
		int[] PRICE = {740000, 7400, 14980, 22000, 65000, 6500, 6500, 6500};
		
		//���� num[]�� 1���� 3������ ���� ������ �����Ѵ�
		int[] num = new int[ITEM.length];
		for(int i = 0; i < ITEM.length; i++) {
			int rand = (int) (Math.random() * 3 + 1);
			num[i] = rand;
		}
		//�鼼ǰ�� ������ ���� ��, ���� �迭
		boolean[] TAXFREE = {true, true, true, true, true, true, 
				true, true, true, true, true, true, 
				true, true, true, true, true, false, 
				true, true, true, false, true, true, 
				true, true, true, true, true, true};
		/*
		boolean[] TAXFREE = {false, false, false, false, false, false, 
				false, false, false, false, false, false, 
				false, false, false, false, false, false, 
				false, false, false, false, false, false, 
				false, false, false, false, false, false};
		*/
		
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy-MM-d HH:mm:ss"); //date format ����
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //�ð� ���� ȹ��
		
		String HEADER = "emart";
		System.out.printf("  %s", HEADER);
		System.out.printf("%33s\n", "�̸�Ʈ ������ (031)888-1234"); //���������� �����Ͽ� ����Ѵ� (printf)
		System.out.printf("%39s\n", "206-85-50913 ����");//���������� �����Ͽ� ����Ѵ� (printf)
		System.out.printf("%37s\n", "���� ������ ������� 552");//���������� �����Ͽ� ����Ѵ� (printf)
		
		System.out.println("������ �������� ��ȯ/ȯ�� �Ұ�"
				+ "\n�����ǰ�� ����, 30�� �̳�(�ż� 7��)"
				+ "\n���Ϻ� �귣����� ����(���� ������ ����)"
				+ "\n��ȯ/ȯ�� ���������� ����(����ī�� ����)\n");
		
		System.out.printf("[�� ��]%s %s\n", k42_TIME, "POS:0011-9861"); //ó�� �ð��� string���� �����Ͽ� ����Ѵ�
		System.out.println("--------------------------------"); //���м�
		System.out.printf("%10s %10s %10s %10s\n", "��ǰ��", "��  ��", "����", "��  ��");
		System.out.println("--------------------------------"); //���м�
		
		int totalamount = 0; //�� ���ż���
		int totalTaxFree = 0; //�� �鼼 ǰ��
		int totalTaxincluded = 0; //�� ���� ǰ��
		
		for(int i = 0; i < ITEM.length; i++) { //������ ����� ���� �ݺ���
			int[] sum = new int[ITEM.length]; //�հ� ������ ���� ���� �迭
			sum[i] = PRICE[i] * num[i];
			if(TAXFREE[i] == false) { //�� �鼼ǰ���̶��
				System.out.printf("* %-10.9s\t%6s\t%d%10s\n", //���������� printf�� �����Ѵ�
						ITEM[i], NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxFree += PRICE[i]*num[i]; //�鼼ǰ�� �հ� = ���� �迭*���� �迭
			} else {
				System.out.printf("   %-10.9s\t%6s\t%d%10s\n", //���������� printf�� �����Ѵ�
						ITEM[i], NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxincluded += PRICE[i]*num[i]; //����ǰ�� �հ�
			}
			
			if((i+1) % 5 == 0) {
				System.out.println("--------------------------------");
				//5������ ���м� ���
			}
			totalamount += num[i];
			//�� ���� ����
		}
		
		double k42_TAX = 0.1; //���� 10%
		int netprice = (int) (totalTaxincluded / (1 + k42_TAX)); //����
		int totalTAX = totalTaxincluded - netprice; //�ΰ��� = ���� ���� - ����
		int totalPRICE = totalTaxFree + totalTaxincluded + totalTAX; //�� ���űݾ� = �鼼ǰ�� + ����ǰ�� + �ΰ���
		
		System.out.println(); //���� ���
		System.out.printf("%22s%30d\n", "�� ǰ�� ����", totalamount);
		System.out.printf("%23s%30s\n", " (*)�鼼 ��ǰ", 
				NumberFormat.getInstance().format(totalTaxFree)); //õ���� ��ǥ ����
		System.out.printf("%24s%27s\n", "���� ��ǰ", //���� �������� printf ������
				NumberFormat.getInstance().format(totalTaxincluded));
		System.out.printf("%19s%4s%4s%27s\n", "��", "��", "��", 
				NumberFormat.getInstance().format(totalTAX));
		System.out.printf("%20s%9s%27s\n", "��", "��", 
				NumberFormat.getInstance().format(totalPRICE));
		System.out.printf("%-15s%32s\n", " �� �� �� �� �� ��", //-15 = ���� ����
				NumberFormat.getInstance().format(totalPRICE)); //���� ��� �ݾ� = �հ� �ݾ�
		System.out.println("--------------------------------");
		System.out.printf("%-15s%24s\n", "0012 KEB �ϳ�", "541707**0484/35860658");//���Ƿ� ������ ī���ȣ
		System.out.printf("ī�����(IC) %22s %s\n", "�Ͻú� /", NumberFormat.getInstance().format(totalPRICE)); //���� �ݾ� ���
		System.out.println("--------------------------------");
		System.out.printf("%30s\n","[�ż��� ����Ʈ ����]");
		System.out.println("***������ ����Ʈ ��Ȳ�Դϴ�.");
		int point = 164; //��ȸ �߻� ����Ʈ
		int pointTOTAL = 5637; //���� ����Ʈ
		int pointA = pointTOTAL - point; //���� ����Ʈ = ���� - ��ȸ �߻�
		
		System.out.printf("%-10.10s %19s  %7d\n", 
				"��ȸ�߻�����Ʈ", "9350**9995", point);
		System.out.printf("%-10.10s %19s(   %8s)\n", 
				"����(����)����Ʈ", NumberFormat.getInstance().format(pointTOTAL),  //õ���� ��ǥ ����
				NumberFormat.getInstance().format(pointA));
		System.out.println("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");
		System.out.println("--------------------------------");
		System.out.printf("%24s\n", "���űݾױ��� ���������ð� �ڵ��ο�");
		System.out.printf("%-10s %34s\n", "������ȣ :", "38��****"); //���� ���� ������ȣ
		System.out.printf("%s %37s\n", "�����ð� : ", k42_TIME); //�����ð� = ó���ð� or ���� ����
		System.out.println("--------------------------------");
		System.out.printf("%s %36s", "ĳ��:084599 ��00", "1150");
		
	}
}
