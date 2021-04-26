package sw09;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		//파일 처리, xml파싱을 위한 예외 처리
		DocumentBuilder k42_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//파싱을 위한 document builder 객체 생성
				
		Document k42_doc = k42_docBuilder.parse(new File("C:\\Users\\J\\Desktop\\source\\aaa.xml"));
		//pc내에 저장된 xml파일을 불러들여 처리하기 위해 전체경로를 지정해준다
		
		String k42_seq = ""; //48시간 중 n번째
		String k42_hour = ""; //동네예보 중 3시간 단위
		String k42_day = ""; //1번째 날 ( 0 오늘 / 1 내일 / 2 모레)
		String k42_temp = ""; //현재 기온
		String k42_tmx = ""; //최고 기온
		String k42_tmn = ""; //최저 기온
		String k42_sky = ""; //하늘 상태 (1: 맑음 2: 구름 조금 3: 구름 많음 4: 흐림)
		String k42_pty = ""; //강수 상태 (0: 없음 1: 비 2: 비/눈 3: 눈/비 4: 눈)
		String k42_wfKor = ""; //날씨 kor
		String k42_wfEn = ""; //날씨 eng
		String k42_pop = ""; //강수 확률
		String k42_r12 = ""; //12시간 예상 강수량
		String k42_s12 = ""; //12시간 예상 적설량
		String k42_ws = ""; //풍속 (m/s)
		String k42_wd = "";  //풍향 (0~7, 북, 북동, 동, 남동, 남, 남서, 서, 북서)
		String k42_wdKor = ""; //풍향 kor
		String k42_wdEn = ""; //풍향 eng
		String k42_reh = ""; //습도 %
		String k42_r06 = ""; //6시간 예상 강수량
		String k42_s06 = ""; //6시간 예상 적설량
		
		Element k42_root = k42_doc.getDocumentElement();
		NodeList k42_tag_001 = k42_doc.getElementsByTagName("data");
		
		System.out.printf(" %-6s|%-4s|%-6s|%-8s|%-9s|%-9s|"
						+ "%-8s|%-6s|%-9s|%-13s|%-3s|%-6s|"
						+ "%-6s|%-18s|%-4s|%-6s|%-4s|%-4s|\n", //헤더
						"seq", "hour", "day", "temp", "tmx", "tmn", "sky", "pty", "wfKor", "wfEn", 
						"pop", "r12", "s12", "ws", "wd", "wdKor", "wdEn", "reh", "r06", "s06"
						); //임시로 칸을 나누기 위해 "|"함께 출력
		System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < k42_tag_001.getLength(); i++) { //data의 길이 안에서 반복
			k42_seq = k42_tag_001.item(i).getAttributes().getNamedItem("seq").getNodeValue();
			
			Element elmt = (Element)k42_tag_001.item(i);
			k42_hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
			k42_day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
			k42_temp = elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue();
			k42_tmx = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
			k42_tmn = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
			k42_sky = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue();
			k42_pty = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
			k42_wfKor = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
			k42_wfEn = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
			k42_pop = elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue();
			k42_r12 = elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue();
			k42_s12 = elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue();
			k42_ws = elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue();
			k42_wd = elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue();
			k42_wdKor = elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue();
			k42_wdEn = elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue();
			k42_reh = elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue();
			k42_r06 = elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue();
			k42_s06 = elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue();
			//데이터 내의 tag name으로 필요한 요소를 가져온다
			
			//seq, hour, day, temp, tmx, tmn, sky, pty, wfKor, wfEn, pop, r12, s12, ws, wd, wdKor, wdEn, reh, r06, s06
			//필요한 요소들
			
			System.out.printf(" %-4s|%-4s|%-4s|%-6s℃|%-7s℃|%-7s℃|"
							+ "%-4s|%-5s|%-4s|%-4s|%-2s%%|%-4sml|"
							+ "%-4sml|%-18s|%-4s|%-4s|%-4s|%-3s%%|\n",
					getseq(k42_seq), k42_hour, getday(k42_day), k42_temp, k42_tmx, k42_tmn, printBlank(strCut(getsky(k42_sky), 8), 8), 
					getpty(k42_pty), printBlank(strCut(k42_wfKor, 9), 9), printBlank(strCut(k42_wfEn, 13), 13), k42_pop, k42_r12, k42_s12, 
					k42_ws, k42_wd, printBlank(strCut(k42_wdKor, 4), 6), k42_wdEn, k42_reh, k42_r06, k42_s06
					); 
			//내부 요소는반복문 내에서 출력한다
			//아래 get~(), printblank, strcut의 기능을 사용하여 필요한 형식으로 출력한다
		}
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
	public static String getseq(String k42_seq) {
		int k42_seqInt = Integer.parseInt(k42_seq); //seq = 48시간 중 몇 번째인지 나타내는 변수
		k42_seq = (k42_seqInt * 3) + "시간"; //48시간 단위로 보기 위해 3을 곱해준다
		return k42_seq;
	}
	public static String getday (String k42_day) {
		switch(k42_day) { //day의 값에 따라 일 정보를 반환해준다
		case "0":
			k42_day = "오늘";
			break;
		case "1":
			k42_day = "내일";
			break;
		case "2":
			k42_day = "모레";
			break;
		}
		return k42_day;
	}
	public static String getsky (String k42_sky) {
		switch(k42_sky) { //sky의 값에 따라 하늘 상태를 반환해준다
		case "1":
			k42_sky = "맑음";
			break;
		case "2":
			k42_sky = "구름조금";
			break;
		case "3":
			k42_sky = "구름많음";
			break;
		case "4":
			k42_sky = "흐림";
			break;
		}
		return k42_sky;
	}
	public static String getpty (String k42_pty) {
		switch(k42_pty) { //pty의 값에 따라 강수 정보를 반환해준다
		case "0":
			k42_pty = "없음";
		case "1":
			k42_pty = "비";
			break;
		case "2":
			k42_pty = "비/눈";
			break;
		case "3":
			k42_pty = "눈/비";
			break;
		case "4":
			k42_pty = "눈";
			break;
		}
		return k42_pty;
	}
}
