package sw05;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

//console font = consolas normal 11

public class Reciepts3 {
	public static void main(String[] args) throws ParseException {
		printer1();
	}
	public static void printer1() throws ParseException {
		//��ǰ��, ���� ������ 30�� ���� �̻��̹Ƿ� �̸�Ʈ ��ǰ ���������� ������
		String[] ITEM = {"�Ƿη� ��纣�� �� 235ml", "[�ȵ�] �Ƿη� ������ 220ml", 
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
		
		int[] PRICE = {1200, 1200, 14980, 22000, 6500, 6500, 6500, 6500, 9900, 9900, 
				12900, 37000, 1680, 3500, 8260, 2415, 3080, 3486, 3570, 3570, 
				3836, 29800, 4186, 4186, 4186, 4186, 4886, 1000, 5586, 5880};
		
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
		
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy-MM-d HH:mm:ss"); //date format ����
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //�ð� ���� ȹ��
		
		String HEADER = "emart";
		System.out.printf("  %s", HEADER);
		System.out.printf("%25s\n", "�̸�Ʈ ������ (031)888-1234"); //���������� �����Ͽ� ����Ѵ� (printf)
		System.out.printf("%35s\n", "206-85-50913 ����");//���������� �����Ͽ� ����Ѵ� (printf)
		System.out.printf("%29s\n", "���� ������ ������� 552");//���������� �����Ͽ� ����Ѵ� (printf)
		
		System.out.println("������ �������� ��ȯ/ȯ�� �Ұ�"
				+ "\n�����ǰ�� ����, 30�� �̳�(�ż� 7��)"
				+ "\n���Ϻ� �귣����� ����(���� ������ ����)"
				+ "\n��ȯ/ȯ�� ���������� ����(����ī�� ����)\n");
		
		System.out.printf("[�� ��]%s%14s\n", k42_TIME, "POS:0011-9861"); //ó�� �ð��� string���� �����Ͽ� ����Ѵ�
		System.out.println("------------------------------------------"); //���м�
		System.out.printf("%12s %12s %5s %5s\n", "��ǰ��", "�� ��", "����", "�� ��");
		System.out.println("------------------------------------------"); //���м�
		
		int[] sum = new int[ITEM.length]; //�հ� ������ ���� ���� �迭
		int totalamount = 0; //�� ���ż���
		int totalTaxFree = 0; //�� �鼼 ǰ��
		int totalTaxincluded = 0; //�� ���� ǰ��
		
		for(int i = 0; i < ITEM.length; i++) { //������ ����� ���� �ݺ���
			sum[i] = PRICE[i] * num[i];
			if(TAXFREE[i] == false) { //�� �鼼ǰ���̶��
				System.out.printf(" * %-10.6s %10s\t%4d%10s\n", //���������� printf�� �����Ѵ�
						strCut(ITEM[i], null, 11, 0, true, true), NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxFree += PRICE[i]*num[i]; //�鼼ǰ�� �հ� = ���� �迭*���� �迭
			} else {
				System.out.printf("   %-10.6s %10s\t%4d%10s\n", //���������� printf�� �����Ѵ�
						strCut(ITEM[i], null, 11, 0, true, true), NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxincluded += PRICE[i]*num[i]; //����ǰ�� �հ�
			}
			if((i+1) % 5 == 0) {
				System.out.println("------------------------------------------");
				//5������ ���м� ���
			}
			totalamount ++;
			//�� ���� ����
		}

		
		double k42_TAX = 0.1; //���� 10%
		int netprice = (int) (totalTaxincluded / (1 + k42_TAX)); //����
		int totalTAX = totalTaxincluded - netprice; //�ΰ��� = ���� ���� - ����
		int totalPRICE = totalTaxFree + totalTaxincluded + totalTAX; //�� ���űݾ� = �鼼ǰ�� + ����ǰ�� + �ΰ���
		
		System.out.println(); //���� ���
		System.out.printf("%12s%4s%4s%17d\n", "��", "ǰ��", "����", totalamount);
		System.out.printf("%13s%4s%4s%17s\n", "(*)","�鼼","��ǰ", 
				NumberFormat.getInstance().format(totalTaxFree)); //õ���� ��ǥ ����
		System.out.printf("%17s%4s%17s\n", "����", "��ǰ", //���� �������� printf ������
				NumberFormat.getInstance().format(totalTaxincluded));
		System.out.printf("%16s%3s%3s%17s\n", "��", "��", "��", 
				NumberFormat.getInstance().format(totalTAX));
		System.out.printf("%16s%7s%17s\n", "��", "��", 
				NumberFormat.getInstance().format(totalPRICE));
		System.out.printf("%-15s%21s\n", " �� �� �� �� �� ��", //-15 = ���� ����
				NumberFormat.getInstance().format(totalPRICE)); //���� ��� �ݾ� = �հ� �ݾ�
		System.out.println("------------------------------------------");
		System.out.printf("%-15s%29s\n", "0012 KEB �ϳ�", "541707**0484/35860658");//���Ƿ� ������ ī���ȣ
		System.out.printf("ī�����(IC)%22s  %s\n", "�Ͻú� /", NumberFormat.getInstance().format(totalPRICE)); //���� �ݾ� ���
		System.out.println("------------------------------------------");
		System.out.printf("%30s\n","[�ż��� ����Ʈ ����]");
		System.out.println("***������ ����Ʈ ��Ȳ�Դϴ�.");
		int point = 164; //��ȸ �߻� ����Ʈ
		int pointTOTAL = 5637; //���� ����Ʈ
		int pointA = pointTOTAL - point; //���� ����Ʈ = ���� - ��ȸ �߻�
		
		System.out.printf("%-10.10s %19s  %7d\n", 
				"��ȸ�߻�����Ʈ", "9350**9995", point);
		System.out.printf("%-10.10s %15s(   %8s)\n", 
				"����(����)����Ʈ", NumberFormat.getInstance().format(pointTOTAL),  //õ���� ��ǥ ����
				NumberFormat.getInstance().format(pointA));
		System.out.println("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");
		System.out.println("------------------------------------------");
		System.out.printf("%24s\n", "���űݾױ��� ���������ð� �ڵ��ο�");
		System.out.printf("%-10s %30s\n", "������ȣ :", "38��****"); //���� ���� ������ȣ
		System.out.printf("%s %34s\n", "�����ð� : ", k42_TIME); //�����ð� = ó���ð� or ���� ����
		System.out.println("------------------------------------------");
		System.out.printf("%s %29s", "ĳ��:084599 ��00", "1150");

		
	}/*
	"�����ٶ�" ���� 2����Ʈ���� �ڸ��� ������� strCut("�����ٶ�", 2, 0, true); ó�� �Ͻø� �˴ϴ�.
 => ��� : "��"                            (String szText, int nLength, int nPrev, boolean isAdddot)

"�����ٶ�" ���� "��"��� Ű���� ���ؿ��� 2����Ʈ���� �ڸ��������� strCut("�����ٶ�", "��", 2, 0, true, true); ó�� �Ͻø� �˴ϴ�.

��ó: https://cublip.tistory.com/102 [HeBhy, since 1983.]
*/
	
	
	public static String strCut(String szText, String szKey, int nLength, int nPrev, boolean isNotag, boolean isAdddot){
		// ���ڿ� �ڸ���         
		String r_val = szText;     
		int oF = 0, oL = 0, rF = 0, rL = 0;     
		int nLengthPrev = 0;     
		//Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE); 
		// �±����� ����         
		//if(isNotag) {r_val = p.matcher(r_val).replaceAll("");}  // �±� ����     
		//r_val = r_val.replaceAll("&amp;", "&");     
		//r_val = r_val.replaceAll("(!/|\r|\n|&nbsp;)", "");  // ��������       
		try {       byte[] bytes = r_val.getBytes("UTF-8");     // ����Ʈ�� ����       
		if(szKey != null && !szKey.equals("")) {
			nLengthPrev = (r_val.indexOf(szKey) == -1)? 0: r_val.indexOf(szKey);  // �ϴ� ��ġã��         
			nLengthPrev = r_val.substring(0, nLengthPrev).getBytes("MS949").length;  // ��ġ�������̸� byte�� �ٽ� ���Ѵ�
			nLengthPrev = (nLengthPrev-nPrev >= 0)? nLengthPrev-nPrev:0;    // �� �պκк��� �����������Ѵ�.       
			}           // x���� y���̸�ŭ �߶󳽴�. �ѱ۾ȱ�����.       
		int j = 0;       
		if(nLengthPrev > 0) while(j < bytes.length) {
			if((bytes[j] & 0x80) != 0) {
				oF+=2; rF+=3; 
				if(oF+2 > nLengthPrev) {break;} 
				j+=3;         
				} else {if(oF+1 > nLengthPrev) {break;} ++oF; ++rF; ++j;}       
			}             
		j = rF;
		while(j < bytes.length) {
			if((bytes[j] & 0x80) != 0) {
				if(oL+2 > nLength) {break;} oL+=2; rL+=3; j+=3;
				} else {if(oL+1 > nLength) {break;} ++oL; ++rL; ++j;}       
			}       r_val = new String(bytes, rF, rL, "UTF-8");  // charset �ɼ�    
			List<String> list = new ArrayList<String>();
			List<String> space = new ArrayList<String>();
			String kor = "^[��-����-�Ӱ�-�R]*$"; //�ѱ۸� �ν�
			//[����ũ] ����
			int Ecnt = 0;
			for(int k = 0; k < szText.length(); k++) { //10���� ������
				boolean korONLY = String.valueOf(szText.charAt(k)).matches(kor);
				if (korONLY = false) { //Ư�����ڳ� �����̶��
					r_val += "/";
					//Ecnt++; //substring �� Ư�������� ���� (int)
				}
			}
		} catch(UnsupportedEncodingException e){ e.printStackTrace(); } 
		return r_val;   
		}
}
