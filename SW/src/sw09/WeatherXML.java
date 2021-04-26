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
		//���� ó��, xml�Ľ��� ���� ���� ó��
		DocumentBuilder k42_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//�Ľ��� ���� document builder ��ü ����
				
		Document k42_doc = k42_docBuilder.parse(new File("C:\\Users\\J\\Desktop\\source\\aaa.xml"));
		//pc���� ����� xml������ �ҷ��鿩 ó���ϱ� ���� ��ü��θ� �������ش�
		
		String k42_seq = ""; //48�ð� �� n��°
		String k42_hour = ""; //���׿��� �� 3�ð� ����
		String k42_day = ""; //1��° �� ( 0 ���� / 1 ���� / 2 ��)
		String k42_temp = ""; //���� ���
		String k42_tmx = ""; //�ְ� ���
		String k42_tmn = ""; //���� ���
		String k42_sky = ""; //�ϴ� ���� (1: ���� 2: ���� ���� 3: ���� ���� 4: �帲)
		String k42_pty = ""; //���� ���� (0: ���� 1: �� 2: ��/�� 3: ��/�� 4: ��)
		String k42_wfKor = ""; //���� kor
		String k42_wfEn = ""; //���� eng
		String k42_pop = ""; //���� Ȯ��
		String k42_r12 = ""; //12�ð� ���� ������
		String k42_s12 = ""; //12�ð� ���� ������
		String k42_ws = ""; //ǳ�� (m/s)
		String k42_wd = "";  //ǳ�� (0~7, ��, �ϵ�, ��, ����, ��, ����, ��, �ϼ�)
		String k42_wdKor = ""; //ǳ�� kor
		String k42_wdEn = ""; //ǳ�� eng
		String k42_reh = ""; //���� %
		String k42_r06 = ""; //6�ð� ���� ������
		String k42_s06 = ""; //6�ð� ���� ������
		
		Element k42_root = k42_doc.getDocumentElement();
		NodeList k42_tag_001 = k42_doc.getElementsByTagName("data");
		
		System.out.printf(" %-6s|%-4s|%-6s|%-8s|%-9s|%-9s|"
						+ "%-8s|%-6s|%-9s|%-13s|%-3s|%-6s|"
						+ "%-6s|%-18s|%-4s|%-6s|%-4s|%-4s|\n", //���
						"seq", "hour", "day", "temp", "tmx", "tmn", "sky", "pty", "wfKor", "wfEn", 
						"pop", "r12", "s12", "ws", "wd", "wdKor", "wdEn", "reh", "r06", "s06"
						); //�ӽ÷� ĭ�� ������ ���� "|"�Բ� ���
		System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < k42_tag_001.getLength(); i++) { //data�� ���� �ȿ��� �ݺ�
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
			//������ ���� tag name���� �ʿ��� ��Ҹ� �����´�
			
			//seq, hour, day, temp, tmx, tmn, sky, pty, wfKor, wfEn, pop, r12, s12, ws, wd, wdKor, wdEn, reh, r06, s06
			//�ʿ��� ��ҵ�
			
			System.out.printf(" %-4s|%-4s|%-4s|%-6s��|%-7s��|%-7s��|"
							+ "%-4s|%-5s|%-4s|%-4s|%-2s%%|%-4sml|"
							+ "%-4sml|%-18s|%-4s|%-4s|%-4s|%-3s%%|\n",
					getseq(k42_seq), k42_hour, getday(k42_day), k42_temp, k42_tmx, k42_tmn, printBlank(strCut(getsky(k42_sky), 8), 8), 
					getpty(k42_pty), printBlank(strCut(k42_wfKor, 9), 9), printBlank(strCut(k42_wfEn, 13), 13), k42_pop, k42_r12, k42_s12, 
					k42_ws, k42_wd, printBlank(strCut(k42_wdKor, 4), 6), k42_wdEn, k42_reh, k42_r06, k42_s06
					); 
			//���� ��Ҵ¹ݺ��� ������ ����Ѵ�
			//�Ʒ� get~(), printblank, strcut�� ����� ����Ͽ� �ʿ��� �������� ����Ѵ�
		}
	}
	public static String printBlank(String k42_str, int k42_i) throws UnsupportedEncodingException { 
		//���� Ÿ�Կ� ���� ���� ���� �����ϱ� ���� �Լ�
		//k42_str = ���� ���ڿ�, k42_i = ������ �����Ͽ� ����� ���ڼ�
		int k42_strBytes = k42_str.getBytes("MS949").length; //���� ���ڿ��� byte���� ������ ����
		//MS949 ���ڵ� �� �ѱ� �� ���� �� 2Byte
		int k42_blank = 0; //���� �� ���� ����

		k42_blank = k42_strBytes; //���� int i ���� blank�� ���� �� ��ŭ ���� ���
		
		String k42_result = "";
		k42_result += k42_str; //return�� �� result�� ���� ���ڿ� ���� ����
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //���ڿ� �ڿ� ���� ����
		}
		return k42_result; //ó�� �� ���� ���ڿ�
	}
	public static String strCut(String k42_str, int k42_length){
		// ���ڿ��� ����Ʈ ������ �ڸ��� ���� �Լ�         
		String k42_result = k42_str; //���� ���ڿ�
		int k42_oL = 0, k42_rF = 0, k42_rL = 0;
		try {
			byte[] k42_bytes = k42_result.getBytes("UTF-8"); //����Ʈ�� ���ڵ��Ͽ� �迭�� ����
			int k42_j = 0;
			k42_j = k42_rF;
			while(k42_j < k42_bytes.length) { //����Ʈ ���� ������
				if((k42_bytes[k42_j] & 0x80) != 0) { //�ѱ� ���ڵ� ����
					if(k42_oL+2 > k42_length) { //������ ���̸� �ʰ��ߴٸ� �ݺ��� Ż��
						break;
					} 
					k42_oL+=2; k42_rL+=3; k42_j+=3;
					} else {
						if(k42_oL+1 > k42_length) { //������ ���̸� �ʰ��ߴٸ� �ݺ��� Ż��
						break;
					} 
					++k42_oL; ++k42_rL; ++k42_j; //1�� �߰��Ѵ�
					}       
				}       
			k42_result = new String(k42_bytes, k42_rF, k42_rL, "UTF-8");  // charset �ɼ� ��� (String class)
		} catch(UnsupportedEncodingException e){  //����ó��
			e.printStackTrace();  //���� ����, ��ġ ���
		} 
		return k42_result;   
		}
	public static String getseq(String k42_seq) {
		int k42_seqInt = Integer.parseInt(k42_seq); //seq = 48�ð� �� �� ��°���� ��Ÿ���� ����
		k42_seq = (k42_seqInt * 3) + "�ð�"; //48�ð� ������ ���� ���� 3�� �����ش�
		return k42_seq;
	}
	public static String getday (String k42_day) {
		switch(k42_day) { //day�� ���� ���� �� ������ ��ȯ���ش�
		case "0":
			k42_day = "����";
			break;
		case "1":
			k42_day = "����";
			break;
		case "2":
			k42_day = "��";
			break;
		}
		return k42_day;
	}
	public static String getsky (String k42_sky) {
		switch(k42_sky) { //sky�� ���� ���� �ϴ� ���¸� ��ȯ���ش�
		case "1":
			k42_sky = "����";
			break;
		case "2":
			k42_sky = "��������";
			break;
		case "3":
			k42_sky = "��������";
			break;
		case "4":
			k42_sky = "�帲";
			break;
		}
		return k42_sky;
	}
	public static String getpty (String k42_pty) {
		switch(k42_pty) { //pty�� ���� ���� ���� ������ ��ȯ���ش�
		case "0":
			k42_pty = "����";
		case "1":
			k42_pty = "��";
			break;
		case "2":
			k42_pty = "��/��";
			break;
		case "3":
			k42_pty = "��/��";
			break;
		case "4":
			k42_pty = "��";
			break;
		}
		return k42_pty;
	}
}
