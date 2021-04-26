package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadWifi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File k42_file = new File ("c:\\Users\\J\\Desktop\\무료와이파이정보.CSV"); //경로 및 파일명 지정
		BufferedReader k42_br = new BufferedReader (new FileReader(k42_file)); //파일 읽기 객체 생성
		
		String k42_str; //br.readLine으로 읽어들인 파일 내용을 저장할 변수
		
		if((k42_str = k42_br.readLine()) == null) { //읽어들인 내용이 없을 경우
			System.out.println("this file is empty"); //안내문 출력
			return; //조건문 나가기
		}
		String[] k42_field_name = k42_str.split(","); //csv이므로 ","을 기준으로 나눈다
		//field_name = 필드명
		
		int k42_lineCnt = 0; //줄 개수를 저장할 변수
		while((k42_str = k42_br.readLine()) != null) { //읽어들인 내용이 존재할 경우
			String[] k42_field = k42_str.split(","); //필드 내용
			System.out.printf("******[ %d번째 항목 ]******\n", k42_lineCnt);
			
			for(int k42_i = 0; k42_i < k42_field_name.length; k42_i++) { //필드명의 개수만큼 반복
				System.out.printf(" %s : %s\n", k42_field_name[k42_i], k42_field[k42_i]);
				//필드명 : 필드 내용 \n을 반복적으로 출력
			}
			System.out.println("****************************");
			if(k42_lineCnt == 100) break; //100개까지만 출력한다
			k42_lineCnt++; //다음 항목 출력을 위해 1을 더해 다음 숫자로 바꿔준다
		}
		k42_br.close();
	}

}
