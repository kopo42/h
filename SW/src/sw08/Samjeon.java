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
		//앞에서 조회한 데이터를 정제하기 위한 코드
		//앞서 정제한 csv파일을 활용하여 필요한 데이터를 추출한다
		File k42_file = new File("C:\\Users\\J\\Desktop\\source\\day_data\\samjeon\\test3.csv");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_file));
		//파일을 읽기 위한 객체
		int k42_cnt = 0; //처리 건수를 저장
		String k42_str; //읽어들인 파일 내용을 저장할 변수
		ArrayList <Integer> k42_nums = new ArrayList<Integer>(); //가격 부분을 정수형으로 변환하여 저장할 list
		ArrayList <String> MAXdate = new ArrayList<String>(); //최대, 최소값의 날짜 데이터를 저장하기 위한 list
		ArrayList <String> MINdate = new ArrayList<String>();
		
		while((k42_str = k42_br.readLine()) != null) {
			String[] k42_field = k42_str.split(","); //csv이므로 "," 기준으로 나눈다
			List<String> k42_tempList = new ArrayList<String>(Arrays.asList(k42_field)); //나눈 값이 저장된 배열을 list로
			List<List<String>> k42_list = new ArrayList<List<String>>(); //행, 열을 사용하기 위해 추가로 선언한 list
			k42_list.add(k42_tempList); //행, 열 값이 저장됨
			
			int k42_j = 0; //열을 진행하기 위한 정수형 변수
			List<String> k42_line = k42_list.get(k42_j); //csv 파일의 행, 열값을 사용함
			k42_j++; //다음 열로 넘어가기 위함
			
			k42_nums.add(Integer.parseInt(k42_line.get(3))); //4번째 필드 값 저장 (0, 1, 2, 3)
			
			if(k42_line.get(3).equals("1503000")) {
				//최대값과 일치하는 값을 가진 열에서 데이터 추출
				MAXdate.add(k42_line.get(1)); 
			}
			if(k42_line.get(3).equals("1067000")) {
				//최소값과 일치하는 값을 가진 열에서 데이터 추출
				MINdate.add(k42_line.get(1));
			}
			k42_cnt++;
		}
		int k42_max = getMAX(k42_nums);
		//k42_max = k42_max / 50; //종가이므로 /50
		int k42_min = getMIN(k42_nums);
		//k42_min = k42_min / 50;
		System.out.println("<삼성전자 최고, 최저 종가 추출 (시가 기준)>");
		System.out.println("\n최고, 최저가 = 금액(NNN KRW)");
		System.out.println("일자[YYYYMMDD]\n");
		System.out.printf("처리 : %d건\n\n", k42_cnt);
		System.out.printf("최고가 = %sKRW\n%s\n\n", NumberFormat.getInstance().format(k42_max), MAXdate);
		System.out.println(k42_max / 50);
		System.out.printf("최저가 = %sKRW\n%s\n", NumberFormat.getInstance().format(k42_min), MINdate);
		System.out.println(k42_min / 50);
		
		k42_br.close(); //파일 읽기 닫기
	}
	public static int getMAX(ArrayList <Integer> nums) { //최대값을 구하기 위한 함수
		int max = Collections.max(nums); //대상이 list이므로 collections 내의 클래스 사용
		for(int i = 0; i < nums.size(); i++) { //list의 크기 내에서
		    if(max < nums.get(i)) { //최대값보다 큰 값이 존재한다면 그 값을 최대값으로 다시 저장한다
			max = nums.get(i);
		    }
		}
		return max;
	}
	public static int getMIN(ArrayList <Integer> nums) {
		int min = Collections.min(nums); //대상이 list이므로 collections 내의 클래스 사용
		for(int i = 0; i < nums.size(); i++) { //list의 크기 내에서
		    if(min > nums.get(i)) { //최소값보다 작은 값이 존재한다면 그 값을 최소값으로 다시 저장한다
			min = nums.get(i);
		    }
		}
		return min;
	}
}
