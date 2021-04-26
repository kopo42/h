package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Queue;

import org.openqa.selenium.NoSuchElementException;

public class Bus {

	public static void main(String[] args) throws IOException {
		//���� �ɼ� -> tab�� �������� txt ����
				File k42_file = new File ("c:\\Users\\J\\Desktop\\source\\�������������� ��ġ����.csv"); //��� �� ���ϸ� ����
				BufferedReader k42_br = new BufferedReader (new FileReader(k42_file)); //���� �б� ��ü ����
				String k42_str; //br.readLine���� �о���� ���� ������ ������ ����
				
				if((k42_str = k42_br.readLine()) == null) { //�о���� ������ ���� ���
					System.out.println("this file is empty"); //�ȳ��� ���
					return; //���ǹ� ������
				}
				double k42_lat = 37.3860521; //����
				double k42_lng = 127.1214038; //�浵
				
				int k42_lineCnt = 0; //�� ������ ������ ����  
				double k42_max = 0.1;
				double k42_min = 0.1; //�ִ�, �ּҰ��� ������ ���� : ���� ���� �� ������ ������ �ʱ�ȭ
				
				List <String> k42_listMAX = new ArrayList <String>(); //�ִ�, �ּҰ��� ������ ���������� ����ϱ� ���� ���
				List <String> k42_listMIN = new ArrayList <String>(); 
				
				while((k42_str = k42_br.readLine()) != null) { //�о���� ������ ������ ��� �ݺ�
					try {
						String[] k42_field = k42_str.split(","); //�ʵ� ���� (tab ����)
						
						double k42_distance = getDistance(k42_field,k42_lat, k42_lng, k42_lineCnt); //�Ÿ��� ����ϰ� �ݿø��� ���� ��ȯ�ϴ� �Լ�
						if(Double.parseDouble(k42_field[9]) > 0 && Double.parseDouble(k42_field[10]) > 0) {
							if(k42_max < getDistance(k42_field, k42_lat, k42_lng, k42_lineCnt)) { //�ִ밪���� ū ���� �����Ѵٸ� �� ���� �ִ밪���� �ٽ� �����Ѵ�
								k42_max = getDistance(k42_field, k42_lat, k42_lng, k42_lineCnt); //�ִ밪 �ʱ�ȭ
								String k42_busInfoMAX = "<����Ÿ�>\n" + "������ : " + k42_field[1] + "\n" + "����  : " + k42_field[21] + "\n" +
										"�Ÿ� : " + k42_distance + "\n" + "���� : " + k42_field[9] + "\n" + "�浵 : " +k42_field[10] + "\n";
								//����� ���� �ϳ��� String�� �����Ѵ�
							k42_listMAX.add(k42_busInfoMAX); //���� ����� ���ڿ� �ϳ��� ���ڿ� �迭�� �߰��Ѵ�
							}
							if(k42_min > getDistance(k42_field, k42_lat, k42_lng, k42_lineCnt)) { //�ּҰ����� ���� ���� �����Ѵٸ� �� ���� �ּҰ����� �ٽ� �����Ѵ�
								k42_min = getDistance(k42_field, k42_lat, k42_lng, k42_lineCnt); //�ּҰ� �ʱ�ȭ
								String k42_busInfoMIN = "<�ִܰŸ�>\n" + "������ : " + k42_field[1] + "\n" + "���� : " + k42_field[21] + "\n" +
										"�Ÿ� : " + k42_distance + "\n" + "���� : " + k42_field[9] + "\n" + "�浵 : " +k42_field[10] + "\n";
								//����� ���� �ϳ��� String�� �����Ѵ�
								k42_listMIN.add(k42_busInfoMIN); //���� ����� ���ڿ� �ϳ��� ���ڿ� �迭�� �߰��Ѵ�
							}
						}
					} catch(ArrayIndexOutOfBoundsException e) { //���� �� ���� ���� Ȯ���Ͽ� ����ó��: �������� ó���� �����̹Ƿ� �߸��� ������ ������
						System.out.println("ArrayIndexOutOfBoundsException");
					} catch(NumberFormatException e) {
						//System.out.println("NumberFormatException");
					} catch(NoSuchElementException e) {
						System.out.println("NoSuchElementException");
					} catch(MissingFormatArgumentException e) {
						System.out.println("MissingFormatArgumentException");
					}
					k42_lineCnt ++;
				}
				System.out.println("���� ���������忡 ���� ����, �ִܰŸ� ��Ȳ");
				System.out.printf("\nó��: %d��\n\n", k42_lineCnt);
				System.out.println(k42_listMAX.get(k42_listMAX.size() - 1)); //������ ���(���� �ֱٿ� �߰��� ���)���� ���
				System.out.println(k42_listMIN.get(k42_listMIN.size() - 1));
				//ex: arr[] = {A}, index "A" = 0, arr.size = 1
				
				k42_br.close(); //���� �б� �ݱ�
			}

	public static double getDistance(String[] k42_field, double k42_lat, double k42_lng, int lineCnt) { //�Ÿ� ��� �Լ�
		double k42_distance = Math.sqrt(Math.pow(Double.parseDouble(k42_field[9]) - k42_lat, 2)
				+ Math.pow(Double.parseDouble(k42_field[10]) - k42_lng, 2));
		//��Ÿ��� �Ÿ� ���� = {(a - c)^2 + (b - d)^2}�� ��Ʈ��
		return k42_distance;
	}
}

