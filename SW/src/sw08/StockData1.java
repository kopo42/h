package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StockData1 { //�켱 ������ ������ ���¸� Ȯ���ϱ� ���� �ڵ�

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File k42_file = new File("C:\\Users\\J\\Desktop\\source\\day_data\\THTSKS010H00.dat");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_file));
		
		String k42_readtxt; //���� ������ ����
		int k42_lineCnt = 0; //���� ������ ����
		int k42_n = 1; //br.read()�� ������� ������ ������ ����
		StringBuffer k42_sb = new StringBuffer();
		//StringBuffer = ���ڿ��� �߰��ϰų� ������ �� �ַ� ����ϴ� �ڷ���
		
		while(true) {
			char[] k42_CH = new char[1000]; //ũ�Ⱑ 1000�� ���� �迭
			
			k42_n = k42_br.read(k42_CH);
			//br.read() = �о���� ���� �� ��ȯ
			//���� ��: -1 ��ȯ
			
			if(k42_n == -1) break;
			
			for(char k42_c : k42_CH) { //for(���� ���� �� : �迭) �迭�� ���� ���ʷ� ������ ����
				if( k42_c == '\n') { //�� ������ ������ ������ ��
					System.out.printf("[%s]****\n", k42_sb.toString());
					k42_sb.delete(0, k42_sb.length()); //StringBuffer delete(int start, int end) = ��ü ����
				} else {
					k42_sb.append(k42_c); //�ƴ� ��� c�� ����
				}
			}
			k42_lineCnt ++; //���� �׸����� 
		}
		System.out.printf("[%s]****\n", k42_sb.toString());
		k42_br.close(); //���� �б� �ݱ�
	}
}
