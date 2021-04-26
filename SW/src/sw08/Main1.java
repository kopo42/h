package sw08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
	public static void main(String[] args) {
		try {
			File k42_f = new File("c:\\Users\\J\\Mytest.txt"); //������ ������ ���
			FileWriter k42_fw = new FileWriter(k42_f); //���� ����: FileWrtier ��ü�� �����Ͽ� ����Ѵ�
			//��ȣ ��: ���� ���, �̸�
			//Mytest.txt�� ����� ����
			k42_fw.write("Hello"); 
			k42_fw.write("�ȳ�");
			//fw ��ü ���� �����Ϳ��� �ڵ����� exception ó���� �䱸��
			
			k42_fw.close(); //�������� �� �Ǵ��� ���� ������ ���� close��
			
			FileReader k42_fr = new FileReader(k42_f); //������ �д� ��ü
			//��ȣ ��: ���� ���, �̸�
			
			int k42_n = -1; //���� ����
			char [] k42_ch; //���� �迭
			
			while(true){ //���� �ݺ�
				k42_ch = new char[100]; //ũ�Ⱑ 100�� ���� �迭
				k42_n = k42_fr.read(k42_ch);
				//�о���� ���� �� ��ȯ
				//���� ��: -1 ��ȯ
				/*
			     * Reads characters into an array.  This method will block until some input
			     * is available, an I/O error occurs, or the end of the stream is reached.
			     *
			     * @param       cbuf  Destination buffer
			     *
			     * @return      The number of characters read, or -1
			     *              if the end of the stream
			     *              has been reached
			     *
			     * @throws      IOException  If an I/O error occurs
			     */
				//���� ���� �������� ��� �ݺ��� ����
				if(k42_n == -1) break;
				
				for(int k42_i = 0; k42_i < k42_n; k42_i++) { //�о���� ������ �� ��ŭ �ݺ�
					System.out.printf("%c", k42_ch[k42_i]); //���� �迭�� ���� ���
				}
			}
			k42_fr.close(); //���� �б� ����
			System.out.println("\nFILE READ END");
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); //���� �߻��� ����, ��ġ ���
		}
	}
}
