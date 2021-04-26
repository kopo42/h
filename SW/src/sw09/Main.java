package sw09;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		score1();
	}
	public static void score1() throws SAXException, IOException, ParserConfigurationException {
		//파일 처리, xml파싱을 위한 예외 처리
		DocumentBuilder k42_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//파싱을 위한 document builder 객체 생성
		
		Document k42_doc = k42_docBuilder.parse(new File("C:\\Users\\J\\Desktop\\source\\score.xml"));
		//pc내에 저장된 xml파일을 불러들여 처리하기 위해 전체경로를 지정해준다
		
		Element k42_root = k42_doc.getDocumentElement();
		//root tag = 현재는 잘 쓰이지 않음
		
		NodeList k42_tag_name = k42_doc.getElementsByTagName("name");
		//get element by tag name "name" "studentif" "kor" "eng" "mat"...
		NodeList k42_tag_studentid = k42_doc.getElementsByTagName("studentid");
		NodeList k42_tag_kor = k42_doc.getElementsByTagName("kor");
		NodeList k42_tag_eng = k42_doc.getElementsByTagName("eng");
		NodeList k42_tag_mat = k42_doc.getElementsByTagName("mat");
		
		System.out.println("***************"); //구분선
		for(int k42_i = 0; k42_i < k42_tag_name.getLength(); k42_i++) { //태그로 구분한 크기에 따라
			System.out.printf(" 이름 : %s\n", k42_tag_name.item(k42_i).getFirstChild().getNodeValue());
			//1.The first child of this node. If there is no such node, this returns <code>null</code>.
			//2.The value of this node, depending on its type (by the table)
			System.out.printf(" 학번 : %s\n", k42_tag_studentid.item(k42_i).getFirstChild().getNodeValue());
			System.out.printf(" 국어 : %s\n", k42_tag_kor.item(k42_i).getFirstChild().getNodeValue());
			System.out.printf(" 영어 : %s\n", k42_tag_eng.item(k42_i).getFirstChild().getNodeValue());
			System.out.printf(" 수학 : %s\n", k42_tag_mat.item(k42_i).getFirstChild().getNodeValue());
			System.out.println("***************");
		}
	}
}
