package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Wdistance {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//���� �ɼ� -> tab�� �������� txt ����
		File k42_file = new File ("c:\\Users\\J\\Desktop\\���������������.txt"); //��� �� ���ϸ� ����
		BufferedReader k42_br = new BufferedReader (new FileReader(k42_file)); //���� �б� ��ü ����
		
		String k42_str; //br.readLine���� �о���� ���� ������ ������ ����
		
		if((k42_str = k42_br.readLine()) == null) { //�о���� ������ ���� ���
			System.out.println("this file is empty"); //�ȳ��� ���
			return; //���ǹ� ������
		}
		String[] k42_field_name = k42_str.split("\t"); // tab�� �������� ������
		//field_name = �ʵ��
		
		double k42_lat = 37.3860521; //����
		double k42_lng = 127.1214038; //�浵
		
		int k42_lineCnt = 0; //�� ������ ������ ����  
		
		while((k42_str = k42_br.readLine()) != null) { //�о���� ������ ������ ���
			try {
				String[] k42_field = k42_str.split("\t"); //�ʵ� ���� (tab ����)
				System.out.printf("******[ %d��° �׸� ]******\n", k42_lineCnt);
				
				System.out.printf(" %s : %s\n", k42_field_name[9], k42_field[9]); //�ʵ� 9 = �����ּ�
				System.out.printf(" %s : %s\n", k42_field_name[13], k42_field[13]); //�ʵ� 12 = ����
				System.out.printf(" %s : %s\n", k42_field_name[14], k42_field[14]); //�ʵ� 13 = �浵
				
				double k42_distance = Math.sqrt(Math.pow(Double.parseDouble(k42_field[13]) - k42_lat, 2)
						+ Math.pow(Double.parseDouble(k42_field[14]) - k42_lng, 2));
				//��Ÿ��� �Ÿ� ���� = {(a - c)^2 + (b - d)^2}�� ��Ʈ��
				
				System.out.printf(" ���� ��ġ���� �Ÿ� : %f%s\n", k42_distance * 100, "km");
				System.out.println("****************************");
				k42_lineCnt++; //���� �׸� ����� ���� 1�� ���� ���� ���ڷ� �ٲ��ش�	
			} catch(ArrayIndexOutOfBoundsException e) { //���� �� ���� ���� Ȯ���Ͽ� ����ó��
				System.out.println("ArrayIndexOutOfBoundsException");
			} catch(NumberFormatException e) {
				System.out.println("NumberFormatException");
			}
		}
		k42_br.close();
	}
}

