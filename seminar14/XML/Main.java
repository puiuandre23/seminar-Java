package seminar14.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


class Student {
    private String id;
    private String nume;
    private int varsta;

    public Student(String id, String nume, int varsta) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getId() { return id; }
    public String getNume() { return nume; }
    public int getVarsta() { return varsta; }
}

public class Main {
    public static void main(String[] args) {
        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(new Student("101", "Popescu Ion", 21));
        listaStudenti.add(new Student("102", "Ionel Maria", 23));
        listaStudenti.add(new Student("103", "Gheorghe Vasile", 22));

        //salvare date in fisier .xml
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();


            Element rootElement = doc.createElement("studenti");
            doc.appendChild(rootElement);


            for (Student student : listaStudenti) {
                Element studentElement = doc.createElement("student");
                studentElement.setAttribute("id", student.getId());

                Element numeNode = doc.createElement("nume");
                numeNode.appendChild(doc.createTextNode(student.getNume()));
                studentElement.appendChild(numeNode);

                Element varstaNode = doc.createElement("varsta");
                varstaNode.appendChild(doc.createTextNode(String.valueOf(student.getVarsta())));
                studentElement.appendChild(varstaNode);


                rootElement.appendChild(studentElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("studenti.xml"));

            transformer.transform(source, result);

            System.out.println("Cei " + listaStudenti.size() + " studenti au fost salvati cu succes in studenti.xml\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //extragere date din fisier .xml
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            File xmlFile = new File("studenti.xml");
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Numele elementului radacina: " + doc.getDocumentElement().getNodeName());
            System.out.println("Studenti cititi din XML:");


            NodeList nList = doc.getElementsByTagName("student");


            List<Student> studentiCititi = new ArrayList<>();

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;


                    String id = eElement.getAttribute("id");
                    String nume = eElement.getElementsByTagName("nume").item(0).getTextContent();
                    int varsta = Integer.parseInt(eElement.getElementsByTagName("varsta").item(0).getTextContent());


                    Student studentNou = new Student(id, nume, varsta);
                    studentiCititi.add(studentNou);
                }
            }


            for (Student s : studentiCititi) {
                System.out.println("ID: " + s.getId() + " || Nume: " + s.getNume() + " || Varsta: " + s.getVarsta());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
