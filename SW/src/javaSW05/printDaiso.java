package javaSW05;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class printDaiso {
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		printer1();
	}
	public static void printer1() throws ParseException, UnsupportedEncodingException {
		Calendar k42_cal = Calendar.getInstance(); //날짜 출력을 위한 calendar 객체
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); //date format 생성
		//두 date format 객체는 각각 거래시간, 교환/환불 가능일 출력에 쓰임
		DateFormat k42_df = new SimpleDateFormat("MM/dd");
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //date information from SimpleDateFormat
		String k42_TIME2 = k42_df.format(k42_cal.getTime()); //date information from DateFormat
		//to get a refundable date
		Date k42_date = k42_df.parse(k42_TIME2); //시간 정보가 담긴 문자열을 parse해서 사용함
		k42_cal.setTime(k42_date);
		k42_cal.add(Calendar.DATE, 14); //교환/환불은 14일 이내 가능하다
		String k42_refundDATE = k42_df.format(k42_cal.getTime());
		
		String k42_HEADER = "\"국민가게, 다이소\""; //헤더
		String k42_STORE = "(주)아성다이소_분당서현점"; //상호명
		String k42_TEL = "031-702-6016"; //전화번호
		String k42_HQ = "서울 강남구 남부순환로 2748 (도곡동)";
		String k42_NAME = "박정부,신호섭 213-81-52063"; //대표자명
		String k42_LOCAT = "경기도 성남시 분당구 분당로53번길\n11 (서현동)"; //주소
		
		System.out.printf("\n%23s\n", k42_HEADER);
		System.out.printf("%s\n", k42_STORE); //상호명 출력
		System.out.printf("전화:%s\n", k42_TEL); //전화번호 출력
		System.out.printf("본사:%s\n", k42_HQ);
		System.out.printf("대표:%s\n", k42_NAME); //대표자명 출력
		System.out.printf("매장:%s\n", k42_LOCAT); //주소 출력
		
		System.out.println("=========================================="); //구분선
		System.out.printf("%24s\n", "소비자중심경영(CCM) 인증기업");
		System.out.printf("%26s\n", "ISO 9001 품질경영시스템 인증기업");
		System.out.println("=========================================="); //구분선
		
		System.out.printf("          교환/환불 14일(%s)이내,\n", k42_refundDATE); //위에 dateformat에서 구한 일자
		System.out.println("       (전자)영수증, 결제카드 지참 후\n              구입매장에서 가능"); 
		System.out.printf("%25s\n", "포장/가격 택 훼손시 교환/환불 불가"); //가운데 정렬
		System.out.printf("%26s\n", "체크카드 취소 시 최대 7일 소요"); //가운데 정렬
		System.out.println("=========================================="); //구분선
		String k42_POS = "1058231"; //단말기 번호
		System.out.printf("[POS%10s]%27s\n", k42_POS, k42_TIME); //단말기 번호, 처리 시간
		System.out.println("=========================================="); //구분선
		
		String[] k42_ITEM = {"내맘대로 잘라쓰는 뱀줄 전선커버(4M)", "소니 H800 블루투스 이어폰 정품", //제품명 문자열 배열 
				"FUN/파티 가발_파티용품 총107종"}; 
		int[] k42_itemNUM = {1231231, 1004261, 1345675}; //제품번호 정수형 배열
		int[] k42_PRICE = {1000, 5000, 3000}; //금액 정수형 배열
		int[] k42_EA = {1, 1, 2}; //개수 정수형 배열
		int k42_sum = 0; //합계가 저장될 변수 초기화
		
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i++) { //제품명 문자열의 길이 = 제품의 종류 수만큼 반복
			int k42_subtotal = k42_PRICE[k42_i] * k42_EA[k42_i]; //소계 = 해당 제품 금액 * 해당 제품 개수
			System.out.printf("%s%7s%3d%8s\n[%d]\n", printBlank(strCut(k42_ITEM[k42_i], 24), 24),  //byte를 기준으로 문자열 자르기
					NumberFormat.getInstance().format(k42_PRICE[k42_i]), //천단위 쉼표 삽입
					k42_EA[k42_i], //개수
					NumberFormat.getInstance().format(k42_subtotal), //소계
					k42_itemNUM[k42_i]); //품번
			k42_sum += k42_subtotal;
		}
		
		double k42_TAX = 0.1; //세율 변수 선언 (10%)
		int k42_netprice = (int) (k42_sum / (1 + k42_TAX)); //원가 = (정수형 변환) 합계 / (1 + 세율)
		// = 합계 + 합계*세율
		int k42_totalTAX = k42_sum - k42_netprice; //부가세 = 합계 - 원가
		
		System.out.printf("%16s%22s\n", "과세합계", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(k42_netprice));
		System.out.printf("%17s%22s\n", "부가세", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(k42_totalTAX));
		System.out.println("------------------------------------------"); //구분선
		System.out.printf("판매합계%34s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(k42_sum));
		System.out.println("=========================================="); //구분선
		System.out.printf("신용카드%34s\n", //printf를 이용해 정렬 및 자리수 제한하여 출력함
				NumberFormat.getInstance().format(k42_sum));
		System.out.println("------------------------------------------"); //구분선
		System.out.printf("우리카드%34s\n", "538720**********"); //임의로 지정한 카드 정보
		
		String k42_topay = "승인금액 " + NumberFormat.getInstance().format(k42_sum); 
		//정확한 오른쪽 정렬을 위해 "승인금액", 공백1, sum을 포함한 하나의 문자열로 만들어줌
		System.out.printf("승인번호 77982843(0)%18s\n", k42_topay);
		
		System.out.println("=========================================="); //구분선
		System.out.printf("%26s 분당서현점\n", k42_TIME); //SimpleDateFormat으로 얻은 시간 데이터 출력
		System.out.println("상품 및 기타 문의 : 1522-4400");
		System.out.println("멤버십 및 샵다이소 관련 문의 : 1599-2211");
		System.out.printf("%36s\n", "||| || ||||| ||||| || |||||");
		System.out.printf("%31s\n", "2112820610158231");
		//바코드
		
		System.out.println("------------------------------------------"); //구분선
		System.out.println("   ◈ 다이소 멤버십 앱 또는 홈페이지에\n      접속하셔서 " //출력 확인을 위한 임의 줄바꿈 (프린터 출력시 자동 줄바꿈)
				+ "회원가입 후\n      다양한 혜택을 누려보세요! ◈");
	}
	public static String printBlank(String k42_str, int k42_i) throws UnsupportedEncodingException { 
		//문자 타입에 따른 공백 수를 저장하기 위한 함수
		//k42_str = 받은 문자열, k42_i = 공백을 포함하여 출력할 문자수
		int k42_totalBytes = k42_str.getBytes("MS949").length; //받은 문자열의 byte수를 저장할 변수
		//MS949 인코딩 시 한글 한 문자 당 2Byte
		int k42_blank = 0; //공백 수 추후 지정

		k42_blank = k42_totalBytes; //받은 int i 에서 blank의 값을 뺀 만큼 공백 출력
		
		String k42_result = "";
		k42_result += k42_str; //받은 문자열 저장
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //공백 저장
		}
		return k42_result;
	}

	//strCut(k42_ITEM[k42_i], 16)
	public static String strCut(String str, int length){
		// 문자열을 바이트 단위로 자르기 위한 함수         
		String result = str; //받은 문자열
		int oL = 0, rF = 0, rL = 0;
		try {
			byte[] bytes = result.getBytes("UTF-8"); //바이트로 인코딩하여 배열로 저장
			int j = 0;
			j = rF;
			while(j < bytes.length) { //바이트 길이 내에서
				if((bytes[j] & 0x80) != 0) { //한글 인코딩 대조
					if(oL+2 > length) { //지정한 길이를 초과했다면 반복문 탈출
						break;
					} 
					oL+=2; rL+=3; j+=3;
					} else {
						if(oL+1 > length) { //지정한 길이를 초과했다면 반복문 탈출
						break;
					} 
					++oL; ++rL; ++j; //1씩 추가한다
					}       
				}       
			result = new String(bytes, rF, rL, "UTF-8");  // charset 옵션 사용 (String class)
		} catch(UnsupportedEncodingException e){  //예외처리
			e.printStackTrace();  //예외 사유, 위치 출력
		} 
		return result;   
	}
}
