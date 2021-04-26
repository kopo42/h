package sw03;

public class main2 {
	public static int k42_netprice(int k42_price, double k42_rate) { //�Һ��ڰ� ����ϱ�
		return (int)(k42_price / (1 + k42_rate)); // x(y + 1) = xy + x
	}
	public static void main(String[] args) { //���� �Լ�
		String [] k42_item = {"����Ĩ", "������", "����Ĩ", "����", "ġ�佺"}; //��ǰ���� string �迭�� ����
		int[] k42_price = {1500, 1500, 2400, 1200, 2000};  //������ int �迭�� ����
		int[] k42_amount = {10, 2, 1, 3, 5}; //������ int �迭�� ����
		double k42_tax_rate = 0.1; //���� 10%
		int k42_total_sum = 0; //�հ踦 ������ ���� ����
		
		System.out.printf("******************************\n");
		System.out.printf("*            ��ǰ��            *\n");
		System.out.printf(" �׸�      �ܰ�   ����      �հ�   \n");
		
		for(int i = 0; i < k42_item.length; i++) { //��ǰ�� �迭�� ���̸�ŭ �ݺ�
			int sum = k42_price[i] * k42_amount[i]; //�հ� = ��ǰ�� �׸� * ���� �׸�
			k42_total_sum = k42_total_sum + sum; //�հ� = �ŵ��Ͽ� ���ϱ� ����
			System.out.printf("%.5s  %7d  %2d  %9d\n", k42_item[i], k42_price[i], k42_amount[i], sum); //�迭�� i��° ���� �ݺ��Ͽ� ���
		}
		System.out.printf("******************************\n");
		System.out.printf("���ұݾ� :%20d\n", k42_total_sum); //���ұݾ��� �ڸ��� �����Ͽ� ����ϱ�
		
		int total_net_price = (int)(k42_total_sum / (1 + k42_tax_rate)); //�Һ��ڰ� ���ϱ�
		System.out.printf("�����ݾ� :%20d\n", total_net_price); //�Һ��ڰ��� �ڸ��� �����Ͽ� ����ϱ�
		int tax = k42_total_sum - total_net_price; //���� = �հ� - �Һ��ڰ�
		System.out.printf("   ���� :%20d\n", tax); //������ �ڸ��� �����Ͽ� ����ϱ�
	}
}
