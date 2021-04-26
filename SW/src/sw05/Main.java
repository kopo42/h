package sw05;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCal(); //메인 함수에서 실행
	}
	public static void printCal() {
		//calendar 객체를 이용하여 날짜, 요일 정보 가져오기
		Calendar k42_cal = Calendar.getInstance(); //Calendar의 getInstance 사용, 현재 정보 획득
		//int Weekday = 5;
		//주 5일
		//int[] End = {31, 29, 31, 30, 31, 30, 31, 30, 31, 31, 30, 31};
		//말일을 배열로 저장한다
		
		for(int k42_mon = 0; k42_mon < 12; k42_mon ++) { //월 지정을 위한 반복문
			System.out.printf("\n\n%15d월\n", k42_mon + 1);
			System.out.printf(" ============================\n");
			System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n", "일", "월", "화", "수", "목", "금", "토");
			//cal 객체에 사용자가 원하는 정보 대입
			k42_cal.set(Calendar.YEAR, 2021); //올해 연도
			k42_cal.set(Calendar.MONTH, k42_mon); //반복문에서 지정된 정수 mon
			k42_cal.set(Calendar.DATE, 1); //일자
			
				int k42_firstday = k42_cal.get(Calendar.DAY_OF_WEEK); //해당월의 1일 정보 획득
				for (int k42_i = 1; k42_i <k42_firstday; k42_i++) { //1일 전까지
					System.out.print("    ");  //공백 출력
				}
				
				int k42_end = k42_cal.getActualMaximum(Calendar.DATE); //해당월의 마지막날 정보 획득
				for (int k42_j = 1; k42_j <= k42_end; k42_j ++) { //말일까지 일자 출력
					k42_cal.set(Calendar.DATE, k42_j); //반복문의 j에 대하여 일자 정보 설정
					if(k42_j < 10) { //j가 한자리 수일 경우
						System.out.printf("%4d", k42_j); //자리값을 맞추어 출력
					} else {
						System.out.printf("%4d", k42_j); //마찬가지로 자리값을 맞추어 출력
					}
					int k42_newLine = k42_cal.get(Calendar.DAY_OF_WEEK); //줄 바꾸기 위한 정수형 변수 지정
					if(k42_newLine % 7 == 0) { //7일마다
							System.out.println(); //줄바꿈
						}
				}
		}
	}
}
