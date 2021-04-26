package sw03;

public class Taxcalc {
	
	public static int k42_taxcal (int k42_val, int k42_rate) { //int���� ��ȯ�ϴ� �Լ�
		int k42_ret;
		
		if(((double)k42_val * (double)k42_rate / 100.0) == k42_val * k42_rate / 100) { //double���� int���� ���ٸ�
			k42_ret = k42_val * k42_rate / 100; //�ø��� �������� �ʰ�
		} else {
			k42_ret = k42_val * k42_rate / 100 + 1; //���� �ʴٸ� �ø� �����Ѵ�
		}
		return k42_ret; //������� ��ȯ
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k42_val = 271; //����
		int k42_rate = 3; //���� ���� ����
		
		//���� �Һ��ڰ� = ���� ����
		int k42_tax = k42_taxcal(k42_val, k42_rate);
		
		System.out.println("***************************************************");
		System.out.println("*                 �ܼ� ���� ���                    *");
		System.out.printf("���� ���� ���: %f\n", k42_val * k42_rate / 100.0);
		//���� ���� = �������� ����(3%)�� ���� ����� 100.0���� ���� ���
		System.out.printf("���� ����: %d, ����: %d, �����԰���: %d\n", 
				k42_val, k42_tax, k42_val + k42_tax); //������� ����
		
		System.out.println("***************************************************");
	}
}