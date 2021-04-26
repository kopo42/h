package sw08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Wdistance {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//엑셀 옵션 -> tab을 기준으로 txt 저장
		File k42_file = new File ("c:\\Users\\J\\Desktop\\무료와이파이정보.txt"); //경로 및 파일명 지정
		BufferedReader k42_br = new BufferedReader (new FileReader(k42_file)); //파일 읽기 객체 생성
		
		String k42_str; //br.readLine으로 읽어들인 파일 내용을 저장할 변수
		
		if((k42_str = k42_br.readLine()) == null) { //읽어들인 내용이 없을 경우
			System.out.println("this file is empty"); //안내문 출력
			return; //조건문 나가기
		}
		String[] k42_field_name = k42_str.split("\t"); // tab을 기준으로 나눈다
		//field_name = 필드명
		
		double k42_lat = 37.3860521; //위도
		double k42_lng = 127.1214038; //경도
		
		int k42_lineCnt = 0; //줄 개수를 저장할 변수  
		
		while((k42_str = k42_br.readLine()) != null) { //읽어들인 내용이 존재할 경우
			try {
				String[] k42_field = k42_str.split("\t"); //필드 내용 (tab 기준)
				System.out.printf("******[ %d번째 항목 ]******\n", k42_lineCnt);
				
				System.out.printf(" %s : %s\n", k42_field_name[9], k42_field[9]); //필드 9 = 지번주소
				System.out.printf(" %s : %s\n", k42_field_name[13], k42_field[13]); //필드 12 = 위도
				System.out.printf(" %s : %s\n", k42_field_name[14], k42_field[14]); //필드 13 = 경도
				
				double k42_distance = Math.sqrt(Math.pow(Double.parseDouble(k42_field[13]) - k42_lat, 2)
						+ Math.pow(Double.parseDouble(k42_field[14]) - k42_lng, 2));
				//피타고라스 거리 정리 = {(a - c)^2 + (b - d)^2}의 루트값
				
				System.out.printf(" 현재 위치와의 거리 : %f%s\n", k42_distance * 100, "km");
				System.out.println("****************************");
				k42_lineCnt++; //다음 항목 출력을 위해 1을 더해 다음 숫자로 바꿔준다	
			} catch(ArrayIndexOutOfBoundsException e) { //실행 시 에러 요인 확인하여 예외처리
				System.out.println("ArrayIndexOutOfBoundsException");
			} catch(NumberFormatException e) {
				System.out.println("NumberFormatException");
			}
		}
		k42_br.close();
	}
}

