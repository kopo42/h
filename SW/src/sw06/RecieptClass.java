package sw06;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//굴림체10

public class RecieptClass {
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		TitlePrint();
		HeaderPrint();
		itemPrint();
	}
	
	public static void TitlePrint() {
		String k42_HEADER = "emart"; //브랜드 로고
		System.out.printf("\n  %s", k42_HEADER); //줄바꿈 없이 매장 정보와 같은 줄에 출력
		System.out.printf("%25s\n", "이마트 죽전점 (031)888-1234"); //왼쪽으로 정렬하여 출력한다 (printf)
		System.out.printf("%27s\n", "206-85-50913 강희석");//왼쪽으로 정렬하여 출력한다 (printf)
		System.out.printf("%26s\n\n", "용인 수지구 포은대로 552");//왼쪽으로 정렬하여 출력한다 (printf)
		
		System.out.println("영수증 미지참시 교환/환불 불가"
				+ "\n정상상품에 한함, 30일 이내(신선 7일)"
				+ "\n※일부 브랜드매장 제외(매장 고지물 참조)"
				+ "\n교환/환불 구매점에서 가능(결제카드 지참)\n");
	}
	
	public static void HeaderPrint() {
		String k42_TIME = TimeStemp();
		
		System.out.printf("[구 매]%s%19s\n", k42_TIME.substring(0, 16), "POS:0011-9861"); //처리 시간을 string으로 저장하여 출력한다
		System.out.println("------------------------------------------"); //구분선
		System.out.printf("%8s%14s%4s%7s\n", "상품명", "단 가", "수량", "금 액");
		System.out.println("------------------------------------------"); //구분선
	}
	
	public static void itemPrint() throws UnsupportedEncodingException {
		//제품명, 가격 정보가 30개 각각 이상이므로 이마트 상품 페이지에서 가져옴
		String[] k42_ITEM = {"뽀로로 블루베리 맛 235ml", "[팔도] 뽀로로 보리차 220ml", 
				"피코크 콜롬비아 안티오키아 수프리모 1kg (홀빈)", "프레스코발디 카스틸리오니 끼안티", 
				"피죤 주방세제 퓨어 750ml 애플밤", "피죤 주방세제 퓨어 750ml 버진모히토", 
				"건조기용 피죤 라피에스타 40매", "건조기용 피죤 미스틱레인 40매", "액츠 퍼펙트 베이킹소다 3L+200ml", 
				"액츠 퍼펙트 딥클린 3L+200ml", "[종가집] 묵은지김치1.6kg", "프레스코발디 카스틸리오니 토스카나", 
				"피코크 트루워터 330ml", "맑은누리숨 황사방역 마스크 KF94 (대형) 1매 FDA등록 (한국생산/한국부자재사용/개별포장)", 
				"오리온 투유 우유초콜릿 60g", "라이프리 안심매트 10p", "[롯데] 허쉬[HERSHEY`S] 미니어처 155g", 
				"(G)피코크 유기농 밤그대로 100g*2입", "[피코크] 트루 스파클링 레몬(500ml×6입)", 
				"[피코크] 트루스파클링 자몽(500ml×6입)", "피코크 핫바베큐치킨300g", 
				"[20년산] 해남쌀이야기10kg(상등급)", "[피코크] 마몰로 녹차트러플 200g", 
				"[피코크] 과일 그래놀라 380g", "[피코크] 버터플라이 새우튀김 400g", 
				"[피코크] 인절미 그래놀라 380g", "피코크 카라멜초코볼 260g", "피코크 리얼화이트 딸기초코볼 170g", 
				"[피코크] 핫앤스파이시 새우튀김 400g", "[리스테린] 구강청결제 후레쉬버스트 750ml [의약외품]"};
		
		int[] k42_PRICE = {1200, 1200, 14980, 22000, 6500, 6500, 6500, 6500, 9900, 9900, 
				12900, 37000, 1680, 3500, 8260, 2415, 3080, 3486, 3570, 3570, 
				3836, 29800, 4186, 4186, 4186, 4186, 4886, 1000, 5586, 1250000};
		
		//수량 num[]에 1부터 3까지의 정수 난수를 지정한다
		int[] k42_num = new int[k42_ITEM.length];
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i++) {
			int k42_rand = (int) (Math.random() * 3 + 1);
			k42_num[k42_i] = k42_rand;
		}
		int[] k42_amount = {1,2,3,4,5, //수량 정보 정수형 배열
				1,2,3,4,5,1,2,3,4,5,
				1,2,3,4,5,1,2,3,4,5,
				1,2,3,4,5};
		
		//면세품목 지정을 위한 참, 거짓 배열
		boolean[] k42_TAXincluded = {true, true, true, true, true, true, 
				true, true, true, true, true, true, 
				true, true, true, true, true, false, 
				true, true, true, false, true, true, 
				true, true, true, true, true, true};
		
		int[] k42_sum = new int[k42_ITEM.length]; //합계 저장을 위한 정수 배열
		int k42_totalamount = 0; //총 구매수량
		int k42_totalTaxFree = 0; //총 면세 품목
		int k42_totalTaxincluded = 0; //총 과세 품목
		
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i++) { //영수증 출력을 위한 반복문
			k42_sum[k42_i] = k42_PRICE[k42_i] * k42_amount[k42_i];
			// k42_TAXincluded[k42_i] alltrue[k42_i]  allfalse[k42_i]
			
			//면제품목
			if(k42_TAXincluded[k42_i] == false) { //즉 면세품목이라면
				System.out.printf("* %s%10s%3d%11s\n", printBlank(strCut(k42_ITEM[k42_i], 16), 16), //strCut으로 16만큼 자른 후 공백 채워줌
						NumberFormat.getInstance().format(k42_PRICE[k42_i]),
						k42_amount[k42_i], NumberFormat.getInstance().format(k42_sum[k42_i]));
				k42_totalTaxFree += k42_PRICE[k42_i] * k42_amount[k42_i]; //면세품목 합계 = 가격 배열*수량 배열
			} //과세품목 
			else {
				System.out.printf("  %s%10s%3d%11s\n", printBlank(strCut(k42_ITEM[k42_i], 16), 16), 
						NumberFormat.getInstance().format(k42_PRICE[k42_i]),
						k42_amount[k42_i], NumberFormat.getInstance().format(k42_sum[k42_i]));
				k42_totalTaxincluded += k42_PRICE[k42_i] * k42_amount[k42_i]; //과세품목 합계
			}
			if((k42_i + 1) % 5 == 0) {
				System.out.println("------------------------------------------");
				//5개마다 구분선 출력
				//i % 5를 조건으로 설정 시 ITEM[0]부터 구분선이 출력됨
			}
			k42_totalamount ++;
			//총 수량 저장
		}
		TotalPrint(k42_totalamount, k42_totalTaxFree, k42_totalTaxincluded);
	}
	
	public static void TotalPrint(int k42_totalamount, int k42_totalTaxFree, int k42_totalTaxincluded) {
		String k42_TIME = TimeStemp();
		
		double k42_TAX = 0.1; //세율 10%
		int k42_netprice = (int) (k42_totalTaxincluded / (1 + k42_TAX)); //원가
		int k42_totalTAX = k42_totalTaxincluded - k42_netprice; //부가세 = 과세 가격 - 원가
		int k42_totalPRICE = k42_totalTaxFree + k42_netprice + k42_totalTAX; //총 구매금액 = 면세품목 + 과세품목 + 부가세
		
		System.out.println(); //한줄 띄움
		System.out.printf("%16s%2s%s%2s%s%15d\n", "총", "품", "목", "수", "량", k42_totalamount); //정확한 정렬을 위해 문자 하나하나 따로 지정
		System.out.printf("%15s%s%2s%3s%2s%15s\n", "(*)","면", "세","물", "품", 
				NumberFormat.getInstance().format(k42_totalTaxFree)); //천단위 쉼표 형식
		System.out.printf("%16s%2s%3s%2s%15s\n", "과", "세", "물", "품", //같은 간격으로 printf 지정함
				NumberFormat.getInstance().format(k42_netprice));
		System.out.printf("%16s%4s%4s%15s\n", "부", "가", "세", 
				NumberFormat.getInstance().format(k42_totalTAX));
		System.out.printf("%16s%9s%15s\n", "합", "계", 
				NumberFormat.getInstance().format(k42_totalPRICE));
		System.out.printf("%s%2s%2s%2s%2s%2s%25s\n", "결", "제", "대", "상", "금", "액", //-15 = 왼쪽 정렬 (printf 음수)
				NumberFormat.getInstance().format(k42_totalPRICE)); //결제 대상 금액 = 합계 금액
		System.out.println("------------------------------------------");
		System.out.printf("%-15s%25s\n", "0012 KEB 하나", "541707**0484/35860658");//임의로 지정한 카드번호
		
		String k42_topay = "일시불 / " + NumberFormat.getInstance().format(k42_totalPRICE);
		//정확한 오른쪽 정렬을 위해 "승인금액", 공백1, sum을 포함한 하나의 문자열로 만들어줌
		
		System.out.printf("카드결제(IC)%27s\n", k42_topay); //결제 금액 출력
		System.out.println("------------------------------------------");
		System.out.printf("%23s\n","[신세계 포인트 적립]");
		System.out.println("***고객님의 포인트 현황입니다.");
		int k42_point = 164; //금회 발생 포인트
		int k42_pointTOTAL = 5637; //누계 포인트
		int k42_pointA = k42_pointTOTAL - k42_point; //가용 포인트 = 누계 - 금회 발생
		
		System.out.printf("%-10.10s%18s%7d\n", 
				"금회발생포인트", "9350**9995", k42_point);
		System.out.printf("%-10.10s%13s(%10s)\n", 
				"누계(가용)포인트", NumberFormat.getInstance().format(k42_pointTOTAL),  //천단위 쉼표 형식
				NumberFormat.getInstance().format(k42_pointA));
		System.out.println("*신세계포인트 유효기간은 2년입니다.");
		System.out.println("------------------------------------------");
		System.out.printf("%22s\n", "구매금액기준 무료주차시간 자동부여");
		System.out.printf("%-10s %26s\n", "차량번호 :", "38보****"); //임의 지정 차량번호
		System.out.printf("%s %30s\n", "입차시간 : ", k42_TIME); //입차시간 = 처리시간 or 임의 지정
		System.out.println("------------------------------------------");
		System.out.printf("%s%5s%25s\n", "캐셔:084599", "양00", "1150"); //임의 지정 캐셔 정보
		
		System.out.printf("\n%35s\n", "||| || ||||| ||||| || |||||"); //바코드 위치 예시
		System.out.printf("%35s\n", "||| || ||||| ||||| || |||||");
		System.out.printf("%15s%s", k42_TIME.substring(0, 10).replace("-", ""), "/00119861/00164980/31"); 
		//SimpleDateFormat에서 얻은 시간 정보를 년, 월, 일까지만 잘라낸 후 "-"를 제거하여 숫자의 연속처럼 출력함
	}
	
	public static String TimeStemp() {
		Calendar k42_cal = Calendar.getInstance(); //날짜 출력을 위한 calendar 객체
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy-MM-d HH:mm:ss"); //date format 생성
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //시간 정보 획득
		return k42_TIME;
	}
	
	public static String printBlank(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//문자 타입에 따른 공백 수를 저장하기 위한 함수
		//k42_str = 받은 문자열, k42_i = 공백을 포함하여 출력할 문자수
		int k42_strBytes = k42_str.getBytes("MS949").length; //받은 문자열의 byte수를 저장할 변수
		//MS949 인코딩 시 한글 한 문자 당 2Byte
		int k42_blank = 0; //공백 수 추후 지정
			k42_blank = k42_strBytes; //받은 int i 에서 blank의 값을 뺀 만큼 공백 출력
		
		String k42_result = "";
		k42_result += k42_str; //return될 값 result에 받은 문자열 먼저 저장
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //문자열 뒤에 공백 저장
		}
		return k42_result; //처리 후 사용될 문자열
	}
	
	public static String strCut(String k42_str, int k42_length){
		// 문자열을 바이트 단위로 자르기 위한 함수         
		String k42_result = k42_str; //받은 문자열
		int k42_oL = 0, k42_rF = 0, k42_rL = 0;
		try {
			byte[] k42_bytes = k42_result.getBytes("UTF-8"); //바이트로 인코딩하여 배열로 저장
			int k42_j = 0;
			k42_j = k42_rF;
			while(k42_j < k42_bytes.length) { //바이트 길이 내에서
				if((k42_bytes[k42_j] & 0x80) != 0) { //한글 인코딩 대조
					if(k42_oL+2 > k42_length) { //지정한 길이를 초과했다면 반복문 탈출
						break;
					} 
					k42_oL+=2; k42_rL+=3; k42_j+=3;
					} else {
						if(k42_oL+1 > k42_length) { //지정한 길이를 초과했다면 반복문 탈출
						break;
					} 
					++k42_oL; ++k42_rL; ++k42_j; //1씩 추가한다
					}       
				}       
			k42_result = new String(k42_bytes, k42_rF, k42_rL, "UTF-8");  // charset 옵션 사용 (String class)
		} catch(UnsupportedEncodingException e){  //예외처리
			e.printStackTrace();  //예외 사유, 위치 출력
		} 
		return k42_result;   
	}
}
