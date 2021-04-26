package sw09;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main2 {
	//JSON ���� �����ϱ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JOSNObject ���� : �Ʒ����� �ϼ��� ������ �������� �� ��ü
		JSONObject k42_jsonObject = new JSONObject();
		//�� ���� ������ ���� Array ��ü
		JSONArray k42_datasArray = new JSONArray();
		
		//�� ���� ������ �� JSONObject ��ü
		JSONObject k42_dataObject = new JSONObject();
		k42_dataObject.put("name", "����");
		k42_dataObject.put("studentid", 209901);
		
		//���� ������ �� JSONArray ��ü
		JSONArray k42_score = new JSONArray();
		k42_score.add(90); k42_score.add(100); k42_score.add(95);
		k42_dataObject.put("score", k42_score);
		k42_datasArray.add(k42_dataObject);
		
		//������ �ް� �Է��ϴ� OneRec �Լ��� �̿��Ͽ� ���� �Է�
		k42_datasArray.add(OneRec("����", 209902, 100, 85, 75));
		k42_datasArray.add(OneRec("���", 209903, 90, 75, 85));
		k42_datasArray.add(OneRec("�糪", 209904, 90, 85, 75));
		k42_datasArray.add(OneRec("��ȿ", 209905, 80, 75, 85));
		k42_datasArray.add(OneRec("�̳�", 209906, 90, 85, 55));
		k42_datasArray.add(OneRec("����", 209907, 70, 75, 65));
		k42_datasArray.add(OneRec("ä��", 209908, 100, 75, 95));
		k42_datasArray.add(OneRec("����", 209909, 80, 65, 95));
		
		try {
			//FileWriter�� �̿��� ���� ����
			//��� ����
			FileWriter k42_file = new FileWriter("C:\\Users\\J\\Desktop\\source\\test.json");
			k42_file.write(k42_datasArray.toJSONString()); //����
			k42_file.flush(); //�ѱ��
			k42_file.close(); //���� ���� �ݱ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON : " + k42_datasArray); //Ȯ���� ���� ���� ���
		
		
	}
	public static JSONObject OneRec (String k42_name, int k42_studentid, int k42_kor, int k42_eng, int k42_mat) {
		//�ݺ� �۾��� ó���ϱ� ���� �Լ�
		JSONObject k42_dataObject = new JSONObject();
		k42_dataObject.put("name", k42_name);
		k42_dataObject.put("studentid", k42_studentid);
		//���� ������ ��JSONArray ����
		JSONArray score = new JSONArray();
		score.add(k42_kor); //���� ����
		score.add(k42_eng); //���� ����
		score.add(k42_mat); //���� ����
		k42_dataObject.put("score", score);
		
		return k42_dataObject; //�ϼ��� dataObject�� ��ȯ�Ѵ�
	}
}
