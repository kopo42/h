package sw08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main3 {
	public static void main(String[] args) throws IOException { 
		//앞에서 조회한 데이터를 정제하기 위한 코드
		//특정 코드의 데이터만 추출하여 파일로 저장
		File k42_file = new File("C:\\Users\\J\\Desktop\\source\\day_data\\THTSKS010H00.dat");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_file));
		//파일을 읽기 위한 객체
		
		File k42_file2 = new File("C:\\Users\\J\\Desktop\\source\\day_data\\A005930.csv");
		BufferedWriter k42_bw = new BufferedWriter (new FileWriter(k42_file2)); //파일명 주의
		//파일을 쓰기 위한 객체
		
		String k42_str; //읽어들인 파일 내용을 저장할 변수
		
		int k42_cnt = 0; int k42_wcnt = 0;
		while((k42_str = k42_br.readLine()) != null) {
			StringBuffer k42_sb = new StringBuffer();
			String[] k42_field = k42_str.split("%_%");
			
			if(k42_field.length > 2 && k42_field[2].replace("^", "").trim().substring(0, 7).equals("A005930")){
				//정제된 데이터 내에서, 3번째 (0, 2)필드의 값이 "A005930" (0~7)과 일치하는 경우
				//불필요한 특문("^")을 제거함
				k42_sb.append(k42_field[0].replace("^", "").trim());
				//StringBuffer sb에 "^"을 제거한 문장을 저장한다
				
				for(int k42_i = 1; k42_i < k42_field.length; k42_i++) { //필드의 개수만큼 반복
					k42_sb.append("," + k42_field[k42_i].replace("^", "").trim());
					//StringBuffer sb에 "^"을 제거한 문장을 저장한다
				}
				k42_bw.write(k42_sb.toString()); //위에서 처리된 sb를 파일에 저장
				k42_bw.newLine(); //줄바꿈
				k42_wcnt ++;
			}
			k42_cnt++;
			//결과를 봤을 때 cnt, wcnt는 각각 행, 열의 개수로 추측됨
		}
		k42_br.close(); //파일 읽기 닫기
		k42_bw.close(); //파일 쓰기 닫기
		
		System.out.printf("Program End [%d] [%d] records\n", k42_cnt, k42_wcnt);
	}
}
