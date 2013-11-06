package chaosPoems;

import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SearchEngine {

	private Boolean fromleft;
	private Boolean withkeywords;
	private int numberofresults;

	XMLHandler xmlHandler;
	ResultCleaner resultCleaner;
/**
 * Constructs a new SearchEngine
 * @param fromleft Determines from which direction words will be removed in the event of no results
 * @param numberofresults Determines the max number of results.
 * @param withkeywords Determines weather or not the keywords will be in the beginning of the strings returned 
 */
	public SearchEngine(Boolean fromleft, int numberofresults,
			Boolean withkeywords) {

		this.fromleft = fromleft;
		this.numberofresults = numberofresults;
		this.withkeywords = withkeywords;
		xmlHandler = new XMLHandler();
		resultCleaner = new ResultCleaner();
	}

	public SearchEngine(int numberofresults) {

		this(true, numberofresults, false);

	}

	/**
	 * 
	 * Makes a search 
	 * @param keywords keywords for the search seperated with space
	 * @return ArrayList with searchresults
	 */
	public ArrayList<String> search(String keywords) {

		ArrayList<String> res = new ArrayList<String>(); // The final Arraylist with results
		ArrayList<String> temp = new ArrayList<String>(); 
		
		temp.addAll(xmlHandler.parseDocument(constructWikiURL("da", keywords)));
		temp.addAll(xmlHandler.parseDocument(constructArchieveURL(keywords))); 
		temp.addAll(xmlHandler.parseDocument(constructSindiceURL(keywords))); //Generates URL and parse it to XML handler, adds the resulting arraylist to an arraylist


		
		temp = resultCleaner.clean(temp, keywords); //Cleans the results

		
		for(String s : temp){
			res.add(resultsplitter(s, keywords));//Cuts off anything before keywords
			
		}
		
		if(res.size() == 0) return cutOfKeywordsAndSearch(keywords);

		if(res.size() > numberofresults) res.subList(numberofresults, res.size()).clear();
			
		
		
		return res;
	
	}

	/**
	 * 
	 * @param keywords The keywords
	 * @return Arraylist with a search minus one of the keywords. THe keyword is cut off from either left or right depending on the attribute fromleft. If less than one keyword is found null is returned.
	 */
	private ArrayList<String> cutOfKeywordsAndSearch(String keywords){
	
		 String words[]= keywords.trim().split(" ");
		
		 if(words.length == 1) return null;

		return search(removeKeyword(keywords));
		 
	}

	
	private String removeKeyword(String keywords){
		
		if(fromleft){
			int i = keywords.indexOf(" ");
			return keywords.substring(i+1);
		} else {
		int i = keywords.lastIndexOf(" ");
		return keywords.substring(0, i);
			
		}
		
	}
	
	
	/**
	 * Constructs URL for Archieve.org search
	 * @param keywords
	 * @return URL
	 */
	private URL constructArchieveURL(String keywords) {

		String l = "";
		try {
			l = URLEncoder.encode(keywords, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			
			l = keywords;
			
			e1.printStackTrace();
		}
		
		String k = "\"" + l.toLowerCase().replaceAll(" ", "+") + "\"";
		
		
		try {
			URL url = new URL("http://archive.org/advancedsearch.php?q=" + k
					+ "&fl%5B%5D=description&sort%5B%5D=&sort%5B%5D=&sort%5B%5D=&rows=50&page=1&callback=callback&output=xml#raw");
			
			return url;
		
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Constructs URL for Sindice search
	 * @param keywords
	 * @return URL
	 */
	private URL constructSindiceURL(String keywords) {

		String l = "";
		try {
			l = URLEncoder.encode(keywords, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			
			l = keywords;
			
			e1.printStackTrace();
		}
		
		String k = "\"" + l.toLowerCase().replaceAll(" ", "+") + "\"";
		
		
		try {
			URL url = new URL("http://api.sindice.com/v2/search?q=" + k
					+ "&qt=term&page=1&format=atom");
			
			return url;
		
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * Construct url for wikimedia search
	 * @param domain
	 * @param keywords
	 * @return
	 */
	private URL constructWikiURL(String domain, String keywords) {

		String k = "%22" + keywords.replaceAll(" ", "%20") + "%22";

		try {
			URL url = new URL(
					"http://"
							+ domain
							+ ".wikipedia.org/w/api.php?action=query&list=search&srsearch="
							+ k + "&srprop=snippet&srwhat=text&format=xml");
			return url;

		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Splits results by keywords
	 * @param tobesplit the string to be split
	 * @param keywords the keywords from the original search, used to determine where to split the string
	 * @return
	 */
	private String resultsplitter(String tobesplit, String keywords) {

		int l = keywords.length();
		int i = tobesplit.toLowerCase().indexOf(keywords.toLowerCase(), 0);
		int sl = tobesplit.length();

		String res = tobesplit.substring((i + l), sl);

		if(withkeywords) return keywords + res;
			
		return res;

	}

	// GETTERS AND SETTERS
	
	/**
	 * 
	 * @return fromleft Determines from which direction words will be removed in the event of no results
	 */
	public Boolean getFromleft() {
		return fromleft;
	}

	/**
	 * 
	 * @param fromleft Determines from which direction words will be removed in the event of no results
	 */
	public void setFromleft(Boolean fromleft) {
		this.fromleft = fromleft;
	}

	/**
	 * 
	 * @return withkeywords Determines weather or not the keywords will be in the beginning of the strings returned 
	 */
	public Boolean getwithkeywords() {
		return withkeywords;
	}

	/**
	 * 
	 * @param withkeywords Determines weather or not the keywords will be in the beginning of the strings returned 
	 */
	public void setwithkeywords(Boolean withkeywords) {
		this.withkeywords = withkeywords;
	}

	/**
	 * 
	 * @return numberofresults Determines the max number of results.
	 */
	public int getNumberofresults() {
		return numberofresults;
	}

	/**
	 * 
	 * @param numberofresults Determines the max number of results.
	 */
	public void setNumberofresults(int numberofresults) {
		this.numberofresults = numberofresults;
	}

}
