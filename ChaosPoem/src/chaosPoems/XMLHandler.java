package chaosPoems;

import java.lang.StringBuffer;
import java.net.ConnectException;
import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {


	
	private ArrayList<String> snippets;
	private StringBuffer bufferString;

	public XMLHandler() {

		snippets = new ArrayList<String>();
		bufferString = new StringBuffer();

	}

	/**
	 * Responsible for parsing the document
	 */
	public ArrayList<String> parseDocument(URL url) {
		
		snippets.clear(); 
		
		// Adds a factory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {

			// adds a new instance of parser
			SAXParser parser = factory.newSAXParser();

			//TODO SHOULD THIS BE MOVED TO MORE PROPER PLACE?
			//Sets user Agent
			System.setProperty("http.agent", "ChaosPoemSearch");
			
			//Stream xml to parser 
			parser.parse(new InputSource(url.openStream()), this);

		} catch (SAXException se) {
		
		} catch (ParserConfigurationException pce) {

		}catch (ConnectException e) {

		}catch (IOException ie) {

			
		}
			
		
		return snippets;
		
	}

	/**
	 * Prints the Arraylist
	 */
	public void printlist() {

		for (String l : snippets) {
			System.out.println(l);
		}
	}

	// Event handlers

	/**
	 * Called automaticly every time start-tag i discovered
	 */
	public void startElement(String uri, String localName, String element,
			Attributes attributes) throws SAXException {
		if (element.equalsIgnoreCase("p")) { // p is used in wikipedia xml files
			String tempSnippet = attributes.getValue("snippet"); //L�ser snippet fra p tag
			snippets.add(tempSnippet);

		}

		if (element.equalsIgnoreCase("str")) { //str is used in archieve.org

			//Because of format of xml a StringBuffer is ues
			int l = bufferString.length();
			bufferString.delete(0, l); //REsets string buffer
		}

		if (element.equalsIgnoreCase("title")) { //Title is used in sindice
			
			//Because of format of xml a StringBuffer is ues
			int l = bufferString.length();
			bufferString.delete(0, l); //REsets string buffer
		}

		if (element.equalsIgnoreCase("field")) { //Field is used in guardian
			
			//Because of format of xml a StringBuffer is ues
			int l = bufferString.length();
			bufferString.delete(0, l); //REsets string buffer
		}

	}

	/**
	 * Called automatically every time and end-tag is discovered
	 */
	public void endElement(String uri, String localName, String element) {
		
		if (element.equalsIgnoreCase("title")) {
			snippets.add(bufferString.toString()); 

		}

		if (element.equalsIgnoreCase("str")) {
			snippets.add(bufferString.toString()); 
			
		}
		if (element.equalsIgnoreCase("field")) {
			snippets.add(bufferString.toString()); 
		}

	}
/**
 *Reads caracters in the middle of tags
 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		// tempTitle = new String(ch, start, length);
		int l = bufferString.length();
		bufferString.insert(l, new String(ch, start, length)); // Inserts
																// characters as
																// string in end
																// of buffer

	}

}