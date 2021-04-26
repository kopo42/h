package sw05;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reciepts1 {
	public static void main(String[] args) {
		printer1();
	}
	public static void printer1() {
		String k42_PORT = "2AB2722"; //단말기 번호
		String k42_printNUM = "041224"; //전표번호
		
		String k42_STORE = "아 그집"; //상호명
		String line = "--------------------------------";
		
		String k42_locat = "서울 노원구 석계로13길 43"; //주소
		String[] split = k42_locat.split(" ");
		String k42_NAME = "유창신"; //대표자명
		String k42_IDNUM = "752-53-00558"; //사업자번호
		int k42_TEL = 7055695; //전화번호

		System.out.println(" 신 용 승 인"); //header
		System.out.printf("단말기 : %s", k42_PORT); //단말기 번호 출력
		System.out.printf("전표번호 : %s\n", k42_printNUM); //전표번호 출력
		System.out.printf("가맹점 : %s\n", k42_STORE); //상호명 출력
		
		System.out.printf("주   소 : %s\n", k42_locat); //주소 출력
		
		System.out.printf("대표자 : %s\n", k42_NAME); //대표자명 출력
		System.out.printf("사업자 : %s", k42_IDNUM); //사업자번호 출력
		System.out.printf("        TEL : %d\n", k42_TEL); //전화번호 출력
		System.out.println("--------------------------------"); //구분선
		
		int k42_PRICE = 4800; //가격 변수 선언
		double k42_TAX = 0.1; //세금 변수 선언
		int k42_TAXPRICE = (int)(k42_PRICE * k42_TAX); //부가세 = 가격 * 세금
		int k42_NETPRICE = k42_PRICE + k42_TAXPRICE; //합계 (소비자가)
		//금액 값에 천단위 콤마 형식 지정
		String k42_priceWcomma = NumberFormat.getInstance().format(k42_PRICE); 
		
		//천단위 쉼표 출력을 위해 따로 변수를 지정했으나 printf %s로 한번에 출력하는 편이 더 간편했음
		
		String k42_taxpriceWcomma = NumberFormat.getInstance().format(k42_TAXPRICE);
		String k42_netpriceWcomma = NumberFormat.getInstance().format(k42_NETPRICE);
		//형식 지정된 금액, 부가세, 합계 출력
		System.out.printf("%s%4s", "금", "액");
		System.out.printf("%44s", k42_priceWcomma);
		System.out.print(" 원\n"); //수정시 편의를 위해 원 따로 출력
		System.out.print("부가세");
		System.out.printf("%44s", k42_taxpriceWcomma);
		System.out.print(" 원\n");
		System.out.printf("%s%4s", "합", "계" );
		System.out.printf("%44s", k42_netpriceWcomma);
		System.out.print(" 원\n");
		System.out.println("--------------------------------"); //구분선
		
		String k42_CARDNUM = "5387-20**-****-4613(S)"; //카드번호
		Calendar k42_cal = Calendar.getInstance(); //날짜 출력을 위한 calendar 객체
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy / MM / dd / HH:mm:ss"); //date format 생성
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //시간 정보 획득
		System.out.println("우리카드");
		System.out.printf("카드번호 : %s %4s", k42_CARDNUM, "일시불\n"); //카드번호 출력
		System.out.printf("거래일시 : %s\n", k42_TIME); //거래 일시 출력
		System.out.println("승인번호 : 70404427"); //승인번호 출력
		System.out.println("거래번호 : 357734873739"); //거래번호 출력
		System.out.println("매입 : 비씨카드사     가맹 : 720068568"); //카드사 정보 출력
		System.out.println("알 림 : EDC매출표");
		System.out.println("문의 : TEL) 1544-4700");
		System.out.println("--------------------------------"); //구분선
		System.out.println("                  * 감사합니다 *");
		System.out.println("                    표준V2. 08_20200212");
	}
}
