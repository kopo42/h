package sw03;

public class main2B {
	public static int k42_netprice(int k42_price, double k42_rate) { //�Һ��ڰ� ����ϱ�
		return (int)(k42_price / (1 + k42_rate)); // x(y + 1) = xy + x
	} //���� ��� �Լ�
	
	public static void main(String[] args) { //���� �Լ�
		int k42price =1234; //������ ���� ����
		double k42tax_rate = 0.1; //�Ǽ��� ���� ����
		
		int k42netprice = k42_netprice(k42price, k42tax_rate); //�̸� ������ �Լ� ���
		int k42tax = k42price - k42netprice; //�Լ� ���
		
		System.out.printf("***************************************************\n");//���
		System.out.printf("*            �Һ��ڰ�, ��������, ���� ���            *\n");//���2
		System.out.printf("       �Һ��ڰ�: %d, ��������: %d, ���� ���: %d       \n",
				k42price, k42netprice, k42tax); //���� ���� ���
		System.out.printf("***************************************************\n");
	}
}