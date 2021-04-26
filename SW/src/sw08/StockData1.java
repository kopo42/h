package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StockData1 { //우선 데이터 파일의 형태를 확인하기 위한 코드

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File k42_file = new File("C:\\Users\\J\\Desktop\\source\\day_data\\THTSKS010H00.dat");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_file));
		
		String k42_readtxt; //아직 사용되지 않음
		int k42_lineCnt = 0; //아직 사용되지 않음
		int k42_n = 1; //br.read()의 결과값을 저장할 정수형 변수
		StringBuffer k42_sb = new StringBuffer();
		//StringBuffer = 문자열을 추가하거나 변경할 때 주로 사용하는 자료형
		
		while(true) {
			char[] k42_CH = new char[1000]; //크기가 1000인 문자 배열
			
			k42_n = k42_br.read(k42_CH);
			//br.read() = 읽어들인 문자 수 반환
			//파일 끝: -1 반환
			
			if(k42_n == -1) break;
			
			for(char k42_c : k42_CH) { //for(변수 선언 부 : 배열) 배열의 값을 차례로 변수에 저장
				if( k42_c == '\n') { //한 문장의 마지막 문자일 때
					System.out.printf("[%s]****\n", k42_sb.toString());
					k42_sb.delete(0, k42_sb.length()); //StringBuffer delete(int start, int end) = 전체 삭제
				} else {
					k42_sb.append(k42_c); //아닐 경우 c를 저장
				}
			}
			k42_lineCnt ++; //다음 항목으로 
		}
		System.out.printf("[%s]****\n", k42_sb.toString());
		k42_br.close(); //파일 읽기 닫기
	}
}
