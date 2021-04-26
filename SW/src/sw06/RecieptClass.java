package sw06;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//����ü10

public class RecieptClass {
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		TitlePrint();
		HeaderPrint();
		itemPrint();
	}
	
	public static void TitlePrint() {
		String k42_HEADER = "emart"; //�귣�� �ΰ�
		System.out.printf("\n  %s", k42_HEADER); //�ٹٲ� ���� ���� ������ ���� �ٿ� ���
		System.out.printf("%25s\n", "�̸�Ʈ ������ (031)888-1234"); //�������� �����Ͽ� ����Ѵ� (printf)
		System.out.printf("%27s\n", "206-85-50913 ����");//�������� �����Ͽ� ����Ѵ� (printf)
		System.out.printf("%26s\n\n", "���� ������ ������� 552");//�������� �����Ͽ� ����Ѵ� (printf)
		
		System.out.println("������ �������� ��ȯ/ȯ�� �Ұ�"
				+ "\n�����ǰ�� ����, 30�� �̳�(�ż� 7��)"
				+ "\n���Ϻ� �귣����� ����(���� ������ ����)"
				+ "\n��ȯ/ȯ�� ���������� ����(����ī�� ����)\n");
	}
	
	public static void HeaderPrint() {
		String k42_TIME = TimeStemp();
		
		System.out.printf("[�� ��]%s%19s\n", k42_TIME.substring(0, 16), "POS:0011-9861"); //ó�� �ð��� string���� �����Ͽ� ����Ѵ�
		System.out.println("------------------------------------------"); //���м�
		System.out.printf("%8s%14s%4s%7s\n", "��ǰ��", "�� ��", "����", "�� ��");
		System.out.println("------------------------------------------"); //���м�
	}
	
	public static void itemPrint() throws UnsupportedEncodingException {
		//��ǰ��, ���� ������ 30�� ���� �̻��̹Ƿ� �̸�Ʈ ��ǰ ���������� ������
		String[] k42_ITEM = {"�Ƿη� ��纣�� �� 235ml", "[�ȵ�] �Ƿη� ������ 220ml", 
				"����ũ �ݷҺ�� ��Ƽ��Ű�� �������� 1kg (Ȧ��)", "�������ڹߵ� ī��ƿ������ ����Ƽ", 
				"���� �ֹ漼�� ǻ�� 750ml ���ù�", "���� �ֹ漼�� ǻ�� 750ml ����������", 
				"������� ���� ���ǿ���Ÿ 40��", "������� ���� �̽�ƽ���� 40��", "���� ����Ʈ ����ŷ�Ҵ� 3L+200ml", 
				"���� ����Ʈ ��Ŭ�� 3L+200ml", "[������] ��������ġ1.6kg", "�������ڹߵ� ī��ƿ������ �佺ī��", 
				"����ũ Ʈ����� 330ml", "���������� Ȳ��濪 ����ũ KF94 (����) 1�� FDA��� (�ѱ�����/�ѱ���������/��������)", 
				"������ ���� �������ݸ� 60g", "�������� �Ƚɸ�Ʈ 10p", "[�Ե�] �㽬[HERSHEY`S] �̴Ͼ�ó 155g", 
				"(G)����ũ ����� ��״�� 100g*2��", "[����ũ] Ʈ�� ����Ŭ�� ����(500ml��6��)", 
				"[����ũ] Ʈ�罺��Ŭ�� �ڸ�(500ml��6��)", "����ũ �ֹٺ�ťġŲ300g", 
				"[20���] �س����̾߱�10kg(����)", "[����ũ] ������ ����Ʈ���� 200g", 
				"[����ũ] ���� �׷���� 380g", "[����ũ] �����ö��� ����Ƣ�� 400g", 
				"[����ũ] ������ �׷���� 380g", "����ũ ī������ں� 260g", "����ũ ����ȭ��Ʈ �������ں� 170g", 
				"[����ũ] �־ؽ����̽� ����Ƣ�� 400g", "[�����׸�] ����û���� �ķ�������Ʈ 750ml [�Ǿ��ǰ]"};
		
		int[] k42_PRICE = {1200, 1200, 14980, 22000, 6500, 6500, 6500, 6500, 9900, 9900, 
				12900, 37000, 1680, 3500, 8260, 2415, 3080, 3486, 3570, 3570, 
				3836, 29800, 4186, 4186, 4186, 4186, 4886, 1000, 5586, 1250000};
		
		//���� num[]�� 1���� 3������ ���� ������ �����Ѵ�
		int[] k42_num = new int[k42_ITEM.length];
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i++) {
			int k42_rand = (int) (Math.random() * 3 + 1);
			k42_num[k42_i] = k42_rand;
		}
		int[] k42_amount = {1,2,3,4,5, //���� ���� ������ �迭
				1,2,3,4,5,1,2,3,4,5,
				1,2,3,4,5,1,2,3,4,5,
				1,2,3,4,5};
		
		//�鼼ǰ�� ������ ���� ��, ���� �迭
		boolean[] k42_TAXincluded = {true, true, true, true, true, true, 
				true, true, true, true, true, true, 
				true, true, true, true, true, false, 
				true, true, true, false, true, true, 
				true, true, true, true, true, true};
		
		int[] k42_sum = new int[k42_ITEM.length]; //�հ� ������ ���� ���� �迭
		int k42_totalamount = 0; //�� ���ż���
		int k42_totalTaxFree = 0; //�� �鼼 ǰ��
		int k42_totalTaxincluded = 0; //�� ���� ǰ��
		
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i++) { //������ ����� ���� �ݺ���
			k42_sum[k42_i] = k42_PRICE[k42_i] * k42_amount[k42_i];
			// k42_TAXincluded[k42_i] alltrue[k42_i]  allfalse[k42_i]
			
			//����ǰ��
			if(k42_TAXincluded[k42_i] == false) { //�� �鼼ǰ���̶��
				System.out.printf("* %s%10s%3d%11s\n", printBlank(strCut(k42_ITEM[k42_i], 16), 16), //strCut���� 16��ŭ �ڸ� �� ���� ä����
						NumberFormat.getInstance().format(k42_PRICE[k42_i]),
						k42_amount[k42_i], NumberFormat.getInstance().format(k42_sum[k42_i]));
				k42_totalTaxFree += k42_PRICE[k42_i] * k42_amount[k42_i]; //�鼼ǰ�� �հ� = ���� �迭*���� �迭
			} //����ǰ�� 
			else {
				System.out.printf("  %s%10s%3d%11s\n", printBlank(strCut(k42_ITEM[k42_i], 16), 16), 
						NumberFormat.getInstance().format(k42_PRICE[k42_i]),
						k42_amount[k42_i], NumberFormat.getInstance().format(k42_sum[k42_i]));
				k42_totalTaxincluded += k42_PRICE[k42_i] * k42_amount[k42_i]; //����ǰ�� �հ�
			}
			if((k42_i + 1) % 5 == 0) {
				System.out.println("------------------------------------------");
				//5������ ���м� ���
				//i % 5�� �������� ���� �� ITEM[0]���� ���м��� ��µ�
			}
			k42_totalamount ++;
			//�� ���� ����
		}
		TotalPrint(k42_totalamount, k42_totalTaxFree, k42_totalTaxincluded);
	}
	
	public static void TotalPrint(int k42_totalamount, int k42_totalTaxFree, int k42_totalTaxincluded) {
		String k42_TIME = TimeStemp();
		
		double k42_TAX = 0.1; //���� 10%
		int k42_netprice = (int) (k42_totalTaxincluded / (1 + k42_TAX)); //����
		int k42_totalTAX = k42_totalTaxincluded - k42_netprice; //�ΰ��� = ���� ���� - ����
		int k42_totalPRICE = k42_totalTaxFree + k42_netprice + k42_totalTAX; //�� ���űݾ� = �鼼ǰ�� + ����ǰ�� + �ΰ���
		
		System.out.println(); //���� ���
		System.out.printf("%16s%2s%s%2s%s%15d\n", "��", "ǰ", "��", "��", "��", k42_totalamount); //��Ȯ�� ������ ���� ���� �ϳ��ϳ� ���� ����
		System.out.printf("%15s%s%2s%3s%2s%15s\n", "(*)","��", "��","��", "ǰ", 
				NumberFormat.getInstance().format(k42_totalTaxFree)); //õ���� ��ǥ ����
		System.out.printf("%16s%2s%3s%2s%15s\n", "��", "��", "��", "ǰ", //���� �������� printf ������
				NumberFormat.getInstance().format(k42_netprice));
		System.out.printf("%16s%4s%4s%15s\n", "��", "��", "��", 
				NumberFormat.getInstance().format(k42_totalTAX));
		System.out.printf("%16s%9s%15s\n", "��", "��", 
				NumberFormat.getInstance().format(k42_totalPRICE));
		System.out.printf("%s%2s%2s%2s%2s%2s%25s\n", "��", "��", "��", "��", "��", "��", //-15 = ���� ���� (printf ����)
				NumberFormat.getInstance().format(k42_totalPRICE)); //���� ��� �ݾ� = �հ� �ݾ�
		System.out.println("------------------------------------------");
		System.out.printf("%-15s%25s\n", "0012 KEB �ϳ�", "541707**0484/35860658");//���Ƿ� ������ ī���ȣ
		
		String k42_topay = "�Ͻú� / " + NumberFormat.getInstance().format(k42_totalPRICE);
		//��Ȯ�� ������ ������ ���� "���αݾ�", ����1, sum�� ������ �ϳ��� ���ڿ��� �������
		
		System.out.printf("ī�����(IC)%27s\n", k42_topay); //���� �ݾ� ���
		System.out.println("------------------------------------------");
		System.out.printf("%23s\n","[�ż��� ����Ʈ ����]");
		System.out.println("***������ ����Ʈ ��Ȳ�Դϴ�.");
		int k42_point = 164; //��ȸ �߻� ����Ʈ
		int k42_pointTOTAL = 5637; //���� ����Ʈ
		int k42_pointA = k42_pointTOTAL - k42_point; //���� ����Ʈ = ���� - ��ȸ �߻�
		
		System.out.printf("%-10.10s%18s%7d\n", 
				"��ȸ�߻�����Ʈ", "9350**9995", k42_point);
		System.out.printf("%-10.10s%13s(%10s)\n", 
				"����(����)����Ʈ", NumberFormat.getInstance().format(k42_pointTOTAL),  //õ���� ��ǥ ����
				NumberFormat.getInstance().format(k42_pointA));
		System.out.println("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");
		System.out.println("------------------------------------------");
		System.out.printf("%22s\n", "���űݾױ��� ���������ð� �ڵ��ο�");
		System.out.printf("%-10s %26s\n", "������ȣ :", "38��****"); //���� ���� ������ȣ
		System.out.printf("%s %30s\n", "�����ð� : ", k42_TIME); //�����ð� = ó���ð� or ���� ����
		System.out.println("------------------------------------------");
		System.out.printf("%s%5s%25s\n", "ĳ��:084599", "��00", "1150"); //���� ���� ĳ�� ����
		
		System.out.printf("\n%35s\n", "||| || ||||| ||||| || |||||"); //���ڵ� ��ġ ����
		System.out.printf("%35s\n", "||| || ||||| ||||| || |||||");
		System.out.printf("%15s%s", k42_TIME.substring(0, 10).replace("-", ""), "/00119861/00164980/31"); 
		//SimpleDateFormat���� ���� �ð� ������ ��, ��, �ϱ����� �߶� �� "-"�� �����Ͽ� ������ ����ó�� �����
	}
	
	public static String TimeStemp() {
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy-MM-d HH:mm:ss"); //date format ����
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //�ð� ���� ȹ��
		return k42_TIME;
	}
	
	public static String printBlank(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//���� Ÿ�Կ� ���� ���� ���� �����ϱ� ���� �Լ�
		//k42_str = ���� ���ڿ�, k42_i = ������ �����Ͽ� ����� ���ڼ�
		int k42_strBytes = k42_str.getBytes("MS949").length; //���� ���ڿ��� byte���� ������ ����
		//MS949 ���ڵ� �� �ѱ� �� ���� �� 2Byte
		int k42_blank = 0; //���� �� ���� ����
			k42_blank = k42_strBytes; //���� int i ���� blank�� ���� �� ��ŭ ���� ���
		
		String k42_result = "";
		k42_result += k42_str; //return�� �� result�� ���� ���ڿ� ���� ����
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //���ڿ� �ڿ� ���� ����
		}
		return k42_result; //ó�� �� ���� ���ڿ�
	}
	
	public static String strCut(String k42_str, int k42_length){
		// ���ڿ��� ����Ʈ ������ �ڸ��� ���� �Լ�         
		String k42_result = k42_str; //���� ���ڿ�
		int k42_oL = 0, k42_rF = 0, k42_rL = 0;
		try {
			byte[] k42_bytes = k42_result.getBytes("UTF-8"); //����Ʈ�� ���ڵ��Ͽ� �迭�� ����
			int k42_j = 0;
			k42_j = k42_rF;
			while(k42_j < k42_bytes.length) { //����Ʈ ���� ������
				if((k42_bytes[k42_j] & 0x80) != 0) { //�ѱ� ���ڵ� ����
					if(k42_oL+2 > k42_length) { //������ ���̸� �ʰ��ߴٸ� �ݺ��� Ż��
						break;
					} 
					k42_oL+=2; k42_rL+=3; k42_j+=3;
					} else {
						if(k42_oL+1 > k42_length) { //������ ���̸� �ʰ��ߴٸ� �ݺ��� Ż��
						break;
					} 
					++k42_oL; ++k42_rL; ++k42_j; //1�� �߰��Ѵ�
					}       
				}       
			k42_result = new String(k42_bytes, k42_rF, k42_rL, "UTF-8");  // charset �ɼ� ��� (String class)
		} catch(UnsupportedEncodingException e){  //����ó��
			e.printStackTrace();  //���� ����, ��ġ ���
		} 
		return k42_result;   
	}
}
