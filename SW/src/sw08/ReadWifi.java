package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadWifi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File k42_file = new File ("c:\\Users\\J\\Desktop\\���������������.CSV"); //��� �� ���ϸ� ����
		BufferedReader k42_br = new BufferedReader (new FileReader(k42_file)); //���� �б� ��ü ����
		
		String k42_str; //br.readLine���� �о���� ���� ������ ������ ����
		
		if((k42_str = k42_br.readLine()) == null) { //�о���� ������ ���� ���
			System.out.println("this file is empty"); //�ȳ��� ���
			return; //���ǹ� ������
		}
		String[] k42_field_name = k42_str.split(","); //csv�̹Ƿ� ","�� �������� ������
		//field_name = �ʵ��
		
		int k42_lineCnt = 0; //�� ������ ������ ����
		while((k42_str = k42_br.readLine()) != null) { //�о���� ������ ������ ���
			String[] k42_field = k42_str.split(","); //�ʵ� ����
			System.out.printf("******[ %d��° �׸� ]******\n", k42_lineCnt);
			
			for(int k42_i = 0; k42_i < k42_field_name.length; k42_i++) { //�ʵ���� ������ŭ �ݺ�
				System.out.printf(" %s : %s\n", k42_field_name[k42_i], k42_field[k42_i]);
				//�ʵ�� : �ʵ� ���� \n�� �ݺ������� ���
			}
			System.out.println("****************************");
			if(k42_lineCnt == 100) break; //100�������� ����Ѵ�
			k42_lineCnt++; //���� �׸� ����� ���� 1�� ���� ���� ���ڷ� �ٲ��ش�
		}
		k42_br.close();
	}

}
