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
		//���� ó��, xml�Ľ��� ���� ���� ó��
		DocumentBuilder k42_docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//�Ľ��� ���� document builder ��ü ����
		
		Document k42_doc = k42_docBuilder.parse(new File("C:\\Users\\J\\Desktop\\source\\score.xml"));
		//pc���� ����� xml������ �ҷ��鿩 ó���ϱ� ���� ��ü��θ� �������ش�
		
		Element k42_root = k42_doc.getDocumentElement();
		//root tag = ����� �� ������ ����
		
		NodeList k42_tag_name = k42_doc.getElementsByTagName("name");
		//get element by tag name "name" "studentif" "kor" "eng" "mat"...
		NodeList k42_tag_studentid = k42_doc.getElementsByTagName("studentid");
		NodeList k42_tag_kor = k42_doc.getElementsByTagName("kor");
		NodeList k42_tag_eng = k42_doc.getElementsByTagName("eng");
		NodeList k42_tag_mat = k42_doc.getElementsByTagName("mat");
		
		System.out.println("***************"); //���м�
		for(int k42_i = 0; k42_i < k42_tag_name.getLength(); k42_i++) { //�±׷� ������ ũ�⿡ ����
			System.out.printf(" �̸� : %s\n", k42_tag_name.item(k42_i).getFirstChild().getNodeValue());
			//1.The first child of this node. If there is no such node, this returns <code>null</code>.
			//2.The value of this node, depending on its type (by the table)
			System.out.printf(" �й� : %s\n", k42_tag_studentid.item(k42_i).getFirstChild().getNodeValue());
			System.out.printf(" ���� : %s\n", k42_tag_kor.item(k42_i).getFirstChild().getNodeValue());
			System.out.printf(" ���� : %s\n", k42_tag_eng.item(k42_i).getFirstChild().getNodeValue());
			System.out.printf(" ���� : %s\n", k42_tag_mat.item(k42_i).getFirstChild().getNodeValue());
			System.out.println("***************");
		}
	}
}
