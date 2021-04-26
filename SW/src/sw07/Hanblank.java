package sw07;

import java.io.UnsupportedEncodingException;

public class Hanblank {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.printf("HanBlankForward  [%s]\n", printBlankForward("�ѱ�abcd", 15));
		System.out.printf("HanBlankForward  [%s]\n", printBlankForward("�ѱ��ѱ�aa", 15));
		System.out.printf("HanBlankBackward [%s]\n", printBlankBackward("�ѱ�aa", 15));
		System.out.printf("HanBlankBackward [%s]\n", printBlankBackward("�ѱ��ѱ�aa", 15));
		System.out.printf("�ѱ�: %d��\n", HanCount("�ѱ��ѱ�aa"));

	}
	public static String printBlankForward(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//���� Ÿ�Կ� ���� ���� ���� �����ϱ� ���� �Լ�
		//k42_str = ���� ���ڿ�, k42_i = ������ �����Ͽ� ����� ���ڼ�
		int k42_strBytes = k42_str.getBytes("MS949").length; //���� ���ڿ��� byte���� ������ ����
		//MS949 ���ڵ� �� �ѱ� �� ���� �� 2Byte
		int k42_blank = 0; //���� �� ���� ����
			k42_blank = k42_strBytes; //���� int i ���� blank�� ���� �� ��ŭ ���� ���
		
		String k42_result = "";
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //���ڿ� �տ� ���� ����
		}
		k42_result += k42_str; //return�� �� result�� ���� ���ڿ� ����
		return k42_result; //ó�� �� ���� ���ڿ�
	}
	public static String printBlankBackward(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//���� Ÿ�Կ� ���� ���� ���� �����ϱ� ���� �Լ�
		//k42_str = ���� ���ڿ�, k42_i = ������ �����Ͽ� ����� ���ڼ�
		int k42_strBytes = k42_str.getBytes("MS949").length; //���� ���ڿ��� byte���� ������ ����
		//MS949 ���ڵ� �� �ѱ� �� ���� �� 2Byte
		int k42_blank = 0; //���� �� ���� ����
			k42_blank = k42_strBytes; //���� int i ���� blank�� ���� �� ��ŭ ���� ���
		
		String k42_result = "";
		k42_result = k42_str; //return�� �� result�� ���� ���ڿ� ���� ����
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //���ڿ� �ڿ� ���� ����
		}
		return k42_result; //ó�� �� ���� ���ڿ�
	}
	public static int HanCount(String k42_str) {
		int k42_cnt = 0; //�ѱ��� ������ ������ ����
		for(int k42_i = 0; k42_i < k42_str.length(); k42_i ++) //���� ���ڿ��� ���� �ȿ���
			if(String.valueOf(k42_str.charAt(k42_i)).matches((".*[��-����-�Ӱ�-�R]+.*"))) {
				k42_cnt++; //���� �ϳ��� �˻��Ͽ� �ѱ� ���Խİ� ��ġ�� ��� ī��Ʈ�Ѵ�
			}
		return k42_cnt; //�� ���� ��ȯ
	}
}
