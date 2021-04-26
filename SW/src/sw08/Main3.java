package sw08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main3 {
	public static void main(String[] args) throws IOException { 
		//�տ��� ��ȸ�� �����͸� �����ϱ� ���� �ڵ�
		//Ư�� �ڵ��� �����͸� �����Ͽ� ���Ϸ� ����
		File k42_file = new File("C:\\Users\\J\\Desktop\\source\\day_data\\THTSKS010H00.dat");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_file));
		//������ �б� ���� ��ü
		
		File k42_file2 = new File("C:\\Users\\J\\Desktop\\source\\day_data\\A005930.csv");
		BufferedWriter k42_bw = new BufferedWriter (new FileWriter(k42_file2)); //���ϸ� ����
		//������ ���� ���� ��ü
		
		String k42_str; //�о���� ���� ������ ������ ����
		
		int k42_cnt = 0; int k42_wcnt = 0;
		while((k42_str = k42_br.readLine()) != null) {
			StringBuffer k42_sb = new StringBuffer();
			String[] k42_field = k42_str.split("%_%");
			
			if(k42_field.length > 2 && k42_field[2].replace("^", "").trim().substring(0, 7).equals("A005930")){
				//������ ������ ������, 3��° (0, 2)�ʵ��� ���� "A005930" (0~7)�� ��ġ�ϴ� ���
				//���ʿ��� Ư��("^")�� ������
				k42_sb.append(k42_field[0].replace("^", "").trim());
				//StringBuffer sb�� "^"�� ������ ������ �����Ѵ�
				
				for(int k42_i = 1; k42_i < k42_field.length; k42_i++) { //�ʵ��� ������ŭ �ݺ�
					k42_sb.append("," + k42_field[k42_i].replace("^", "").trim());
					//StringBuffer sb�� "^"�� ������ ������ �����Ѵ�
				}
				k42_bw.write(k42_sb.toString()); //������ ó���� sb�� ���Ͽ� ����
				k42_bw.newLine(); //�ٹٲ�
				k42_wcnt ++;
			}
			k42_cnt++;
			//����� ���� �� cnt, wcnt�� ���� ��, ���� ������ ������
		}
		k42_br.close(); //���� �б� �ݱ�
		k42_bw.close(); //���� ���� �ݱ�
		
		System.out.printf("Program End [%d] [%d] records\n", k42_cnt, k42_wcnt);
	}
}
