package sw09;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main2 {
	//JSON 파일 생성하기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JOSNObject 선언 : 아래에서 완성된 내용이 최종으로 들어갈 객체
		JSONObject k42_jsonObject = new JSONObject();
		//한 명의 정보를 담을 Array 객체
		JSONArray k42_datasArray = new JSONArray();
		
		//한 명의 정보가 들어갈 JSONObject 객체
		JSONObject k42_dataObject = new JSONObject();
		k42_dataObject.put("name", "나연");
		k42_dataObject.put("studentid", 209901);
		
		//성적 정보가 들어갈 JSONArray 객체
		JSONArray k42_score = new JSONArray();
		k42_score.add(90); k42_score.add(100); k42_score.add(95);
		k42_dataObject.put("score", k42_score);
		k42_datasArray.add(k42_dataObject);
		
		//정보를 받고 입력하는 OneRec 함수를 이용하여 정보 입력
		k42_datasArray.add(OneRec("정연", 209902, 100, 85, 75));
		k42_datasArray.add(OneRec("모모", 209903, 90, 75, 85));
		k42_datasArray.add(OneRec("사나", 209904, 90, 85, 75));
		k42_datasArray.add(OneRec("지효", 209905, 80, 75, 85));
		k42_datasArray.add(OneRec("미나", 209906, 90, 85, 55));
		k42_datasArray.add(OneRec("다현", 209907, 70, 75, 65));
		k42_datasArray.add(OneRec("채영", 209908, 100, 75, 95));
		k42_datasArray.add(OneRec("쯔위", 209909, 80, 65, 95));
		
		try {
			//FileWriter를 이용해 파일 생성
			//경로 지정
			FileWriter k42_file = new FileWriter("C:\\Users\\J\\Desktop\\source\\test.json");
			k42_file.write(k42_datasArray.toJSONString()); //쓰기
			k42_file.flush(); //넘기기
			k42_file.close(); //파일 쓰기 닫기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON : " + k42_datasArray); //확인을 위해 내용 출력
		
		
	}
	public static JSONObject OneRec (String k42_name, int k42_studentid, int k42_kor, int k42_eng, int k42_mat) {
		//반복 작업을 처리하기 위한 함수
		JSONObject k42_dataObject = new JSONObject();
		k42_dataObject.put("name", k42_name);
		k42_dataObject.put("studentid", k42_studentid);
		//성적 정보가 들어갈JSONArray 생성
		JSONArray score = new JSONArray();
		score.add(k42_kor); //국어 성적
		score.add(k42_eng); //영어 성적
		score.add(k42_mat); //수학 성적
		k42_dataObject.put("score", score);
		
		return k42_dataObject; //완성된 dataObject를 반환한다
	}
}
