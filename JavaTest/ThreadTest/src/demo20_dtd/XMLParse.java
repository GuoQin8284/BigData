package demo20_dtd;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XMLParse {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("ThreadTest\\src\\demo19_XML\\student.xml"));
        Element rootElement = document.getRootElement();

//        获取指定标签
        List<Element> elements = rootElement.elements("student");
        for (Element element : elements) {
            Element nameElement = element.element("name");
            String nameText = nameElement.getText();

            Element ageElement = element.element("age");
            String ageText = ageElement.getText();

            Attribute idArr = element.attribute("id");
            String idText = idArr.getValue();
            System.out.println(idText);
            System.out.println(nameText);
            System.out.println(ageText);

        }

//        获取所有标签
//        List<Element> elements = rootElement.elements();
//        for (Element element : elements) {
//            Element nameElement = element.element("name");
//            String nameText = nameElement.getText();
//
//            Element ageElement = element.element("age");
//            String ageText = ageElement.getText();
//            System.out.println(nameText);
//            System.out.println(ageText);
//        }
    }
}
