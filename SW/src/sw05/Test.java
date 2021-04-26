package sw05;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//console font = consolas normal 11

public class Test {
	public static void main(String[] args) throws ParseException {
		printer1();
	}
	public static void printer1() throws ParseException {
		//제품명, 가격 정보가 30개 각각 이상이므로 효율성을 위해 selenium, webdriver를 활용한 크롤링으로 정보를 추출함
		String[] ITEM = {"뽀로로 블루베리 맛 235ml", "[팔도] 뽀로로 보리차 220ml", 
				"피코크 콜롬비아 안티오키아 수프리모 1kg (홀빈)", "프레스코발디 카스틸리오니 끼안티", 
				"피죤 주방세제 퓨어 750ml 애플밤", "피죤 주방세제 퓨어 750ml 버진모히토", 
				"건조기용 피죤 라피에스타 40매", "건조기용 피죤 미스틱레인 40매"};
		
		int[] PRICE = {740000, 7400, 14980, 22000, 65000, 6500, 6500, 6500};
		
		//수량 num[]에 1부터 3까지의 정수 난수를 지정한다
		int[] num = new int[ITEM.length];
		for(int i = 0; i < ITEM.length; i++) {
			int rand = (int) (Math.random() * 3 + 1);
			num[i] = rand;
		}
		//면세품목 지정을 위한 참, 거짓 배열
		boolean[] TAXFREE = {true, true, true, true, true, true, 
				true, true, true, true, true, true, 
				true, true, true, true, true, false, 
				true, true, true, false, true, true, 
				true, true, true, true, true, true};
		/*
		boolean[] TAXFREE = {false, false, false, false, false, false, 
				false, false, false, false, false, false, 
				false, false, false, false, false, false, 
				false, false, false, false, false, false, 
				false, false, false, false, false, false};
		*/
		
		Calendar k42_cal = Calendar.getInstance(); //날짜 출력을 위한 calendar 객체
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy-MM-d HH:mm:ss"); //date format 생성
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //시간 정보 획득
		
		String HEADER = "emart";
		System.out.printf("  %s", HEADER);
		System.out.printf("%33s\n", "이마트 죽전점 (031)888-1234"); //오른쪽으로 정렬하여 출력한다 (printf)
		System.out.printf("%39s\n", "206-85-50913 강희석");//오른쪽으로 정렬하여 출력한다 (printf)
		System.out.printf("%37s\n", "용인 수지구 포은대로 552");//오른쪽으로 정렬하여 출력한다 (printf)
		
		System.out.println("영수증 미지참시 교환/환불 불가"
				+ "\n정상상품에 한함, 30일 이내(신선 7일)"
				+ "\n※일부 브랜드매장 제외(매장 고지물 참조)"
				+ "\n교환/환불 구매점에서 가능(결제카드 지참)\n");
		
		System.out.printf("[구 매]%s %s\n", k42_TIME, "POS:0011-9861"); //처리 시간을 string으로 저장하여 출력한다
		System.out.println("--------------------------------"); //구분선
		System.out.printf("%10s %10s %10s %10s\n", "상품명", "단  가", "수량", "금  액");
		System.out.println("--------------------------------"); //구분선
		
		int totalamount = 0; //총 구매수량
		int totalTaxFree = 0; //총 면세 품목
		int totalTaxincluded = 0; //총 과세 품목
		
		for(int i = 0; i < ITEM.length; i++) { //영수증 출력을 위한 반복문
			int[] sum = new int[ITEM.length]; //합계 저장을 위한 정수 배열
			sum[i] = PRICE[i] * num[i];
			if(TAXFREE[i] == false) { //즉 면세품목이라면
				System.out.printf("* %-10.9s\t%6s\t%d%10s\n", //마찬가지로 printf로 정렬한다
						ITEM[i], NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxFree += PRICE[i]*num[i]; //면세품목 합계 = 가격 배열*수량 배열
			} else {
				System.out.printf("   %-10.9s\t%6s\t%d%10s\n", //마찬가지로 printf로 정렬한다
						ITEM[i], NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxincluded += PRICE[i]*num[i]; //과세품목 합계
			}
			
			if((i+1) % 5 == 0) {
				System.out.println("--------------------------------");
				//5개마다 구분선 출력
			}
			totalamount += num[i];
			//총 수량 저장
		}
		
		double k42_TAX = 0.1; //세율 10%
		int netprice = (int) (totalTaxincluded / (1 + k42_TAX)); //원가
		int totalTAX = totalTaxincluded - netprice; //부가세 = 과세 가격 - 원가
		int totalPRICE = totalTaxFree + totalTaxincluded + totalTAX; //총 구매금액 = 면세품목 + 과세품목 + 부가세
		
		System.out.println(); //한줄 띄움
		System.out.printf("%22s%30d\n", "총 품목 수량", totalamount);
		System.out.printf("%23s%30s\n", " (*)면세 물품", 
				NumberFormat.getInstance().format(totalTaxFree)); //천단위 쉼표 형식
		System.out.printf("%24s%27s\n", "과세 물품", //같은 간격으로 printf 지정함
				NumberFormat.getInstance().format(totalTaxincluded));
		System.out.printf("%19s%4s%4s%27s\n", "부", "가", "세", 
				NumberFormat.getInstance().format(totalTAX));
		System.out.printf("%20s%9s%27s\n", "합", "계", 
				NumberFormat.getInstance().format(totalPRICE));
		System.out.printf("%-15s%32s\n", " 결 제 대 상 금 액", //-15 = 왼쪽 정렬
				NumberFormat.getInstance().format(totalPRICE)); //결제 대상 금액 = 합계 금액
		System.out.println("--------------------------------");
		System.out.printf("%-15s%24s\n", "0012 KEB 하나", "541707**0484/35860658");//임의로 지정한 카드번호
		System.out.printf("카드결제(IC) %22s %s\n", "일시불 /", NumberFormat.getInstance().format(totalPRICE)); //결제 금액 출력
		System.out.println("--------------------------------");
		System.out.printf("%30s\n","[신세계 포인트 적립]");
		System.out.println("***고객님의 포인트 현황입니다.");
		int point = 164; //금회 발생 포인트
		int pointTOTAL = 5637; //누계 포인트
		int pointA = pointTOTAL - point; //가용 포인트 = 누계 - 금회 발생
		
		System.out.printf("%-10.10s %19s  %7d\n", 
				"금회발생포인트", "9350**9995", point);
		System.out.printf("%-10.10s %19s(   %8s)\n", 
				"누계(가용)포인트", NumberFormat.getInstance().format(pointTOTAL),  //천단위 쉼표 형식
				NumberFormat.getInstance().format(pointA));
		System.out.println("*신세계포인트 유효기간은 2년입니다.");
		System.out.println("--------------------------------");
		System.out.printf("%24s\n", "구매금액기준 무료주차시간 자동부여");
		System.out.printf("%-10s %34s\n", "차량번호 :", "38보****"); //임의 지정 차량번호
		System.out.printf("%s %37s\n", "입차시간 : ", k42_TIME); //입차시간 = 처리시간 or 임의 지정
		System.out.println("--------------------------------");
		System.out.printf("%s %36s", "캐셔:084599 양00", "1150");
		
	}
}
