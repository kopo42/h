package sw08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
	public static void FileWrite() throws IOException {
		File k42_f = new File("c:\\Users\\J\\Mytest2.txt"); //���, ���ϸ�
		BufferedWriter k42_bw = new BufferedWriter(new FileWriter(k42_f)); //���� ���� buffered ��ü ����
		
		k42_bw.write("Writing a file"); //�Է��� ����
		k42_bw.newLine(); //�ٹٲ�
		k42_bw.write("Hello");
		k42_bw.newLine();
		
		k42_bw.close(); //���� ���� �ݱ�
	}
	
	public static void FileRead() throws IOException {
		File k42_f = new File("c:\\Users\\J\\Mytest2.txt");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_f)); //���� �б� ��ü ����
		
		String k42_readtxt; //br�� �о���� ���� ������ ������ ����
		
		while((k42_readtxt = k42_br.readLine()) != null) { //���� ������ ��� ������ ���
			System.out.printf("%s\n", k42_readtxt); //readtxt�� ������ ���� ���� ���
		}
		k42_br.close(); //���� �б� �ݱ�
	}

	public static void main(String[] args) throws IOException { //�����Լ����� ����
		FileWrite();
		FileRead();
		//����ó�� �䱸 (throws IOException)
	}
}
