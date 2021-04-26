package javaSW05;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class printDaiso {
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		printer1();
	}
	public static void printer1() throws ParseException, UnsupportedEncodingException {
		Calendar k42_cal = Calendar.getInstance(); //��¥ ����� ���� calendar ��ü
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); //date format ����
		//�� date format ��ü�� ���� �ŷ��ð�, ��ȯ/ȯ�� ������ ��¿� ����
		DateFormat k42_df = new SimpleDateFormat("MM/dd");
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //date information from SimpleDateFormat
		String k42_TIME2 = k42_df.format(k42_cal.getTime()); //date information from DateFormat
		//to get a refundable date
		Date k42_date = k42_df.parse(k42_TIME2); //�ð� ������ ��� ���ڿ��� parse�ؼ� �����
		k42_cal.setTime(k42_date);
		k42_cal.add(Calendar.DATE, 14); //��ȯ/ȯ���� 14�� �̳� �����ϴ�
		String k42_refundDATE = k42_df.format(k42_cal.getTime());
		
		String k42_HEADER = "\"���ΰ���, ���̼�\""; //���
		String k42_STORE = "(��)�Ƽ����̼�_�д缭����"; //��ȣ��
		String k42_TEL = "031-702-6016"; //��ȭ��ȣ
		String k42_HQ = "���� ������ ���μ�ȯ�� 2748 (���)";
		String k42_NAME = "������,��ȣ�� 213-81-52063"; //��ǥ�ڸ�
		String k42_LOCAT = "��⵵ ������ �д籸 �д��53����\n11 (������)"; //�ּ�
		
		System.out.printf("\n%23s\n", k42_HEADER);
		System.out.printf("%s\n", k42_STORE); //��ȣ�� ���
		System.out.printf("��ȭ:%s\n", k42_TEL); //��ȭ��ȣ ���
		System.out.printf("����:%s\n", k42_HQ);
		System.out.printf("��ǥ:%s\n", k42_NAME); //��ǥ�ڸ� ���
		System.out.printf("����:%s\n", k42_LOCAT); //�ּ� ���
		
		System.out.println("=========================================="); //���м�
		System.out.printf("%24s\n", "�Һ����߽ɰ濵(CCM) �������");
		System.out.printf("%26s\n", "ISO 9001 ǰ���濵�ý��� �������");
		System.out.println("=========================================="); //���м�
		
		System.out.printf("          ��ȯ/ȯ�� 14��(%s)�̳�,\n", k42_refundDATE); //���� dateformat���� ���� ����
		System.out.println("       (����)������, ����ī�� ���� ��\n              ���Ը��忡�� ����"); 
		System.out.printf("%25s\n", "����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�"); //��� ����
		System.out.printf("%26s\n", "üũī�� ��� �� �ִ� 7�� �ҿ�"); //��� ����
		System.out.println("=========================================="); //���м�
		String k42_POS = "1058231"; //�ܸ��� ��ȣ
		System.out.printf("[POS%10s]%27s\n", k42_POS, k42_TIME); //�ܸ��� ��ȣ, ó�� �ð�
		System.out.println("=========================================="); //���м�
		
		String[] k42_ITEM = {"������� �߶󾲴� ���� ����Ŀ��(4M)", "�Ҵ� H800 ������� �̾��� ��ǰ", //��ǰ�� ���ڿ� �迭 
				"FUN/��Ƽ ����_��Ƽ��ǰ ��107��"}; 
		int[] k42_itemNUM = {1231231, 1004261, 1345675}; //��ǰ��ȣ ������ �迭
		int[] k42_PRICE = {1000, 5000, 3000}; //�ݾ� ������ �迭
		int[] k42_EA = {1, 1, 2}; //���� ������ �迭
		int k42_sum = 0; //�հ谡 ����� ���� �ʱ�ȭ
		
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i++) { //��ǰ�� ���ڿ��� ���� = ��ǰ�� ���� ����ŭ �ݺ�
			int k42_subtotal = k42_PRICE[k42_i] * k42_EA[k42_i]; //�Ұ� = �ش� ��ǰ �ݾ� * �ش� ��ǰ ����
			System.out.printf("%s%7s%3d%8s\n[%d]\n", printBlank(strCut(k42_ITEM[k42_i], 24), 24),  //byte�� �������� ���ڿ� �ڸ���
					NumberFormat.getInstance().format(k42_PRICE[k42_i]), //õ���� ��ǥ ����
					k42_EA[k42_i], //����
					NumberFormat.getInstance().format(k42_subtotal), //�Ұ�
					k42_itemNUM[k42_i]); //ǰ��
			k42_sum += k42_subtotal;
		}
		
		double k42_TAX = 0.1; //���� ���� ���� (10%)
		int k42_netprice = (int) (k42_sum / (1 + k42_TAX)); //���� = (������ ��ȯ) �հ� / (1 + ����)
		// = �հ� + �հ�*����
		int k42_totalTAX = k42_sum - k42_netprice; //�ΰ��� = �հ� - ����
		
		System.out.printf("%16s%22s\n", "�����հ�", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(k42_netprice));
		System.out.printf("%17s%22s\n", "�ΰ���", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(k42_totalTAX));
		System.out.println("------------------------------------------"); //���м�
		System.out.printf("�Ǹ��հ�%34s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(k42_sum));
		System.out.println("=========================================="); //���м�
		System.out.printf("�ſ�ī��%34s\n", //printf�� �̿��� ���� �� �ڸ��� �����Ͽ� �����
				NumberFormat.getInstance().format(k42_sum));
		System.out.println("------------------------------------------"); //���м�
		System.out.printf("�츮ī��%34s\n", "538720**********"); //���Ƿ� ������ ī�� ����
		
		String k42_topay = "���αݾ� " + NumberFormat.getInstance().format(k42_sum); 
		//��Ȯ�� ������ ������ ���� "���αݾ�", ����1, sum�� ������ �ϳ��� ���ڿ��� �������
		System.out.printf("���ι�ȣ 77982843(0)%18s\n", k42_topay);
		
		System.out.println("=========================================="); //���м�
		System.out.printf("%26s �д缭����\n", k42_TIME); //SimpleDateFormat���� ���� �ð� ������ ���
		System.out.println("��ǰ �� ��Ÿ ���� : 1522-4400");
		System.out.println("����� �� �����̼� ���� ���� : 1599-2211");
		System.out.printf("%36s\n", "||| || ||||| ||||| || |||||");
		System.out.printf("%31s\n", "2112820610158231");
		//���ڵ�
		
		System.out.println("------------------------------------------"); //���м�
		System.out.println("   �� ���̼� ����� �� �Ǵ� Ȩ��������\n      �����ϼż� " //��� Ȯ���� ���� ���� �ٹٲ� (������ ��½� �ڵ� �ٹٲ�)
				+ "ȸ������ ��\n      �پ��� ������ ����������! ��");
	}
	public static String printBlank(String k42_str, int k42_i) throws UnsupportedEncodingException { 
		//���� Ÿ�Կ� ���� ���� ���� �����ϱ� ���� �Լ�
		//k42_str = ���� ���ڿ�, k42_i = ������ �����Ͽ� ����� ���ڼ�
		int k42_totalBytes = k42_str.getBytes("MS949").length; //���� ���ڿ��� byte���� ������ ����
		//MS949 ���ڵ� �� �ѱ� �� ���� �� 2Byte
		int k42_blank = 0; //���� �� ���� ����

		k42_blank = k42_totalBytes; //���� int i ���� blank�� ���� �� ��ŭ ���� ���
		
		String k42_result = "";
		k42_result += k42_str; //���� ���ڿ� ����
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //���� ����
		}
		return k42_result;
	}

	//strCut(k42_ITEM[k42_i], 16)
	public static String strCut(String str, int length){
		// ���ڿ��� ����Ʈ ������ �ڸ��� ���� �Լ�         
		String result = str; //���� ���ڿ�
		int oL = 0, rF = 0, rL = 0;
		try {
			byte[] bytes = result.getBytes("UTF-8"); //����Ʈ�� ���ڵ��Ͽ� �迭�� ����
			int j = 0;
			j = rF;
			while(j < bytes.length) { //����Ʈ ���� ������
				if((bytes[j] & 0x80) != 0) { //�ѱ� ���ڵ� ����
					if(oL+2 > length) { //������ ���̸� �ʰ��ߴٸ� �ݺ��� Ż��
						break;
					} 
					oL+=2; rL+=3; j+=3;
					} else {
						if(oL+1 > length) { //������ ���̸� �ʰ��ߴٸ� �ݺ��� Ż��
						break;
					} 
					++oL; ++rL; ++j; //1�� �߰��Ѵ�
					}       
				}       
			result = new String(bytes, rF, rL, "UTF-8");  // charset �ɼ� ��� (String class)
		} catch(UnsupportedEncodingException e){  //����ó��
			e.printStackTrace();  //���� ����, ��ġ ���
		} 
		return result;   
	}
}
