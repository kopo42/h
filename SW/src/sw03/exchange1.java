package sw03;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class exchange1 {
	static int kp42_won = 1000000; //ȯ���� �ݾ�
	static double kp42_ex = 1238.21; //ȯ��
	static double kp42_commision = 0.003; //������ 0.3%
	static int kp42_usd = (int)(kp42_won / kp42_ex); //won to usd ��ȭ
	static int kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex); //�ܵ�
	static double kp42_ComPerOne = kp42_ex * kp42_commision; //�Ǵ� ������ ���ϱ� 
	static double kp42_totalcom = kp42_usd * kp42_ComPerOne; //�� ������ ���ϱ�
	//comperone 1�޷��� ������ = ȯ�� * ������
	//totalcom �� ������ = �� �޷� �� * 1�޷��� ������
	//�ѹ��� ����ϴ� ������ ����

	public static void main(String[] args) { //�ٸ� �Լ��� ������ main �Լ�
		// TODO Auto-generated method stub
		//kp42_justEX();
		//kp42_EX1();
		//kp42_EX2();
		//kp42_EX3();
		kp42_DF1();
	}
	public static void kp42_justEX() { //�ܼ� ȯ��
		//���������� �̿��Ͽ� ����� ����ϴ� �Լ�
		System.out.println("***************************************************");
		System.out.println("*                 ������ ���� ���                    *");
		//�ܼ� ���� ������� ȯ���� ��ȭ, ȯ���� ��ȭ, ��ȭ �ܵ��� ����Ѵ�
		System.out.printf("�� ��ȭ ȯ�� �ݾ�: %d�� ==> ��ȭ: %d�޷�, �ܵ� ==> %d��\n", 
				kp42_won, kp42_usd, kp42_remain); //���: ��, ��ȭ, �ܵ� ��
		//remain = ó�� ��ȭ���� ȯ���� ��ȭ * ȯ��( = ��ȭ ����)�� ���� ��
		System.out.println("***************************************************");
	}
	public static void kp42_EX1 () { //������ ����ϱ�
		System.out.println("***************************************************");
		System.out.println("*                   ������ ���                     *");
		System.out.printf("�� ������: %f�� ==> ��ȭ: %d�޷�, �޷��� ������ ==> %f��\n", 
				kp42_totalcom, kp42_usd, kp42_ComPerOne); //���: ������, ��ȭ, �޷��� ������ ��
		System.out.println("***************************************************");
	}
	public static void kp42_EX2() { //������ ���� ȯ��
		int kp42_totalcomInt; //�� �������� ������
		
		if (kp42_totalcom != (double)((int)kp42_totalcom)) { //�Ҽ����� ������ ���
			kp42_totalcomInt = (int)kp42_totalcom + 1; //�ø� �����Ѵ�
		} else {
			kp42_totalcomInt = (int)kp42_totalcom; //���� ��� �������� ����
		}
		System.out.println("***************************************************");
		System.out.println("*                 ������ ���� ȯ��                  *");
		System.out.printf("�� ������: %d�� ==> ��ȭ: %d�޷�, �޷��� ������ ==> %f��\n", 
				kp42_totalcomInt, kp42_usd, kp42_ComPerOne); //���: ������, ��ȭ, �޷��� ������ ��
		kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex - kp42_totalcomInt); //�ܵ� �ٽ� ����
		
		System.out.printf("�� ��ȭ ȯ�� �ݾ�: %d�� ==> ��ȭ: %d�޷�, ������ ¡��: %d��, �ܵ� ==> %d��\n", 
				kp42_won, kp42_usd, kp42_totalcomInt, kp42_remain); //���: ��, ��ȭ, �ܵ� ��
		
		System.out.println("***************************************************");
	}
	public static void kp42_EX3() { //��Ȯ�� ������ ���� ȯ��
		kp42_usd = (int)(kp42_won / (kp42_ex + kp42_ComPerOne)); //�޷��� ���������� ǥ��
		kp42_totalcom = kp42_usd * kp42_ComPerOne; //�� ������ = �޷� ���� �κ� * �޷��� ������
		int kp42_totalcomInt; //�ø� ������ ����
		
		if (kp42_totalcom != (double)((int)kp42_totalcom)) { //�Ҽ����� �����Ѵٸ�
			kp42_totalcomInt = (int)kp42_totalcom + 1; //�ø�ó��
		} else {
			kp42_totalcomInt = (int)kp42_totalcom; //�ƴ� ��� �������� ����
		}
		System.out.println("***************************************************");
		System.out.println("*            (��Ȯ��) ������ ���� ȯ��               *");
		System.out.printf("�� ������: %d�� ==> ��ȭ: %d�޷�, �޷��� ������ ==> %f��\n", 
				kp42_totalcomInt, kp42_usd, kp42_ComPerOne); //���: ������, ��ȭ, �޷��� ������ ��
		
		kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex - kp42_totalcomInt); //�ܵ� �ٽ� ����
		
		System.out.printf("�� ��ȭ ȯ�� �ݾ�: %d�� ==> ��ȭ: %d�޷�, ������ ¡��: %d��, �ܵ� ==> %d��\n", 
				kp42_won, kp42_usd, kp42_totalcomInt, kp42_remain); //���: ��, ��ȭ, �ܵ� ��
		
		System.out.println("***************************************************");
	}
	public static void kp42_DF1() { //Decimal Format, Calendar Ȱ���Ͽ� ó�� �ð��� ����ϴ� �Լ�
		DecimalFormat df = new DecimalFormat( "###,###,###,###,###"); //1000���� �޸� ����
		kp42_usd = (int)(kp42_won / (kp42_ex + kp42_ComPerOne)); //�޷��� ���������� ǥ��
		//�޷� = ��ȭ�� (ȯ�� + �޷��� ������)�� ������ ���Ѵ�
		kp42_totalcom = kp42_usd * kp42_ComPerOne; //�� ������ = �޷� ���� �κ� * �޷��� ������
		int kp42_totalcomInt; //�ø� ������ ����
		
		if (kp42_totalcom != (double)((int)kp42_totalcom)) { //�Ҽ����� �����Ѵٸ�
			kp42_totalcomInt = (int)kp42_totalcom + 1; //�ø�ó��
		} else {
			kp42_totalcomInt = (int)kp42_totalcom;//�ƴ� ��� �������� ����
		}
		
		System.out.printf("************************************************\n");
		System.out.printf("*              �޸� ���, ��¥ ����              *\n");
		
		System.out.printf("�� ������: %s�� ==> ��ȭ: %s�޷�, �޷��� ������ ==> %f��\n",
				df.format(kp42_totalcomInt), df.format(kp42_usd), kp42_ComPerOne); //df.format���� ���� �����Ͽ� ���
		
		kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex - kp42_totalcomInt); //�ܵ� �ٽ� ����
		
		System.out.printf("�� ��ȭ ȯ�� �ݾ�: %s�� ==> ��ȭ: %s�޷�, ������ ¡��: %s��, �ܵ� ==> %s��\n", 
				df.format(kp42_won), df.format(kp42_usd), df.format(kp42_totalcomInt), //df.format���� ���� �����Ͽ� ���
				df.format(kp42_remain)); //���: ��, ��ȭ, �ܵ� ��
		Calendar calt = Calendar.getInstance(); //calendar class ����ϱ�
		
		SimpleDateFormat sdt = new SimpleDateFormat ("YYYY/MM/dd HH:mm:ss"); //���� �ҷ�����
		System.out.printf("���� ���� �ð�: %s\n", sdt.format(calt.getTime())); //����ð� ����ϱ�
		
		System.out.println("***************************************************");
	}
}















