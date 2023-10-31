package net.therap.courseenrollment.repository.db;

import net.therap.courseenrollment.utils.Constant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @author rokib.ahmed
 * @since 10/28/23
 */
public class XMLParser {

    public static Properties parse() {
        Properties properties = new Properties();

        try {
            File persistenceXml = new File(Constant.DB_FILE_PATH + "/persistence.xml");
            FileInputStream fileInputStream = new FileInputStream(persistenceXml);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileInputStream);

            Element rootElement = document.getDocumentElement();

            String dbPersistenceUnitName = "dbconfig";
            NodeList dbPersistenceUnits = rootElement.getElementsByTagName("persistence-unit");
            Element persistenceUnit = null;

            for (int i = 0; i < dbPersistenceUnits.getLength(); i++) {
                Element unit = (Element) dbPersistenceUnits.item(i);
                String name = unit.getAttribute("name");

                if (dbPersistenceUnitName.equals(name)) {
                    persistenceUnit = unit;
                    break;
                }
            }

            if (Objects.nonNull(persistenceUnit)) {
                Element propertiesElement = (Element) persistenceUnit.getElementsByTagName("properties").item(0);
                NodeList propertyNodes = propertiesElement.getElementsByTagName("property");

                for (int i = 0; i < propertyNodes.getLength(); i++) {
                    Element propertyElement = (Element) propertyNodes.item(i);

                    String name = propertyElement.getAttribute("name");
                    String value = propertyElement.getAttribute("value");

                    properties.setProperty(name, value);
                }

            } else {
                System.out.println("Persistence unit not found.");
            }

            fileInputStream.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return properties;
    }

}
