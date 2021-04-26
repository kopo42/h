package sw05;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//console font = consolas normal 11
public class Reciepts2 {
	public static void main(String[] args) throws ParseException {
		printer1();
	}
	public static void printer1() throws ParseException {
		Calendar k42_cal = Calendar.getInstance(); //날짜 출력을 위한 calendar 객체
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy.MM.d HH:mm:ss"); //date format 생성
		//두 date format 객체는 각각 거래시간, 교환/환불 가능일 출력에 쓰임
		DateFormat k42_df = new SimpleDateFormat("MM/dd");
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //date information from SimpleDateFormat
		String k42_TIME2 = k42_df.format(k42_cal.getTime()); //date information from DateFormat
		//to get a refundable date
		Date date = k42_df.parse(k42_TIME2); //시간 정보가 담긴 문자열을 parse해서 사용함
		k42_cal.setTime(date);
		k42_cal.add(Calendar.DATE, 14); //교환/환불은 14일 이내 가능하다
		String refundDATE = k42_df.format(k42_cal.getTime());
		
		String HEADER = "               \"국민가게, 다이소\""; //헤더
		String k42_STORE = "(주)아성다이소_분당서현점"; //상호명
		String k42_TEL = "031-702-6016"; //전화번호
		String HQ = "서울 강남구 남부순환로 2748 (도곡동)";
		String k42_NAME = "박정부, 신호섭 213-81-52063"; //대표자명
		String k42_LOCAT = "경기도 성남시 분당구 분당로53번길 11 (서현동)"; //주소
		
		System.out.printf("    %s\n", HEADER);
		System.out.printf("%s\n", k42_STORE); //상호명 출력
		System.out.printf("전화: %s\n", k42_TEL); //전화번호 출력
		System.out.printf("본사: %s\n", HQ);
		System.out.printf("대표 : %s\n", k42_NAME); //대표자명 출력
		System.out.printf("매장: %s\n", k42_LOCAT); //주소 출력
		
		System.out.println("======================================="); //구분선
		System.out.println("        소비자 중심경영(CCM) 인증기업");
		System.out.println("       ISO 9001 품질경영시스템 인증기업");
		System.out.println("======================================="); //구분선
		
		System.out.printf("         교환/환불 14일(%s)이내,\n", refundDATE); //위에 dateformat에서 구한 일자
		System.out.println(" (전자)영수증, 결제카드 지참 후 구입매장에서 가능");
		System.out.println("      포장/가격 택 훼손시 교환/환불 불가");
		System.out.println("        체크카드 취소 시 최대 7일 소요");
		System.out.println("======================================="); //구분선
		String k42_POS = "1058231"; //단말기 번호
		System.out.printf("[POS  %s]     %s\n", k42_POS, k42_TIME); //단말기 번호, 처리 시간
		System.out.println("======================================="); //구분선
		
		String item1 = "내맘대로 잘라쓰는 뱀줄 전선커버(4M)";
		int itemNUM1 = 1231231;
		//item1 = item1.substring(0, 14); //제목 길이 제한 출력을 위해 substring을 고려했으나 printf를 이용한 정렬이 더 효율적이었다
		int k42_price1 = 1000;
		int ea1 = 1;
		int k42_subtotal1 = k42_price1 * ea1; //소계: 품목 단가 * 수량
		
		String item2 = "소니 WF-H800 블루투스 이어폰 정품";
		int itemNUM2 = 1004261;
		//item2 = item2.substring(0, 14);
		int k42_price2 = 4000;
		int ea2 = 2;
		int k42_subtotal2 = k42_price2 * ea2;
		
		String item3 = "FUN/파티 가발_파티용품 107종";
		int itemNUM3 = 1345675;
		//item3 = item3.substring(0, 14);
		int k42_price3 = 3000;
		int ea3 = 1;
		int k42_subtotal3 = k42_price3 * ea3;

		System.out.printf("%-5.14s\t%s %d  %5s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				item1, NumberFormat.getInstance().format(k42_price1),
				ea1, NumberFormat.getInstance().format(k42_subtotal1));
		//천단위 쉼표 삽입 시 굳이 변수를 지정하지 않고 바로 printf 자리에 위치시켜 출력함
		System.out.printf("[%d]\n", itemNUM1); //품목번호
		
		System.out.printf("%-10.14s\t%s %d  %5s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				item2, NumberFormat.getInstance().format(k42_price2),
				ea2, NumberFormat.getInstance().format(k42_subtotal2));
		System.out.printf("[%d]\n", itemNUM2);
		
		System.out.printf("%-10.14s\t%s %d  %5s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				item3, NumberFormat.getInstance().format(k42_price3),
				ea3, NumberFormat.getInstance().format(k42_subtotal3));
		System.out.printf("[%d]\n", itemNUM3);
		
		int sum = k42_subtotal1 + k42_subtotal2 + k42_subtotal3; //합계 = 소계1 + 소계2 + 소계3
		
		double k42_TAX = 0.1; //세금 변수 선언 (10%)
		int netprice = (int) (sum / (1 + k42_TAX)); //원가
		int totalTAX = sum - netprice; //부가세 = 합계 - 원가
		
		System.out.printf("%15s%34s\n", "과세합계", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(netprice));
		System.out.printf("%15s%37s\n", "부가세", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(totalTAX));
		System.out.println("---------------------------------------"); //구분선
		System.out.printf("판매합계\t %40s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(sum));
		System.out.println("======================================="); //구분선
		System.out.printf("신용카드\t %40s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(sum));
		System.out.println("---------------------------------------"); //구분선
		System.out.println("우리카드               538720**********");
		System.out.printf("승인번호 77982843(0)     승인금액 %s\n", 
				NumberFormat.getInstance().format(sum));
		System.out.println("======================================="); //구분선
		System.out.printf("%30s 분당서현점\n", k42_TIME);
		System.out.println("상품 및 기타 문의 : 1522-4400");
		System.out.println("멤버십 및 샵다이소 관련 문의 : 1599-2211");
		
		//바코드
		
		System.out.println("---------------------------------------"); //구분선
		System.out.println("◈ 다이소 멤버십 앱 또는 홈페이지에 접속하셔서 "
				+ "회원가입 후 다양한 혜택을 누려보세요! ◈");
	}
}
