package sw08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class Samjeon {
	public static void main(String[] args) throws IOException { 
		//�տ��� ��ȸ�� �����͸� �����ϱ� ���� �ڵ�
		//�ռ� ������ csv������ Ȱ���Ͽ� �ʿ��� �����͸� �����Ѵ�
		File k42_file = new File("C:\\Users\\J\\Desktop\\source\\day_data\\samjeon\\test3.csv");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_file));
		//������ �б� ���� ��ü
		int k42_cnt = 0; //ó�� �Ǽ��� ����
		String k42_str; //�о���� ���� ������ ������ ����
		ArrayList <Integer> k42_nums = new ArrayList<Integer>(); //���� �κ��� ���������� ��ȯ�Ͽ� ������ list
		ArrayList <String> MAXdate = new ArrayList<String>(); //�ִ�, �ּҰ��� ��¥ �����͸� �����ϱ� ���� list
		ArrayList <String> MINdate = new ArrayList<String>();
		
		while((k42_str = k42_br.readLine()) != null) {
			String[] k42_field = k42_str.split(","); //csv�̹Ƿ� "," �������� ������
			List<String> k42_tempList = new ArrayList<String>(Arrays.asList(k42_field)); //���� ���� ����� �迭�� list��
			List<List<String>> k42_list = new ArrayList<List<String>>(); //��, ���� ����ϱ� ���� �߰��� ������ list
			k42_list.add(k42_tempList); //��, �� ���� �����
			
			int k42_j = 0; //���� �����ϱ� ���� ������ ����
			List<String> k42_line = k42_list.get(k42_j); //csv ������ ��, ������ �����
			k42_j++; //���� ���� �Ѿ�� ����
			
			k42_nums.add(Integer.parseInt(k42_line.get(3))); //4��° �ʵ� �� ���� (0, 1, 2, 3)
			
			if(k42_line.get(3).equals("1503000")) {
				//�ִ밪�� ��ġ�ϴ� ���� ���� ������ ������ ����
				MAXdate.add(k42_line.get(1)); 
			}
			if(k42_line.get(3).equals("1067000")) {
				//�ּҰ��� ��ġ�ϴ� ���� ���� ������ ������ ����
				MINdate.add(k42_line.get(1));
			}
			k42_cnt++;
		}
		int k42_max = getMAX(k42_nums);
		//k42_max = k42_max / 50; //�����̹Ƿ� /50
		int k42_min = getMIN(k42_nums);
		//k42_min = k42_min / 50;
		System.out.println("<�Ｚ���� �ְ�, ���� ���� ���� (�ð� ����)>");
		System.out.println("\n�ְ�, ������ = �ݾ�(NNN KRW)");
		System.out.println("����[YYYYMMDD]\n");
		System.out.printf("ó�� : %d��\n\n", k42_cnt);
		System.out.printf("�ְ� = %sKRW\n%s\n\n", NumberFormat.getInstance().format(k42_max), MAXdate);
		System.out.println(k42_max / 50);
		System.out.printf("������ = %sKRW\n%s\n", NumberFormat.getInstance().format(k42_min), MINdate);
		System.out.println(k42_min / 50);
		
		k42_br.close(); //���� �б� �ݱ�
	}
	public static int getMAX(ArrayList <Integer> nums) { //�ִ밪�� ���ϱ� ���� �Լ�
		int max = Collections.max(nums); //����� list�̹Ƿ� collections ���� Ŭ���� ���
		for(int i = 0; i < nums.size(); i++) { //list�� ũ�� ������
		    if(max < nums.get(i)) { //�ִ밪���� ū ���� �����Ѵٸ� �� ���� �ִ밪���� �ٽ� �����Ѵ�
			max = nums.get(i);
		    }
		}
		return max;
	}
	public static int getMIN(ArrayList <Integer> nums) {
		int min = Collections.min(nums); //����� list�̹Ƿ� collections ���� Ŭ���� ���
		for(int i = 0; i < nums.size(); i++) { //list�� ũ�� ������
		    if(min > nums.get(i)) { //�ּҰ����� ���� ���� �����Ѵٸ� �� ���� �ּҰ����� �ٽ� �����Ѵ�
			min = nums.get(i);
		    }
		}
		return min;
	}
}
