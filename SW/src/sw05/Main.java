package sw05;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCal(); //���� �Լ����� ����
	}
	public static void printCal() {
		//calendar ��ü�� �̿��Ͽ� ��¥, ���� ���� ��������
		Calendar k42_cal = Calendar.getInstance(); //Calendar�� getInstance ���, ���� ���� ȹ��
		//int Weekday = 5;
		//�� 5��
		//int[] End = {31, 29, 31, 30, 31, 30, 31, 30, 31, 31, 30, 31};
		//������ �迭�� �����Ѵ�
		
		for(int k42_mon = 0; k42_mon < 12; k42_mon ++) { //�� ������ ���� �ݺ���
			System.out.printf("\n\n%15d��\n", k42_mon + 1);
			System.out.printf(" ============================\n");
			System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n", "��", "��", "ȭ", "��", "��", "��", "��");
			//cal ��ü�� ����ڰ� ���ϴ� ���� ����
			k42_cal.set(Calendar.YEAR, 2021); //���� ����
			k42_cal.set(Calendar.MONTH, k42_mon); //�ݺ������� ������ ���� mon
			k42_cal.set(Calendar.DATE, 1); //����
			
				int k42_firstday = k42_cal.get(Calendar.DAY_OF_WEEK); //�ش���� 1�� ���� ȹ��
				for (int k42_i = 1; k42_i <k42_firstday; k42_i++) { //1�� ������
					System.out.print("    ");  //���� ���
				}
				
				int k42_end = k42_cal.getActualMaximum(Calendar.DATE); //�ش���� �������� ���� ȹ��
				for (int k42_j = 1; k42_j <= k42_end; k42_j ++) { //���ϱ��� ���� ���
					k42_cal.set(Calendar.DATE, k42_j); //�ݺ����� j�� ���Ͽ� ���� ���� ����
					if(k42_j < 10) { //j�� ���ڸ� ���� ���
						System.out.printf("%4d", k42_j); //�ڸ����� ���߾� ���
					} else {
						System.out.printf("%4d", k42_j); //���������� �ڸ����� ���߾� ���
					}
					int k42_newLine = k42_cal.get(Calendar.DAY_OF_WEEK); //�� �ٲٱ� ���� ������ ���� ����
					if(k42_newLine % 7 == 0) { //7�ϸ���
							System.out.println(); //�ٹٲ�
						}
				}
		}
	}
}
