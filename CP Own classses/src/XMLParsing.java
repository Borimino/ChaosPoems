
//package org.tabaserve.gigablast4j;

/**
 *This is a subclass of Search abstract class
 * providing the necessary XML-processing functionality.
 * @author Tamas from TabaServe Solutions
 */
import org.w3c.dom.*;
import org.w3c.dom.Node;
import java.net.*;
import javax.xml.parsers.*;
import java.util.*;
import org.xml.sax.SAXException;
import java.io.IOException;
public class XMLParsing extends Search {

    private Document doc;
    private DocumentBuilder db;
    private Element element;
    private DocumentBuilderFactory dbf;
    private NodeList nl;
    private List<Element> l;
    private List<Object> resultList;

    public XMLParsing() {
        dbf = DocumentBuilderFactory.newInstance();
    }

    public List<Object> processRequest() throws ParserConfigurationException, SAXException, IOException {
        resultList = new ArrayList<Object>();
        db = dbf.newDocumentBuilder();
        doc = db.parse(super.getRequest());
        element = doc.getDocumentElement();
        nl=doc.getElementsByTagName("topic");
     
        
   for(int i=0;i<nl.getLength();i++)
       {
           try
           {
           resultList.add(new Topic((Element)nl.item(i)));                        
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
   nl=doc.getElementsByTagName("result");
      for(int i=0;i<nl.getLength();i++)
       {
           try
           {
           resultList.add(new SearchResult((Element)nl.item(i)));                        
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
       
       
       return resultList;
  
       
        
    }
}
